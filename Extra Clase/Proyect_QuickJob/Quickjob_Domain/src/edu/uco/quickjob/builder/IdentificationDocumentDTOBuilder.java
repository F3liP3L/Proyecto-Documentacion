package edu.uco.quickjob.builder;

import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getDefaultUUID;

import java.sql.Date;
import java.util.UUID;

import edu.uco.quickjob.domain.CityDTO;
import edu.uco.quickjob.domain.IdentificationDocumentDTO;
import edu.uco.quickjob.domain.IdentificationTypeDTO;

public final class IdentificationDocumentDTOBuilder {

	private UUID id;
	private String name;
	private String surname;
	private Date birthDate;
	private CityDTO placeOfBirth;
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

	public IdentificationDocumentDTOBuilder(String name, String surname, Date birthDate, CityDTO placeOfBirth,
			String identificationNumber, IdentificationTypeDTO identificationType) {
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.placeOfBirth = placeOfBirth;
		this.identificationNumber = identificationNumber;
		this.identificationType = identificationType;
	}

	public UUID getId() {
		return id;
	}

	public final void setId(UUID id) {
		this.id = getDefaultUUID(id);
	}

	public final IdentificationDocumentDTOBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public final IdentificationDocumentDTOBuilder setSurname(String surname) {
		this.surname = surname;
		return this;
	}

	public final IdentificationDocumentDTOBuilder setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
		return this;
	}

	public final IdentificationDocumentDTOBuilder setPlaceOfBirth(CityDTO placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
		return this;
	}

	public final IdentificationDocumentDTOBuilder setExpeditionDate(Date expeditionDate) {
		this.expeditionDate = expeditionDate;
		return this;
	}

	public final IdentificationDocumentDTOBuilder setExpeditionSite(String expeditionSite) {
		this.expeditionSite = expeditionSite;
		return this;
	}

	public final IdentificationDocumentDTOBuilder setSex(String sex) {
		this.sex = sex;
		return this;
	}

	public final IdentificationDocumentDTOBuilder setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
		return this;
	}

	public final IdentificationDocumentDTOBuilder setIdentificationType(IdentificationTypeDTO identificationType) {
		this.identificationType = identificationType;
		return this;
	}

	public Date getExpeditionDate() {
		return expeditionDate;
	}

	public String getExpeditionSite() {
		return expeditionSite;
	}

	public String getSex() {
		return sex;
	}

	public final IdentificationDocumentDTO build() {
		return IdentificationDocumentDTO.create(name, surname, birthDate, placeOfBirth, identificationNumber,
				identificationType);
	}

}
