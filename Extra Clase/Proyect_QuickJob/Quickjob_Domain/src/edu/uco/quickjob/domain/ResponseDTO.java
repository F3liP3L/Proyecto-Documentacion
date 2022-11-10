package edu.uco.quickjob.domain;

import java.util.UUID;

public class ResponseDTO {
	
	private UUID id;
	private String description;
	private QuestionDTO question;
	private ServiceProviderDTO serviceProvider;
	
	
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
	public QuestionDTO getQuestion() {
		return question;
	}
	public void setQuestion(QuestionDTO question) {
		this.question = question;
	}
	public ServiceProviderDTO getServiceProvider() {
		return serviceProvider;
	}
	public void setServiceProvider(ServiceProviderDTO serviceProvider) {
		this.serviceProvider = serviceProvider;
	}
	
	

}
