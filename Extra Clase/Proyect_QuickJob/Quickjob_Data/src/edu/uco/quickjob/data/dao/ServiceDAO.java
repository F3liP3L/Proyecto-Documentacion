package edu.uco.quickjob.data.dao;

import java.util.List;
import java.util.UUID;

import edu.uco.quickjob.domain.ServiceDTO;

public interface ServiceDAO {
	
	void create (ServiceDTO service);
	
	List<ServiceDTO> find(ServiceDTO service);
	
	void update (ServiceDTO service);
	
	void delete (UUID id);

}
