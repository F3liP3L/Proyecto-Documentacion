package edu.uco.budget.crosscutting.helper;

import java.sql.Connection;
import java.sql.SQLException;
import edu.uco.budget.crosscutting.exceptions.CrosscuttingCustomException;
import edu.uco.budget.crosscutting.messages.Messages;

public final class SqlConnectionHelper {
	
	private SqlConnectionHelper() {
		super();
	}
	
	public static final boolean connectionIsNull(final Connection coonection) {
		return ObjectHelper.isNull(coonection);
	}
	
	public static final boolean connectionIsOpen(final Connection coonection) {
		try {
			return !connectionIsNull(coonection) && !coonection.isClosed();
		} catch (final SQLException exception) {
			throw CrosscuttingCustomException.createTechnicalException(Messages.SqlConnectionHelper.TECHNICAL_CONNECTION_IS_CLOSED);
		}
	}
	
	public static final void closeConnection(final Connection connection) {
		if(!connectionIsOpen(connection)) {
			throw CrosscuttingCustomException.createTechnicalException("TECHNICAL EXCEPTION");
		}
	}
}
