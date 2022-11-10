package edu.uco.quickjob.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;

import edu.uco.quickjob.data.dao.IdentificationTypeDAO;
import edu.uco.quickjob.data.dao.relational.DAORelational;
import edu.uco.quickjob.domain.IdentificationTypeDTO;

public class IdentificationTypePostgresqlDAO extends DAORelational implements IdentificationTypeDAO {

	protected IdentificationTypePostgresqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public List<IdentificationTypeDTO> find(IdentificationTypeDTO identificationType) {
		// TODO Auto-generated method stub
		return null;
	}

}
