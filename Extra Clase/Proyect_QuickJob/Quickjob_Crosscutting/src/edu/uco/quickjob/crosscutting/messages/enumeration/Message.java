package edu.uco.quickjob.crosscutting.messages.enumeration;

import edu.uco.quickjob.crosscutting.helper.StringHelper;

public class Message {
	
	private MessageLevel level;
	private String content;
	
	public Message() {
		setLevel(MessageLevel.FATAL);
		setContent(StringHelper.EMPTY);
	}
	
	public Message(final MessageLevel level, final String content) {
		super();
		setLevel(level);
		setContent(content);
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
	
	public static final Message createFatalMessage(final String content) {
		return new Message(MessageLevel.FATAL, content);
	}
	
	public static final Message createErrorMessage(final String content) {
		return new Message(MessageLevel.ERROR, content);
	}
	
	public static final Message createWarningMessage(final String content) {
		return new Message(MessageLevel.WARNING, content);
	}
	
	public static final Message createInfoMessage(final String content) {
		return new Message(MessageLevel.INFO, content);
	}
	
	public static final Message createSuccessMessage(final String content) {
		return new Message(MessageLevel.SUCCESS, content);
	}
	
	
	
	
	

}
