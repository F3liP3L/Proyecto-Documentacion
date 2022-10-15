package edu.uco.budget.service.business.budget;

import edu.uco.budget.domain.BudgetDTO;

public interface CreateBudgetUseCase {
	
	void execute(BudgetDTO budget);

}
