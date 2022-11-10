package edu.uco.quickjob.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

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
		// TODO Auto-generated method stub
		
	}

}
