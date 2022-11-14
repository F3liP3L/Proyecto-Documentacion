package edu.uco.quickjob.service.command;

import edu.uco.quickjob.domain.UserDTO;

public interface CreateUserCommand {
	
	void createUser (UserDTO user);
	
}

