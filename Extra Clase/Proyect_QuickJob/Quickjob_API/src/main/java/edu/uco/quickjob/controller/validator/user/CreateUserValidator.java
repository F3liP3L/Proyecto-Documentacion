package edu.uco.quickjob.controller.validator.user;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import edu.uco.quickjob.controller.validator.Validator;
import edu.uco.quickjob.crosscutting.messages.Messages;
import edu.uco.quickjob.crosscutting.messages.enumeration.Message;
import edu.uco.quickjob.domain.UserDTO;
import edu.uco.quickjob.crosscutting.helper.MailHelper;
import edu.uco.quickjob.crosscutting.helper.NumberHelper;
import static edu.uco.quickjob.crosscutting.helper.DateHelper.isOfLegalAge;

public class CreateUserValidator implements Validator<UserDTO> {

	@Override
	public List<Message> validate(UserDTO dto) {	
		List<Message> messages = new ArrayList<>();
		validateBirthDate(dto.getIdentification().getBirthDate(), messages);
		validateEmail(dto.getEmail(), messages);
		validateUsername(dto.getName(), messages);
		validateSurname(dto.getLastName(), messages);
		validateUserPassword(dto.getPassword(), messages);
		return messages;
	}
	
	private void validateEmail(String email, List<Message> messages) {
		if(MailHelper.isDefaultMail(email)) {
			messages.add(Message.createErrorMessage(Messages.CreateUserValidator.MAIL_IS_DEFAULT_ERROR));
		}
		if(!MailHelper.isMailValid(email)) {
			messages.add(Message.createErrorMessage(Messages.CreateUserValidator.MAIL_IS_INVALID_FORMAT_ERROR));
		}
	}
	private void validateUsername(String username, List<Message> messages) {
		if (!(username.length() >= 1 && username.length() <= 30)) {
			messages.add(Message.createErrorMessage(Messages.CreateUserValidator.NAME_IS_INVALID_ERROR));
		}
	}
	
	private void validateSurname(String surname, List<Message> messages) {
		if (!(surname.length() >= 1 && surname.length() <= 30)) {
			messages.add(Message.createErrorMessage(Messages.CreateUserValidator.SURNAME_IS_INVALID_ERROR));
		}
	}
	
	private void validateUserPassword(String password, List<Message> messages) {
		if (NumberHelper.isLessThan(password.length(), 8)) {
			messages.add(Message.createErrorMessage(Messages.CreateUserValidator.PASSWORD_IS_INVALID_ERROR));
		}
	}
	
	private void validateBirthDate(Date birthDate, List<Message> messages) {
		if(!isOfLegalAge(birthDate)) {
			messages.add(Message.createErrorMessage(Messages.CreateUserValidator.BIRTH_DATE_IS_INVALID_ERROR));
		}
	}

}
