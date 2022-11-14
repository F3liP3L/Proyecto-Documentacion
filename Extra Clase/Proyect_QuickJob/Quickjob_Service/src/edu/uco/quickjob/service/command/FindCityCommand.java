package edu.uco.quickjob.service.command;

import java.util.List;

import edu.uco.quickjob.domain.CityDTO;

public interface FindCityCommand {

	List<CityDTO> findCity();
	
}
