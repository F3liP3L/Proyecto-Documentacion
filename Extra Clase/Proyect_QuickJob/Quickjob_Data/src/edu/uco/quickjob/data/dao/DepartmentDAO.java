package edu.uco.quickjob.data.dao;

import java.util.List;

import edu.uco.quickjob.domain.DepartmentDTO;

public interface DepartmentDAO {

	
	List<DepartmentDTO> find(DepartmentDTO department);
}
