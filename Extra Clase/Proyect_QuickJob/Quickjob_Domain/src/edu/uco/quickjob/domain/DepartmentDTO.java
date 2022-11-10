package edu.uco.quickjob.domain;

import java.util.UUID;

public final class DepartmentDTO {
	
	private UUID id;
	private String name;
	private CountryDTO country;
	
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
	public CountryDTO getCountry() {
		return country;
	}
	public void setCountry(CountryDTO country) {
		this.country = country;
	}
	
	
	

}
