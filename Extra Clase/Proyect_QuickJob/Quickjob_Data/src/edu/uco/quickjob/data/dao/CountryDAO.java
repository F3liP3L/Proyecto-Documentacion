package edu.uco.quickjob.data.dao;

import java.util.List;

import edu.uco.quickjob.domain.CountryDTO;

public interface CountryDAO {
	
	List<CountryDTO> find(CountryDTO country);

}
