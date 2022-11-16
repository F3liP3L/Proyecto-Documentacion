package edu.uco.quickjob.service.command;

import java.util.List;

import edu.uco.quickjob.domain.ServiceTypeDTO;
import edu.uco.quickjob.domain.SubserviceTypeDTO;

public interface FindSubserviceTypeCommand {
	
	List<SubserviceTypeDTO> findSubserviceType(String serviceType);

}
