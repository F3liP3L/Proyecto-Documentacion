package edu.uco.budget.service.business.budget.implementation;

import java.util.List;

import edu.uco.budget.data.dao.daofactory.DAOFactory;
import edu.uco.budget.data.enumeration.DAOFactoryType;
import edu.uco.budget.domain.BudgetDTO;
import edu.uco.budget.service.business.budget.CreateBudgetUseCase;

public final class CreateBudgetUseCaseImpl implements CreateBudgetUseCase {

	private final DAOFactory factory;
	
	public CreateBudgetUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public final void execute(final BudgetDTO budget) {

		DAOFactory.getDAOFactory(DAOFactoryType.SQLSERVER).getBudgetDAO().create(budget);
		
	}
	
	public static void main(String[] args) {
		
		List<BudgetDTO> results = DAOFactory.getDAOFactory(DAOFactoryType.SQLSERVER).getBudgetDAO().find(null);
		
		
		results.forEach(elem -> System.out.println(elem.getPerson().getFirstName() + elem.getPerson().ge));
		
		
	}

}
