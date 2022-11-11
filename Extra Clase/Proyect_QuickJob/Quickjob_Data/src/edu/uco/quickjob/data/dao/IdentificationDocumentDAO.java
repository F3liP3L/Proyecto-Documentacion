package edu.uco.quickjob.data.dao;

import java.util.List;

import edu.uco.quickjob.domain.IdentificationDocumentDTO;

public interface IdentificationDocumentDAO {
	
	void create (IdentificationDocumentDTO identificationType);
	
	List<IdentificationDocumentDTO> find(IdentificationDocumentDTO identificationDocument);
	
	void update (IdentificationDocumentDTO identificationType);

}
