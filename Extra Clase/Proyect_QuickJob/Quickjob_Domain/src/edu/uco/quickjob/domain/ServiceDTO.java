package edu.uco.quickjob.domain;

import java.util.UUID;

public final class ServiceDTO {
	
	private UUID id;
	private String name;
	private String description;
	private SubserviceTypeDTO subSevice;
	
	
	
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
	public SubserviceTypeDTO getSubSevice() {
		return subSevice;
	}
	public void setSubSevice(SubserviceTypeDTO subSevice) {
		this.subSevice = subSevice;
	}
	
	

}
