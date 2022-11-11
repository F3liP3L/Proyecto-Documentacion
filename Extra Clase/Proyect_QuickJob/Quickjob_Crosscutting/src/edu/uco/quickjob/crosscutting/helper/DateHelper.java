package edu.uco.quickjob.crosscutting.helper;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateHelper {
	
	private DateHelper() {
		super();
	}
	
	public static final String DEFAULT_DATE = "01/01/0001";
	
	public static final LocalDate getDefaultDate() {
		return LocalDate.parse(DEFAULT_DATE, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	public static final LocalDate currentDate() {
		return LocalDate.now();
	}
	
	public static final short getNextYear() {
		return (short) LocalDate.now().plusYears(1).getYear();
	}
	
	public static final Date getLocalDateADate(LocalDate date) {
		return Date.valueOf(date);
	}
	
	
	public static void main(String[] args) {
		LocalDate fecha = DateHelper.getDefaultDate();
		
		System.out.println("the date defect is: " + fecha + "\n this is a date is: " + getLocalDateADate(fecha));
	}

}
