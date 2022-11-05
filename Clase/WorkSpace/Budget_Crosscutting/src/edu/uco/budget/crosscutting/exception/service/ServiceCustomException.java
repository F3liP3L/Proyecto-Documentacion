package edu.uco.budget.crosscutting.exception.service;

import static edu.uco.budget.crosscutting.helper.StringHelper.EMPTY;

import edu.uco.budget.crosscutting.exception.BudgetCustomException;
import edu.uco.budget.crosscutting.exception.enumeration.LayerException;

public class ServiceCustomException extends BudgetCustomException {
	
	private static final long serialVersionUID = 2004123920866285366L;

	private ServiceCustomException(String userMessage, String technicalMessage, Throwable rootException) {
			super(userMessage, technicalMessage, rootException, LayerException.SERVICE);
	}
	
	public static final BudgetCustomException createUserException(final String userMessage) {
		return new ServiceCustomException(userMessage, userMessage, new Exception());
	}
	
	public static final BudgetCustomException createTechnicalException (final String technicalMessage) {
		return new ServiceCustomException(EMPTY, technicalMessage, new Exception());
	}
	
	public static final BudgetCustomException createBussinesException (final String bussineslMessage,
			final Exception rootException) {
		return new ServiceCustomException(EMPTY, bussineslMessage, rootException);
	}
	
	public static final BudgetCustomException wrapException(final String message, final BudgetCustomException exception) {
		if(exception.isTechnicalException()) {
			return ServiceCustomException.createBussinesException(message, exception);
		}
		return exception;
	}
	
	
	public static final BudgetCustomException create(final String userMessage, final String technicalMessage) {
		return new ServiceCustomException(userMessage, technicalMessage, new Exception());
	}
	
	public static final BudgetCustomException create (final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new ServiceCustomException(userMessage, userMessage, rootException);
	}
	
}
