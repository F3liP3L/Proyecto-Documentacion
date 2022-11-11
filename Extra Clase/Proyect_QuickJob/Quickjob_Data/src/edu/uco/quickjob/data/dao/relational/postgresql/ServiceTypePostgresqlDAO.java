package edu.uco.quickjob.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;

import edu.uco.quickjob.data.dao.ServiceTypeDAO;
import edu.uco.quickjob.data.dao.relational.DAORelational;

import edu.uco.quickjob.domain.ServiceTypeDTO;

public class ServiceTypePostgresqlDAO extends DAORelational implements ServiceTypeDAO {

	protected ServiceTypePostgresqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public List<ServiceTypeDTO> find(ServiceTypeDTO serviceType) {
		return null;
	}

}
