package edu.uco.quickjob.data.dao;

import java.util.List;
import java.util.UUID;

import edu.uco.quickjob.domain.IdentificationDocumentDTO;

public interface IdentificationDocumentDAO {
	
	void create (IdentificationDocumentDTO identificationType);
	
	List<IdentificationDocumentDTO> find(IdentificationDocumentDTO identificationDocument);
	
	void delete (UUID id);

}
