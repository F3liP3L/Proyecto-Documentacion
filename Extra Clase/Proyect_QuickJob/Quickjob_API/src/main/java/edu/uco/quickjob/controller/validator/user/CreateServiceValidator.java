package edu.uco.quickjob.controller.validator.user;

import java.util.ArrayList;
import java.util.List;

import edu.uco.quickjob.controller.validator.Validator;
import edu.uco.quickjob.crosscutting.messages.Messages;
import edu.uco.quickjob.crosscutting.messages.enumeration.Message;
import edu.uco.quickjob.domain.ServiceDTO;
import edu.uco.quickjob.crosscutting.helper.StringHelper;

public class CreateServiceValidator implements Validator<ServiceDTO>{

	@Override
	public List<Message> validate(ServiceDTO dto) {
		List<Message> messages = new ArrayList<>();
		validateDescription(dto.getDescription(), messages);
		validateName(dto.getName(), messages);
		return messages;
	}
	
	public void validateDescription(String description, List<Message> messages) {
		if(description.equals(StringHelper.EMPTY)) {
			messages.add(Message.createErrorMessage(Messages.CreateServiceValidator.DESCRIPTION_IS_INVALID_ERROR));
		}
	}
	
	public void validateName(String name, List<Message> messages) {
		if (name.equals(StringHelper.EMPTY)) {
			messages.add(Message.createErrorMessage(Messages.CreateServiceValidator.NAME_IS_INVALID_ERROR));
		}
	}

}
