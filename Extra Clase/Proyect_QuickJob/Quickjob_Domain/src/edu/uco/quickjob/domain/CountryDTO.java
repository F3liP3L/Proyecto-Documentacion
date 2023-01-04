package edu.uco.quickjob.domain;

import java.util.UUID;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.quickjob.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.quickjob.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getUUIDFromString;

public final class CountryDTO {

	private UUID id;
	private String name;
	
	public CountryDTO(final UUID id, final String name) {
		setId(id);
		setName(name);
	}

	public CountryDTO() {
		setId(getNewUUID());
		setName(EMPTY);
	}
	
	public static final CountryDTO create (final UUID id, final String name) {
		return new CountryDTO(id, name);
	}

	public static final CountryDTO create(final String id,final String name) {
		return new CountryDTO(getUUIDFromString(id), name);
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
	
	public final String getIdAsString() {
		return getUUIDAsString(getId());
	}

	
}
