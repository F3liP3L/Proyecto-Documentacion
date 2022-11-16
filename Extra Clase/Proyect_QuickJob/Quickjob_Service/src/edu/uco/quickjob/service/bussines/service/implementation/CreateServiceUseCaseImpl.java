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
		
		//TODO implement methods to create the service
		
		//1.) Se debe verificar que exista el prestador de servicios.
		//2.) Se debe crear el servicio.
		
	}

}
