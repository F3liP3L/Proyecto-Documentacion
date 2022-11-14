package edu.uco.quickjob.service.command.implementation;

import edu.uco.quickjob.crosscutting.exception.QuickjobCustomException;
import edu.uco.quickjob.crosscutting.exception.service.ServiceCustomException;
import edu.uco.quickjob.crosscutting.messages.Messages;
import edu.uco.quickjob.data.dao.factory.DAOFactory;
import edu.uco.quickjob.data.enumeration.DAOFactoryType;
import edu.uco.quickjob.domain.IdentificationDocumentDTO;
import edu.uco.quickjob.service.bussines.identificationdocument.CreateIdentificationDocumentUseCase;
import edu.uco.quickjob.service.bussines.identificationdocument.implementation.CreateIdentificationDocumentUseCaseImpl;

public class CreateIdentificationDocumentCommandImpl implements CreateIdentificationDocumentUseCase{
	
	private final DAOFactory factory = DAOFactory.getDAOFactory(DAOFactoryType.POSTGRESQL);
	private final CreateIdentificationDocumentUseCase useCase = new CreateIdentificationDocumentUseCaseImpl(factory);

	@Override
	public void execute(IdentificationDocumentDTO identificatinDocumentDTO) {
		try {
			factory.initTransaction();
			useCase.execute(identificatinDocumentDTO);
			factory.confirmTransaction();
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
	}
}
