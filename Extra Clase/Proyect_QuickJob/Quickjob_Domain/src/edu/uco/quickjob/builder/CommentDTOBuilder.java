package edu.uco.quickjob.builder;

import java.util.UUID;

import edu.uco.quickjob.domain.CustomerDTO;
import edu.uco.quickjob.domain.ServiceDTO;

public class CommentDTOBuilder {
	
	private UUID id;
	private String name;
	private String description;
	private ServiceDTO service;
	private CustomerDTO customer;
	
	private CommentDTOBuilder() {
		super();
	}
	
	public static final CommentDTOBuilder getCommentDTOBuilder() {
		return new CommentDTOBuilder();
	}

}
