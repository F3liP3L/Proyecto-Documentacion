package edu.uco.quickjob.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;

import edu.uco.quickjob.data.dao.IdentificationDocumentDAO;
import edu.uco.quickjob.data.dao.relational.DAORelational;
import edu.uco.quickjob.domain.IdentificationDocumentDTO;

public class IdentificationDocumentPostgresqlDAO extends DAORelational implements IdentificationDocumentDAO {

	protected IdentificationDocumentPostgresqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(IdentificationDocumentDTO identificationType) {
		
	}

	@Override
	public List<IdentificationDocumentDTO> find(IdentificationDocumentDTO identificationDocument) {
		return null;
	}

	@Override
	public void update(IdentificationDocumentDTO identificationType) {
		
	}

}
