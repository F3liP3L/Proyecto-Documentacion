package edu.uco.quickjob.data.dao.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import edu.uco.quickjob.crosscutting.exception.CrosscuttingCustomException;
import edu.uco.quickjob.crosscutting.exception.QuickjobCustomException;
import edu.uco.quickjob.crosscutting.exception.data.DataCustomException;
import edu.uco.quickjob.crosscutting.helper.SqlConnectionHelper;
import edu.uco.quickjob.crosscutting.messages.Messages;
import edu.uco.quickjob.data.dao.CityDAO;
import edu.uco.quickjob.data.dao.CountryDAO;
import edu.uco.quickjob.data.dao.DepartmentDAO;
import edu.uco.quickjob.data.dao.IdentificationDocumentDAO;
import edu.uco.quickjob.data.dao.IdentificationTypeDAO;
import edu.uco.quickjob.data.dao.QuestionDAO;
import edu.uco.quickjob.data.dao.ResponseDAO;
import edu.uco.quickjob.data.dao.ServiceDAO;
import edu.uco.quickjob.data.dao.ServiceProviderDAO;
import edu.uco.quickjob.data.dao.ServiceTypeDAO;
import edu.uco.quickjob.data.dao.SubserviceTypeDAO;
import edu.uco.quickjob.data.dao.UserDAO;
import edu.uco.quickjob.data.dao.relational.postgresql.CityPostgresqlDAO;
import edu.uco.quickjob.data.dao.relational.postgresql.CountryPostgresqlDAO;
import edu.uco.quickjob.data.dao.relational.postgresql.DepartmentPostgresqlDAO;
import edu.uco.quickjob.data.dao.relational.postgresql.IdentificationDocumentPostgresqlDAO;
import edu.uco.quickjob.data.dao.relational.postgresql.IdentificationTypePostgresqlDAO;
import edu.uco.quickjob.data.dao.relational.postgresql.QuestionPostgresqlDAO;
import edu.uco.quickjob.data.dao.relational.postgresql.ResponsePostgresqlDAO;
import edu.uco.quickjob.data.dao.relational.postgresql.ServicePostgresqlDAO;
import edu.uco.quickjob.data.dao.relational.postgresql.ServiceProviderPostgresqlDAO;
import edu.uco.quickjob.data.dao.relational.postgresql.ServiceTypePostgresqlDAO;
import edu.uco.quickjob.data.dao.relational.postgresql.SubserviceTypePostgresqlDAO;
import edu.uco.quickjob.data.dao.relational.postgresql.UserPostgresqlDAO;

public class PostgresqlDAOFactory extends DAOFactory {
	
private Connection connection;
	
	PostgresqlDAOFactory(){
		super();
	}

	@Override
	public void openConnection() {
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

	@Override
	public DepartmentDAO getDepartmentDAO() {
		return new DepartmentPostgresqlDAO(connection);
	}

	@Override
	public CityDAO getCityDAO() {
		return new CityPostgresqlDAO(connection);
	}

	@Override
	public IdentificationTypeDAO getIdentificationTypeDAO() {
		return new IdentificationTypePostgresqlDAO(connection);
	}

	@Override
	public IdentificationDocumentDAO getIdentificationDocumentDAO() {
		return new IdentificationDocumentPostgresqlDAO(connection);
	}

	@Override
	public UserDAO getUserDAO() {
		return new UserPostgresqlDAO(connection);
	}

	@Override
	public ServiceTypeDAO getServiceTypeDAO() {
		return new ServiceTypePostgresqlDAO(connection);
	}

	@Override
	public SubserviceTypeDAO getSubserviceTypeDAO() {
		return new SubserviceTypePostgresqlDAO(connection);
	}

	@Override
	public ServiceDAO getServiceDAO() {
		return new ServicePostgresqlDAO(connection);
	}

	@Override
	public ServiceProviderDAO getServiceProviderDAO() {
		return new ServiceProviderPostgresqlDAO(connection);
	}

	@Override
	public QuestionDAO getQuestionDAO() {
		return new QuestionPostgresqlDAO(connection);
	}

	@Override
	public ResponseDAO getReponseDAO() {
		return new ResponsePostgresqlDAO(connection);
	}
}
