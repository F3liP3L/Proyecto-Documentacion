package edu.uco.quickjob.service.command;

import edu.uco.quickjob.domain.IdentificationDocumentDTO;

public interface CreateIdentificationDocumentCommand {
	
	void execute (IdentificationDocumentDTO identificationDocument);

}
