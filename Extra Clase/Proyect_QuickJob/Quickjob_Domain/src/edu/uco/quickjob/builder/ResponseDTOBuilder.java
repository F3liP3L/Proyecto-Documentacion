package edu.uco.quickjob.builder;

import java.util.UUID;

import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getDefaultUUID;
import edu.uco.quickjob.domain.QuestionDTO;
import edu.uco.quickjob.domain.ResponseDTO;
import edu.uco.quickjob.domain.ServiceProviderDTO;

public class ResponseDTOBuilder {
	
	private UUID id;
	private String description;
	private QuestionDTO question;
	private ServiceProviderDTO serviceProvider;
	
	private ResponseDTOBuilder() {
		super();
	}
	
	public static final ResponseDTOBuilder getResponseDTOBuilder() {
		return new ResponseDTOBuilder();
	}
	
	public final UUID getId() {
		return id;
	}
	public final void setId(UUID id) {
		this.id = getDefaultUUID(id);
	}
	public final ResponseDTOBuilder setDescription(final String description) {
		this.description = description;
		return this;
	}
	public final ResponseDTOBuilder setQuestion(final QuestionDTO question) {
		this.question = question;
		return this;
	}
	public final ResponseDTOBuilder setServiceProvider(final ServiceProviderDTO serviceProvider) {
		this.serviceProvider = serviceProvider;
		return this;
	}

	public final ResponseDTO build() {
		return ResponseDTO.create(id, description, question, serviceProvider);
	}
	
}
