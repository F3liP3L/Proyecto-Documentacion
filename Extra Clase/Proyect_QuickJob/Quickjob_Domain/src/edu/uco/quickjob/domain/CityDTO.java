package edu.uco.quickjob.domain;

import static edu.uco.quickjob.builder.DepartmentDTOBuilder.getDepartmentDTOBuilder;
import static edu.uco.quickjob.crosscutting.helper.ObjectHelper.getDefaultIfNull;
import static edu.uco.quickjob.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.quickjob.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getUUIDFromString;

import java.util.UUID;

public final class CityDTO {

	private UUID id;
	private String name;
	private DepartmentDTO department;

	public CityDTO() {
		setId(getNewUUID());
		setName(EMPTY);
		setDepartment(getDepartmentDTOBuilder().build());
	}

	public CityDTO(final UUID id, final String name, final DepartmentDTO department) {
		setId(id);
		setName(name);
		setDepartment(department);
	}

	public CityDTO(UUID id) {
		this.id = id;
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

	public DepartmentDTO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDTO department) {
		this.department = getDefaultIfNull(department, getDepartmentDTOBuilder().build());
	}

	public static final CityDTO create(final UUID id, final String name, final DepartmentDTO department) {
		return new CityDTO(id, name, department);
	}

	public static final CityDTO create(final String id, final String name, final DepartmentDTO department) {
		return new CityDTO(getUUIDFromString(id), name, department);
	}

	public static final CityDTO create(final UUID id) {
		return new CityDTO(id);
	}

	public final String getIdAsString() {
		return getUUIDAsString(getId());
	}

}
