package edu.uco.quickjob.service.command;

import edu.uco.quickjob.domain.UserDTO;

public interface CreateUserCommand {
	
	void execute (UserDTO user);
	
}

