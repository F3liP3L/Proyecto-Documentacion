package edu.uco.quickjob.domain;

import static edu.uco.quickjob.builder.ServiceDTOBuilder.getServiceDTOBuilder;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.quickjob.crosscutting.helper.ObjectHelper.getDefaultIfNull;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getNewUUID;

import java.util.UUID;

public class CustomerDTO extends UserDTO {
	
	private UUID customerId;
	private ServiceDTO usedService;
	
	public CustomerDTO() {
		setCustomerId(getNewUUID());
		setUsedService(getServiceDTOBuilder().build());
	}
	
	public CustomerDTO(final UUID customerId, final ServiceDTO usedService) {
		setCustomerId(customerId);
		setUsedService(usedService);
	}
	
	public UUID getCustomerId() {
		return customerId;
	}

	public void setCustomerId(UUID customerId) {
		this.customerId = getDefaultUUID(customerId);
	}
	
	public ServiceDTO getUsedService() {
		return usedService;
	}

	public void setUsedService(ServiceDTO usedService) {
		this.usedService = getDefaultIfNull(usedService, getServiceDTOBuilder().build());
	}
	
	public static final CustomerDTO create(final UUID customerId, final ServiceDTO usedService) {
		return new CustomerDTO(customerId, usedService);
	}
	
	@Override
	public final String getIdAsString() {
		return getUUIDAsString(getCustomerId());
	}
}
