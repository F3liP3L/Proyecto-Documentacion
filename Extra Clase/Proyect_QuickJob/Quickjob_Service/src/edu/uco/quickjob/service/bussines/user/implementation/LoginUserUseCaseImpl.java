package edu.uco.quickjob.service.bussines.user.implementation;

import java.util.List;

import edu.uco.quickjob.crosscutting.exception.service.ServiceCustomException;
import edu.uco.quickjob.crosscutting.messages.Messages;
import edu.uco.quickjob.data.dao.factory.DAOFactory;
import edu.uco.quickjob.data.enumeration.DAOFactoryType;
import edu.uco.quickjob.domain.UserDTO;
import edu.uco.quickjob.service.bussines.user.FindUserUseCase;
import edu.uco.quickjob.service.bussines.user.LoginUserUseCase;

public class LoginUserUseCaseImpl implements LoginUserUseCase{

	private final FindUserUseCase findUserUseCase;
	private final FindUserByEmailUseCaseImpl findUserByEmail;

	public LoginUserUseCaseImpl (DAOFactory factory) {
		this.findUserUseCase = new FindUserUseCaseImpl(factory);
		this.findUserByEmail = new FindUserByEmailUseCaseImpl(factory);
	}
	@Override
	public UserDTO execute(UserDTO user) {
		
		
		boolean exist = findUserByEmail.execute(user.getEmail());
		
		boolean isEquals = findUserUseCase.findUser(UserDTO.create(user.getEmail())).get(0).getPassword().equals(user.getPassword());
		
		if (!exist) {
			throw ServiceCustomException.createUserException(Messages.LoginUserUseCaseImpl.BUSSINES_USER_DOESNT_EXISTS);
		} 
		if (!isEquals){
			throw ServiceCustomException.createUserException(Messages.LoginUserUseCaseImpl.BUSSINES_USER_INCORRECT_PASSWORD);
		}
		
		return findUserUseCase.findUser(user).get(0);
	}
	/*
	public static void main(String[] args) {
		UserDTO user = UserDTO.create("japofficial@gmail.com");
		List<UserDTO> users = DAOFactory.getDAOFactory(DAOFactoryType.POSTGRESQL).getUserDAO().find(user);
		users.forEach(elem -> System.out.println("the user is id:"  + elem.getIdAsString() + "the mail is: " +  "the name user is: [" + elem.getName() + "] whith email is: "+ elem.getEmail() + " the document identidad: " + elem.getIdentification()));
	}*/

}
