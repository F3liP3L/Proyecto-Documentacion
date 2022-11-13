package edu.uco.quickjob.service.command.implementation;

import edu.uco.quickjob.crosscutting.exception.QuickjobCustomException;
import edu.uco.quickjob.crosscutting.exception.service.ServiceCustomException;
import edu.uco.quickjob.crosscutting.messages.Messages;
import edu.uco.quickjob.data.dao.factory.DAOFactory;
import edu.uco.quickjob.data.enumeration.DAOFactoryType;
import edu.uco.quickjob.domain.UserDTO;
import edu.uco.quickjob.service.command.CreateUserCommand;

public class CreateUserCommandImpl implements CreateUserCommand {


	private final DAOFactory factory = DAOFactory.getDAOFactory(DAOFactoryType.SQLSERVER);

	
	@Override
	public void execute(UserDTO user) {
		try {
			factory.initTransaction();
			// Use case execution
			// useCase.execute(user);
			factory.confirmTransaction();
		} catch (ServiceCustomException exception) {
			factory.cancelTransaction();
			throw exception;
		} catch (QuickjobCustomException exception) {
			factory.cancelTransaction();
			if(exception.isTechnicalException()) {
				// Wrapper negocio!!
			throw ServiceCustomException.wrapException(null, exception);
			}
		} catch (Exception exception) {
			factory.cancelTransaction();
			throw ServiceCustomException.createBussinesException(Messages.CreateUserUseCaseImpl.BUSSINES_UNEXPECTED, exception);
		} finally {
			factory.closeConnection();
		}
		
	}

}
