package edu.uco.quickjob.service.bussines.serviceprovider.implementation;

import edu.uco.quickjob.data.dao.factory.DAOFactory;
import edu.uco.quickjob.domain.ServiceProviderDTO;
import edu.uco.quickjob.service.bussines.serviceprovider.CreateServiceProviderUseCase;

public class CreateServiceProviderUseCaseImpl implements CreateServiceProviderUseCase {

	
	private DAOFactory factory;
	
	public CreateServiceProviderUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	}

	@Override
	public void execute(ServiceProviderDTO serviceProvider) {
		factory.getServiceProviderDAO().create(serviceProvider);
	}
}
