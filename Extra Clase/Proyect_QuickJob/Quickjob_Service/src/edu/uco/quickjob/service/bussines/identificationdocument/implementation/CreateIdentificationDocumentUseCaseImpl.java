package edu.uco.quickjob.service.bussines.identificationdocument.implementation;

import edu.uco.quickjob.crosscutting.exception.service.ServiceCustomException;
import edu.uco.quickjob.crosscutting.helper.UUIDHelper;
import edu.uco.quickjob.crosscutting.messages.Messages;
import edu.uco.quickjob.data.dao.factory.DAOFactory;
import edu.uco.quickjob.domain.IdentificationDocumentDTO;
import edu.uco.quickjob.service.bussines.identificationdocument.CreateIdentificationDocumentUseCase;
import edu.uco.quickjob.service.bussines.identificationdocument.FindIdentificationDocumentByNumberAndType;

public class CreateIdentificationDocumentUseCaseImpl implements CreateIdentificationDocumentUseCase {

	private final DAOFactory factory;
	private final FindIdentificationDocumentByNumberAndType findDocumentByNumberAndType;
	
	public CreateIdentificationDocumentUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
		this.findDocumentByNumberAndType = new FindIdentificationDocumentByNumberAndTypeUseCaseImpl(factory);
	}
	
	private final void validateIfDocumentIdentificationExist(IdentificationDocumentDTO identificationDocument) {
		if (!findDocumentByNumberAndType.execute(identificationDocument)) {
			throw ServiceCustomException.createUserException(Messages.FindDocumentIdentificationUseCaseImpl.BUSSINES_DOCUMENT_IDENTIFICATION_EXISTS);
		}
	}

	@Override
	public IdentificationDocumentDTO createIdentificationDocument(IdentificationDocumentDTO identificatinDocumentDTO) {
		
		// 1.) Verificar si existe un documento de identificacion con el mismo numero.
		
		validateIfDocumentIdentificationExist(identificatinDocumentDTO);
		
		// 2.) Crear el documento de identificacion.
		
		identificatinDocumentDTO.setId(UUIDHelper.getNewUUID());
		
		return factory.getIdentificationDocumentDAO().create(identificatinDocumentDTO);
	}


}
