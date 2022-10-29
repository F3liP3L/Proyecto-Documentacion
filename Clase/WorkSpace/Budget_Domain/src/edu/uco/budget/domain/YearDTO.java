package edu.uco.budget.domain;

import java.util.UUID;
import static edu.uco.budget.crosscutting.helper.UUIDHelper.getUUIDFromString;

import static edu.uco.budget.crosscutting.helper.NumberHelper.isLessOrEqualsThan;
import static edu.uco.budget.crosscutting.helper.NumberHelper.ZERO;

import static edu.uco.budget.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.budget.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.budget.crosscutting.helper.UUIDHelper.getUUIDAsString;

public final class YearDTO {
		
	private UUID id;
	private short yearNumber;
	
	public YearDTO(){
		setId(getNewUUID());
		setYearNumber(ZERO);
	}
	
	public static final YearDTO create (final UUID id, final short yearNumber) {
		return new YearDTO(id, yearNumber);
	}
	
	public static final YearDTO create (final String id , final short yearNumber) {
		return new YearDTO(getUUIDFromString(id), yearNumber);
	}
	
	public YearDTO(final UUID id, final short yearNumber) {
		setId(id);
		setYearNumber(yearNumber);
	}

	public final UUID getId() {
		return id;
	}

	public final void setId(UUID id) {
		this.id = getDefaultUUID(id);
	}

	public final short getYearNumber() {
		return yearNumber;
	}

	public final void setYearNumber(short yearNumber) {
		this.yearNumber = isLessOrEqualsThan(yearNumber,ZERO)? ZERO: yearNumber;
	}
	
	
	public final String getIdAsString() {
		return getUUIDAsString(getId());
	}
	
}
