package edu.uco.quickjob.service.bussines.user;

import edu.uco.quickjob.domain.UserDTO;

public interface FindUserByEmailUseCase {

	UserDTO execute(String email);

}
