package edu.uco.quickjob.domain;

import java.util.UUID;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.quickjob.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.quickjob.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.quickjob.crosscutting.helper.ObjectHelper.getDefaultIfNull;
import static edu.uco.quickjob.builder.ServiceTypeDTOBuilder.getServiceTypeDTOBuilder;

public final class SubserviceTypeDTO {
	
	private UUID id;
	private ServiceTypeDTO serviceType;
	private String name;
	private String description; 
	private boolean state;
	
	public SubserviceTypeDTO(final UUID id, final ServiceTypeDTO serviceType, final String name, final String description, final boolean state) {
		setId(id);
		setServiceType(serviceType);
		setName(name);
		setDescription(description);
		setState(state);
	}
	
	public SubserviceTypeDTO() {
		setId(getNewUUID());
		setServiceType(getServiceTypeDTOBuilder().build());
		setName(EMPTY);
		setDescription(EMPTY);
		setState(true);
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = getDefaultUUID(id);
	}
	
	public ServiceTypeDTO getServiceType() {
		return serviceType;
	}
	
	public void setServiceType(ServiceTypeDTO serviceType) {
		this.serviceType = getDefaultIfNull(serviceType, getServiceTypeDTOBuilder().build());
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = applyTrim(name);
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = applyTrim(description);
	}
	
	public boolean isState() {
		return state;
	}
	
	public void setState(boolean state) {
		this.state = state;
	}
	
	public static final SubserviceTypeDTO create(final UUID id, final ServiceTypeDTO serviceType, final String name, final String description, final boolean state) {
		return new SubserviceTypeDTO(id,serviceType, name, description, state);
	}

}
