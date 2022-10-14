package edu.uco.budget.crosscutting.helper;

import static edu.uco.budget.crosscutting.helper.ObjectHelper.getDefaultIfNull;

public final class NumberHelper {
	
	private NumberHelper() {
		super();
	}
	
	public static final byte ZERO = 0;
	
	public static final <T extends Number> T getDefaultNumber(T value, T defaultValue) {
		return getDefaultIfNull(value, defaultValue);
	}
	
	public static final <T extends Number> Number getDefaultNumber(T value) {
		return getDefaultNumber(value, ZERO);
	}
	
	public static final <T extends Number> boolean isGreaterThan(T numberOne, T numberTwo) {
		return getDefaultNumber(numberOne).doubleValue() > getDefaultNumber(numberTwo).doubleValue();
	}
	
	public static final <T extends Number> boolean isLessThan(T numberOne, T numberTwo) {
		return getDefaultNumber(numberOne).doubleValue() < getDefaultNumber(numberTwo).doubleValue();
	}
	
	public static final <T extends Number> boolean isEqualsThan(T numberOne, T numberTwo) {
		return getDefaultNumber(numberOne).doubleValue() == getDefaultNumber(numberTwo).doubleValue();
	}
	
	public static final <T extends Number> boolean isGreaterOrEqualsThan(T numberOne, T numberTwo) {
		return getDefaultNumber(numberOne).doubleValue()>= getDefaultNumber(numberTwo).doubleValue();
	}
	
	public static final <T extends Number> boolean isLessOrEqualsThan(T numberOne, T numberTwo) {
		return getDefaultNumber(numberOne).doubleValue() <= getDefaultNumber(numberTwo).doubleValue();
	}
	
	public static final <T extends Number> boolean isDifferentThan(T numberOne, T numberTwo) {
		return !isEqualsThan(numberOne, numberTwo);
	}
	
	
	
}

