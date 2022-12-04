package edu.uco.quickjob.service.command.implementation;

import edu.uco.quickjob.crosscutting.exception.QuickjobCustomException;
import edu.uco.quickjob.crosscutting.exception.service.ServiceCustomException;
import edu.uco.quickjob.crosscutting.messages.Messages;
import edu.uco.quickjob.data.dao.factory.DAOFactory;
import edu.uco.quickjob.data.enumeration.DAOFactoryType;
import edu.uco.quickjob.domain.ServiceDTO;
import edu.uco.quickjob.service.bussines.service.CreateServiceUseCase;
import edu.uco.quickjob.service.bussines.service.implementation.CreateServiceUseCaseImpl;
import edu.uco.quickjob.service.command.CreateServiceCommand;

public class CreateServiceCommandImpl implements CreateServiceCommand {

	private final DAOFactory factory = DAOFactory.getDAOFactory(DAOFactoryType.POSTGRESQL);
	private final CreateServiceUseCase useCase = new CreateServiceUseCaseImpl(factory); 
	
	@Override
	public void execute(ServiceDTO service) {
		try {
			factory.openConnection();
			factory.initTransaction();
			useCase.execute(service);
			factory.confirmTransaction();
		} catch (ServiceCustomException exception) {
			factory.cancelTransaction();
			throw exception;
		} catch (QuickjobCustomException exception) {
			factory.cancelTransaction();
			if(exception.isTechnicalException()) {
			throw ServiceCustomException.wrapException(Messages.CreateServiceUseCaseImpl.BUSSINES_SERVICE_EXISTS, exception);
			}
		} catch (Exception exception) {
			factory.cancelTransaction();
			throw ServiceCustomException.createBussinesException(Messages.CreateServiceUseCaseImpl.BUSSINES_SERVICE_UNEXPECTED, exception);
		} finally {
			factory.closeConnection();
		}
		
	}

}
