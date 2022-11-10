package edu.uco.quickjob.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import edu.uco.quickjob.data.dao.ServiceDAO;
import edu.uco.quickjob.data.dao.relational.DAORelational;
import edu.uco.quickjob.domain.ServiceDTO;

public class ServicePostgresqlDAO extends DAORelational implements ServiceDAO {

	protected ServicePostgresqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(ServiceDTO service) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ServiceDTO> find(ServiceDTO service) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(ServiceDTO service) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
