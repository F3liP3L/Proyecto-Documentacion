package edu.uco.quickjob.service.bussines.user;

import java.util.List;

import edu.uco.quickjob.domain.UserDTO;

public interface FindUserUseCase {

	List<UserDTO> findUser(UserDTO user);

}
