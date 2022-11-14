package edu.uco.quickjob.crosscutting.messages;

public class Messages {
	
	private Messages() {
		super();
	}

	public static class DAOFactory {
		
		private DAOFactory() {
			super();
		}
		
		public static final String TECHNICAL_SQLSERVER_NOT_IMPLEMENTED = "DAOFactory for Postgresql is not implemented yet";
		public static final String TECHNICAL_MONGODB_NOT_IMPLEMENTED = "DAOFactory for MongoDB is not implemented yet";
		public static final String TECHNICAL_CASSANDRA_NOT_IMPLEMENTED = "DAOFactory for Cassandra is not implemented yet";
		public static final String TECHNICAL_MARIADB_NOT_IMPLEMENTED = "DAOFactory for MariaDB is not implemented yet";
		public static final String TECHNICAL_MYSQL_NOT_IMPLEMENTED = "DAOFactory for Mysql is not implemented yet";
		public static final String TECHNICAL_ORACLE_NOT_IMPLEMENTED = "DAOFactory for Oracle is not implemented yet";
		public static final String TECHNICAL_POSTGRESQL_NOT_IMPLEMENTED = "DAOFactory for Postgresql is not implemented yet";
		public static final String TECHNICAL_UNEXPECTED_DAOFACTORY = "Unexpected DAOFactory";
		
	}
	
	public static class SqlConnectionHelper {
		
		private SqlConnectionHelper() {
			super();
		}
		
		public static final String TECHNICAL_CONNECTION_IS_NULL = "Connection is null";
		public static final String TECHNICAL_CONNECTION_IS_CLOSED = "Connection is closed";
		public static final String TECHNICAL_CONNECTION_ALREADY_IS_CLOSED = "Connection already is closed";
		public static final String TECHNICAL_PROBLEM_CLOSING_CONNECTION = "There was a problem trying to close connection. Please verify the technicals details";
		public static final String TECHNICAL_CONNECTION_IS_CLOSED_FOR_INIT_TRANSACTION = "Connection is closed to start a new transaction";
		public static final String TECHNICAL_CONNECTION_IS_CLOSED_FOR_COMMIT_TRANSACTION = "Connection is closed to commit the current transaction";
		public static final String TECHNICAL_CONNECTION_IS_CLOSED_FOR_ROLLBACK_TRANSACTION = "Connection is closed to rollback the current transaction";
		public static final String TECHNICAL_PROBLEM_TRY_INIT_TRANSACTION = "There was a problem trying to start the transaction. Please verify the technicals details";
		public static final String TECHNICAL_PROBLEM_TRY_COMMIT_TRANSACTION = "There was a problem trying to commit the current transaction. Please verify the technicals details";
		public static final String TECHNICAL_PROBLEM_TRY_ROLLBACK_TRANSACTION = "There was a problem trying to rollback the current transaction. Please verify the technicals details";
	}
	
	
	public static class PostgresqlDAOFactory {
		
		private PostgresqlDAOFactory() {
			super();
		}		
		
		public static final String TECHNICAL_PROBLEM_INIT_TRANSACTION = "There was a problem trying to init transaction with the current connection in PostgresqlDAOFactory";
		public static final String TECHNICAL_PROBLEM_OPEN_CONNECTION = "There was a problem trying to open connection in PostgresqlDAOFactory";
		public static final String TECHNICAL_PROBLEM_CONFIRM_TRANSACTION = "There was a problem trying to confirm transaction in PostgresqlDAOFactory";
		public static final String TECHNICAL_PROBLEM_CANCEL_TRANSACTION = "There was a problem trying to cancel transaction in PostgresqlDAOFactory";
		public static final String TECHNICAL_PROBLEM_CLOSE_CONNECTION = "There was a problem trying to confirm close connection in PostgresqlDAOFactory";
	}
	
	public static class UserPostgresqlDAO {
		
		private UserPostgresqlDAO() {
				super();
		}
		
