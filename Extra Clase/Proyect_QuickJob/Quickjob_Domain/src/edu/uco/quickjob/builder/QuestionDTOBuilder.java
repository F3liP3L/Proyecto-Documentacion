package edu.uco.quickjob.builder;

import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getDefaultUUID;

import java.util.UUID;

import edu.uco.quickjob.domain.CustomerDTO;
import edu.uco.quickjob.domain.QuestionDTO;
import edu.uco.quickjob.domain.ServiceDTO;

public class QuestionDTOBuilder {
	
	private UUID id;
	private String description;
	private CustomerDTO customer;
	private ServiceDTO service;
	
	private QuestionDTOBuilder() {
		super();
	}
	
	public static final QuestionDTOBuilder getQuestionDTOBuilder() {
		return new QuestionDTOBuilder();
	}
	
	public final UUID getId() {
		return id;
	}
	public final void setId(UUID id) {
		this.id = getDefaultUUID(id);
	}
	public final QuestionDTOBuilder setDescription(String description) {
		this.description = description;
		return this;
	}
	
	public final QuestionDTOBuilder setCustomer(CustomerDTO customer) {
		this.customer = customer;
		return this;
	}
	
	public final QuestionDTOBuilder setService(ServiceDTO service) {
		this.service = service;
		return this;
	}
	
	public final QuestionDTO build() {
		return QuestionDTO.create(id, description, customer, service);
	}
}
