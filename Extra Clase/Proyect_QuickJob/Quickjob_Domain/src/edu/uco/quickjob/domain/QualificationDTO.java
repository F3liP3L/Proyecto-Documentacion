package edu.uco.quickjob.domain;

import java.util.UUID;

public class QualificationDTO {
	
	private UUID id;
	private Short score;
	private CustomerDTO customer;
	private ServiceDTO service;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public Short getScore() {
		return score;
	}
	public void setScore(Short score) {
		this.score = score;
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
