package edu.uco.quickjob.service.bussines.identificationType;

import java.util.List;

import edu.uco.quickjob.domain.IdentificationTypeDTO;

public interface FindIdentificationTypeUseCase {
	
	List<IdentificationTypeDTO> findIdentification();

}
