package edu.uco.budget.crosscutting.helper;

import java.sql.Connection;
import java.sql.SQLException;

public final class SqlConnectionHelper {
	
	private SqlConnectionHelper() {
		super();
	}
	
	public static final boolean connectionIsNull(final Connection coonection) {
		return ObjectHelper.isNull(coonection);
	}
	
	public static final boolean connectionIsOpen(final Connection coonection) {
		try {
			return !ObjectHelper.isNull(coonection) && !coonection.isClosed();
		} catch (final SQLException exception) {
			throw new RuntimeException(exception.getMessage());
		}
	}

	
	public static final void closeConnection(final Connection connection) {
		if(connectionIsOpen(connection)) {
			
		}
	}
}
