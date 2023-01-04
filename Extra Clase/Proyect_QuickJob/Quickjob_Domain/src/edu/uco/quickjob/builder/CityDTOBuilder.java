package edu.uco.quickjob.builder;

import java.util.UUID;

import edu.uco.quickjob.domain.CityDTO;
import edu.uco.quickjob.domain.DepartmentDTO;

public final class CityDTOBuilder {

	private UUID id;
	private String name;
	private DepartmentDTO department;

	private CityDTOBuilder() {
		super();
	}

	public CityDTOBuilder(UUID id) {
		this.id = id;
	}

	public static final CityDTOBuilder getCityDTOBuilder() {
		return new CityDTOBuilder();
	}

	public final UUID getId() {
		return id;
	}

	public final void setId(final UUID id) {
		this.id = id;
	}

	public final CityDTOBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public final CityDTOBuilder setDepartment(DepartmentDTO department) {
		this.department = department;
		return this;
	}

	public final CityDTO build() {
		return CityDTO.create(id, name, department);
	}

	public final CityDTO buildWhitId() {
		return CityDTO.create(id);
	}

}
