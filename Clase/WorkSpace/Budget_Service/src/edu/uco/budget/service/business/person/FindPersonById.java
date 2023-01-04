package edu.uco.budget.service.business.person;

import java.util.UUID;

import edu.uco.budget.domain.PersonDTO;

public interface FindPersonById {
	
	PersonDTO execute(UUID id);
	
}
