package edu.uco.quickjob.service.command;

import edu.uco.quickjob.domain.UserDTO;

public interface LoginUserCommand {
	
	UserDTO execute(UserDTO user);

}
