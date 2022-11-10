package edu.uco.quickjob.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
