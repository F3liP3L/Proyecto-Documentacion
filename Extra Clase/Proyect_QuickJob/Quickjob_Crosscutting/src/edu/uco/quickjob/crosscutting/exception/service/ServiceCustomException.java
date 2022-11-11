package edu.uco.quickjob.crosscutting.exception.service;

import edu.uco.quickjob.crosscutting.exception.QuickjobCustomException;
import edu.uco.quickjob.crosscutting.exception.enumeration.LayerException;
import static edu.uco.quickjob.crosscutting.helper.StringHelper.EMPTY;

public class ServiceCustomException extends QuickjobCustomException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4262414934313481930L;

	private ServiceCustomException(String userMessage, String technicalMessage, Throwable rootException) {
		super(userMessage, technicalMessage, rootException, LayerException.SERVICE);
	}

	public static final QuickjobCustomException createUserException(final String userMessage) {
		return new ServiceCustomException(userMessage, userMessage, new Exception());
	}

	public static final QuickjobCustomException createTechnicalException (final String technicalMessage) {
		return new ServiceCustomException(EMPTY, technicalMessage, new Exception());
	}

	public static final QuickjobCustomException createBussinesException (final String bussineslMessage,
		final Exception rootException) {
		return new ServiceCustomException(EMPTY, bussineslMessage, rootException);
	}

	public static final QuickjobCustomException wrapException(final String message, final QuickjobCustomException exception) {
		if(exception.isTechnicalException()) {
			return ServiceCustomException.createBussinesException(message, exception);
	}
			return exception;
	}


	public static final QuickjobCustomException create(final String userMessage, final String technicalMessage) {
		return new ServiceCustomException(userMessage, technicalMessage, new Exception());
	}

	public static final QuickjobCustomException create (final String userMessage, final String technicalMessage,
		final Exception rootException) {
		return new ServiceCustomException(userMessage, userMessage, rootException);
	}

}
