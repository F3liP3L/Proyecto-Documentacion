package edu.uco.budget.domain.builder;

import java.util.UUID;

import static edu.uco.budget.crosscutting.helper.UUIDHelper.getDefaultUUID;

import edu.uco.budget.domain.BudgetDTO;
import edu.uco.budget.domain.PersonDTO;
import edu.uco.budget.domain.YearDTO;

public class BudgetDTOBuilder {
	
	private UUID id;
	private PersonDTO person;
	private YearDTO year;
	
	private BudgetDTOBuilder() {
		super();
	}
	
	public static final BudgetDTOBuilder getBudgetDTOBuilder() {
		return new BudgetDTOBuilder();
	}

	public final UUID getId() {
		return id;
	}

	public final void setId(final UUID id) {
		this.id = getDefaultUUID(id);
	}

	public final BudgetDTOBuilder setPerson(final PersonDTO person) {
		this.person = person;
		return this;
	}

	public final BudgetDTOBuilder setYear(final YearDTO year) {
		this.year = year;
		return this;
	}

	public final BudgetDTO build() {
		return BudgetDTO.create(id, person, year);
	}
	
}
