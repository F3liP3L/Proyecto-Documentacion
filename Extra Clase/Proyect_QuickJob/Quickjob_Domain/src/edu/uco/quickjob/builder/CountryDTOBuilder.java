package edu.uco.quickjob.builder;

import java.util.UUID;

import edu.uco.quickjob.domain.CountryDTO;

public class CountryDTOBuilder {
	
	private UUID id;
	private String name;
	
	protected CountryDTOBuilder() {
		super();
	}
	
	public static final CountryDTOBuilder getCountryDTOBuilder() {
		return new CountryDTOBuilder();
	}
	
	public UUID getId() {
		return id;
	}
	public final void setId(UUID id) {
		this.id = id;
	}

	public final CountryDTOBuilder setName(String name) {
		this.name = name;
		return this;
	}
	
	public final CountryDTO build() {
		return CountryDTO.create(id, name);
	}

}
