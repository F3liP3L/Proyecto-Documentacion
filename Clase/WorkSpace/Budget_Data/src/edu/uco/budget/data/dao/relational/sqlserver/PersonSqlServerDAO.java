package edu.uco.budget.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import edu.uco.budget.data.dao.PersonDAO;
import edu.uco.budget.data.dao.relational.DAORelational;
import edu.uco.budget.domain.PersonDTO;

public final class PersonSqlServerDAO extends DAORelational implements PersonDAO {

	public PersonSqlServerDAO(final Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public final void create(PersonDTO person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final List<PersonDTO> find(PersonDTO person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final void update(PersonDTO person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
