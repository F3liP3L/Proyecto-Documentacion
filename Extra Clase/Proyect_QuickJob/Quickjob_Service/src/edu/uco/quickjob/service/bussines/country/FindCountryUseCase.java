package edu.uco.quickjob.service.bussines.country;

import java.util.List;

import edu.uco.quickjob.domain.CountryDTO;

public interface FindCountryUseCase {
	
	List<CountryDTO> execute(CountryDTO country);

}
