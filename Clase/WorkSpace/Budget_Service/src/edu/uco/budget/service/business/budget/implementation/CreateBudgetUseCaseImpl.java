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

		// 1. Que no exista un presupuesto para el mismo año.
		final YearDTO year = findNextYearUseCase.execute();
		// 2. Que el año de presupuesto exista.
		
		// 3. Que la persona exista.
		final PersonDTO person = findPersonByIdUseCase.execute(budget.getPerson().getId());
		budget.setYear(year);
		budget.setPerson(person);
		
		List<BudgetDTO> results = findBudgetUseCase.execute(budget);
	
		factory.getBudgetDAO().create(budget);	
	}
}
