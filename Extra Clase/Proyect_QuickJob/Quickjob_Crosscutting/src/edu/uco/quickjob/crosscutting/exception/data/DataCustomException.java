package edu.uco.quickjob.crosscutting.exception.data;

import static edu.uco.quickjob.crosscutting.helper.StringHelper.EMPTY;

import edu.uco.quickjob.crosscutting.exception.QuickjobCustomException;
import edu.uco.quickjob.crosscutting.exception.enumeration.LayerException;

public class DataCustomException extends QuickjobCustomException {

	private static final long serialVersionUID = -4221135925785108001L;

	private DataCustomException(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		super(userMessage, technicalMessage, rootException, LayerException.DATA);
	}
	
	public static final QuickjobCustomException createUserException(final String userMessage) {
		return new DataCustomException(userMessage, userMessage, new Exception());
	}
	
	public static final QuickjobCustomException createTechnicalException (final String technicalMessage) {
		return new DataCustomException(EMPTY, technicalMessage, new Exception());
	}
	
	public static final QuickjobCustomException createTechnicalException (final String technicalMessage,
			final Exception rootException) {
		return new DataCustomException(EMPTY, technicalMessage, rootException);
	}
	
	public static final QuickjobCustomException create (final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new DataCustomException(userMessage, userMessage, rootException);
	}
	
	public static final QuickjobCustomException create(final String userMessage, String tehcnicalMessage) {
		return new DataCustomException(userMessage, tehcnicalMessage, new Exception());
	}
	
}
