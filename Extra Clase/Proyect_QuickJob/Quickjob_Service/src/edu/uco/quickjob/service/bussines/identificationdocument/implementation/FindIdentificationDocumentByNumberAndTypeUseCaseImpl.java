package edu.uco.quickjob.service.bussines.identificationdocument.implementation;

import edu.uco.quickjob.data.dao.factory.DAOFactory;
import edu.uco.quickjob.domain.IdentificationDocumentDTO;
import edu.uco.quickjob.service.bussines.identificationdocument.FindIdentificationDocumentByNumberAndType;
import edu.uco.quickjob.service.bussines.identificationdocument.FindIdentificationDocumentUseCase;

public class FindIdentificationDocumentByNumberAndTypeUseCaseImpl implements FindIdentificationDocumentByNumberAndType {

	private final DAOFactory factory;
	private final FindIdentificationDocumentUseCase findIdentificationDocumentUseCase;
	
	public FindIdentificationDocumentByNumberAndTypeUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
		this.findIdentificationDocumentUseCase = new FindIdentificationDocumentUseCaseImpl(factory);
	}
	
	@Override
	public boolean execute(IdentificationDocumentDTO identificationDocument) {
		
		IdentificationDocumentDTO identificationByNumber = new IdentificationDocumentDTO();
		identificationByNumber.setIdentificationNumber(identificationDocument.getIdentificationNumber());
		// identificationByNumber.setIdentificationType(IdentificationTypeDTO.create(identificationByNumber.getIdentificationType().getIdAsString()));
		boolean exist = false;
		if (findIdentificationDocumentUseCase.execute(identificationByNumber).isEmpty()) {
			exist = true;
		}
		return exist;
	}
}
