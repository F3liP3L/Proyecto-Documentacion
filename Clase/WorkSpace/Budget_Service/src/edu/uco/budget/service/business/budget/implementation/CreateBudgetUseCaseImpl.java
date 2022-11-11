package edu.uco.budget.service.business.budget.implementation;

import java.util.List;

import edu.uco.budget.data.dao.daofactory.DAOFactory;
import edu.uco.budget.data.enumeration.DAOFactoryType;
import edu.uco.budget.domain.BudgetDTO;
import edu.uco.budget.domain.PersonDTO;
import edu.uco.budget.domain.YearDTO;
import edu.uco.budget.service.business.budget.CreateBudgetUseCase;
import edu.uco.budget.service.business.budget.FindBudgetUseCase;
import edu.uco.budget.service.business.person.FindPersonById;
import edu.uco.budget.service.business.person.implementation.FindPersonByIdUseCaseImpl;
import edu.uco.budget.service.business.year.FindNextYearUseCase;
import edu.uco.budget.service.business.year.implementation.FindNextYearUseCaseImpl;

public final class CreateBudgetUseCaseImpl implements CreateBudgetUseCase {

	private final DAOFactory factory;
	private final FindNextYearUseCase findNextYearUseCase;
	private final FindPersonById findPersonByIdUseCase;
	private final FindBudgetUseCase findBudgetUseCase;
	
	public CreateBudgetUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
		findNextYearUseCase = new FindNextYearUseCaseImpl(factory);
		findPersonByIdUseCase = new FindPersonByIdUseCaseImpl(factory);
		findBudgetUseCase = new FindBudgetUseCaseImpl(factory);
	}
	
	@Override
	public final void execute(final BudgetDTO budget) {

		// 1. Que el año de presupusupuesto exista
		final YearDTO year = findNextYearUseCase.execute();
		// 2. Que la persona exista.
		final PersonDTO person = findPersonByIdUseCase.execute(budget.getPerson().getId());
		// 3. Que no exista un presupesto para el mismo usuario en el mismo año
		budget.setYear(year);
		budget.setPerson(person);
		
		// List<BudgetDTO> results = 
		
		
		factory.getBudgetDAO().create(budget);
		
	}
	
	
	public static void main(String[] args) {
		
		List<BudgetDTO> results = DAOFactory.getDAOFactory(DAOFactoryType.SQLSERVER).getBudgetDAO().find(null);
		
		
		results.forEach(elem -> System.out.println(elem.getPerson().getFirstName() + elem.getPerson()));
		
		
	}

}
