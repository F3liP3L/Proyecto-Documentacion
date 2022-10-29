package edu.uco.budget.service.command;

import edu.uco.budget.crosscutting.exception.BudgetCustomException;
import edu.uco.budget.data.dao.daofactory.DAOFactory;
import edu.uco.budget.data.enumeration.DAOFactoryType;
import edu.uco.budget.domain.BudgetDTO;
import edu.uco.budget.service.business.budget.CreateBudgetUseCase;
import edu.uco.budget.service.business.budget.implementation.CreateBudgetUseCaseImpl;

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
		} catch (BudgetCustomException exception) {
			factory.cancelTransaction();
			throw exception;
		} catch (Exception exception) {
			factory.cancelTransaction();
		//	throw [Devolver excepcion Service ];
		} finally {
			factory.closeConnection();
		}
	}

}
