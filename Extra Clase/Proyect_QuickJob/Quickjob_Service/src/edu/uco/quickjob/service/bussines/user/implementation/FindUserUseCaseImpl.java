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
	
	public static void main(String[] args) {
		List<UserDTO> users = DAOFactory.getDAOFactory(DAOFactoryType.POSTGRESQL).getUserDAO().find(null);
		users.forEach(elem -> System.out.println("the user is id:"  + elem.getIdAsString() + "the mail is: " + elem.getEmail() + " the document identidad: " + elem.getIdentification()));
	}

}
