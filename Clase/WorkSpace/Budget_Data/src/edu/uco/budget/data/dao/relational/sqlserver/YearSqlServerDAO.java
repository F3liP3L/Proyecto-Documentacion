package edu.uco.budget.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import edu.uco.budget.data.dao.YearDAO;
import edu.uco.budget.data.dao.relational.DAORelational;
import edu.uco.budget.domain.YearDTO;

public final class YearSqlServerDAO extends DAORelational implements YearDAO{

	public YearSqlServerDAO(final Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public final void create(YearDTO year) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final List<YearDTO> find(YearDTO year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final void update(YearDTO year) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
