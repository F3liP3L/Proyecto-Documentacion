package edu.uco.quickjob.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;

import edu.uco.quickjob.data.dao.SubserviceTypeDAO;
import edu.uco.quickjob.data.dao.relational.DAORelational;
import edu.uco.quickjob.domain.SubserviceTypeDTO;

public class SubserviceTypePostgresqlDAO extends DAORelational implements SubserviceTypeDAO{

	protected SubserviceTypePostgresqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public List<SubserviceTypeDTO> find(SubserviceTypeDTO subServiceType) {
		// TODO Auto-generated method stub
		return null;
	}

}
