package edu.uco.quickjob.builder;

import java.sql.Date;
import java.util.UUID;


import edu.uco.quickjob.domain.IdentificationTypeDTO;

public final class IdentificationDocumentDTOBuilder {
	
	private UUID id;
	private String name;
	private String surname;
	private Date birthDate;
	private String placeOfBirth;
	private Date expeditionDate;
	private String expeditionSite;
	private String sex;
	private String identificationNumber;
	private IdentificationTypeDTO identificationType;

}
