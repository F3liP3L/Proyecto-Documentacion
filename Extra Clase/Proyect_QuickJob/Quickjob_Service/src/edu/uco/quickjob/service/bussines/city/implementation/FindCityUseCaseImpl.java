package edu.uco.quickjob.service.bussines.city.implementation;

import java.util.List;

import edu.uco.quickjob.data.dao.factory.DAOFactory;
import edu.uco.quickjob.data.enumeration.DAOFactoryType;
import edu.uco.quickjob.domain.CityDTO;
import edu.uco.quickjob.service.bussines.city.FindCityUseCase;

public class FindCityUseCaseImpl implements FindCityUseCase {

	@Override
	public List<CityDTO> execute(CityDTO city) {
		return null;
	}
	
	public static void main(String[] args) {
		List<CityDTO> results = DAOFactory.getDAOFactory(DAOFactoryType.POSTGRESQL).getCityDAO().find(null);
		
		results.forEach(elem -> System.out.println(elem.getName() + elem.getIdAsString()));
	}
}
