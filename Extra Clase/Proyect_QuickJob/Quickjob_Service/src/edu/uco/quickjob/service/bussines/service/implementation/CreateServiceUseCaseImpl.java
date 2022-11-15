package edu.uco.quickjob.service.bussines.service.implementation;

import edu.uco.quickjob.data.dao.factory.DAOFactory;
import edu.uco.quickjob.domain.ServiceDTO;
import edu.uco.quickjob.service.bussines.service.CreateServiceUseCase;

public class CreateServiceUseCaseImpl implements CreateServiceUseCase {
	
	private DAOFactory factory;
	

	public CreateServiceUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	}




	@Override
	public void createService(ServiceDTO service) {
		
	}

}
