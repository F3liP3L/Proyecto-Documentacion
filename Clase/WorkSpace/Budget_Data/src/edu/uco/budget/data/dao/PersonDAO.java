package edu.uco.budget.data.dao;

import java.util.List;
import java.util.UUID;

import edu.uco.budget.domain.PersonDTO;

public interface PersonDAO {
	
	void create (PersonDTO person);
	
	List<PersonDTO> find(PersonDTO person);
	
	void update (PersonDTO person);
	
	void delete (UUID id);

}
