package edu.uco.quickjob.controller.validator;

import java.util.List;

import edu.uco.quickjob.crosscutting.messages.enumeration.Message;

public interface Validator<T> {

	List<Message> validate(T dto);
	
}
