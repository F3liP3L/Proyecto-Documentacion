package edu.uco.quickjob.domain;

import java.sql.Date;
import java.util.UUID;

public final class IdentificationDocumentDTO {
	
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
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}
	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
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
		this.expeditionSite = expeditionSite;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getIdentificationNumber() {
		return identificationNumber;
	}
	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}
	public IdentificationTypeDTO getIdentificationType() {
		return identificationType;
	}
	public void setIdentificationType(IdentificationTypeDTO identificationType) {
		this.identificationType = identificationType;
	}
	
	
	
	

}
