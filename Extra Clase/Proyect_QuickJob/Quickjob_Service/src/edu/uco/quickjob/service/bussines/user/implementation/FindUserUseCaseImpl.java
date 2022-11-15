package edu.uco.quickjob.service.bussines.user.implementation;

import java.util.List;

import edu.uco.quickjob.data.dao.factory.DAOFactory;
import edu.uco.quickjob.data.enumeration.DAOFactoryType;
import edu.uco.quickjob.domain.UserDTO;
import edu.uco.quickjob.service.bussines.user.FindUserUseCase;

public class FindUserUseCaseImpl implements FindUserUseCase {
	
	private final DAOFactory factory;
	
	public FindUserUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	}

	@Override
	public List<UserDTO> findUser(UserDTO user) {
		return factory.getUserDAO().find(user);
	}
	/*
	public static void main(String[] args) {
		
		final UserDTO user = UserDTO.create("jessica.alarcon9124@gmail.com");
		System.out.println(user.getName() + " city " + user.getResidenceCity());
		
		
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactoryType.POSTGRESQL);
		List<UserDTO> users = factory.getUserDAO().find(user);
		users.forEach(elem -> System.out.println("id: " + elem.getIdAsString() + " nombre: " + elem.getName() + " Correo: " + elem.getEmail()));
	}*/

}
