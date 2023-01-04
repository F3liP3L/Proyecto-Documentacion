package edu.uco.quickjob.service.command;

import edu.uco.quickjob.domain.ServiceDTO;

public interface CreateServiceCommand {
	
	void execute (ServiceDTO service);

}
