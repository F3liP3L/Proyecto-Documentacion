package edu.uco.quickjob.data.dao.relational.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.uco.quickjob.crosscutting.exception.data.DataCustomException;
import edu.uco.quickjob.crosscutting.messages.Messages;
import edu.uco.quickjob.data.dao.IdentificationTypeDAO;
import edu.uco.quickjob.data.dao.relational.DAORelational;
import edu.uco.quickjob.domain.IdentificationTypeDTO;

public class IdentificationTypePostgresqlDAO extends DAORelational implements IdentificationTypeDAO {

	public IdentificationTypePostgresqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public List<IdentificationTypeDTO> find() {

		final var sqlBuilder = new StringBuilder();

		createSelectFrom(sqlBuilder);

		createOrderBy(sqlBuilder);

		return prepareAndExecuteQuery(sqlBuilder);
	}
	
	private final void createSelectFrom(final StringBuilder sqlBuilder) {
		sqlBuilder.append("SELECT 	codigo AS idIdentificationType, ");
		sqlBuilder.append("         nombre AS identificationTypeName ");
		sqlBuilder.append("         FROM tipo_identificacion ");
	}

	private final List<IdentificationTypeDTO> prepareAndExecuteQuery(StringBuilder sqlBuilder) {
		try (final var preparedStatement = getConnection().prepareStatement(sqlBuilder.toString())){

			return executeQuery(preparedStatement);

		}  catch (final DataCustomException exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.IdentificationTypePostgresqlDAO.TECHNICAL_PROBLEM_PREPARED_STATEMENT, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.IdentificationTypePostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_PREPARED_STATEMENT, exception);
		}
	}

	private final void createOrderBy(final StringBuilder stringBuilder) {
		stringBuilder.append("Order By identificationTypeName ASC ");
	}

	private final List<IdentificationTypeDTO> fillResults (final ResultSet resultset) {
		try {
			var results = new ArrayList<IdentificationTypeDTO>();
			while(resultset.next()){
				results.add(fillIdentificationTypeDTO(resultset));
		}
			return results;
		} catch (final DataCustomException exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.IdentificationTypePostgresqlDAO.TECHNICAL_PROBLEM_FILL_IDENTIFICATION_TYPE_DTO, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.IdentificationTypePostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILL_IDENTIFICATION_TYPE_DTO, exception);
		}
	}

	private final List<IdentificationTypeDTO> executeQuery(PreparedStatement preparedStatement){
		try (final var resultSet = preparedStatement.executeQuery()) {

			return fillResults(resultSet);

		} catch (DataCustomException exception) {
			throw exception;
		} catch (SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.IdentificationTypePostgresqlDAO.TECHNICAL_PROBLEM_EXECUTE_QUERY ,exception);
		} catch (Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.IdentificationTypePostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_EXECUTE_QUERY,exception);
		}
	}

	private final IdentificationTypeDTO fillIdentificationTypeDTO (final ResultSet resultset) {
		try {
			return IdentificationTypeDTO.create(resultset.getString("idIdentificationType"), resultset.getString("identificationTypeName"));
		} catch (final DataCustomException exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.IdentificationTypePostgresqlDAO.TECHNICAL_PROBLEM_FILL_IDENTIFICATION_TYPE_DTO, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.IdentificationTypePostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILL_IDENTIFICATION_TYPE_DTO, exception);
		}
	}
	
	
	

}
