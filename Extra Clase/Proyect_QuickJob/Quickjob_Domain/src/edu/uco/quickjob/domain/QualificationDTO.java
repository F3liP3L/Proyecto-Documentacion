package edu.uco.quickjob.domain;


import static edu.uco.quickjob.builder.CustomerDTOBuilder.getCustomerDTOBuilder;
import static edu.uco.quickjob.builder.ServiceDTOBuilder.getServiceDTOBuilder;
import static edu.uco.quickjob.crosscutting.helper.NumberHelper.ZERO;
import static edu.uco.quickjob.crosscutting.helper.NumberHelper.isGreaterThan;
import static edu.uco.quickjob.crosscutting.helper.ObjectHelper.getDefaultIfNull;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getUUIDAsString;

import java.util.UUID;

public class QualificationDTO {
	
	private UUID id;
	private short score;
	private CustomerDTO customer;
	private ServiceDTO service;
	private static final Short SCORE_MAX = 5;
	
	
	public QualificationDTO(final UUID id, final Short score, final CustomerDTO customer, final ServiceDTO service) {
		setId(id);
		setScore(score);
		setCustomer(customer);
		setService(service);
	}
	
	public QualificationDTO() {
		setId(getNewUUID());
		setScore(score);
		setCustomer(getCustomerDTOBuilder().build());
		setService(getServiceDTOBuilder().build());
	}
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = getDefaultUUID(id);
	}
	public Short getScore() {
		return score;
	}
	public void setScore(Short score) {
		this.score = isGreaterThan(SCORE_MAX, score) ? ZERO: score;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDTO customer) {
		this.customer = getDefaultIfNull(customer, getCustomerDTOBuilder().build());
	}
	public ServiceDTO getService() {
		return service;
	}
	public void setService(ServiceDTO service) {
		this.service = getDefaultIfNull(service, getServiceDTOBuilder().build());
	}
	
	public final String getIdAsString() {
		return getUUIDAsString(getId());
	}
	

	
	

}
