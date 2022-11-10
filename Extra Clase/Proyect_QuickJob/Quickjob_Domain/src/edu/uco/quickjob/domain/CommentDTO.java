package edu.uco.quickjob.domain;

import java.util.UUID;

public class CommentDTO {
	
	private UUID id;
	private String name;
	private String description;
	private ServiceDTO service;
	private CustomerDTO customer;
	
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ServiceDTO getService() {
		return service;
	}
	public void setService(ServiceDTO service) {
		this.service = service;
	}
	public CustomerDTO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
	
	
	

}
