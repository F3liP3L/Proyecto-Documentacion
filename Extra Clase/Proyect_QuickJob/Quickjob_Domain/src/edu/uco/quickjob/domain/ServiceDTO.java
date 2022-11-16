package edu.uco.quickjob.domain;

import static edu.uco.quickjob.builder.SubserviceTypeDTOBuilder.getSubserviceTypeDTOBuilder;
import static edu.uco.quickjob.crosscutting.helper.ObjectHelper.getDefaultIfNull;
import static edu.uco.quickjob.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.quickjob.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getUUIDFromString;

import java.util.UUID;

public final class ServiceDTO {
	
	private UUID id;
	private String name;
	private String description;
	private boolean state;
	private SubserviceTypeDTO subService;
	
	public ServiceDTO() {
		setId(getNewUUID());
		setName(EMPTY);
		setDescription(EMPTY);
		setState(true);
		setSubService(getSubserviceTypeDTOBuilder().build());
	}
	
	public ServiceDTO(final UUID id, final String name, final String description, final boolean state, final SubserviceTypeDTO subSevice) {
		setId(id);
		setName(name);
		setDescription(description);
		setState(state);
		setSubService(subSevice);
		setState(state);
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = applyTrim(description);
	}
	public SubserviceTypeDTO getSubService() {
		return subService;
	}
	public void setSubService(SubserviceTypeDTO subService) {
		this.subService = getDefaultIfNull(subService, getSubserviceTypeDTOBuilder().build());
	}
	
	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public static final ServiceDTO create(final UUID id, final String name, final String description, final boolean state,final SubserviceTypeDTO subService) {
		return new ServiceDTO(id, name, description, state ,subService);
	}
	public static final ServiceDTO create(final String id, final String name, final String description, final boolean state,final SubserviceTypeDTO subService) {
		return new ServiceDTO(getUUIDFromString(id), name, description, state ,subService);
	}
	
	public final String getIdAsString() {
		return getUUIDAsString(getId());
	}
	
}
