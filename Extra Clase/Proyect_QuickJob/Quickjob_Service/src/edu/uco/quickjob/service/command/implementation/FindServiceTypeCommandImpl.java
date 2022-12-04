package edu.uco.quickjob.service.command.implementation;

import java.util.ArrayList;
import java.util.List;

import edu.uco.quickjob.crosscutting.exception.QuickjobCustomException;
import edu.uco.quickjob.crosscutting.exception.service.ServiceCustomException;
import edu.uco.quickjob.crosscutting.messages.Messages;
import edu.uco.quickjob.data.dao.factory.DAOFactory;
import edu.uco.quickjob.data.enumeration.DAOFactoryType;
import edu.uco.quickjob.domain.ServiceTypeDTO;
import edu.uco.quickjob.service.bussines.servicetype.implementation.FindServiceTypeUseCaseImpl;
import edu.uco.quickjob.service.command.FindServiceTypeCommand;

public class FindServiceTypeCommandImpl implements FindServiceTypeCommand {
	
	private final DAOFactory factory = DAOFactory.getDAOFactory(DAOFactoryType.POSTGRESQL);
	private final FindServiceTypeUseCaseImpl useCase = new FindServiceTypeUseCaseImpl(factory);

	@Override
	public List<ServiceTypeDTO> findServiceType() {
		List<ServiceTypeDTO> result = new ArrayList<>();
		try {
			factory.openConnection();
			factory.initTransaction();
			result.addAll(useCase.findServiceType());
		} catch (ServiceCustomException exception) {
			factory.cancelTransaction();
			throw exception;
		} catch (QuickjobCustomException exception) {
			factory.cancelTransaction();
			if(exception.isTechnicalException()) {
			throw ServiceCustomException.wrapException(Messages.FindServiceTypeUseCaseImpl.BUSSINES_SERVICE_TYPE_UNEXPECTED, exception);
			}
		} catch (Exception exception) {
			factory.cancelTransaction();
			throw ServiceCustomException.createBussinesException(Messages.FindServiceTypeUseCaseImpl.BUSSINES_SERVICE_TYPE_UNEXPECTED, exception);
		} finally {
			factory.closeConnection();
		}
		return result;
	}

}
