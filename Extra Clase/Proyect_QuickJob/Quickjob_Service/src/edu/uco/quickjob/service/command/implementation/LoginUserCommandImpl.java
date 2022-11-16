package edu.uco.quickjob.service.command.implementation;

import edu.uco.quickjob.crosscutting.exception.QuickjobCustomException;
import edu.uco.quickjob.crosscutting.exception.service.ServiceCustomException;
import edu.uco.quickjob.crosscutting.messages.Messages;
import edu.uco.quickjob.data.dao.factory.DAOFactory;
import edu.uco.quickjob.data.enumeration.DAOFactoryType;
import edu.uco.quickjob.domain.UserDTO;
import edu.uco.quickjob.service.bussines.user.LoginUserUseCase;
import edu.uco.quickjob.service.bussines.user.implementation.LoginUserUseCaseImpl;
import edu.uco.quickjob.service.command.LoginUserCommand;

public class LoginUserCommandImpl implements LoginUserCommand {
	
	private final DAOFactory factory = DAOFactory.getDAOFactory(DAOFactoryType.POSTGRESQL);
	private final LoginUserUseCase useCase = new LoginUserUseCaseImpl(factory);

	@Override
	public UserDTO execute(UserDTO user) {
		UserDTO userLogin = null;
		try {
			factory.initTransaction();
			 userLogin = useCase.execute(user);
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
			// factory.closeConnection();
		}
		return userLogin;		
	}

}
