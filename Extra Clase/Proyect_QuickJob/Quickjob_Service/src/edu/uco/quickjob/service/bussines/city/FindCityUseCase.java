package edu.uco.quickjob.service.bussines.city;

import java.util.List;

import edu.uco.quickjob.domain.CityDTO;

public interface FindCityUseCase {
	
	List<CityDTO> execute(CityDTO city);
}
