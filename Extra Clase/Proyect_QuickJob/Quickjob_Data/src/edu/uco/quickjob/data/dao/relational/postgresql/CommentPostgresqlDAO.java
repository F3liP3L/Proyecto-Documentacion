package edu.uco.quickjob.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import edu.uco.quickjob.data.dao.CommentDAO;
import edu.uco.quickjob.data.dao.relational.DAORelational;
import edu.uco.quickjob.domain.CommentDTO;

public class CommentPostgresqlDAO extends DAORelational implements CommentDAO{

	protected CommentPostgresqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(CommentDTO comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CommentDTO> find(CommentDTO comment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(CommentDTO comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
