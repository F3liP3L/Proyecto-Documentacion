package edu.uco.budget.data.dao;

import java.util.List;
import java.util.UUID;

import edu.uco.budget.domain.BudgetDTO;

public interface BudgetDAO {

	void create(BudgetDTO budget);

	List<BudgetDTO> find(BudgetDTO budget);

	void update(BudgetDTO budget);

	void delete(UUID id);

}
