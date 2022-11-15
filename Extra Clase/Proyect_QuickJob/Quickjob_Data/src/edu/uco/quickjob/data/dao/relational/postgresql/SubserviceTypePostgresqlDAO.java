package edu.uco.quickjob.data.dao.relational.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.uco.quickjob.crosscutting.exception.data.DataCustomException;
import edu.uco.quickjob.crosscutting.messages.Messages;
import edu.uco.quickjob.data.dao.SubserviceTypeDAO;
import edu.uco.quickjob.data.dao.relational.DAORelational;
import edu.uco.quickjob.domain.ServiceTypeDTO;
import edu.uco.quickjob.domain.SubserviceTypeDTO;

public class SubserviceTypePostgresqlDAO extends DAORelational implements SubserviceTypeDAO{

	public SubserviceTypePostgresqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public List<SubserviceTypeDTO> find() {
		
		var parameters = new ArrayList<Object>();

		final var sqlBuilder = new StringBuilder();

		createSelectFrom(sqlBuilder);

		createOrderBy(sqlBuilder);

		return prepareAndExecuteQuery(sqlBuilder, parameters);
	}
	
	private final void createOrderBy(final StringBuilder stringBuilder) {
		stringBuilder.append("Order By S.nombre ASC, ");
		stringBuilder.append("         SB.nombre ASC ");
	}
	
	private final List<SubserviceTypeDTO> prepareAndExecuteQuery(StringBuilder sqlBuilder, List<Object> parameters) {
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

	private final void setParameterValues(final PreparedStatement preparedStatement, final List<Object> parameters) {
		try {
			for (int index = 0; index < parameters.size(); index++) {
				preparedStatement.setObject(index + 1, parameters.get(index));
			}
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.SubserviceTypePostgresqlDAO.TECHNICAL_PROBLEM_SET_PARAMETERS_VALUES_QUERY, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.SubserviceTypePostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_SET_PARAMATERS_VALUES_QUERY, exception);
		}
	}

	private final List<SubserviceTypeDTO> fillResults (final ResultSet resultset) {
		try {
			var results = new ArrayList<SubserviceTypeDTO>();
			while(resultset.next()){
				results.add(fillSubServiceTypeDTO(resultset));
		}
			return results;
		} catch (final DataCustomException exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.SubserviceTypePostgresqlDAO.TECHNICAL_PROBLEM_FILL_SUB_SERVICE_TYPE, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.SubserviceTypePostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILL_SUB_SERVICE_TYPE,exception);
		}
	}

	private final List<SubserviceTypeDTO> executeQuery(PreparedStatement preparedStatement){
		try (final var resultSet = preparedStatement.executeQuery()) {

			return fillResults(resultSet);

		} catch (DataCustomException exception) {
			throw exception;
		} catch (SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.SubserviceTypePostgresqlDAO.TECHNICAL_PROBLEM_EXECUTE_QUERY ,exception);
		} catch (Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.SubserviceTypePostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_EXECUTE_QUERY,exception);
		}
	}


	private final SubserviceTypeDTO fillSubServiceTypeDTO (final ResultSet resultset) {
		try {
			ServiceTypeDTO serviceType = ServiceTypeDTO.create(resultset.getString("idServiceType"), resultset.getString("serviceTypeName"));
			return SubserviceTypeDTO.create(resultset.getString("idSubserviceType") ,serviceType, resultset.getString("subServiceTypeName"));
		} catch (final DataCustomException exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.SubserviceTypePostgresqlDAO.TECHNICAL_PROBLEM_FILL_SUB_SERVICE_TYPE, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.SubserviceTypePostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILL_SUB_SERVICE_TYPE, exception);
		}
	}

	private final void createSelectFrom(final StringBuilder sqlBuilder) {

		sqlBuilder.append("SELECT S.codigo AS idServiceType, ");
		sqlBuilder.append("         S.nombre AS serviceTypeName, ");
		sqlBuilder.append("         SB.codigo AS idSubserviceType, ");
		sqlBuilder.append("         SB.nombre AS subServiceTypeName  ");
		sqlBuilder.append("         FROM tipo_servicio S ");
		sqlBuilder.append("INNER JOIN tipo_subservicio SB ");
		sqlBuilder.append("ON S.codigo = SB.tipo_servicio_codigo ");
	}

}
