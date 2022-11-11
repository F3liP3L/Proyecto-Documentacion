package edu.uco.budget.service.business.person.implementation;

import java.util.List;
import java.util.UUID;

import edu.uco.budget.data.dao.daofactory.DAOFactory;
import edu.uco.budget.domain.PersonDTO;
import edu.uco.budget.service.business.person.FindPersonById;

public class FindPersonByIdUseCaseImpl implements FindPersonById{

	private final DAOFactory factory;
	
	public FindPersonByIdUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	}

	@Override
	public PersonDTO execute(UUID id) {
		final PersonDTO person = PersonDTO.create(id);
		final List<PersonDTO> results = factory.getPersonDAO().find(person);
		
		if (!results.isEmpty()) {
			return results.get(0);
		}
		
		return new PersonDTO();
	}
	
	
	
}
