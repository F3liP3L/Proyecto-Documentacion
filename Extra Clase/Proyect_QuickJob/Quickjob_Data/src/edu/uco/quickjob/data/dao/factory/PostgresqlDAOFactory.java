package edu.uco.quickjob.data.dao.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import edu.uco.quickjob.crosscutting.exception.CrosscuttingCustomException;
import edu.uco.quickjob.crosscutting.exception.QuickjobCustomException;
import edu.uco.quickjob.crosscutting.exception.data.DataCustomException;
import edu.uco.quickjob.crosscutting.helper.SqlConnectionHelper;
import edu.uco.quickjob.crosscutting.messages.Messages;

public class PostgresqlDAOFactory extends DAOFactory {
	
private Connection connection;
	
	PostgresqlDAOFactory(){
		openConnection();
	}

	@Override
	protected void openConnection() {
		String url = "jdbc:postgresql://localhost/quickjob";
		String user = "postgres";
		String password = "Nomic230s";
		  try {
	           connection = DriverManager.getConnection(url, user, password);
	        } catch (QuickjobCustomException exception) {
	            throw exception;
	        } catch (SQLException exception) {
	        	throw DataCustomException.createTechnicalException(Messages.PostgresqlDAOFactory.TECHNICAL_PROBLEM_OPEN_CONNECTION, exception);
	        }
	}

	@Override
	public void initTransaction() {
		try {
			SqlConnectionHelper.initTransaction(connection);
		} catch(CrosscuttingCustomException exception) {
			throw DataCustomException.createTechnicalException(Messages.PostgresqlDAOFactory.TECHNICAL_PROBLEM_INIT_TRANSACTION, exception);
		}
	}

	@Override
	public void confirmTransaction() {
		SqlConnectionHelper.commitTransaction(connection);
	}

	@Override
	public void cancelTransaction() {
		SqlConnectionHelper.rollbackTransaction(connection);
	}

	@Override
	public void closeConnection() {
		SqlConnectionHelper.closeConnection(connection);	
	}
	
}
