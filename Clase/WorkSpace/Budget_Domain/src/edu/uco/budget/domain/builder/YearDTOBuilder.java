package edu.uco.budget.domain.builder;

import java.util.UUID;

import edu.uco.budget.domain.YearDTO;

public class YearDTOBuilder {
	
	private UUID id;
	private short yearNumber;
	
	private YearDTOBuilder() {
		super();
	}
	
	public static final YearDTOBuilder getYearDTOBuilder() {
		return new YearDTOBuilder();
	}
	
	public final YearDTOBuilder setId(final UUID id) {
		this.id = id;
		return this;
	}

	public final YearDTOBuilder setYearNumber(final short yearNumber) {
		this.yearNumber = yearNumber;
		return this;
	}

	public final YearDTO build() {
		return YearDTO.create(id, yearNumber);
	}	
	
}
