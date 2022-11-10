package edu.uco.quickjob.builder;

import java.util.UUID;

import edu.uco.quickjob.domain.CityDTO;
import edu.uco.quickjob.domain.IdentificationDocumentDTO;

public class UserDTOBuilder {
	
	private UUID id;
	private String name;
	private String description;
	private IdentificationDocumentDTO identification;
	private String email;
	private String password;
	private CityDTO residenceCity;
	
	private UserDTOBuilder() {
		super();
	}
	
	

}
