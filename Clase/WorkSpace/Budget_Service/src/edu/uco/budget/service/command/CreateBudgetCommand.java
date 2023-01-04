package edu.uco.budget.service.command;

import edu.uco.budget.domain.BudgetDTO;

public interface CreateBudgetCommand {
	void execute(BudgetDTO budget); 
}
