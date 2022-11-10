package edu.uco.quickjob.builder;

import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getDefaultUUID;
import java.util.UUID;
import edu.uco.quickjob.domain.CountryDTO;
import edu.uco.quickjob.domain.DepartmentDTO;

public class DepartmentDTOBuilder {
	
	private UUID id;
	private String name;
	private CountryDTO country;
	
	private DepartmentDTOBuilder() {
		super();
	}
	
	public static final DepartmentDTOBuilder getDepartmentDTOBuilder() {
		return new DepartmentDTOBuilder();
	}
	
	public UUID getId() {
		return id;
	}

	public final void setId(UUID id) {
		this.id = getDefaultUUID(id);
	}

	public final DepartmentDTOBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public final DepartmentDTOBuilder setCountry(CountryDTO country) {
		this.country = country;
		return this;
	}
	
	public final DepartmentDTO build() {
		return DepartmentDTO.create(id, name, country);
	}
	
}
