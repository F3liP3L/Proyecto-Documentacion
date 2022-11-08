package edu.uco.quickjob.builder;

import java.util.UUID;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getDefaultUUID;

import edu.uco.quickjob.domain.DepartmentDTO;

public final class CityDTOBuilder {
	
	private UUID id;
	private String name;
	private DepartmentDTO department;
	
	private CityDTOBuilder() {
		super();
	}

	public static final CityDTOBuilder getCityDTOBuilder() {
		return new CityDTOBuilder();
	}

	public UUID getId() {
		return id;
	}

	public final void setId(final UUID id) {
		this.id = getDefaultUUID(id);
	}
	
	public final CityDTOBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public final CityDTOBuilder setDepartment(DepartmentDTO department) {
		this.department = department;
		return this;
	}
	
	/*public final CityDTOBuilder build() {
		return CityDTOBuilder.create(id, name, department));
	}*/
	
	
}
