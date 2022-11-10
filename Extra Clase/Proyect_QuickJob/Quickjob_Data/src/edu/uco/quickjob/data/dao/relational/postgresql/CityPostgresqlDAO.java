package edu.uco.quickjob.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;

import edu.uco.quickjob.data.dao.CityDAO;
import edu.uco.quickjob.data.dao.relational.DAORelational;
import edu.uco.quickjob.domain.CityDTO;

public class CityPostgresqlDAO extends DAORelational implements CityDAO{

	protected CityPostgresqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public List<CityDTO> find(CityDTO city) {
		// TODO Auto-generated method stub
		return null;
	}

}
