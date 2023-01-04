package edu.uco.quickjob.service.bussines.serviceprovider;

import edu.uco.quickjob.domain.ServiceProviderDTO;

public interface CreateServiceProviderUseCase {
	
	void execute(ServiceProviderDTO serviceProvider);

}
