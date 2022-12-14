package edu.uco.quickjob.domain;

import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getUUIDAsString;
import java.util.UUID;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.quickjob.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getUUIDFromString;
import static edu.uco.quickjob.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.quickjob.crosscutting.helper.ObjectHelper.getDefaultIfNull;
import static edu.uco.quickjob.builder.ServiceTypeDTOBuilder.getServiceTypeDTOBuilder;

public final class SubserviceTypeDTO {
	
	private UUID id;
	private ServiceTypeDTO serviceType;
	private String name;
	
	public SubserviceTypeDTO(final UUID id, final ServiceTypeDTO serviceType, final String name) {
		setId(id);
		setServiceType(serviceType);
		setName(name);
	}
	
	public SubserviceTypeDTO() {
		setId(getNewUUID());
		setServiceType(getServiceTypeDTOBuilder().build());
		setName(EMPTY);
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
	
	public static final SubserviceTypeDTO create(final UUID id, final ServiceTypeDTO serviceType, final String name) {
		return new SubserviceTypeDTO(id,serviceType, name);
	}
	
	public static final SubserviceTypeDTO create(final String id, final ServiceTypeDTO serviceType, final String name) {
		return new SubserviceTypeDTO(getUUIDFromString(id),serviceType, name);
	}
	
	public final String getIdAsString() {
		return getUUIDAsString(getId());
	}

}
