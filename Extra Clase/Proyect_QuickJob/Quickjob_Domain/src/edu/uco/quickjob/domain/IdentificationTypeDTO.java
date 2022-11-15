package edu.uco.quickjob.domain;

import static edu.uco.quickjob.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.quickjob.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getUUIDFromString;

import java.util.UUID;

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

	public IdentificationTypeDTO(final UUID id) {
		setId(id);
	}

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
		this.name = applyTrim(name);
	}

	public static final IdentificationTypeDTO create(final UUID id, final String name) {
		return new IdentificationTypeDTO(id, name);
	}

	public static final IdentificationTypeDTO create(final String id, final String name) {
		return new IdentificationTypeDTO(getUUIDFromString(id), name);
	}

	public static final IdentificationTypeDTO create(final UUID id) {
		return new IdentificationTypeDTO(id);
	}

	public final String getIdAsString() {
		return getUUIDAsString(getId());
	}
}
