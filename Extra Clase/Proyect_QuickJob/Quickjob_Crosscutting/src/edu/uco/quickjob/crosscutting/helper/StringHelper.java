package edu.uco.quickjob.crosscutting.helper;

import java.util.Objects;

import static edu.uco.quickjob.crosscutting.helper.ObjectHelper.getDefaultIfNull;

public class StringHelper {
	
	private StringHelper() {
		super();
	}
	
	public static final String EMPTY = "";
	
	public static final String getDefaultString(String value, String defaultValue) {
		return getDefaultIfNull(value, defaultValue);
	}
	
	public static final String getDefaultString(String value) {
		return getDefaultString(value, EMPTY);
	}
	
	public static final String applyTrim(String value) {
		return getDefaultString(value).trim();
	}
	
	public static final boolean isEmpty(String value) {
		return Objects.equals(applyTrim(value), EMPTY);
	}
	
}
