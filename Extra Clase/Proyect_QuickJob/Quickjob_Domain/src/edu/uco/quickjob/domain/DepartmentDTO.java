package edu.uco.quickjob.domain;

import java.util.UUID;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.quickjob.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.quickjob.crosscutting.helper.ObjectHelper.getDefaultIfNull;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.quickjob.builder.CountryDTOBuilder.getCountryDTOBuilder;
import static edu.uco.quickjob.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getUUIDFromString;;

public final class DepartmentDTO {
	
	private UUID id;
	private String name;
	private CountryDTO country;
	
	public DepartmentDTO() {
		setId(getNewUUID());
		setName(EMPTY);
		setCountry(getCountryDTOBuilder().build());
	}
	
	public DepartmentDTO(final UUID id, final String name, final CountryDTO country) {
		setId(id);
		setName(name);
		setCountry(country);
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
		this.name = applyTrim(name);
	}
	
	public CountryDTO getCountry() {
		return country;
	}
	
	public void setCountry(CountryDTO country) {
		this.country = getDefaultIfNull(country, getCountryDTOBuilder().build());
	}
	
	public static final DepartmentDTO create( final UUID id, final String name, final CountryDTO country) {
		return new DepartmentDTO(id, name, country);
	}
	
	public static final DepartmentDTO create(final String id, final String name, final CountryDTO country) {
		return new DepartmentDTO(getUUIDFromString(id), name, country);
	}
	
	public final String getIdAsString() {
		return getUUIDAsString(getId());
	}
	

}
