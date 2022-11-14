package edu.uco.quickjob.data.dao.relational.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.uco.quickjob.crosscutting.exception.data.DataCustomException;
import edu.uco.quickjob.crosscutting.helper.ObjectHelper;
import edu.uco.quickjob.crosscutting.helper.UUIDHelper;
import edu.uco.quickjob.crosscutting.messages.Messages;
import edu.uco.quickjob.data.dao.IdentificationDocumentDAO;
import edu.uco.quickjob.data.dao.relational.DAORelational;
import edu.uco.quickjob.domain.CityDTO;
import edu.uco.quickjob.domain.CountryDTO;
import edu.uco.quickjob.domain.DepartmentDTO;
import edu.uco.quickjob.domain.IdentificationDocumentDTO;
import edu.uco.quickjob.domain.IdentificationTypeDTO;

public class IdentificationDocumentPostgresqlDAO extends DAORelational implements IdentificationDocumentDAO {

	public IdentificationDocumentPostgresqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public IdentificationDocumentDTO create(IdentificationDocumentDTO identificationDocument) {
		final var sqlInsert = "INSERT INTO public.documento_identificacion(codigo, nombre, apellido, fecha_nacimiento, fecha_expedimiento, lugar_expedicion, sexo, numero_identificacion, lugar_nacimiento, tipo_identificacion_codigo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (final var preparedStatement = getConnection().prepareStatement(sqlInsert)) {
			
			preparedStatement.setString(1, identificationDocument.getIdAsString());
			preparedStatement.setString(2, identificationDocument.getName());
			preparedStatement.setString(3, identificationDocument.getSurname());
			preparedStatement.setDate(4, identificationDocument.getBirthDate());
			preparedStatement.setDate(5, identificationDocument.getExpeditionDate());
			preparedStatement.setString(6, identificationDocument.getExpeditionSite());
			preparedStatement.setString(7, identificationDocument.getSex());
			preparedStatement.setString(8, identificationDocument.getIdentificationNumber());
			preparedStatement.setString(9, identificationDocument.getPlaceOfBirth().getIdAsString());
			preparedStatement.setString(10, identificationDocument.getIdentificationType().getIdAsString());
			
			preparedStatement.executeUpdate();
			
		} catch(final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.QualificationPostgresqlDAO.TECHNICAL_PROBLEM_CREATE_QUALIFICATION, exception); 
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.QualificationPostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_CREATE_QUALIFICATION ,exception);
		}
		return identificationDocument;	
	}	

	@Override
	public List<IdentificationDocumentDTO> find(IdentificationDocumentDTO identificationDocument) {
		var parameters = new ArrayList<Object>();

		final var sqlBuilder = new StringBuilder();

		createSelectFrom(sqlBuilder);

		createWhere(sqlBuilder, identificationDocument, parameters);

		createOrderBy(sqlBuilder);

		return prepareAndExecuteQuery(sqlBuilder, parameters);
	}

	@Override
	public void update(IdentificationDocumentDTO identificationType) {
		// 
	}
	
	
	private final List<IdentificationDocumentDTO> prepareAndExecuteQuery(StringBuilder sqlBuilder, List<Object> parameters) {
		try (final var preparedStatement = getConnection().prepareStatement(sqlBuilder.toString())){

			setParameterValues(preparedStatement, parameters);

			return executeQuery(preparedStatement);

		}  catch (final DataCustomException exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.DepartmentPostgresqlDAO.TECHNICAL_PROBLEM_PREPARED_STATEMENT, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.DepartmentPostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_PREPARED_STATEMENT, exception);
		}
	}
	
	private final List<IdentificationDocumentDTO> executeQuery(PreparedStatement preparedStatement){
		try (final var resultSet = preparedStatement.executeQuery()) {

			return fillResults(resultSet);

		} catch (DataCustomException exception) {
			throw exception;
		} catch (SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.DepartmentPostgresqlDAO.TECHNICAL_PROBLEM_EXECUTE_QUERY ,exception);
		} catch (Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.DepartmentPostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_EXECUTE_QUERY,exception);
		}
	}
	

	private final void createOrderBy(final StringBuilder stringBuilder) {
		stringBuilder.append("Order By DI.nombre ASC, ");
		stringBuilder.append("         T.nombre ASC ");
	}


	private final void setParameterValues(final PreparedStatement preparedStatement, final List<Object> parameters) {
		try {
			for (int index = 0; index < parameters.size(); index++) {
				preparedStatement.setObject(index + 1, parameters.get(index));
			}
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.DepartmentPostgresqlDAO.TECHNICAL_PROBLEM_SET_PARAMETERS_VALUES_QUERY, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.DepartmentPostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_SET_PARAMATERS_VALUES_QUERY, exception);
		}
	}

	private final List<IdentificationDocumentDTO> fillResults (final ResultSet resultset) {
		try {
			var results = new ArrayList<IdentificationDocumentDTO>();
			while(resultset.next()){
				results.add(fillIdentificationDocumentDTO(resultset));
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

	public final IdentificationDocumentDTO fillIdentificationDocumentDTO (final ResultSet resultset) {
		try {
			return IdentificationDocumentDTO.create(resultset.getString("idDocumentIdentification"), resultset.getString("name"), resultset.getString("surname"),resultset.getDate("birthDate"), fillCityDTO(resultset), 
			 resultset.getString("identificationNumber"), fillIdentificationTypeDTO(resultset));
		} catch (final DataCustomException exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.DepartmentPostgresqlDAO.TECHNICAL_PROBLEM_FILL_DEPARTMENT_DTO, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.DepartmentPostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILL_RESULTS_DEPARTMENT, exception);
		}
	}

	private final IdentificationTypeDTO fillIdentificationTypeDTO(final ResultSet resultset) {
		try {
			return IdentificationTypeDTO.create(resultset.getString("idIdentificationType"), resultset.getString("identificationTypeName"));
		} catch (final SQLException exception ) {
			throw DataCustomException.createTechnicalException(Messages.IdentificationTypePostgresqlDAO.TECHNICAL_PROBLEM_FILL_IDENTIFICATION_TYPE_DTO, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.IdentificationTypePostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILL_IDENTIFICATION_TYPE_DTO, exception);
		}
	}
	
	public final CityDTO fillCityDTO (final ResultSet resultset) {
		try {
			return CityDTO.create(resultset.getString("idCity"), resultset.getString("cityName"), fillDepartmentDTO(resultset));
		} catch (final DataCustomException exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.CityPostgresqlDAO.TECHNICAL_PROBLEM_FILL_CITY_DTO, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.CityPostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILL_RESULTS_CITY, exception);
		}
	}
	
	private final DepartmentDTO fillDepartmentDTO (final ResultSet resultset) {
		try {
			return DepartmentDTO.create(resultset.getString("idDepartment"), resultset.getString("departmentName"), fillCountryDTO(resultset));
		} catch (final DataCustomException exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.DepartmentPostgresqlDAO.TECHNICAL_PROBLEM_FILL_DEPARTMENT_DTO, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.DepartmentPostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILL_RESULTS_DEPARTMENT, exception);
		}
	}
	
	private final CountryDTO fillCountryDTO(final ResultSet resultset) {
		try {
			return CountryDTO.create(resultset.getString("idCountry"), resultset.getString("countryName"));
		} catch (final SQLException exception ) {
			throw DataCustomException.createTechnicalException(Messages.DepartmentPostgresqlDAO.TECHNICAL_PROBLEM_FILL_DEPARTMENT_DTO, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.DepartmentPostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILL_RESULTS_DEPARTMENT, exception);
		}
	}

	private final void createSelectFrom(final StringBuilder sqlBuilder) {
		
		sqlBuilder.append("SELECT   DI.codigo AS idDocumentIdentification, ");
		sqlBuilder.append("         DI.nombre AS name, ");
		sqlBuilder.append("         DI.apellido AS surname, ");
		sqlBuilder.append("         DI.fecha_nacimiento AS birthDate, ");
		sqlBuilder.append("         DI.fecha_expedimiento AS expeditionDate, ");
		sqlBuilder.append("         DI.lugar_expedicion AS expeditionPlace,  ");
		sqlBuilder.append("         DI.sexo AS sex, ");
		sqlBuilder.append("         DI.numero_identificacion AS identificationNumber, ");
		sqlBuilder.append("         DI.lugar_nacimiento AS placeBirth, ");
		sqlBuilder.append("         DI.tipo_identificacion_codigo AS idIdentificationType,  ");
		sqlBuilder.append("         T.nombre AS identificationTypeName, ");
		sqlBuilder.append("         C.nombre AS cityName, ");
		sqlBuilder.append("         C.departamento_codigo AS idDepartment, ");
		sqlBuilder.append("         D.nombre AS departmentName, ");
		sqlBuilder.append("        	D.pais_codigo AS idCountry, ");
		sqlBuilder.append("         P.nombre AS countryName ");
		sqlBuilder.append("FROM documento_identificacion DI ");
		sqlBuilder.append("INNER JOIN tipo_identificacion T ");
		sqlBuilder.append("ON T.codigo = DI.tipo_identificacion_codigo ");
		sqlBuilder.append("INNER JOIN ciudad C ");
		sqlBuilder.append("ON C.codigo = DI.lugar_nacimiento ");
		sqlBuilder.append("INNER JOIN departamento D ");
		sqlBuilder.append("ON D.codigo = C.departamento_codigo ");
		sqlBuilder.append("INNER JOIN pais P ");
		sqlBuilder.append("ON P.codigo = D.pais_codigo ");
	}

		private final void createWhere(final StringBuilder sqlBuilder, final IdentificationDocumentDTO identificationDocument, final List<Object> parameters) {

		var setWhere = true;

		if(!ObjectHelper.isNull(identificationDocument)) {

			if(!UUIDHelper.isDefaultUUID(identificationDocument.getId())) {
				sqlBuilder.append("WHERE DI.codigo = ? ");
				setWhere = false;
				parameters.add(identificationDocument.getIdAsString());
			}

			if(UUIDHelper.isDefaultUUID(identificationDocument.getIdentificationType().getId())) {
				sqlBuilder.append(setWhere ? "WHERE ": "AND ").append("DI.tipo_identificacion_codigo = ? ");
				setWhere = false;
				parameters.add(identificationDocument.getIdentificationType().getIdAsString());
			}
			
			if(UUIDHelper.isDefaultUUID(identificationDocument.getPlaceOfBirth().getId())) {
				sqlBuilder.append(setWhere ? "WHERE ": "AND ").append("DI.lugar_nacimiento = ? ");
				setWhere = false;
				parameters.add(identificationDocument.getIdentificationType().getIdAsString());
			}
			
			if(UUIDHelper.isDefaultUUID(identificationDocument.getPlaceOfBirth().getDepartment().getId())) {
				sqlBuilder.append(setWhere ? "WHERE ": "AND ").append("C.departamento_codigo = ? ");
				setWhere = false;
				parameters.add(identificationDocument.getPlaceOfBirth().getDepartment().getIdAsString());
			}
			
			if(UUIDHelper.isDefaultUUID(identificationDocument.getPlaceOfBirth().getDepartment().getCountry().getId())) {
				sqlBuilder.append(setWhere ? "WHERE ": "AND ").append("D.pais_codigo = ? ");
				parameters.add(identificationDocument.getPlaceOfBirth().getDepartment().getCountry().getIdAsString());
			}
		}
	}
	
	

}
