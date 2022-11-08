package edu.uco.quickjob.data.dao;

import java.util.List;

import edu.uco.quickjob.domain.IdentificationDocumentDTO;

public interface IdentificationDocumentDAO {
	
	
	List<IdentificationDocumentDTO> find(IdentificationDocumentDTO identificationDocument);

}
