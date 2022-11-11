package edu.uco.quickjob.builder;

import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getDefaultUUID;

import java.util.UUID;

import edu.uco.quickjob.domain.CityDTO;
import edu.uco.quickjob.domain.IdentificationDocumentDTO;
import edu.uco.quickjob.domain.UserDTO;

public class UserDTOBuilder {
	
	private UUID id;
	private String name;
	private String description;
	private IdentificationDocumentDTO identification;
	private String email;
	private String password;
	private CityDTO residenceCity;
	
	protected UserDTOBuilder() {
		super();
	}
	
	public static final UserDTOBuilder getUserDTOBuilder() {
		return new UserDTOBuilder();
	}

	public final UUID getId() {
		return id;
	}

	public final void setId(final UUID id) {
		this.id = getDefaultUUID(id);
	}

	public final UserDTOBuilder setName (String name) {
		this.name = name;
		return this;
	}

	public final UserDTOBuilder setDescription(String description) {
		this.description = description;
		return this;
	}

	public final UserDTOBuilder setIdentification(IdentificationDocumentDTO identification) {
		this.identification = identification;
		return this;
	}

	public final UserDTOBuilder setEmail(String email) {
		this.email = email;
		return this;
	}


	public final UserDTOBuilder setPassword(String password) {
		this.password = password;
		return this;
	}

	public final UserDTOBuilder setResidenceCity(CityDTO residenceCity) {
		this.residenceCity = residenceCity;
		return this;
	}
	
	public UserDTO build() {
		return UserDTO.create(id, name, description, identification, email, password, residenceCity);
	}
	
}
