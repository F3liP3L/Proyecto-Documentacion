package edu.uco.quickjob.service.command;

import edu.uco.quickjob.domain.IdentificationDocumentDTO;

public interface CreateIdentificationDocumentCommand {
	
	IdentificationDocumentDTO createIdentificationDocument (IdentificationDocumentDTO identificationDocument);
	
}
