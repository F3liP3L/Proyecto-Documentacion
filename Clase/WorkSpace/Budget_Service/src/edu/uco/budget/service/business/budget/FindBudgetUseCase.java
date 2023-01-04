package edu.uco.budget.service.business.budget;

import java.util.List;

import edu.uco.budget.domain.BudgetDTO;

public interface FindBudgetUseCase {
 		
	List<BudgetDTO> execute(BudgetDTO budget);

}
