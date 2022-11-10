package edu.uco.quickjob.domain;

import java.util.UUID;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.quickjob.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.quickjob.crosscutting.helper.ObjectHelper.getDefaultIfNull;
import static edu.uco.quickjob.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.quickjob.builder.DepartmentDTOBuilder.getDepartmentDTOBuilder;


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
	
	public static final CityDTO create(final UUID id, final String name, final DepartmentDTO department ) {
		return new CityDTO(id, name, department);
	}
	
	
}
