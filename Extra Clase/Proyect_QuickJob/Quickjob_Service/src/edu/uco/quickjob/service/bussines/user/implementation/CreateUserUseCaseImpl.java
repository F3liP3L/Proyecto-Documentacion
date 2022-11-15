package edu.uco.quickjob.service.bussines.user.implementation;

import edu.uco.quickjob.crosscutting.exception.service.ServiceCustomException;
import edu.uco.quickjob.crosscutting.helper.UUIDHelper;
import edu.uco.quickjob.crosscutting.messages.Messages;
import edu.uco.quickjob.data.dao.factory.DAOFactory;
import edu.uco.quickjob.domain.IdentificationDocumentDTO;
import edu.uco.quickjob.domain.UserDTO;
import edu.uco.quickjob.service.bussines.identificationdocument.CreateIdentificationDocumentUseCase;
import edu.uco.quickjob.service.bussines.identificationdocument.implementation.CreateIdentificationDocumentUseCaseImpl;
import edu.uco.quickjob.service.bussines.user.CreateUserUseCase;
import edu.uco.quickjob.service.bussines.user.FindUserByEmailUseCase;

public class CreateUserUseCaseImpl implements CreateUserUseCase {
	
	private final DAOFactory factory;
	private final CreateIdentificationDocumentUseCase createIdentificationDocumentUseCase;
	private final FindUserByEmailUseCase findUserByEmailUseCase;
	
	public CreateUserUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
		this.createIdentificationDocumentUseCase = new CreateIdentificationDocumentUseCaseImpl(factory);
		this.findUserByEmailUseCase = new FindUserByEmailUseCaseImpl(factory);
	}

	@Override
	public void execute(UserDTO user) {
		
		// 1.) Se debe verificar que no exista el mismo usuario.
		
		validateUserExits(user); // TODO terminar el validar si el correo es el mismo
		
		// 2.) Registrar la informacion de su documento de identificacion.
		
		IdentificationDocumentDTO identificationDocument = createIdentificationDocumentUseCase.createIdentificationDocument(user.getIdentification());
			
		// 3.) se debe crear el usuario.
		
		user.setIdentification(identificationDocument);
		user.setId(UUIDHelper.getNewUUID());
		
		factory.getUserDAO().create(user);
	}
	
		private void validateUserExits(UserDTO user) {
			if (findUserByEmailUseCase.execute(user.getEmail()).getEmail().equals(user.getEmail())) {
				throw ServiceCustomException.createUserException(Messages.CreateUserUseCaseImpl.BUSSINES_USER_EXISTS);
			}
		}
}
