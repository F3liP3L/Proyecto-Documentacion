package edu.uco.quickjob.data.dao;

import java.util.List;

import edu.uco.quickjob.domain.ServiceTypeDTO;
import edu.uco.quickjob.domain.SubserviceTypeDTO;

public interface SubserviceTypeDAO {
	
	List<SubserviceTypeDTO> find(String serviceType);

}
