package edu.uco.quickjob.data.dao;

import java.util.List;

import edu.uco.quickjob.domain.ServiceTypeDTO;

public interface ServiceTypeDAO {

	List<ServiceTypeDTO> find();
	
}
