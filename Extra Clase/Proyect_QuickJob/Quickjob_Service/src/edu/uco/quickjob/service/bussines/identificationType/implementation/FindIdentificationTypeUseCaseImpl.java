package edu.uco.quickjob.service.bussines.identificationType.implementation;

import java.util.List;

import edu.uco.quickjob.data.dao.factory.DAOFactory;
import edu.uco.quickjob.domain.IdentificationTypeDTO;
import edu.uco.quickjob.service.bussines.identificationType.FindIdentificationTypeUseCase;

public class FindIdentificationTypeUseCaseImpl implements FindIdentificationTypeUseCase {

	private DAOFactory factory;
	
	public FindIdentificationTypeUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	}

	@Override
	public List<IdentificationTypeDTO> findIdentification () {
		return factory.getIdentificationTypeDAO().find();
	}


}
