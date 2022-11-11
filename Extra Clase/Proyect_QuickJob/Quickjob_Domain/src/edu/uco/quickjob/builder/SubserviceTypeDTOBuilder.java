package edu.uco.quickjob.builder;

import java.util.UUID;

import edu.uco.quickjob.domain.ServiceTypeDTO;
import edu.uco.quickjob.domain.SubserviceTypeDTO;

import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getDefaultUUID;

public class SubserviceTypeDTOBuilder {
	
	private UUID id;
	private ServiceTypeDTO serviceType;
	private String name;
	private String description; 
	private boolean state;
	
	private SubserviceTypeDTOBuilder() {
		super();
	}
	
	public static final SubserviceTypeDTOBuilder getSubserviceTypeDTOBuilder() {
		return new SubserviceTypeDTOBuilder();
	}
	
	public final UUID getId() {
		return id;
	}
	
	public final void setId(UUID id) {
		this.id = getDefaultUUID(id);
	}
	
	public final SubserviceTypeDTOBuilder setServiceType(ServiceTypeDTO serviceType) {
		this.serviceType = serviceType;
		return this;
	}

	public final SubserviceTypeDTOBuilder setName(String name) {
		this.name = name;
		return this;
	}
	public final SubserviceTypeDTOBuilder setDescription(String description) {
		this.description = description;
		return this;
	}

	public final SubserviceTypeDTOBuilder setState(boolean state) {
		this.state = state;
		return this;
	}
	
	public final SubserviceTypeDTO build() {
		return SubserviceTypeDTO.create(id, serviceType, name, description, state);
	}
	
	

}
