package edu.uco.budget.crosscutting.exception;

import static edu.uco.budget.crosscutting.helper.ObjectHelper.getDefaultIfNull;
import static edu.uco.budget.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.budget.crosscutting.helper.StringHelper.isEmpty;

import edu.uco.budget.crosscutting.exception.enumeration.LayerException;

public class BudgetCustomException extends RuntimeException {
	
	private static final long serialVersionUID = -61839141971946281L;
	
	private LayerException layer;
	private String userMessage;
	
	protected BudgetCustomException(final String userMessage, final String technicalMessage,
			final Throwable rootException, final LayerException layer) {
		super(applyTrim(technicalMessage), getDefaultIfNull(rootException, new Exception()));
		setUserMessage(userMessage);
		setLayer(layer);
	}

	private final void setLayer(LayerException layer) {
		this.layer = getDefaultIfNull(layer, LayerException.APPLICATION);
	}

	private final void setUserMessage(String userMessage) {
		this.userMessage = applyTrim(userMessage);
	}

	public final LayerException getLayer() {
		return layer;
	}

	public final String getUserMessage() {
		return userMessage;
	}

	public final boolean isTechnicalException() {
		return isEmpty(getUserMessage());
	}
}
