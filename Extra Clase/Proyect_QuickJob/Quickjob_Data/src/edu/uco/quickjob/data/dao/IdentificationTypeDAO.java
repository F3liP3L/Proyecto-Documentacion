package edu.uco.quickjob.data.dao;

import java.util.List;

import edu.uco.quickjob.domain.IdentificationTypeDTO;



public interface IdentificationTypeDAO {
	
	
	List<IdentificationTypeDTO> find(IdentificationTypeDTO identificationType);
	
	


}
