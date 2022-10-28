package edu.uco.quickjob.domain;

import java.util.UUID;

public final class UserDTO {
	
	private UUID id;
	private String name;
	private String description;
	private IdentificationDocumentDTO identification;
	private String email;
	private String password;
	private CityDTO residenceCity;
	
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public IdentificationDocumentDTO getIdentification() {
		return identification;
	}
	public void setIdentification(IdentificationDocumentDTO identification) {
		this.identification = identification;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public CityDTO getResidenceCity() {
		return residenceCity;
	}
	public void setResidenceCity(CityDTO residenceCity) {
		this.residenceCity = residenceCity;
	}
	
	
	
	

}
