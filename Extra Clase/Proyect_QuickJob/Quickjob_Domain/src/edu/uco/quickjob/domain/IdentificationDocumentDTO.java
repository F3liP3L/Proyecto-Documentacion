package edu.uco.quickjob.domain;

import java.sql.Date;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getUUIDAsString;
import java.util.UUID;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.quickjob.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.quickjob.crosscutting.helper.ObjectHelper.getDefaultIfNull;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getUUIDFromString;
import static edu.uco.quickjob.builder.IdentificationTypeDTOBuilder.getIdentificationTypeDTOBuilder;
import static edu.uco.quickjob.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.quickjob.crosscutting.helper.DateHelper.getDefaultDate;
import static edu.uco.quickjob.crosscutting.helper.DateHelper.getLocalDateADate;
import static edu.uco.quickjob.builder.CityDTOBuilder.getCityDTOBuilder;

public final class IdentificationDocumentDTO {
	
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
	
	public IdentificationDocumentDTO() {
		setId(getNewUUID());
		setName(EMPTY);
		setSurname(EMPTY);
		setBirthDate(birthDate);
		setPlaceOfBirth(getCityDTOBuilder().build());
		setExpeditionDate(getLocalDateADate(getDefaultDate()));
		setExpeditionSite(EMPTY);
		setIdentificationNumber(EMPTY);
		setIdentificationType(getIdentificationTypeDTOBuilder().build());
	}
	
	public IdentificationDocumentDTO(final UUID id, final String name, final String surname, final Date birthDate,final CityDTO placeOfBirth,
			final Date expeditionDate, final String expeditionSite, final String sex, final String identificationNumber, final IdentificationTypeDTO identificationType) {
			setId(id);
			setName(name);
			setSurname(surname);
			setBirthDate(birthDate);
			setPlaceOfBirth(placeOfBirth);
			setExpeditionDate(expeditionDate);
			setExpeditionSite(expeditionSite);
			setSex(sex);
			setIdentificationNumber(identificationNumber);
			setIdentificationType(identificationType);
	}
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = getDefaultUUID(id);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = applyTrim(name) ;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = applyTrim(surname);
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public CityDTO getPlaceOfBirth() {
		return placeOfBirth;
	}
	public void setPlaceOfBirth(CityDTO placeOfBirth) {
		this.placeOfBirth = getDefaultIfNull(placeOfBirth, getCityDTOBuilder().build());
	}
	public Date getExpeditionDate() {
		return expeditionDate;
	}
	public void setExpeditionDate(Date expeditionDate) {
		this.expeditionDate = expeditionDate;
	}
	public String getExpeditionSite() {
		return expeditionSite;
	}
	public void setExpeditionSite(String expeditionSite) {
		this.expeditionSite = applyTrim(expeditionSite);
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = applyTrim(sex);
	}
	public String getIdentificationNumber() {
		return identificationNumber;
	}
	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = applyTrim(identificationNumber);
	}
	public IdentificationTypeDTO getIdentificationType() {
		return identificationType;
	}
	public void setIdentificationType(IdentificationTypeDTO identificationType) {
		this.identificationType = getDefaultIfNull(identificationType, getIdentificationTypeDTOBuilder().build());
	}

	public static final IdentificationDocumentDTO create(final UUID id, final String name, final String surname, final Date birthDate, final CityDTO placeOfBirth,
			final Date expeditionDate, final String expeditionSite, final String sex, final String identificationNumber,
			final IdentificationTypeDTO identificationType) {
		return new IdentificationDocumentDTO(id, name, surname, birthDate, placeOfBirth, expeditionDate, expeditionSite, sex, identificationNumber, identificationType);
	}
	
	public static final IdentificationDocumentDTO create(final String id, final String name, final String surname, final Date birthDate, final CityDTO placeOfBirth,
			final Date expeditionDate, final String expeditionSite, final String sex, final String identificationNumber,
			final IdentificationTypeDTO identificationType) {
		return new IdentificationDocumentDTO(getUUIDFromString(id), name, surname, birthDate, placeOfBirth, expeditionDate, expeditionSite, sex, identificationNumber, identificationType);
	}
	
	public final String getIdAsString() {
		return getUUIDAsString(getId());
	}
	
}