		public static final String TECHNICAL_PROBLEM_CREATE_USER = "There was a problem trying to create the desired user in PostgresqlDAOFactory";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_CREATE_USER = "There was an unexpected problem trying to create the qualification in PostgresqlDAOFactory";
		public static final String TECHNICAL_PROBLEM_UPDATE_USER = "There was a problem trying to update the desired user in PostgresqlDAOFactory";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_USER = "There was an unexpected problem trying to create the user in PostgresqlDAOFactory";
		public static final String TECHNICAL_PROBLEM_FILL_USER_DTO = "There was a problem filling userDTO from the resultSet";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILL_USER_DTO = "There was an unexpected problem trying to filling userDTO from the resultSet";
		public static final String TECHNICAL_PROBLEM_DELETE_USER_DTO = "There was a problem filling userDTO from the resultSet";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_DELETE_USER_DTO = "There was an unexpected problem trying to filling userDTO from the resultSet";
		public static final String TECHNICAL_PROBLEM_EXECUTE_QUERY = "There was a problem trying to execute query to find the specific department";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_EXECUTE_QUERY = "There was an unexpected problem trying to execute query to find the specific department";
		public static final String TECHNICAL_PROBLEM_SET_PARAMETERS_VALUES_QUERY = "There was a problem trying to execute query to find the specific department";
		public static final String TECHNICAL_PROBLEM_PREPARED_STATEMENT = "There was a problem trying to prepare the sql statement";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_PREPARED_STATEMENT = "There was an unexpected problem trying to prepare the sql statement";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_SET_PARAMATERS_VALUES_QUERY = "There was an unexpected problem trying to execute query to find the specific department";
	}
	
	public static class QualificationPostgresqlDAO {
		
		private QualificationPostgresqlDAO() {
				super();
		}
		
		public static final String TECHNICAL_PROBLEM_CREATE_QUALIFICATION = "There was a problem trying to create the desired qualification in PostgresqlDAOFactory with id = ";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_CREATE_QUALIFICATION = "There was an unexpected problem trying to create the qualification in PostgresqlDAOFactory";
		public static final String TECHNICAL_PROBLEM_UPDATE_QUALIFICATION = "There was a problem trying to update the desired qualification in PostgresqlDAOFactory with id = ";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_QUALIFICATION = "There was an unexpected problem trying to create the qualification in PostgresqlDAOFactory";
		
	}
	
	public static class CountryPostgresqlDAO {
		
		private CountryPostgresqlDAO() {
			super();
		}
		
		public static final String TECHNICAL_PROBLEM_FILL_COUNTRY_DTO = "There was a problem filling countryDTO from the resultSet";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILL_COUNTRY_DTO = "There was an unexpected problem trying to filling countryDTO from the resultSet";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILL_RESULTS_COUNTRY = "There was a unexpected problem trying to recovering results from the resultSet";
		public static final String TECHNICAL_PROBLEM_EXECUTE_QUERY = "There was a problem trying to execute query to find the specific country";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_EXECUTE_QUERY = "There was an unexpected problem trying to execute query to find the specific country";
		public static final String TECHNICAL_PROBLEM_SET_PARAMETERS_VALUES_QUERY = "There was a problem trying to execute query to find the specific country";
		public static final String TECHNICAL_PROBLEM_PREPARED_STATEMENT = "There was a problem trying to prepare the sql statement";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_PREPARED_STATEMENT = "There was an unexpected problem trying to prepare the sql statement";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_SET_PARAMATERS_VALUES_QUERY = "There was an unexpected problem trying to execute query to find the specific country";	
		
	}
	
	public static class DepartmentPostgresqlDAO {
		
		private DepartmentPostgresqlDAO() {
			super();
		}
		
		public static final String TECHNICAL_PROBLEM_FILL_DEPARTMENT_DTO = "There was a problem filling departmentDTO from the resultSet";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILL_DEPARTMENT_DTO = "There was an unexpected problem trying to filling departmentDTO from the resultSet";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILL_RESULTS_DEPARTMENT = "There was a unexpected problem trying to recovering results from the resultSet";
		public static final String TECHNICAL_PROBLEM_EXECUTE_QUERY = "There was a problem trying to execute query to find the specific department";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_EXECUTE_QUERY = "There was an unexpected problem trying to execute query to find the specific department";
		public static final String TECHNICAL_PROBLEM_SET_PARAMETERS_VALUES_QUERY = "There was a problem trying to execute query to find the specific department";
		public static final String TECHNICAL_PROBLEM_PREPARED_STATEMENT = "There was a problem trying to prepare the sql statement";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_PREPARED_STATEMENT = "There was an unexpected problem trying to prepare the sql statement";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_SET_PARAMATERS_VALUES_QUERY = "There was an unexpected problem trying to execute query to find the specific department";
	
	}
	
