package edu.uco.quickjob.data.dao.relational.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.uco.quickjob.crosscutting.exception.data.DataCustomException;
import edu.uco.quickjob.crosscutting.messages.Messages;
import edu.uco.quickjob.data.dao.ServiceTypeDAO;
import edu.uco.quickjob.data.dao.relational.DAORelational;
import edu.uco.quickjob.domain.ServiceTypeDTO;

public class ServiceTypePostgresqlDAO extends DAORelational implements ServiceTypeDAO {

	public ServiceTypePostgresqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public List<ServiceTypeDTO> find() {

		final var sqlBuilder = new StringBuilder();

		createSelectFrom(sqlBuilder);

		createOrderBy(sqlBuilder);

		return prepareAndExecuteQuery(sqlBuilder);
	}
	
	private final void createSelectFrom(final StringBuilder sqlBuilder) {
		sqlBuilder.append("SELECT  codigo AS idServiceType, ");
		sqlBuilder.append("        nombre AS serviceTypeName  ");
		sqlBuilder.append("        FROM tipo_servicio ");
	}
	

	private final List<ServiceTypeDTO> prepareAndExecuteQuery(StringBuilder sqlBuilder) {
		try (final var preparedStatement = getConnection().prepareStatement(sqlBuilder.toString())){

			return executeQuery(preparedStatement);

		}  catch (final DataCustomException exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.ServiceTypePostgresqlDAO.TECHNICAL_PROBLEM_FILL_SERVICE_TYPE, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.ServiceTypePostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILL_SERVICE_TYPE, exception);
		}
	}

	private final void createOrderBy(final StringBuilder stringBuilder) {
		stringBuilder.append("Order By serviceTypeName ASC ");
	}

	private final List<ServiceTypeDTO> fillResults (final ResultSet resultset) {
		try {
			var results = new ArrayList<ServiceTypeDTO>();
			while(resultset.next()){
				results.add(fillServiceTypeDTO(resultset));
		}
			return results;
		} catch (final DataCustomException exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.ServiceTypePostgresqlDAO.TECHNICAL_PROBLEM_FILL_SERVICE_TYPE, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.ServiceTypePostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILL_SERVICE_TYPE, exception);
		}
	}

	private final List<ServiceTypeDTO> executeQuery(PreparedStatement preparedStatement){
		try (final var resultSet = preparedStatement.executeQuery()) {

			return fillResults(resultSet);

		} catch (DataCustomException exception) {
			throw exception;
		} catch (SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.ServiceTypePostgresqlDAO.TECHNICAL_PROBLEM_EXECUTE_QUERY ,exception);
		} catch (Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.ServiceTypePostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_EXECUTE_QUERY,exception);
		}
	}

	private final ServiceTypeDTO fillServiceTypeDTO (final ResultSet resultset) {
		try {
			return ServiceTypeDTO.create(resultset.getString("idServiceType"), resultset.getString("serviceTypeName"));
		} catch (final DataCustomException exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.ServiceTypePostgresqlDAO.TECHNICAL_PROBLEM_FILL_SERVICE_TYPE, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.ServiceTypePostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILL_SERVICE_TYPE, exception);
		}
	}

}
