package edu.uco.quickjob.domain;

import java.util.UUID;

public final class CityDTO {
	
	private UUID id;
	private String name;
	private DepartmentDTO department;
	
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
	public DepartmentDTO getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentDTO department) {
		this.department = department;
	}
	
	

}
