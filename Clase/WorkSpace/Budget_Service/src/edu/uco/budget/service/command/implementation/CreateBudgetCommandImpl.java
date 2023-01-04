package edu.uco.budget.service.command.implementation;

import edu.uco.budget.crosscutting.exception.BudgetCustomException;
import edu.uco.budget.crosscutting.exception.service.ServiceCustomException;
import edu.uco.budget.crosscutting.messages.Messages;
import edu.uco.budget.data.dao.daofactory.DAOFactory;
import edu.uco.budget.data.enumeration.DAOFactoryType;
import edu.uco.budget.domain.BudgetDTO;
import edu.uco.budget.service.business.budget.CreateBudgetUseCase;
import edu.uco.budget.service.business.budget.implementation.CreateBudgetUseCaseImpl;
import edu.uco.budget.service.command.CreateBudgetCommand;

public class CreateBudgetCommandImpl implements CreateBudgetCommand {

	private final DAOFactory factory = DAOFactory.getDAOFactory(DAOFactoryType.SQLSERVER);
	private final CreateBudgetUseCase useCase = new CreateBudgetUseCaseImpl(factory);
	
	@Override
	public void execute(BudgetDTO budget) {
		try {
			factory.initTransaction();
			// Use case execution
			useCase.execute(budget);
			factory.confirmTransaction();
		} catch (ServiceCustomException exception) {
			factory.cancelTransaction();
			throw exception;
		} catch (BudgetCustomException exception) {
			factory.cancelTransaction();
			if(exception.isTechnicalException()) {
				// Wrapper negocio!!
				throw ServiceCustomException.wrapException(null, exception);
			}
		} catch (Exception exception) {
			factory.cancelTransaction();
			throw ServiceCustomException.createBussinesException(Messages.CreateBudgetUseCaseImpl.BUSSINES_UNEXPECTED, exception);
		} finally {
			factory.closeConnection();
		}
	}

}
