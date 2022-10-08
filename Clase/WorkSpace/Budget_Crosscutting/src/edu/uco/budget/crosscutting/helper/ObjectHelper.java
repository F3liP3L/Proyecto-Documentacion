package edu.uco.budget.crosscutting.helper;

public final class ObjectHelper {
	
	private ObjectHelper() {
		super();
	}
	
	// Evalua si un objeto es igual a null
	
	public static final <T> boolean isNull(T value) {
		return value == null;
	}
	
	public static final <T> T getDefaultIfNull(T value, T defaultValue) {
		return (isNull(value)) ? defaultValue : value;
	}

}
