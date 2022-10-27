package edu.uco.budget.crosscutting.exception.data;

import static edu.uco.budget.crosscutting.helper.StringHelper.EMPTY;

import edu.uco.budget.crosscutting.exception.BudgetCustomException;
import edu.uco.budget.crosscutting.exception.enumeration.LayerException;

public class DataCustomException extends BudgetCustomException {

	private static final long serialVersionUID = -4221135925785108001L;

	private DataCustomException(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		super(userMessage, technicalMessage, rootException, LayerException.DATA);
	}
	
	public static final BudgetCustomException createUserException(final String userMessage) {
		return new DataCustomException(userMessage, userMessage, new Exception());
	}
	
	public static final BudgetCustomException createTechnicalException (final String technicalMessage) {
		return new DataCustomException(EMPTY, technicalMessage, new Exception());
	}
	
	public static final BudgetCustomException createTechnicalException (final String technicalMessage,
			final Exception rootException) {
		return new DataCustomException(EMPTY, technicalMessage, rootException);
	}
	
	public static final BudgetCustomException create (final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new DataCustomException(userMessage, userMessage, rootException);
	}
	
	public static final BudgetCustomException create(final String userMessage, String tehcnicalMessage) {
		return new DataCustomException(userMessage, tehcnicalMessage, new Exception());
	}
	
}
