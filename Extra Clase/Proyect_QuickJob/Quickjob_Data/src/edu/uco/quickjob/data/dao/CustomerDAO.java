package edu.uco.quickjob.data.dao;

import java.util.List;
import java.util.UUID;

import edu.uco.quickjob.domain.CustomerDTO;

public interface CustomerDAO {
	
	void create (CustomerDTO customer);
	
	List<CustomerDTO> find(CustomerDTO customer);
	
	void update (CustomerDTO customer);
	
	void delete (UUID id);

}
