package edu.uco.budget.service.business.budget.implementation;

import edu.uco.budget.data.dao.daofactory.DAOFactory;
import edu.uco.budget.data.enumeration.DAOFactoryType;
import edu.uco.budget.domain.BudgetDTO;
import edu.uco.budget.service.business.budget.CreateBudgetUseCase;

public final class CreateBudgetUseCaseImpl implements CreateBudgetUseCase {

	@Override
	public final void execute(final BudgetDTO budget) {

		DAOFactory.getDAOFactory(DAOFactoryType.SQLSERVER).getBudgetDAO().create(budget);
		
	}

}
