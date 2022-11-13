package edu.uco.quickjob.service.bussines.identificationdocument;

import java.util.List;

import edu.uco.quickjob.domain.IdentificationDocumentDTO;

public interface FindIdentificationDocumentUseCase {
	
	List<IdentificationDocumentDTO> execute(IdentificationDocumentDTO identification);

}
