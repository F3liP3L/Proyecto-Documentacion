package edu.uco.budget.crosscutting.exceptions;

public class BudgetExceptions extends RuntimeException {

	private static final long serialVersionUID = -7479231409956934620L;
	
	private Exception excepcionRaiz;
	private String message;
	private String technicalMessage;
	
	protected BudgetExceptions(Exception excepcionRaiz, String message, String technicalMessage) {
		super();
		this.excepcionRaiz = excepcionRaiz;
		this.message = message;
		this.technicalMessage = technicalMessage;
	}

	public Exception getExcepcionRaiz() {
		return excepcionRaiz;
	}
	public String getMessage() {
		return message;
	}
	public String getTechnicalMessage() {
		return technicalMessage;
	}
	
	
	
	
	
	


}
