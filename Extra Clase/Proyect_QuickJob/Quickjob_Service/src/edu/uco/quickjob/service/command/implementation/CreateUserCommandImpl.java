package edu.uco.quickjob.service.command.implementation;

import edu.uco.quickjob.crosscutting.exception.QuickjobCustomException;
import edu.uco.quickjob.crosscutting.exception.service.ServiceCustomException;
import edu.uco.quickjob.crosscutting.messages.Messages;
import edu.uco.quickjob.data.dao.factory.DAOFactory;
import edu.uco.quickjob.data.enumeration.DAOFactoryType;
import edu.uco.quickjob.domain.UserDTO;
import edu.uco.quickjob.service.bussines.user.CreateUserUseCase;
import edu.uco.quickjob.service.bussines.user.implementation.CreateUserUseCaseImpl;
import edu.uco.quickjob.service.command.CreateUserCommand;

public class CreateUserCommandImpl implements CreateUserCommand {
	
	private final DAOFactory factory = DAOFactory.getDAOFactory(DAOFactoryType.POSTGRESQL);
	private final CreateUserUseCase useCase = new CreateUserUseCaseImpl(factory);

	@Override
	public final void createUser(final UserDTO user) {
		try {
			factory.initTransaction();
			useCase.execute(user);
			factory.confirmTransaction();
		} catch (ServiceCustomException exception) {
			factory.cancelTransaction();
			throw exception;
		} catch (QuickjobCustomException exception) {
			factory.cancelTransaction();
			if(exception.isTechnicalException()) {
			throw ServiceCustomException.wrapException(Messages.CreateUserUseCaseImpl.BUSSINES_USER_EXISTS, exception);
			}
		} catch (Exception exception) {
			factory.cancelTransaction();
			throw ServiceCustomException.createBussinesException(Messages.CreateUserUseCaseImpl.BUSSINES_USER_UNEXPECTED, exception);
		} finally {
			factory.closeConnection();
		}
		
	}

}
