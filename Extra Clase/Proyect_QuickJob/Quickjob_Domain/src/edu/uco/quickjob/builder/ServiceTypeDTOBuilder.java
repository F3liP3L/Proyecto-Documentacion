package edu.uco.quickjob.builder;

import java.util.UUID;

import edu.uco.quickjob.domain.ServiceTypeDTO;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getDefaultUUID;

public class ServiceTypeDTOBuilder {
	
	private UUID id;
	private String name;
	
	private ServiceTypeDTOBuilder() {
		super();
	}
	
	public static final ServiceTypeDTOBuilder getServiceTypeDTOBuilder() {
		return new ServiceTypeDTOBuilder();
	}

	public final UUID getId() {
		return id;
	}

	public final void setId(UUID id) {
		this.id = getDefaultUUID(id);
	}

	public final ServiceTypeDTOBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public final ServiceTypeDTO build() {
		return ServiceTypeDTO.create(id, name);
	}	
	

}
