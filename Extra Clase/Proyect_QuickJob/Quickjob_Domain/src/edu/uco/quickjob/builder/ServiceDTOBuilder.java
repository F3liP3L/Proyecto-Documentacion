package edu.uco.quickjob.builder;

import java.util.UUID;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getDefaultUUID;

import edu.uco.quickjob.domain.ServiceDTO;
import edu.uco.quickjob.domain.SubserviceTypeDTO;

public class ServiceDTOBuilder {
	
	private UUID id;
	private String name;
	private String description;
	private boolean state;
	private SubserviceTypeDTO subService;
	
	private ServiceDTOBuilder() {
		super();
	}
	
	public static final ServiceDTOBuilder getServiceDTOBuilder() {
		return new ServiceDTOBuilder();
	}

	public final UUID getId() {
		return id;
	}

	public final void setId(UUID id) {
		this.id = getDefaultUUID(id);
	}
	
	public final ServiceDTOBuilder setName(String name) {
		this.name = name;
		return this;
	}
	
	public final ServiceDTOBuilder setDescription(String description) {
		this.description = description;
		return this;
	}
	
	public final ServiceDTOBuilder setState(boolean state) {
		this.state = state;
		return this;
	}

	public final ServiceDTOBuilder setSubService(SubserviceTypeDTO subService) {
		this.subService = subService;
		return this;
	}
	
	public final ServiceDTO build() {
		return ServiceDTO.create(id, name, description, state, subService);
	}

}
