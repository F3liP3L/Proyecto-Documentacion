package edu.uco.quickjob.service.bussines.servicetype.implementation;

import java.util.List;

import edu.uco.quickjob.data.dao.factory.DAOFactory;
import edu.uco.quickjob.domain.ServiceTypeDTO;
import edu.uco.quickjob.service.bussines.servicetype.FindServiceTypeUseCase;

public class FindServiceTypeUseCaseImpl implements FindServiceTypeUseCase {

	private DAOFactory factory;
	
	public FindServiceTypeUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	}

	@Override
	public List<ServiceTypeDTO> findServiceType() {
		return factory.getServiceTypeDAO().find();
	}

}
