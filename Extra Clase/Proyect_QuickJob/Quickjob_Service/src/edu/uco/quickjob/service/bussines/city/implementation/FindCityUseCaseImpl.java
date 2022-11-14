package edu.uco.quickjob.service.bussines.city.implementation;

import java.util.List;

import edu.uco.quickjob.data.dao.factory.DAOFactory;
import edu.uco.quickjob.domain.CityDTO;
import edu.uco.quickjob.service.bussines.city.FindCityUseCase;

public class FindCityUseCaseImpl implements FindCityUseCase {

	private DAOFactory factory;
	
	public FindCityUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public List<CityDTO> findCity() {
		return factory.getCityDAO().find();
	}
	
}
