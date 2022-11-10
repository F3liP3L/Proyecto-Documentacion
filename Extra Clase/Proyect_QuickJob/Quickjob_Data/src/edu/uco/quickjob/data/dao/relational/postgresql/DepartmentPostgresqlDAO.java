package edu.uco.quickjob.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;

import edu.uco.quickjob.data.dao.DepartmentDAO;
import edu.uco.quickjob.data.dao.relational.DAORelational;
import edu.uco.quickjob.domain.DepartmentDTO;

public class DepartmentPostgresqlDAO extends DAORelational implements DepartmentDAO {

	protected DepartmentPostgresqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public List<DepartmentDTO> find(DepartmentDTO department) {
		// TODO Auto-generated method stub
		return null;
	}

}
