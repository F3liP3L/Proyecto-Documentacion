package edu.uco.quickjob.domain;

import java.util.UUID;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.quickjob.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getUUIDFromString;
import static edu.uco.quickjob.crosscutting.helper.StringHelper.EMPTY;

public class ServiceTypeDTO {
	
	private UUID id;
	private String name;
	
	public ServiceTypeDTO(final UUID id, final String name) {
		setId(id);
		setName(name);
	}
	
	public ServiceTypeDTO() {
		setId(getNewUUID());
		setName(EMPTY);
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
	
	public static final ServiceTypeDTO create(final UUID id, final String name) {
		return new ServiceTypeDTO(id, name);
	}
	
	public static final ServiceTypeDTO create(final String id, final String name) {
		return new ServiceTypeDTO(getUUIDFromString(id), name);
	}
	
	public final String getIdAsString() {
		return getUUIDAsString(getId());
	}

}
