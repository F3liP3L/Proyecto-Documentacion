package edu.uco.quickjob.data.dao.relational.postgresql;

import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getUUIDAsString;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import edu.uco.quickjob.crosscutting.exception.data.DataCustomException;
import edu.uco.quickjob.data.dao.CustomerDAO;
import edu.uco.quickjob.data.dao.relational.DAORelational;
import edu.uco.quickjob.domain.CustomerDTO;

public class CustomerPostgresqlDAO extends DAORelational implements CustomerDAO{

	protected CustomerPostgresqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(CustomerDTO customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CustomerDTO> find(CustomerDTO customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(CustomerDTO customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		final var sqlDelete = "DELETE FROM public.cliente WHERE codigo = ?";
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
