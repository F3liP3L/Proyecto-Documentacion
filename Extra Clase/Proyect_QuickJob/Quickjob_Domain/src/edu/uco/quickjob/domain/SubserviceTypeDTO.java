package edu.uco.quickjob.domain;

import java.util.UUID;

public final class SubserviceTypeDTO {
	
	private UUID id;
	private ServiceTypeDTO serviceType;
	private String name;
	private String description; 
	private boolean state;
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public ServiceTypeDTO getServiceType() {
		return serviceType;
	}
	public void setServiceType(ServiceTypeDTO serviceType) {
		this.serviceType = serviceType;
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
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	
	
	
	

}
