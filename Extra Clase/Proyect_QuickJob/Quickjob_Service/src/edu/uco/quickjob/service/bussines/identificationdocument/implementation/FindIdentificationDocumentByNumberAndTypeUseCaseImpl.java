package edu.uco.quickjob.service.bussines.identificationdocument.implementation;

import java.util.List;

import edu.uco.quickjob.data.dao.factory.DAOFactory;
import edu.uco.quickjob.data.enumeration.DAOFactoryType;
import edu.uco.quickjob.domain.IdentificationDocumentDTO;
import edu.uco.quickjob.domain.IdentificationTypeDTO;
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
		
		// Verificar que el numero de identificacion y el tipo no es el mismo
		
		IdentificationDocumentDTO identificationByNumber = new IdentificationDocumentDTO();
		identificationByNumber.setIdentificationNumber(identificationDocument.getIdentificationNumber());
		// identificationByNumber.setIdentificationType(IdentificationTypeDTO.create(identificationByNumber.getIdentificationType().getIdAsString()));
		boolean exist = false;
		if (findIdentificationDocumentUseCase.execute(identificationByNumber).isEmpty()) {
			exist = true;
		}
		/*
		if (findIdentificationDocumentUseCase.execute(identificationByNumber)
			.stream().filter(elem -> elem.getIdentificationNumber().equals(identificationByNumber.getIdentificationNumber()) && elem.getIdentificationType().getName().equals(identificationByNumber.getIdentificationType().getName()))
			.toList().size() > 1) {
				exist = true;
			}*/
		return exist;
	}
	
	/*
	public static void main(String[] args) {
		IdentificationDocumentDTO identification = IdentificationDocumentDTO.create(null, null, null, null, null, null);
		identification.setIdentificationNumber("10547654124");
		identification.setIdentificationType(IdentificationTypeDTO.create("df5659d3-ab5b-45f2-a9f4-4329180cddd5"));
		System.out.println(identification.getIdentificationNumber() + " -- " + identification.getIdentificationType().getName());
		List<IdentificationDocumentDTO> users = DAOFactory.getDAOFactory(DAOFactoryType.POSTGRESQL).getIdentificationDocumentDAO().find(identification);
		List<IdentificationDocumentDTO> usersRepeat = users.stream().filter(elem -> elem.getIdentificationNumber().equals("1000054564") && elem.getIdentificationType().getName().equals("Cedula de Extranjeria")).toList();
		
		usersRepeat.forEach(elem -> System.out.println(" Name: " + elem.getName() + " surname: " + elem.getSurname() +  " DNI : " + elem.getIdentificationNumber() + " Type: " + elem.getIdentificationType().getName()));
		System.out.println("longitud del array " + usersRepeat.size());
		// users.forEach(elem -> System.out.println("the DOCUMENT :"  + elem.getIdAsString() + "the name is " +  elem.getName() + "the surname is : [" + elem.getSurname() + " ]  \n\t The document is  " + elem.getIdentificationNumber() +  " the type document identidad: " + elem.getIdentificationType().getName()));
	}
	 */
}
