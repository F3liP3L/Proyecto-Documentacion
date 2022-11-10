package edu.uco.quickjob.data.dao.relational.postgresql;

import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getUUIDAsString;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import edu.uco.quickjob.crosscutting.exception.data.DataCustomException;
import edu.uco.quickjob.data.dao.ServiceProviderDAO;
import edu.uco.quickjob.data.dao.relational.DAORelational;
import edu.uco.quickjob.domain.ServiceProviderDTO;

public class ServiceProviderPostgresqlDAO extends DAORelational implements ServiceProviderDAO {

	protected ServiceProviderPostgresqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(ServiceProviderDTO serviceProvider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ServiceProviderDTO> find(ServiceProviderDTO serviceProvider) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(ServiceProviderDTO serviceProvider) {
		
	}

	@Override
	public void delete(UUID id) {
		final var sqlDelete = "DELETE FROM public.prestador_servicio WHERE codigo = ?";
		final var idAsString = getUUIDAsString(id);
		
		try (final var preparedStatement = getConnection().prepareStatement(sqlDelete)) {
			preparedStatement.setString(1, idAsString);
		} catch(SQLException exception) {
			// String message = Messages.BudgetSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_BUDGET(idAsString);
			throw DataCustomException.createTechnicalException(null, exception);
		} catch (Exception exception) {
			// String message = Messages.BudgetSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_DELETE_BUDGET.concat(idAsString);
			throw DataCustomException.createTechnicalException(null, exception);
		}	
		
	}

}
