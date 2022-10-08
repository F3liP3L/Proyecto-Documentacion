package edu.uco.budget.domain.builder;

import java.util.UUID;

import edu.uco.budget.domain.PersonDTO;

public class PersonDTOBuilder {
	
	private UUID id;
	private String idCard;
	private String firstName;
	private String secondName;
	private String firstSurname;
	private String secondSurname;

	private PersonDTOBuilder() {
		super();
	}
	
	public static final PersonDTOBuilder getPersonDTOBuilder() {
		return new PersonDTOBuilder();
	}
	
	public final PersonDTOBuilder setId(final UUID id) {
		this.id = id;
		return this;
	}
	
	public final PersonDTOBuilder setIdCard(final String idCard) {
		this.idCard = idCard;
		return this;
	}
	
	public final PersonDTOBuilder setFirstName (final String firstName) {
		this.firstName = firstName;
		return this;
	}
	
	public final PersonDTOBuilder setSecondName (final String secondName) {
		this.secondName = secondName;
		return this;
	}
	
	public final PersonDTOBuilder setFirstSurname (final String firstSurname) {
		this.firstSurname = firstSurname;
		return this;
	}
	
	public final PersonDTOBuilder setSecondSurname (final String secondSurname) {
		this.secondSurname = secondSurname;
		return this;
	}
	
	public final PersonDTO build() {
		return PersonDTO.create(id, idCard, firstName, secondName, firstSurname, secondSurname);
	}
	
}
