package edu.uco.budget.domain;

import static edu.uco.budget.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.budget.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.budget.crosscutting.helper.UUIDHelper.getUUIDAsString;

import java.util.UUID;

import static edu.uco.budget.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.budget.crosscutting.helper.StringHelper.EMPTY;

public class PersonDTO {
	
	private UUID id;
	private String idCard;
	private String firstName;
	private String secondName;
	private String firstSurname;
	private String secondSurname;
	
	public PersonDTO() {
		setId(getNewUUID());
		setIdCard(EMPTY);
		setFirstName(EMPTY);
		setSecondName(EMPTY);
		setFirstSurname(EMPTY);
		setSecondSurname(EMPTY);
	}
	
	public PersonDTO(final UUID id, final String idCard, final String firstName, final String secondName, final String firstSurname, final String secondSurname) {
		setId(id);
		setIdCard(idCard);
		setFirstName(firstName);
		setSecondName(secondName);
		setFirstSurname(firstSurname);
		setSecondSurname(secondSurname);
	}
	
	public static final PersonDTO create (final UUID id, final String idCard, final String firstName, final String secondName, final String firstSurname, final String secondSurname) {
		return new PersonDTO(id, idCard, firstName,secondName,firstSurname,secondSurname);
	}

	public final UUID getId() {
		return id;
	}

	public final void setId(UUID id) {
		this.id = getDefaultUUID(id);
	}

	public final String getIdCard() {
		return idCard;
	}

	public final void setIdCard(String idCard) {
		this.idCard = applyTrim(idCard);
	}

	public final String getFirstName() {
		return firstName;
	}

	public final void setFirstName(String firstName) {
		this.firstName = applyTrim(firstName);
	}

	public final String getSecondName() {
		return secondName;
	}

	public final void setSecondName(String secondName) {
		this.secondName = applyTrim(secondName);
	}

	public final String getFirstSurname() {
		return firstSurname;
	}

	public final void setFirstSurname(String firstSurname) {
		this.firstSurname = applyTrim(firstSurname);
	}

	public final String getSecondSurname() {
		return secondSurname;
	}

	public final void setSecondSurname(String secondSurname) {
		this.secondSurname = applyTrim(secondSurname);
	}
	
	public final String getIdAsString() {
		return getUUIDAsString(getId());
	}
	

}
