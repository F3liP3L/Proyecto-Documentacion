package edu.uco.quickjob.crosscutting.exception.data;

import static edu.uco.quickjob.crosscutting.helper.StringHelper.EMPTY;

import edu.uco.quickjob.crosscutting.exception.QuickjobCustomException;
import edu.uco.quickjob.crosscutting.exception.enumeration.LayerException;

public class CrosscuttingCustomException extends QuickjobCustomException {

	private static final long serialVersionUID = 1560390210752726252L;


	private CrosscuttingCustomException(final String userMessage, final String technicalMessage,
			final Exception rootException) {
			super(userMessage, technicalMessage, rootException, LayerException.CROSSCUTTING);
	}

	public static final QuickjobCustomException createUserException(final String userMessage) {
		return new CrosscuttingCustomException(userMessage, userMessage, new Exception());
	}
	
	public static final QuickjobCustomException createTechnicalException (final String technicalMessage) {
		return new CrosscuttingCustomException(EMPTY, technicalMessage, new Exception());
	}
	
	public static final QuickjobCustomException createTechnicalException (final String technicalMessage,
			final Exception rootException) {
		return new CrosscuttingCustomException(EMPTY, technicalMessage, rootException);
	}
	
	public static final QuickjobCustomException create(final String userMessage, final String technicalMessage) {
		return new CrosscuttingCustomException(userMessage, technicalMessage, new Exception());
	}
	
	public static final QuickjobCustomException create (final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new CrosscuttingCustomException(userMessage, userMessage, rootException);
	}
}
