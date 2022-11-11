package edu.uco.quickjob.domain;

import java.util.UUID;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.quickjob.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.quickjob.crosscutting.helper.ObjectHelper.getDefaultIfNull;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.quickjob.builder.SubserviceTypeDTOBuilder.getSubserviceTypeDTOBuilder;
import static edu.uco.quickjob.crosscutting.helper.StringHelper.EMPTY;

public final class ServiceDTO {
	
	private UUID id;
	private String name;
	private String description;
	private SubserviceTypeDTO subSevice;
	
	public ServiceDTO() {
		setId(getNewUUID());
		setName(EMPTY);
		setDescription(EMPTY);
		setSubSevice(getSubserviceTypeDTOBuilder().build());
	}
	
	public ServiceDTO(final UUID id, final String name, final String description,final SubserviceTypeDTO subSevice) {
		setId(id);
		setName(name);
		setDescription(description);
		setSubSevice(subSevice);
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
	public SubserviceTypeDTO getSubSevice() {
		return subSevice;
	}
	public void setSubSevice(SubserviceTypeDTO subSevice) {
		this.subSevice = getDefaultIfNull(subSevice, getSubserviceTypeDTOBuilder().build());
	}
	
	public static final ServiceDTO create(final UUID id, final String name, final String description, final SubserviceTypeDTO subSevice) {
		return new ServiceDTO(id, name, description, subSevice);
	}
	
	public final String getIdAsString() {
		return getUUIDAsString(getId());
	}
	
}
