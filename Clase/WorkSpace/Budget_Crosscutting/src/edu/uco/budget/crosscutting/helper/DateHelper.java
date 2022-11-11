package edu.uco.budget.crosscutting.helper;

import java.time.LocalDate;

public class DateHelper {
	
	private DateHelper() {
		super();
	}
	
	public static final short getNextYear() {
		return (short) LocalDate.now().plusYears(1).getYear();
	}

}
