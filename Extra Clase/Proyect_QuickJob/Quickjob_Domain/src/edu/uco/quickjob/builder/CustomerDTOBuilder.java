package edu.uco.quickjob.builder;

import java.util.UUID;

import edu.uco.quickjob.domain.CustomerDTO;
import edu.uco.quickjob.domain.ServiceDTO;

public class CustomerDTOBuilder extends UserDTOBuilder {
	
	private UUID customerId;
	private ServiceDTO usedService;
	
	private CustomerDTOBuilder() {
		super();
	}
	
	public static final CustomerDTOBuilder getCustomerDTOBuilder() {
		return new CustomerDTOBuilder();
	}

	public final CustomerDTOBuilder setUsedService(ServiceDTO usedService) {
		this.usedService = usedService;
		return this;
	}
	
	@Override
	public final CustomerDTO build() {
		return CustomerDTO.create(customerId , usedService);
	}
	
	

}
