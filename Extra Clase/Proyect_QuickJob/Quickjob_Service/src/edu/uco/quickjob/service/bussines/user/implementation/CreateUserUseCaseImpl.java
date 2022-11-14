package edu.uco.quickjob.service.bussines.user.implementation;

import edu.uco.quickjob.crosscutting.exception.service.ServiceCustomException;
import edu.uco.quickjob.crosscutting.helper.UUIDHelper;
import edu.uco.quickjob.crosscutting.messages.Messages;
import edu.uco.quickjob.data.dao.factory.DAOFactory;
import edu.uco.quickjob.domain.UserDTO;
import edu.uco.quickjob.service.bussines.identificationdocument.CreateIdentificationDocumentUseCase;
import edu.uco.quickjob.service.bussines.identificationdocument.implementation.CreateIdentificationDocumentUseCaseImpl;
import edu.uco.quickjob.service.bussines.user.CreateUserUseCase;
import edu.uco.quickjob.service.bussines.user.FindUserUseCase;

public class CreateUserUseCaseImpl implements CreateUserUseCase {
	
	private final DAOFactory factory;
	private final CreateIdentificationDocumentUseCase createIdentificationDocumentUseCase;
	private final FindUserUseCase findUserUseCase;
	
	public CreateUserUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
		this.createIdentificationDocumentUseCase = new CreateIdentificationDocumentUseCaseImpl(factory);
		this.findUserUseCase = new FindUserUseCaseImpl(factory);
	}

	@Override
	public void execute(UserDTO user) {
		
		// 1.) Se debe verificar que no exista el mismo usuario.
		
		validateUserExits(user);
		
		// 2.) Registrar la informacion de su documento de identificacion.
		
		createIdentificationDocumentUseCase.execute(user.getIdentification());
			
		// 3.) se debe crear el usuario.
		user.setId(UUIDHelper.getNewUUID());
		
		factory.getUserDAO().create(user);
	}
	
	
	private void validateUserExits(UserDTO user) {
			if (!findUserUseCase.findUser(user).isEmpty()) {
				throw ServiceCustomException.createUserException(Messages.CreateUserUseCaseImpl.BUSSINES_USER_EXISTS);
			}
		}
}
