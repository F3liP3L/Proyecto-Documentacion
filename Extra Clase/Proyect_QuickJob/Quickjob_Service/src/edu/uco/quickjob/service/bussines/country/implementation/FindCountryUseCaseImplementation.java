package edu.uco.quickjob.service.bussines.country.implementation;

import java.util.List;

import edu.uco.quickjob.data.dao.factory.DAOFactory;
import edu.uco.quickjob.data.enumeration.DAOFactoryType;
import edu.uco.quickjob.domain.CountryDTO;
import edu.uco.quickjob.service.bussines.country.FindCountryUseCase;

public class FindCountryUseCaseImplementation implements FindCountryUseCase {
	
	// private final DAOFactory factory

	@Override
	public List<CountryDTO> execute(CountryDTO country) {
		return null;
	}
	
	public static void main(String[] args) {
		
		List<CountryDTO> results = DAOFactory.getDAOFactory(DAOFactoryType.POSTGRESQL).getCountryDAO().find(null);
		
		results.forEach(elem -> System.out.println(elem.getName() + elem.getIdAsString()));
		
	}
}
