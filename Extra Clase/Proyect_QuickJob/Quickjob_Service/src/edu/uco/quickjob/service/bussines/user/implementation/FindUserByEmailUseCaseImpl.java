package edu.uco.quickjob.service.bussines.user.implementation;

import edu.uco.quickjob.data.dao.factory.DAOFactory;
import edu.uco.quickjob.domain.UserDTO;
import edu.uco.quickjob.service.bussines.user.FindUserByEmailUseCase;
import edu.uco.quickjob.service.bussines.user.FindUserUseCase;

public class FindUserByEmailUseCaseImpl implements FindUserByEmailUseCase {

	private final FindUserUseCase findUserUseCase;

	public FindUserByEmailUseCaseImpl(DAOFactory factory) {
		this.findUserUseCase = new FindUserUseCaseImpl(factory);
	}

	@Override
	public boolean execute(String email) {

		final UserDTO user = UserDTO.create(email);

		return !findUserUseCase.findUser(user).isEmpty();
	}

}
