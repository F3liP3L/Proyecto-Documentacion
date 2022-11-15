package edu.uco.quickjob.domain;

import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getUUIDAsString;

import java.util.UUID;
import static edu.uco.quickjob.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.quickjob.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.quickjob.crosscutting.helper.ObjectHelper.getDefaultIfNull;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getUUIDFromString;
import static edu.uco.quickjob.builder.IdentificationDocumentDTOBuilder.getIdentificationDocumentDTOBuilder;
import static edu.uco.quickjob.builder.CityDTOBuilder.getCityDTOBuilder;

public class UserDTO {
	
	private UUID id;
	private String name;
	private String lastname;
	private IdentificationDocumentDTO identification;
	private String email;
	private String password;
	private CityDTO residenceCity;
	
	public UserDTO() {
		setId(getNewUUID());
		setName(EMPTY);
		setLastName(EMPTY);
		setEmail(EMPTY);
		setPassword(EMPTY);
		setIdentification(getIdentificationDocumentDTOBuilder().build());
		setResidenceCity(getCityDTOBuilder().build());
	}

	public UserDTO(final UUID id, final String name, final String lastname, final IdentificationDocumentDTO identification, final String email,
		final String password, final CityDTO residenceCity) {
		setId(id);
		setName(name);
		setLastName(lastname);
		setIdentification(identification);
		setEmail(email);
		setPassword(password);
		setResidenceCity(residenceCity);
	}
	
	public UserDTO(final UUID id, final String name, final String lastname,final String email,
			final String password) {
			setId(id);
			setName(name);
			setLastName(lastname);
			setEmail(email);
			setPassword(password);
		}

	public static final UserDTO create (final UUID id, final String name, final String lastname, final IdentificationDocumentDTO identification, final String email,
		final String password, final CityDTO residenceCity) {
		return new UserDTO(id, name, lastname , identification , email, password, residenceCity);
	}
	
	public static final UserDTO create (final String id, final String name, final String lastname, final IdentificationDocumentDTO identification, final String email,
			final String password, final CityDTO residenceCity) {
		return new UserDTO(getUUIDFromString(id), name, lastname ,identification ,email, password, residenceCity);
	}
	
	public static final UserDTO create(final String id, final String name, final String lastname,  final String email,
			final String password) {
		return new UserDTO(getUUIDFromString(id), name, lastname ,email, password);
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
	
	public String getLastName() {
		return lastname;
	}
	public void setLastName(String lastname) {
		this.lastname = applyTrim(lastname);
	}
	public IdentificationDocumentDTO getIdentification() {
		return identification;
	}
	public void setIdentification(IdentificationDocumentDTO identification) {
		this.identification = getDefaultIfNull(identification, getIdentificationDocumentDTOBuilder().build());
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = applyTrim(email);
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = applyTrim(password);
	}
	public CityDTO getResidenceCity() {
		return residenceCity;
	}
	public void setResidenceCity(CityDTO residenceCity) {
		this.residenceCity = getDefaultIfNull(residenceCity, getCityDTOBuilder().build());
	}

	public String getIdAsString() {
		return getUUIDAsString(getId());
	}

	public static UserDTO create(final String email) {
		return new UserDTO(getNewUUID(), EMPTY, EMPTY, getIdentificationDocumentDTOBuilder().build(), email, EMPTY, getCityDTOBuilder().build());
	}
}
