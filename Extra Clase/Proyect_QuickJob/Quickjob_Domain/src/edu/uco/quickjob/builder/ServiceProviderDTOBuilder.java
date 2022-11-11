package edu.uco.quickjob.builder;

import java.util.UUID;

import edu.uco.quickjob.domain.ServiceDTO;
import edu.uco.quickjob.domain.ServiceProviderDTO;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getDefaultUUID;

public class ServiceProviderDTOBuilder extends UserDTOBuilder {
	
	private UUID serviceProviderId;
	private ServiceDTO serviceProvided;
	
	protected ServiceProviderDTOBuilder() {
		super();
	}	
	
	public final UUID getServiceProviderId() {
		return serviceProviderId;
	}

	public final void setServiceProviderId(UUID serviceProviderId) {
		this.serviceProviderId = getDefaultUUID(serviceProviderId);
	}

	public static final ServiceProviderDTOBuilder getServiceProviderDTOBuilder() {
		return new ServiceProviderDTOBuilder();
	}

	public final ServiceProviderDTOBuilder setServiceProvided(final ServiceDTO serviceProvided) {
		this.serviceProvided = serviceProvided;
		return this;
	}
	
	@Override
	public final ServiceProviderDTO build() {
		return ServiceProviderDTO.create(serviceProviderId, serviceProvided);
	}


}
