package edu.uco.quickjob.service.bussines.user.implementation;

import java.util.List;

import edu.uco.quickjob.data.dao.factory.DAOFactory;
import edu.uco.quickjob.domain.UserDTO;
import edu.uco.quickjob.service.bussines.user.FindUserUseCase;

public class FindUserUseCaseImpl implements FindUserUseCase{

	private final DAOFactory factory;
	
	
	public FindUserUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	}

	@Override
	public List<UserDTO> findUser(UserDTO user) {
		return factory.getUserDAO().find(user);
	}

}
