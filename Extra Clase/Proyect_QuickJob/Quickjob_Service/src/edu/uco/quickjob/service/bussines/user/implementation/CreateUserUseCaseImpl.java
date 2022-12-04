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

		validateUserExits(user);

		IdentificationDocumentDTO identificationDocument = createIdentificationDocumentUseCase
				.createIdentificationDocument(user.getIdentification());

		user.setIdentification(identificationDocument);
		user.setId(UUIDHelper.getNewUUID());

		factory.getUserDAO().create(user);
	}

	private void validateUserExits(UserDTO user) {
		boolean exist = findUserByEmailUseCase.execute(user.getEmail());
		if (exist) {
			throw ServiceCustomException.createUserException(Messages.CreateUserUseCaseImpl.BUSSINES_USER_EXISTS_FOR_MAIL);
		}
	}
}
