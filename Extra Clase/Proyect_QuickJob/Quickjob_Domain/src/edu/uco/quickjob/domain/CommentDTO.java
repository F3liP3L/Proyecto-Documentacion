package edu.uco.quickjob.domain;

import java.util.UUID;
import static edu.uco.quickjob.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.quickjob.crosscutting.helper.ObjectHelper.getDefaultIfNull;
import static edu.uco.quickjob.builder.ServiceDTOBuilder.getServiceDTOBuilder;
import static edu.uco.quickjob.builder.CustomerDTOBuilder.getCustomerDTOBuilder;
import static edu.uco.quickjob.crosscutting.helper.StringHelper.applyTrim;

public final class CommentDTO {
	
	private UUID id;
	private String name;
	private String description;
	private ServiceDTO service;
	private CustomerDTO customer;
	
	public CommentDTO() {
		setId(getNewUUID());
		setName(EMPTY);
		setDescription(EMPTY);
		setService(getServiceDTOBuilder().build());
		setCustomer(getCustomerDTOBuilder().build());
	}
		
	public CommentDTO(final UUID id, final String name, final String description, final ServiceDTO service, final CustomerDTO customer) {
		setId(id);
		setName(name);
		setDescription(description);
		setService(service);
		setCustomer(customer);
	}
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = getDefaultUUID(id);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = applyTrim(name);
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = applyTrim(description);
	}
	public ServiceDTO getService() {
		return service;
	}
	public void setService(ServiceDTO service) {
		this.service = getDefaultIfNull(service, getServiceDTOBuilder().build());
	}
	public CustomerDTO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDTO customer) {
		this.customer = getDefaultIfNull(customer, null);
	}
	
	public static final CommentDTO create(final UUID id, final String name, final String description, final ServiceDTO service, final CustomerDTO customer) {
		return new CommentDTO(id, name, description, service, customer);
	}
	
}
