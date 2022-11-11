package edu.uco.quickjob.crosscutting.helper;

import java.sql.Connection;
import java.sql.SQLException;

import edu.uco.quickjob.crosscutting.exception.CrosscuttingCustomException;
import edu.uco.quickjob.crosscutting.messages.Messages;

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
			throw CrosscuttingCustomException
			.createTechnicalException(Messages.SqlConnectionHelper.TECHNICAL_CONNECTION_IS_CLOSED, exception);
		}
	}
	
	public static final void closeConnection(final Connection connection) {
		try {
			if(!connectionIsOpen(connection)) {
				throw CrosscuttingCustomException
				.createTechnicalException(Messages.SqlConnectionHelper.TECHNICAL_CONNECTION_ALREADY_IS_CLOSED);
			}
			connection.close();
		} catch (final CrosscuttingCustomException exception) {
			throw exception;
		}
		  catch (final SQLException exception) {
			  throw CrosscuttingCustomException
			  .createTechnicalException(Messages.SqlConnectionHelper.TECHNICAL_PROBLEM_CLOSING_CONNECTION, exception);
		}
	}
	
	public static final void initTransaction(final Connection connection) {
		try {
			if(!connectionIsOpen(connection)) {
				throw CrosscuttingCustomException
				.createTechnicalException(Messages.SqlConnectionHelper.TECHNICAL_CONNECTION_IS_CLOSED_FOR_INIT_TRANSACTION);
			}
			connection.setAutoCommit(false);
		} catch (final CrosscuttingCustomException exception) {
			throw exception;
		}
		  catch (final SQLException exception) {
			  throw CrosscuttingCustomException
			  .createTechnicalException(Messages.SqlConnectionHelper.TECHNICAL_PROBLEM_TRY_INIT_TRANSACTION, exception);
		}
	}
	
	public static final void commitTransaction(final Connection connection) {
		try {
			if(!connectionIsOpen(connection)) {
				throw CrosscuttingCustomException
				.createTechnicalException(Messages.SqlConnectionHelper.TECHNICAL_CONNECTION_IS_CLOSED_FOR_COMMIT_TRANSACTION);
			}
			connection.setAutoCommit(false);
		} catch (final CrosscuttingCustomException exception) {
			throw exception;
		}
		  catch (final SQLException exception) {
			  throw CrosscuttingCustomException
			  .createTechnicalException(Messages.SqlConnectionHelper.TECHNICAL_PROBLEM_TRY_COMMIT_TRANSACTION, exception);
		}
	}
	
	public static final void rollbackTransaction(final Connection connection) {
		try {
			if(!connectionIsOpen(connection)) {
				throw CrosscuttingCustomException
				.createTechnicalException(Messages.SqlConnectionHelper.TECHNICAL_CONNECTION_IS_CLOSED_FOR_ROLLBACK_TRANSACTION);
			}
			connection.setAutoCommit(false);
		} catch (final CrosscuttingCustomException exception) {
			throw exception;
		}
		  catch (final SQLException exception) {
			  throw CrosscuttingCustomException
			  .createTechnicalException(Messages.SqlConnectionHelper.TECHNICAL_PROBLEM_TRY_ROLLBACK_TRANSACTION, exception);
		}
	}
	
	
	
	
}
