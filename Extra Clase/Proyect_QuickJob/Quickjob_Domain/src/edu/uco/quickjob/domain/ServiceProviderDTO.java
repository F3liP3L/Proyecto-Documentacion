package edu.uco.quickjob.domain;

import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.quickjob.builder.ServiceDTOBuilder.getServiceDTOBuilder;
import static edu.uco.quickjob.crosscutting.helper.ObjectHelper.getDefaultIfNull;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getDefaultUUID;
import java.util.UUID;

public class ServiceProviderDTO extends UserDTO {
	
	private UUID serviceProviderId;
	private ServiceDTO serviceProvided;

	public ServiceProviderDTO() {
		setServiceProviderId(getNewUUID());
		setServiceProvided(getServiceDTOBuilder().build());
	}
	
	public ServiceProviderDTO(final UUID serviceProviderId, final ServiceDTO serviceProvided) {
		setServiceProviderId(serviceProviderId);
		setServiceProvided(serviceProvided);
	}
	
	public UUID getServiceProviderId() {
		return serviceProviderId;
	}

	public void setServiceProviderId(UUID serviceProviderId) {
		this.serviceProviderId = getDefaultUUID(serviceProviderId);
	}

	public ServiceDTO getServiceProvided() {
		return serviceProvided;
	}

	public void setServiceProvided(ServiceDTO serviceProvided) {
		this.serviceProvided = getDefaultIfNull(serviceProvided, getServiceDTOBuilder().build());
	}

	public static final ServiceProviderDTO create(final UUID serviceProviderId, final ServiceDTO serviceProvided) {
		return new ServiceProviderDTO(serviceProviderId, serviceProvided);
	}
	
	@Override
	public final String getIdAsString() {
		return getUUIDAsString(getServiceProviderId());
	}
	
	
}
