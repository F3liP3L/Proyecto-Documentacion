package edu.uco.quickjob.crosscutting.helper;

import java.util.regex.Pattern;

public class MailHelper {
	
	private MailHelper() {
		super();
	}

	public static final String DEFAULT_MAIL = "email@mail.com";
	
	private static final Pattern VALIDATOR_MAIL = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" 
	+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	
	public static boolean isMailValid(String mail) {
		return VALIDATOR_MAIL.matcher(mail).find();
	}
	
	public static boolean isDefaultMail (String mail) {
		return DEFAULT_MAIL.equals(mail);
	}
	
}
