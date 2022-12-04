package edu.uco.quickjob.service.bussines.identificationdocument.implementation;

import java.util.List;
import java.util.UUID;

import edu.uco.quickjob.crosscutting.helper.UUIDHelper;
import edu.uco.quickjob.data.dao.factory.DAOFactory;
import edu.uco.quickjob.data.enumeration.DAOFactoryType;
import edu.uco.quickjob.domain.IdentificationDocumentDTO;
import edu.uco.quickjob.domain.IdentificationTypeDTO;
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
	
	public static void main(String[] args) {
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactoryType.POSTGRESQL);
		IdentificationDocumentDTO document = new IdentificationDocumentDTO();
		factory.openConnection();
		// factory.getIdentificationTypeDAO().find().forEach(elem -> System.out.println(elem.getIdAsString() + " -- " + elem.getName()));;
		UUID id = UUIDHelper.getUUIDFromString("df5659d3-ab5b-45f2-a9f4-4329180cddd5");
		IdentificationTypeDTO documentTypeDTO = IdentificationTypeDTO.create(id);
		document.setIdentificationType(documentTypeDTO);
		document.setIdentificationNumber("1000101338");
		List<IdentificationDocumentDTO> results = factory.getIdentificationDocumentDAO().find(document); //.forEach(e -> System.out.println(e.getIdAsString() + " -- " + e.getSurname() + " -- digitos: " + e.getIdentificationNumber() + " -- Type: "+ e.getIdentificationType().getName()));
		results.forEach(e -> System.out.println(e.getIdAsString() + " -- " + e.getSurname() + " -- digitos: " + e.getIdentificationNumber() + " -- Type: "+ e.getIdentificationType().getName()));
		System.out.println(findIdentificationTypeExist(results, document));
		
	}
}
