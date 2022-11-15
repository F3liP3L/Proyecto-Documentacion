package edu.uco.quickjob.service.bussines.servicetype;

import java.util.List;

import edu.uco.quickjob.domain.ServiceTypeDTO;

public interface FindServiceTypeUseCase {

	List<ServiceTypeDTO> findServiceType();
		
}
