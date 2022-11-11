package edu.uco.quickjob.data.dao.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import edu.uco.quickjob.crosscutting.exception.CrosscuttingCustomException;
import edu.uco.quickjob.crosscutting.exception.QuickjobCustomException;
import edu.uco.quickjob.crosscutting.exception.data.DataCustomException;
import edu.uco.quickjob.crosscutting.helper.SqlConnectionHelper;
import edu.uco.quickjob.crosscutting.messages.Messages;
import edu.uco.quickjob.data.dao.CountryDAO;
import edu.uco.quickjob.data.dao.relational.postgresql.CountryPostgresqlDAO;

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
		try {
			SqlConnectionHelper.commitTransaction(connection);
		} catch (CrosscuttingCustomException exception) {
			throw DataCustomException.createTechnicalException(Messages.PostgresqlDAOFactory.TECHNICAL_PROBLEM_CONFIRM_TRANSACTION, exception);
		}
	}

	@Override
	public void cancelTransaction() {
		try {
			SqlConnectionHelper.rollbackTransaction(connection);
		} catch (CrosscuttingCustomException exception) {
			throw DataCustomException.createTechnicalException(Messages.PostgresqlDAOFactory.TECHNICAL_PROBLEM_CANCEL_TRANSACTION, exception);
		}
	}

	@Override
	public void closeConnection() {
		try {
			SqlConnectionHelper.closeConnection(connection);	
		} catch (CrosscuttingCustomException exception) {
			throw DataCustomException.createTechnicalException(Messages.PostgresqlDAOFactory.TECHNICAL_PROBLEM_CLOSE_CONNECTION,exception);
		}
	}

	@Override
	public CountryDAO getCountryDAO() {
		return new CountryPostgresqlDAO(connection);
	}
}
