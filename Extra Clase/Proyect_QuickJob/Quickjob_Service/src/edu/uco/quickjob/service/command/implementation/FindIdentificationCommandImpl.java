package edu.uco.quickjob.service.command.implementation;

import java.util.ArrayList;
import java.util.List;

import edu.uco.quickjob.crosscutting.exception.QuickjobCustomException;
import edu.uco.quickjob.crosscutting.exception.service.ServiceCustomException;
import edu.uco.quickjob.crosscutting.messages.Messages;
import edu.uco.quickjob.data.dao.factory.DAOFactory;
import edu.uco.quickjob.data.enumeration.DAOFactoryType;
import edu.uco.quickjob.domain.IdentificationTypeDTO;
import edu.uco.quickjob.service.bussines.identificationType.FindIdentificationTypeUseCase;
import edu.uco.quickjob.service.bussines.identificationType.implementation.FindIdentificationTypeUseCaseImpl;
import edu.uco.quickjob.service.command.FindIdentificationTypeCommand;

public class FindIdentificationCommandImpl implements FindIdentificationTypeCommand {
	
	private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactoryType.POSTGRESQL);
	private FindIdentificationTypeUseCase useCase = new FindIdentificationTypeUseCaseImpl(factory);

	@Override
	public List<IdentificationTypeDTO> findIndetification() {
		List<IdentificationTypeDTO> result = new ArrayList<>();
		try {
			factory.initTransaction();
			result.addAll(useCase.findIdentification());
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
			throw ServiceCustomException.createBussinesException(Messages.FindDocumentIdentificationUseCaseImpl.BUSSINES_DOCUMENT_IDENTIFICATION_UNEXPECTED, exception);
		} finally {
			factory.closeConnection();
		}
		return result;
	}

}
