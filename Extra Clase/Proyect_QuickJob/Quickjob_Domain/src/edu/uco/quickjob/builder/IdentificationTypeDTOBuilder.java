package edu.uco.quickjob.builder;

import java.util.UUID;

import edu.uco.quickjob.domain.IdentificationTypeDTO;

import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getDefaultUUID;

public class IdentificationTypeDTOBuilder {
	
	private UUID id;
	private String name;
	
	private IdentificationTypeDTOBuilder() {
		super();
	}
	
	public static final IdentificationTypeDTOBuilder getIdentificationTypeDTOBuilder() {
		return new IdentificationTypeDTOBuilder();
	}
	
	public final void setId(UUID id) {
		this.id = getDefaultUUID(id);
	}
	public final IdentificationTypeDTOBuilder setName(String name) {
		this.name = name;
		return this;
	}
	
	public final IdentificationTypeDTO build() {
		return IdentificationTypeDTO.create(id, name);
	}
}
