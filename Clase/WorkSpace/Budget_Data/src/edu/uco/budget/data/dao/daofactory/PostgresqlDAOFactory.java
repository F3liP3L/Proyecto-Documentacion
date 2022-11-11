package edu.uco.budget.data.dao.daofactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.uco.budget.crosscutting.exception.CrosscuttingCustomException;
import edu.uco.budget.crosscutting.exception.data.DataCustomException;
import edu.uco.budget.crosscutting.helper.SqlConnectionHelper;
import edu.uco.budget.crosscutting.messages.Messages;
import edu.uco.budget.data.dao.BudgetDAO;
import edu.uco.budget.data.dao.PersonDAO;
import edu.uco.budget.data.dao.YearDAO;

public class PostgresqlDAOFactory extends DAOFactory {
	
	private Connection connection;
	
	PostgresqlDAOFactory(){
		openConnection();
	}

	@Override
	protected void openConnection() {
		String url = "jdbc:postgresql://localhost/dvdrental"; // Ejemplo de conexion a un base de datos local.
		String user = "postgres";
		String password = "Nomic230s";
		  try {
	            connection = DriverManager.getConnection(url, user, password);
	            /*
	            String SQL = "SELECT * FROM film WHERE film_id = ?";
				PreparedStatement pstmt = connection.prepareStatement(SQL);
				pstmt.setLong(1, 777);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					System.out.println( "[The title: " + rs.getString("title") + "]  Sipnosis: \n" + rs.getString("description") + " \n Special Feature: " + rs.getString("special_features") );
				}
				*/
	        } catch (CrosscuttingCustomException exception) {
	            throw exception;
	        } catch (SQLException exception) {
	        	throw DataCustomException.createTechnicalException(Messages.SqlServerDAOFactory.TECHNICAL_PROBLEM_OPEN_CONNECTION, exception);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonDAO getPersonDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public YearDAO getYearDAO() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// Prueba para saber si la conexion a Postgresql funciona correctamente.
	
	public static void main(String[] args) {
		try {
			PostgresqlDAOFactory PostSQLDAO = new PostgresqlDAOFactory();
			System.out.println("Connected to the PostgreSQL server successfully.");
			PostSQLDAO.closeConnection();
		} catch (DataCustomException exception) {
			exception.printStackTrace();
		}
	}

}
