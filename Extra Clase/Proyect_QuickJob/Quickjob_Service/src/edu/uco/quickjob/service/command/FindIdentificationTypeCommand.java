package edu.uco.quickjob.service.command;

import java.util.List;

import edu.uco.quickjob.domain.IdentificationTypeDTO;

public interface FindIdentificationTypeCommand {
	
	List<IdentificationTypeDTO> findIndetification (); 

}
