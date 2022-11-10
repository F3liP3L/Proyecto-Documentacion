package edu.uco.quickjob.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import edu.uco.quickjob.data.dao.IdentificationDocumentDAO;
import edu.uco.quickjob.data.dao.relational.DAORelational;
import edu.uco.quickjob.domain.IdentificationDocumentDTO;

public class IdentificationDocumentPostgresqlDAO extends DAORelational implements IdentificationDocumentDAO {

	protected IdentificationDocumentPostgresqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(IdentificationDocumentDTO identificationType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<IdentificationDocumentDTO> find(IdentificationDocumentDTO identificationDocument) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
