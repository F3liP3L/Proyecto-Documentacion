package edu.uco.quickjob.service.bussines.identificationdocument.implementation;

import java.util.List;

import edu.uco.quickjob.data.dao.factory.DAOFactory;
import edu.uco.quickjob.domain.IdentificationDocumentDTO;
import edu.uco.quickjob.service.bussines.identificationdocument.FindIdentificationDocumentByNumberAndType;
import edu.uco.quickjob.service.bussines.identificationdocument.FindIdentificationDocumentUseCase;

public class FindIdentificationDocumentByNumberAndTypeUseCaseImpl implements FindIdentificationDocumentByNumberAndType {

	private final FindIdentificationDocumentUseCase findIdentificationDocumentUseCase;
	
	public FindIdentificationDocumentByNumberAndTypeUseCaseImpl(DAOFactory factory) {
		this.findIdentificationDocumentUseCase = new FindIdentificationDocumentUseCaseImpl(factory);
	}
	
	@Override
	public boolean execute(IdentificationDocumentDTO identificationDocument) {
		
		IdentificationDocumentDTO identificationByType = new IdentificationDocumentDTO();
		identificationByType.setIdentificationType(identificationDocument.getIdentificationType());
		boolean exist = false;
		List<IdentificationDocumentDTO> resultDocuments = findIdentificationDocumentUseCase.execute(identificationByType);
		if (findIdentificationTypeExist(resultDocuments, identificationDocument)) {
			exist = true;
		}
		return exist;
	}
	
	private static boolean findIdentificationTypeExist (List<IdentificationDocumentDTO> result, IdentificationDocumentDTO document) {
		return !result.stream().filter(doc -> doc.getIdentificationNumber().equalsIgnoreCase(document.getIdentificationNumber())).toList().isEmpty();
	}
}
