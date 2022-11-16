package edu.uco.quickjob.service.bussines.subservicetype.implementation;

import java.util.List;

import edu.uco.quickjob.data.dao.factory.DAOFactory;
import edu.uco.quickjob.domain.ServiceTypeDTO;
import edu.uco.quickjob.domain.SubserviceTypeDTO;
import edu.uco.quickjob.service.bussines.subservicetype.FindSubserviceTypeUseCase;

public class FindSubserviceTypeUseCaseImpl implements FindSubserviceTypeUseCase {

	private DAOFactory factory;
	
	public FindSubserviceTypeUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	}

	@Override
	public List<SubserviceTypeDTO> findSubserviceTypeDTO(ServiceTypeDTO serviceType) {
		return factory.getSubserviceTypeDAO().find(serviceType);
	}

}
