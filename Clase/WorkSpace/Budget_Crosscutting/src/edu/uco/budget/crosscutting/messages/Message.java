package edu.uco.budget.crosscutting.messages;

import edu.uco.budget.crosscutting.helper.StringHelper;
import edu.uco.budget.crosscutting.messages.enumeration.MessageLevel;

public class Message {

	private MessageLevel level;
	private String content;
	
	public Message() {
		setLevel(MessageLevel.FATAL);
		setContent(StringHelper.EMPTY);
	}
	
	public Message(MessageLevel level, String content) {
		setLevel(level);
		setContent(content);
	}
	
	public static Message createSuccessMessage(final MessageLevel level, final String content) {
		return new Message(level, content);
	}
	
	public static Message createSuccessMessage(final MessageLevel level, final String content) {
		return new Message(level, content);
	}

	public static Message createErrorMessage(final MessageLevel level, final String content) {
		return new Message(level, content);
	}

	public static Message createFatalMessage(final MessageLevel level, final String content) {
		return new Message(level, content);
	}

	public static Message createSuccessMessage(final MessageLevel level, final String content) {
		return new Message(level, content);
	}
	
	public void addFatalMessage(final String content) {
		
	}
	

	public MessageLevel getLevel() {
		return level;
	}

	public void setLevel(MessageLevel level) {
		this.level = level;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	
}
