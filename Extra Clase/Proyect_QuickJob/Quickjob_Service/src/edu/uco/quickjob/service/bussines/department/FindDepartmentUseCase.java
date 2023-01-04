package edu.uco.quickjob.service.bussines.department;

import java.util.List;

import edu.uco.quickjob.domain.DepartmentDTO;

public interface FindDepartmentUseCase {
	
	List<DepartmentDTO> execute(DepartmentDTO department);

}
