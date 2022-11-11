package edu.uco.quickjob.domain;

import java.util.UUID;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.quickjob.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.quickjob.crosscutting.helper.StringHelper.EMPTY;

public class ServiceTypeDTO {
	
	private UUID id;
	private String name;
	private String description;
	private boolean state;
	
	public ServiceTypeDTO(final UUID id, final String name, final String description, final boolean state) {
		setId(id);
		setName(name);
		setDescription(description);
		setState(state);
	}
	
	public ServiceTypeDTO() {
		setId(getNewUUID());
		setName(EMPTY);
		setDescription(EMPTY);
		setState(true);
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
	public boolean isState() {
		return state;
	}
	
	public void setState(boolean state) {
		this.state = state;
	}
	
	public static final ServiceTypeDTO create(final UUID id, final String name, final String description, final boolean state) {
		return new ServiceTypeDTO(id, name, description, state);
	}
	
	public final String getIdAsString() {
		return getUUIDAsString(getId());
	}

}
