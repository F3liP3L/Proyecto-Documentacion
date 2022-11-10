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
	
	private IdentificationDocumentDTOBuilder() {
		super();
	}
	
	public static final IdentificationDocumentDTOBuilder getIdentificationDocumentDTOBuilder() {
		return new IdentificationDocumentDTOBuilder();
	}
	

	public UUID getId() {
		return id;
	}


	public final void setId(UUID id) {
		this.id = id;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final void setSurname(String surname) {
		this.surname = surname;
	}

	public final void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public final void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public final void setExpeditionDate(Date expeditionDate) {
		this.expeditionDate = expeditionDate;
	}

	public final void setExpeditionSite(String expeditionSite) {
		this.expeditionSite = expeditionSite;
	}

	public final void setSex(String sex) {
		this.sex = sex;
	}

	public final void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public final void setIdentificationType(IdentificationTypeDTO identificationType) {
		this.identificationType = identificationType;
	}
	
	

}
