package edu.uco.quickjob.domain;

import java.util.UUID;

public class QuestionDTO {
	
	private UUID id;
	private String description;
	private CustomerDTO customer;
	private ServiceDTO service;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
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
		this.service = service;
	}
	
	

}
