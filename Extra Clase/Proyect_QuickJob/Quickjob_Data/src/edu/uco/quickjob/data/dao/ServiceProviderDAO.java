package edu.uco.quickjob.data.dao;

import java.util.List;
import java.util.UUID;

import edu.uco.quickjob.domain.ServiceProviderDTO;

public interface ServiceProviderDAO {
	
	void create (ServiceProviderDTO serviceProvider);
	
	List<ServiceProviderDTO> find(ServiceProviderDTO serviceProvider);
	
	void update (ServiceProviderDTO serviceProvider);
	
	void delete (UUID id);
		
}
