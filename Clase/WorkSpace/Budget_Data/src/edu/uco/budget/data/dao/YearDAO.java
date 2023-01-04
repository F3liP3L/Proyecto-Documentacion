package edu.uco.budget.data.dao;

import java.util.List;
import java.util.UUID;

import edu.uco.budget.domain.YearDTO;

public interface YearDAO {

	void create(YearDTO year);

	List<YearDTO> find(YearDTO year);

	void update(YearDTO year);

	void delete(UUID id);


}
