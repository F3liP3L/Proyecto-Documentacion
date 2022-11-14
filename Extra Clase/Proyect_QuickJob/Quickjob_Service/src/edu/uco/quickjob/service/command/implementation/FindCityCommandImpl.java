package edu.uco.quickjob.service.command.implementation;

import java.util.ArrayList;
import java.util.List;

import edu.uco.quickjob.crosscutting.exception.QuickjobCustomException;
import edu.uco.quickjob.crosscutting.exception.service.ServiceCustomException;
import edu.uco.quickjob.crosscutting.messages.Messages;
import edu.uco.quickjob.data.dao.factory.DAOFactory;
import edu.uco.quickjob.data.enumeration.DAOFactoryType;
import edu.uco.quickjob.domain.CityDTO;
import edu.uco.quickjob.service.bussines.city.implementation.FindCityUseCaseImpl;
import edu.uco.quickjob.service.command.FindCityCommand;

public class FindCityCommandImpl implements FindCityCommand {

	private final DAOFactory factory = DAOFactory.getDAOFactory(DAOFactoryType.POSTGRESQL);
	private final FindCityUseCaseImpl useCase = new FindCityUseCaseImpl(factory);
	
	@Override
	public List<CityDTO> findCity() {
		List<CityDTO> result = new ArrayList<>();
		try {
			factory.initTransaction();
			result.addAll(useCase.findCity());
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
