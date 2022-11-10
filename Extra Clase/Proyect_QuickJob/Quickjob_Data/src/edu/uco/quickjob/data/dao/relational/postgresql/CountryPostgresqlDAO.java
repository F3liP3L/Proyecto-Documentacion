package edu.uco.quickjob.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;

import edu.uco.quickjob.data.dao.CountryDAO;
import edu.uco.quickjob.data.dao.relational.DAORelational;
import edu.uco.quickjob.domain.CountryDTO;

public class CountryPostgresqlDAO extends DAORelational implements CountryDAO {

	protected CountryPostgresqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public List<CountryDTO> find(CountryDTO country) {
		// TODO Auto-generated method stub
		return null;
	}

}
