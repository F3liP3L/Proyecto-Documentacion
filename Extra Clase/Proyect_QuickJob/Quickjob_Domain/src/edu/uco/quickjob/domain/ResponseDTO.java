package edu.uco.quickjob.domain;

import java.util.UUID;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.quickjob.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.quickjob.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.quickjob.crosscutting.helper.ObjectHelper.getDefaultIfNull;
import static edu.uco.quickjob.builder.ServiceProviderDTOBuilder.getServiceProviderDTOBuilder;
import static edu.uco.quickjob.builder.QuestionDTOBuilder.getQuestionDTOBuilder;

public final class ResponseDTO {
	
	private UUID id;
	private String description;
	private QuestionDTO question;
	private ServiceProviderDTO serviceProvider;
	
	public ResponseDTO() {
		setId(getNewUUID());
		setDescription(EMPTY);
		setQuestion(getQuestionDTOBuilder().build());
		setServiceProvider(getServiceProviderDTOBuilder().build());
	}
	
	public ResponseDTO(final UUID id, final String description, final QuestionDTO question, final ServiceProviderDTO serviceProvider) {
		setId(id);
		setDescription(description);
		setQuestion(question);
		setServiceProvider(serviceProvider);
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
		this.description = applyTrim(description);
	}
	public QuestionDTO getQuestion() {
		return question;
	}
	public void setQuestion(QuestionDTO question) {
		this.question = getDefaultIfNull(question, getQuestionDTOBuilder().build());
	}
	public ServiceProviderDTO getServiceProvider() {
		return serviceProvider;
	}
	public void setServiceProvider(ServiceProviderDTO serviceProvider) {
		this.serviceProvider = getDefaultIfNull(serviceProvider, null);
	}
	
	public static final ResponseDTO create(final UUID id, final String description, final QuestionDTO question, final ServiceProviderDTO serviceProvider) {
		return new ResponseDTO(id, description, question, serviceProvider);
	}

}
