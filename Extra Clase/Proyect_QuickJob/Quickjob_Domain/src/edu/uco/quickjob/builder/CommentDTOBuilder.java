package edu.uco.quickjob.builder;

import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getDefaultUUID;

import java.util.Date;
import java.util.UUID;

import edu.uco.quickjob.domain.CommentDTO;
import edu.uco.quickjob.domain.CustomerDTO;
import edu.uco.quickjob.domain.ServiceDTO;

public class CommentDTOBuilder {
	
	private UUID id;
	private String name;
	private String description;
	private Date publicationDate;
	private ServiceDTO service;
	private CustomerDTO customer;
		
	private CommentDTOBuilder() {
		super();
	}
	
	public static final CommentDTOBuilder getCommentDTOBuilder() {
		return new CommentDTOBuilder();
	}
	
	public final UUID getId() {
		return id;
	}

	public final void setId(UUID id) {
		this.id = getDefaultUUID(id);
	}

	public final CommentDTOBuilder setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
		return this;
	}

	public final CommentDTOBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public final CommentDTOBuilder setDescription(String description) {
		this.description = description;
		return this;
	}

	public final CommentDTOBuilder setService(ServiceDTO service) {
		this.service = service;
		return this;
	}

	public final CommentDTOBuilder setCustomer(CustomerDTO customer) {
		this.customer = customer;
		return this;
	}

	public final CommentDTO build() {
		return CommentDTO.create(id, name, description, publicationDate, service, customer);
	}
}
