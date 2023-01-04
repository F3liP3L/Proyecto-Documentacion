package edu.uco.quickjob.service.command;

import java.util.List;

import edu.uco.quickjob.domain.ServiceTypeDTO;

public interface FindServiceTypeCommand {
	
	List<ServiceTypeDTO> findServiceType();

}
