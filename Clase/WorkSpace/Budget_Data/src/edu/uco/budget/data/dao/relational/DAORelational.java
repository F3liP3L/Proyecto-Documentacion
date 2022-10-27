package edu.uco.budget.data.dao.relational;

import java.sql.Connection;

import edu.uco.budget.crosscutting.exception.data.DataCustomException;
import edu.uco.budget.crosscutting.helper.SqlConnectionHelper;
import edu.uco.budget.crosscutting.messages.Messages;

public class DAORelational {
	
	private Connection connection;
	
	protected DAORelational(final Connection connection) {
		if(!SqlConnectionHelper.connectionIsOpen(connection)) {
			throw DataCustomException.createTechnicalException(Messages.SqlConnectionHelper.TECHNICAL_CONNECTION_IS_CLOSED);
		}
		this.connection = connection;
	}
	
	protected final Connection getConnection() {
		return connection;
	}

}
