package edu.uco.budget.domain;

import java.util.UUID;

import static edu.uco.budget.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.budget.crosscutting.helper.UUIDHelper.getNewUUID;

public final class BudgetDTO {
	
	private UUID id;
	private PersonDTO person;
	private YearDTO year;
	
	public BudgetDTO() {
		setId(getNewUUID());
		// setPerson(person);
		// setYear(year);
	}
	
	public BudgetDTO(final UUID id, final PersonDTO person, final YearDTO year) {
		setId(id);
		setPerson(person);
		setYear(year);
	}
	
	public static final BudgetDTO create (final UUID id, final PersonDTO person, final YearDTO year) {
		return new BudgetDTO(id, person, year);
	}
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = getDefaultUUID(id);
	}
	public PersonDTO getPerson() {
		return person;
	}
	public void setPerson(PersonDTO person) {
		this.person = person;
	}
	public YearDTO getYear() {
		return year;
	}
	public void setYear(YearDTO year) {
		this.year = year;
	}
	
}
