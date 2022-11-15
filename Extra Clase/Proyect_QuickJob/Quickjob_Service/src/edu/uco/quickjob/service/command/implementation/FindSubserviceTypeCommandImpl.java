package edu.uco.quickjob.service.command.implementation;

import java.util.ArrayList;
import java.util.List;

import edu.uco.quickjob.crosscutting.exception.QuickjobCustomException;
import edu.uco.quickjob.crosscutting.exception.service.ServiceCustomException;
import edu.uco.quickjob.crosscutting.messages.Messages;
import edu.uco.quickjob.data.dao.factory.DAOFactory;
import edu.uco.quickjob.data.enumeration.DAOFactoryType;
import edu.uco.quickjob.domain.SubserviceTypeDTO;
import edu.uco.quickjob.service.bussines.subservicetype.implementation.FindSubserviceTypeUseCaseImpl;
import edu.uco.quickjob.service.command.FindSubserviceTypeCommand;

public class FindSubserviceTypeCommandImpl implements FindSubserviceTypeCommand {
	
	private final DAOFactory factory = DAOFactory.getDAOFactory(DAOFactoryType.POSTGRESQL);
	private final FindSubserviceTypeUseCaseImpl useCase = new FindSubserviceTypeUseCaseImpl(factory);

	@Override
	public List<SubserviceTypeDTO> findSubserviceType() {
		List<SubserviceTypeDTO> result = new ArrayList<>();
		try {
			factory.initTransaction();
			result.addAll(useCase.findSubserviceTypeDTO());
		} catch (ServiceCustomException exception) {
			factory.cancelTransaction();
			throw exception;
		} catch (QuickjobCustomException exception) {
			factory.cancelTransaction();
			if(exception.isTechnicalException()) {
			throw ServiceCustomException.wrapException(null, exception);
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