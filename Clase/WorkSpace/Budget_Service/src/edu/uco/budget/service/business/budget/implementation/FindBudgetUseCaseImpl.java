package edu.uco.budget.service.business.budget.implementation;

import java.util.List;

import edu.uco.budget.data.dao.daofactory.DAOFactory;
import edu.uco.budget.domain.BudgetDTO;
import edu.uco.budget.service.business.budget.FindBudgetUseCase;

public class FindBudgetUseCaseImpl implements FindBudgetUseCase{
	
	private final DAOFactory factory;
	
	public FindBudgetUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	} 

	@Override
	public List<BudgetDTO> execute(BudgetDTO budget) {
		return factory.getBudgetDAO().find(budget);
	}	

}
