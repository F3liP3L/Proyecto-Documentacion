package edu.uco.quickjob.service.bussines.user;

import edu.uco.quickjob.domain.UserDTO;

public interface LoginUserUseCase {
	
	UserDTO execute (UserDTO user);

}
