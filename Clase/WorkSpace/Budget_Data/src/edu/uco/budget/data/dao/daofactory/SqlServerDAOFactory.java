package edu.uco.budget.data.dao.daofactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import edu.uco.budget.crosscutting.exception.data.CrosscuttingCustomException;
import edu.uco.budget.crosscutting.exception.data.DataCustomException;
import edu.uco.budget.crosscutting.helper.SqlConnectionHelper;
import edu.uco.budget.crosscutting.messages.Messages;
import edu.uco.budget.data.dao.BudgetDAO;
import edu.uco.budget.data.dao.PersonDAO;
import edu.uco.budget.data.dao.YearDAO;
import edu.uco.budget.data.dao.relational.sqlserver.BudgetSqlServerDAO;
import edu.uco.budget.data.dao.relational.sqlserver.PersonSqlServerDAO;
import edu.uco.budget.data.dao.relational.sqlserver.YearSqlServerDAO;

public final class SqlServerDAOFactory extends DAOFactory{
	
	private Connection connection;
	
	SqlServerDAOFactory(){
		openConnection();
	}

	@Override
	protected void openConnection() {
		String connectionSql =  "jdbc:sqlserver://rg-wf.database.windows.net:1433;" 
				+ "database=db-budget;user=userDmlBudget;" 
				+ "password=us3rDmlBudg3t;" 
				+ "encrypt=true;" 
				+ "trustServerCertificate=false;" 
				+ "hostNameInCertificate=*.database.windows.net;";
		try {
			connection = DriverManager.getConnection(connectionSql);
		} catch (CrosscuttingCustomException exception) {
			throw exception;
		} catch (SQLException excepcion) {
			throw DataCustomException.createTechnicalException(Messages.SqlServerDAOFactory.TECHNICAL_PROBLEM_OPEN_CONNECTION, excepcion);
		}
	}

	@Override
	public void initTransaction() {
		try {
			SqlConnectionHelper.initTransaction(connection);
		} catch(CrosscuttingCustomException exception) {
			throw DataCustomException.createTechnicalException(Messages.SqlServerDAOFactory.TECHNICAL_PROBLEM_INIT_TRANSACTION, exception);
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

	@Override
	public BudgetDAO getBudgetDAO() {
		return new BudgetSqlServerDAO(connection);
	}

	@Override
	public PersonDAO getPersonDAO() {
		return new PersonSqlServerDAO(connection);
	}

	@Override
	public YearDAO getYearDAO() {
		return new YearSqlServerDAO(connection);
	}

	public static void main(String[] args) {
		try {
			SqlServerDAOFactory dao = new SqlServerDAOFactory();
			dao.initTransaction();
			System.out.println("Transaccion iniciada!!!!!");
			
		} catch (DataCustomException exception) {
			exception.printStackTrace();
		}
	}
	
}
