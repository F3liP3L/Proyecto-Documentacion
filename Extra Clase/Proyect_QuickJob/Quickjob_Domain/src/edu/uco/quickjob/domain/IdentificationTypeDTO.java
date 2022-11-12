package edu.uco.quickjob.domain;

import java.util.UUID;

import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.quickjob.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.quickjob.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getUUIDFromString;

public final class IdentificationTypeDTO {
	
	private UUID id;
	private String name;
	
	public IdentificationTypeDTO() {
		setId(getNewUUID());
		setName(EMPTY);
	}
		
	public IdentificationTypeDTO(final UUID id, final String name) {
		setId(id);
		setName(name);
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
	
	public static final IdentificationTypeDTO create(final UUID id, final String name) {
		return new IdentificationTypeDTO(id, name);
	}
	public static final IdentificationTypeDTO create(final String id, final String name) {
		return new IdentificationTypeDTO(getUUIDFromString(id), name);
	}

	public final String getIdAsString() {
		return getUUIDAsString(getId());
	}
}
