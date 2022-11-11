package edu.uco.quickjob.domain;

import java.util.UUID;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.quickjob.builder.ServiceDTOBuilder.getServiceDTOBuilder;
import static edu.uco.quickjob.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.quickjob.crosscutting.helper.ObjectHelper.getDefaultIfNull;


public final class QuestionDTO {
	
	private UUID id;
	private String description;
	private CustomerDTO customer;
	private ServiceDTO service;
	
	public QuestionDTO() {
		setId(getNewUUID());
		setDescription(EMPTY);
		setService(getServiceDTOBuilder().build());
		setCustomer(customer);
	}
	
	
	public QuestionDTO(final UUID id, final String description, final CustomerDTO customer, final ServiceDTO service) {
		setId(id);
		setDescription(description);
		setCustomer(customer);
		setService(service);
	}
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = getDefaultUUID(id);
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public CustomerDTO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
	public ServiceDTO getService() {
		return service;
	}
	public void setService(ServiceDTO service) {
		this.service = getDefaultIfNull(service, getServiceDTOBuilder().build());
	}
	
	public static final QuestionDTO create(final UUID id, final String description, final CustomerDTO customer, final ServiceDTO service) {
		return new QuestionDTO(id,description, customer, service);
	}	

}
