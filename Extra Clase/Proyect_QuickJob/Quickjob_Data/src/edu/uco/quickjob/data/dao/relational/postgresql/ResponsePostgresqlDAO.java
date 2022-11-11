package edu.uco.quickjob.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;

import edu.uco.quickjob.data.dao.ResponseDAO;
import edu.uco.quickjob.data.dao.relational.DAORelational;
import edu.uco.quickjob.domain.ResponseDTO;

public class ResponsePostgresqlDAO extends DAORelational implements ResponseDAO {

	protected ResponsePostgresqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(ResponseDTO response) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ResponseDTO> find(ResponseDTO response) {
		// TODO Auto-generated method stub
		return null;
	}

}
