package edu.uco.quickjob.data.dao;

import java.util.List;

import edu.uco.quickjob.domain.QualificationDTO;

public interface QualificationDAO {
	
	void create (QualificationDTO qualification);
	
	List<QualificationDTO> find(QualificationDTO qualification);
	
	void update (QualificationDTO qualification);
	

}
