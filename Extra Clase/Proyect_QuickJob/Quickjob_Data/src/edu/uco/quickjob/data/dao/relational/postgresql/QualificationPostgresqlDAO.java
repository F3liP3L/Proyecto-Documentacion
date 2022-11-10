package edu.uco.quickjob.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;

import edu.uco.quickjob.data.dao.QualificationDAO;
import edu.uco.quickjob.data.dao.relational.DAORelational;
import edu.uco.quickjob.domain.QualificationDTO;

public class QualificationPostgresqlDAO extends DAORelational implements QualificationDAO {

	protected QualificationPostgresqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(QualificationDTO qualification) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<QualificationDTO> find(QualificationDTO qualification) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(QualificationDTO qualification) {
		// TODO Auto-generated method stub
		
	}

}
