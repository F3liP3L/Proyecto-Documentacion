package edu.uco.quickjob.data.dao;

import java.util.List;

import edu.uco.quickjob.domain.IdentificationDocumentDTO;

public interface IdentificationDocumentDAO {
	
	IdentificationDocumentDTO create (IdentificationDocumentDTO identificationType);
	
	List<IdentificationDocumentDTO> find(IdentificationDocumentDTO identificationDocument);
	
	void update (IdentificationDocumentDTO identificationType);

}
