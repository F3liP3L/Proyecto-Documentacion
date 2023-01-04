package edu.uco.quickjob.service.bussines.identificationdocument;

import edu.uco.quickjob.domain.IdentificationDocumentDTO;

public interface FindIdentificationDocumentByNumberAndType {

	boolean execute (IdentificationDocumentDTO identificationDocument);
	
}