	public static class CityPostgresqlDAO {
		
		private CityPostgresqlDAO() {
			super();
		}
		
		public static final String TECHNICAL_PROBLEM_FILL_CITY_DTO = "There was a problem filling cityDTO from the resultSet";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILL_CITY_DTO = "There was an unexpected problem trying to filling cityDTO from the resultSet";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILL_RESULTS_CITY = "There was a unexpected problem trying to recovering results from the resultSet";
		public static final String TECHNICAL_PROBLEM_EXECUTE_QUERY = "There was a problem trying to execute query to find the specific city";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_EXECUTE_QUERY = "There was an unexpected problem trying to execute query to find the specific city";
		public static final String TECHNICAL_PROBLEM_SET_PARAMETERS_VALUES_QUERY = "There was a problem trying to execute query to find the specific city";
		public static final String TECHNICAL_PROBLEM_PREPARED_STATEMENT = "There was a problem trying to prepare the sql statement";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_PREPARED_STATEMENT = "There was an unexpected problem trying to prepare the sql statement";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_SET_PARAMATERS_VALUES_QUERY = "There was an unexpected problem trying to execute query to find the specific city";
	
	}
	
	public static class IdentificationTypePostgresqlDAO {
		
		private IdentificationTypePostgresqlDAO() {
			super();
		}
		
		public static final String TECHNICAL_PROBLEM_FILL_IDENTIFICATION_TYPE_DTO = "There was a problem filling IdentificationTypeDTO from the resultSet";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILL_IDENTIFICATION_TYPE_DTO = "There was an unexpected problem trying to filling IdentificationTypeDTO from the resultSet";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILL_RESULTS_IDENTIFICATION_TYPE = "There was a unexpected problem trying to recovering results from the resultSet";
		public static final String TECHNICAL_PROBLEM_EXECUTE_QUERY = "There was a problem trying to execute query to find the specific identification type";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_EXECUTE_QUERY = "There was an unexpected problem trying to execute query to find the specific identification type";
		public static final String TECHNICAL_PROBLEM_SET_PARAMETERS_VALUES_QUERY = "There was a problem trying to execute query to find the specific identification type";
		public static final String TECHNICAL_PROBLEM_PREPARED_STATEMENT = "There was a problem trying to prepare the sql statement";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_PREPARED_STATEMENT = "There was an unexpected problem trying to prepare the sql statement";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_SET_PARAMATERS_VALUES_QUERY = "There was an unexpected problem trying to execute query to find the specific identification type";
	
	}
	
	public static class UUIDHelper {
		
		private UUIDHelper() {
			super();
		}
		
		public static final String TECHNICAL_UUID_FROM_STRING_INVALID = " The UUID to convert doesnot have a valid format";
		public static final String TECHNICAL_UUID_FROM_STRING_UNEXPECTED_ERROR = " There was  convert doesnot have a valid format";
	}

	
	public static class CreateUserUseCaseImpl {
		
		private CreateUserUseCaseImpl() {
			super();
		}
		
		public static final String BUSSINES_USER_EXISTS = " The UUID to convert doesnot have a valid format";
		public static final String BUSSINES_USER_UNEXPECTED = " There was an unexpected problem";
		
	}
	
	public static class FindDocumentIdentificationUseCaseImpl {
		
		private FindDocumentIdentificationUseCaseImpl() {
			super();
		}
		
		public static final String BUSSINES_DOCUMENT_IDENTIFICATION_EXISTS = " The UUID to convert doesnot have a valid format";
		public static final String BUSSINES_DOCUMENT_IDENTIFICATION_UNEXPECTED = " There was an unexpected problem";
		
	}
	
}
