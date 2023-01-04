package edu.uco.quickjob.data.dao;

import java.util.List;

import edu.uco.quickjob.domain.QuestionDTO;

public interface QuestionDAO {
	
	void create (QuestionDTO question);
	
	List<QuestionDTO> find(QuestionDTO question);
	
}
