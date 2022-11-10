package edu.uco.quickjob.data.dao;

import java.util.List;

import edu.uco.quickjob.domain.CityDTO;

public interface CityDAO {
	
	
	List<CityDTO> find(CityDTO city);

}
