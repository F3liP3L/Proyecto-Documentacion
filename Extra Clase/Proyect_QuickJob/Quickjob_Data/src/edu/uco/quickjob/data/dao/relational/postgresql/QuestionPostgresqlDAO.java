package edu.uco.quickjob.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;

import edu.uco.quickjob.data.dao.QuestionDAO;
import edu.uco.quickjob.data.dao.relational.DAORelational;
import edu.uco.quickjob.domain.QuestionDTO;

public class QuestionPostgresqlDAO extends DAORelational implements QuestionDAO {

	protected QuestionPostgresqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(QuestionDTO question) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<QuestionDTO> find(QuestionDTO question) {
		// TODO Auto-generated method stub
		return null;
	}

}
