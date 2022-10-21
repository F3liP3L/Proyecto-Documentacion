package edu.uco.budget.crosscutting.exceptions;

public class BudgetDAOFactoryCassandraExceptions extends BudgetExceptions {

	private static final long serialVersionUID = -3914821103367267662L;

	private BudgetDAOFactoryCassandraExceptions(Exception excepcionRaiz, String message, String technicalMessage) {
		super(excepcionRaiz, message, technicalMessage);
	}
	
	public static BudgetExceptions create(String mensaje) {
		return new BudgetDAOFactoryCassandraExceptions(new Exception(), mensaje, mensaje);
	}
	
	public static BudgetExceptions create(String mensajeTecnico, Exception exception) {
		return new BudgetDAOFactoryCassandraExceptions(exception, mensajeTecnico, mensajeTecnico);
	}
	
	public static BudgetExceptions create(String mensajeTecnico, String mensajeUsuario, Exception exception) {
		return new BudgetDAOFactoryCassandraExceptions(exception, mensajeTecnico, mensajeUsuario);
	}
	

}
