package edu.uco.quickjob.service.bussines.department.implementation;

import java.util.List;

import edu.uco.quickjob.data.dao.factory.DAOFactory;
import edu.uco.quickjob.data.enumeration.DAOFactoryType;
import edu.uco.quickjob.domain.DepartmentDTO;
import edu.uco.quickjob.service.bussines.department.FindDepartmentUseCase;

public class FindDepartmentUseCaseImpl implements FindDepartmentUseCase {

	@Override
	public List<DepartmentDTO> execute(DepartmentDTO department) {
		return null;
	}
	
	public static void main(String[] args) {
		List<DepartmentDTO> results = DAOFactory.getDAOFactory(DAOFactoryType.POSTGRESQL).getDepartmentDAO().find(null);
		results.forEach(elem -> System.out.println("Nombre del departamento: " +elem.getName() + " id_departamento: " + elem.getIdAsString() + " pais: " + elem.getCountry().getName()));
	}

}
