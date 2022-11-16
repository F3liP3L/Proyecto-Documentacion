package edu.uco.quickjob.data.dao.relational.postgresql;

import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getUUIDAsString;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import edu.uco.quickjob.crosscutting.exception.data.DataCustomException;
import edu.uco.quickjob.crosscutting.helper.ObjectHelper;
import edu.uco.quickjob.crosscutting.messages.Messages;
import edu.uco.quickjob.data.dao.UserDAO;
import edu.uco.quickjob.data.dao.relational.DAORelational;
import edu.uco.quickjob.domain.UserDTO;

public class UserPostgresqlDAO extends DAORelational implements UserDAO {

	public UserPostgresqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(UserDTO user) {
		final var sqlInsert = "INSERT INTO usuario(codigo, nombres, apellidos, correo, clave, ciudad_codigo, documento_identidad_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (final var preparedStatement = getConnection().prepareStatement(sqlInsert)) {

			preparedStatement.setString(1, user.getIdAsString());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getLastName());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getPassword());
			preparedStatement.setString(6, user.getResidenceCity().getIdAsString());
			preparedStatement.setString(7, user.getIdentification().getIdAsString());

			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.UserPostgresqlDAO.TECHNICAL_PROBLEM_CREATE_USER,
					exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(
					Messages.UserPostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_CREATE_USER, exception);
		}
	}

	@Override
	public List<UserDTO> find(UserDTO user) {

		var parameters = new ArrayList<Object>();

		final var sqlBuilder = new StringBuilder();

		createSelectFrom(sqlBuilder);

		createWhere(sqlBuilder, user, parameters);

		createOrderBy(sqlBuilder);

		return prepareAndExecuteQuery(sqlBuilder, parameters);
	}

	private final List<UserDTO> prepareAndExecuteQuery(StringBuilder sqlBuilder, List<Object> parameters) {
		try (final var preparedStatement = getConnection().prepareStatement(sqlBuilder.toString())) {

			setParameterValues(preparedStatement, parameters);

			return executeQuery(preparedStatement);

		} catch (final DataCustomException exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(
					Messages.UserPostgresqlDAO.TECHNICAL_PROBLEM_PREPARED_STATEMENT, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(
					Messages.UserPostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_PREPARED_STATEMENT, exception);
		}
	}

	private final List<UserDTO> executeQuery(PreparedStatement preparedStatement) {
		try (final var resultSet = preparedStatement.executeQuery()) {

			return fillResults(resultSet);

		} catch (DataCustomException exception) {
			throw exception;
		} catch (SQLException exception) {
			throw DataCustomException
					.createTechnicalException(Messages.UserPostgresqlDAO.TECHNICAL_PROBLEM_EXECUTE_QUERY, exception);
		} catch (Exception exception) {
			throw DataCustomException.createTechnicalException(
					Messages.UserPostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_EXECUTE_QUERY, exception);
		}
	}

	private final void createOrderBy(final StringBuilder stringBuilder) {
		stringBuilder.append("Order By U.nombres ASC ");
	}

	private final void setParameterValues(final PreparedStatement preparedStatement, final List<Object> parameters) {
		try {
			for (int index = 0; index < parameters.size(); index++) {
				preparedStatement.setObject(index + 1, parameters.get(index));
			}
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(
					Messages.UserPostgresqlDAO.TECHNICAL_PROBLEM_SET_PARAMETERS_VALUES_QUERY, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(
					Messages.UserPostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_SET_PARAMATERS_VALUES_QUERY, exception);
		}
	}

	private final List<UserDTO> fillResults(final ResultSet resultset) {
		try {
			var results = new ArrayList<UserDTO>();
			while (resultset.next()) {
				results.add(fillUserDTO(resultset));
			}
			return results;
		} catch (final DataCustomException exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(
					Messages.IdentificationTypePostgresqlDAO.TECHNICAL_PROBLEM_FILL_IDENTIFICATION_TYPE_DTO, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(
					Messages.IdentificationTypePostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILL_IDENTIFICATION_TYPE_DTO,
					exception);
		}
	}

	private final UserDTO fillUserDTO(final ResultSet resultset) {
		try {
			return UserDTO.create(resultset.getString("idUsuario"), resultset.getString("name"),
					resultset.getString("lastname"), resultset.getString("email"), resultset.getString("password"));
		} catch (final DataCustomException exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw DataCustomException
					.createTechnicalException(Messages.UserPostgresqlDAO.TECHNICAL_PROBLEM_FILL_USER_DTO, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(
					Messages.UserPostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILL_USER_DTO, exception);
		}
	}

	private final void createSelectFrom(final StringBuilder sqlBuilder) {
		sqlBuilder.append("SELECT   U.codigo AS idUsuario, ");
		sqlBuilder.append("		    U.nombres AS name, ");
		sqlBuilder.append("		    U.apellidos AS lastname, ");
		sqlBuilder.append("		    U.correo AS email, ");
		sqlBuilder.append("		   	U.clave AS password, ");
		sqlBuilder.append("		   	U.ciudad_codigo AS idCity, ");
		sqlBuilder.append("		    U.documento_identidad_id AS idDocumentIdentification, ");
		sqlBuilder.append("         DI.fecha_nacimiento AS birthDate, ");
		sqlBuilder.append("         DI.numero_identificacion AS identificationNumber, ");
		sqlBuilder.append("         DI.ciudad_codigo AS placeBirth, ");
		sqlBuilder.append("         DI.tipo_identificacion_codigo AS idIdentificationType ");
		sqlBuilder.append("FROM usuario U ");
		sqlBuilder.append("INNER JOIN documento_identificacion DI ");
		sqlBuilder.append("ON U.documento_identidad_id = DI.codigo ");
		sqlBuilder.append("INNER JOIN ciudad C ");
		sqlBuilder.append("ON C.codigo = U.ciudad_codigo ");
	}

	private final void createWhere(final StringBuilder sqlBuilder, final UserDTO user, final List<Object> parameters) {

		var setWhere = true;

		if (!ObjectHelper.isNull(user)) {

			if (user.getEmail() != null) {
				sqlBuilder.append("WHERE U.correo = ? ");
				setWhere = false;
				parameters.add(user.getEmail());
			}

			if (user.getPassword() != null && user.getPassword() != "") {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("U.clave = ? ");
				parameters.add(user.getPassword());
			}
		}
	}

	@Override
	public void update(UserDTO user) {
		final var sqlUpdate = "UPDATE public.usuario SET nombres=?, apellidos=?, correo=?, clave=?, ciudad_codigo=? WHERE codigo = ?";
		try (final var preparedStatement = getConnection().prepareStatement(sqlUpdate)) {
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getResidenceCity().getIdAsString());
			preparedStatement.setString(5, user.getIdAsString());
			
		} catch (SQLException exception) {
			throw DataCustomException
					.createTechnicalException(Messages.UserPostgresqlDAO.TECHNICAL_PROBLEM_UPDATE_USER, exception);
		} catch (Exception exception) {
			throw DataCustomException.createTechnicalException(
					Messages.UserPostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_USER, exception);
		}
	}

	@Override
	public void delete(UUID id) {
		final var sqlDelete = "DELETE FROM usuario WHERE codigo = ?";
		final var idAsString = getUUIDAsString(id);

		try (final var preparedStatement = getConnection().prepareStatement(sqlDelete)) {
			preparedStatement.setString(1, idAsString);
		} catch (SQLException exception) {
			throw DataCustomException
					.createTechnicalException(Messages.UserPostgresqlDAO.TECHNICAL_PROBLEM_DELETE_USER_DTO, exception);
		} catch (Exception exception) {
			throw DataCustomException.createTechnicalException(
					Messages.UserPostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_DELETE_USER_DTO, exception);
		}

	}

}
