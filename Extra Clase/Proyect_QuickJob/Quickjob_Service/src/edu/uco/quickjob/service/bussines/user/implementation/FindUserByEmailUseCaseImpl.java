package edu.uco.quickjob.service.bussines.user.implementation;

import java.util.List;

import edu.uco.quickjob.data.dao.factory.DAOFactory;
import edu.uco.quickjob.domain.UserDTO;
import edu.uco.quickjob.service.bussines.user.FindUserByEmailUseCase;
import edu.uco.quickjob.service.bussines.user.FindUserUseCase;

public class FindUserByEmailUseCaseImpl implements FindUserByEmailUseCase{

	private final DAOFactory factory;
	private final FindUserUseCase findUserUseCase;
	
	
	public FindUserByEmailUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
		this.findUserUseCase = new FindUserUseCaseImpl(factory);
	}

	@Override
	public UserDTO execute(String email) {
		
		final UserDTO user = UserDTO.create(email);
		final List<UserDTO> results = findUserUseCase.findUser(user);
		
		if(results.isEmpty()) {
			return new UserDTO();
		} 
			return results.get(0);
	}
}
