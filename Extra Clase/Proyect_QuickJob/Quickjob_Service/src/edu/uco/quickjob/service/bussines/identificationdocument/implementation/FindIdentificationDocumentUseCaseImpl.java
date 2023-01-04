package edu.uco.quickjob.service.bussines.identificationdocument.implementation;

import java.util.List;

import edu.uco.quickjob.data.dao.factory.DAOFactory;
import edu.uco.quickjob.domain.IdentificationDocumentDTO;
import edu.uco.quickjob.service.bussines.identificationdocument.FindIdentificationDocumentUseCase;

public class FindIdentificationDocumentUseCaseImpl implements FindIdentificationDocumentUseCase {

	private final DAOFactory factory;

	
	public FindIdentificationDocumentUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public List<IdentificationDocumentDTO> execute(IdentificationDocumentDTO identification) {
		return factory.getIdentificationDocumentDAO().find(identification);
	}
	

}
