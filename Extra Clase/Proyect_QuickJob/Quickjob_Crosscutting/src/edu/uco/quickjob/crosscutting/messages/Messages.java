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
		public static final String TECHNICAL_PROBLEM_EXECUTE_QUERY = "There was a problem trying to execute query to find the specific user";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_EXECUTE_QUERY = "There was an unexpected problem trying to execute query to find the specific user";
		public static final String TECHNICAL_PROBLEM_SET_PARAMETERS_VALUES_QUERY = "There was a problem trying to execute query to find the specific user";
		public static final String TECHNICAL_PROBLEM_PREPARED_STATEMENT = "There was a problem trying to prepare the sql statement";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_PREPARED_STATEMENT = "There was an unexpected problem trying to prepare the sql statement";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_SET_PARAMATERS_VALUES_QUERY = "There was an unexpected problem trying to execute query to find the specific user";
	}
	
	public static class IdentificationDocumentPostgresqlDAO {
		
		private IdentificationDocumentPostgresqlDAO() {
				super();
		}
		
		public static final String TECHNICAL_PROBLEM_CREATE_IDENTIFICATION_DOCUMENT = "There was a problem trying to create the desired identification document in PostgresqlDAOFactory";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_CREATE_IDENTIFICATION_DOCUMENT = "There was an unexpected problem trying to create the identification document in PostgresqlDAOFactory";
		public static final String TECHNICAL_PROBLEM_UPDATE_IDENTIFICATION_DOCUMENT = "There was a problem trying to update the desired identification document in PostgresqlDAOFactory";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_IDENTIFICATION_UPDATE_DOCUMENT = "There was an unexpected problem trying to update the identification document in PostgresqlDAOFactory";
		public static final String TECHNICAL_PROBLEM_FILL_IDENTIFICATION_DOCUMENT_DTO = "There was a problem filling identification document DTO from the resultSet";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILL_IDENTIFICATION_DOCUMENT_DTO = "There was an unexpected problem trying to filling identification document DTO from the resultSet";
		public static final String TECHNICAL_PROBLEM_DELETE_IDENTIFICATION_DOCUMENT_DTO = "There was a problem filling identification document DTO from the resultSet";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_DELETE_IDENTIFICATION_DOCUMENT_DTO = "There was an unexpected problem trying to filling identification document DTO from the resultSet";
		public static final String TECHNICAL_PROBLEM_EXECUTE_QUERY = "There was a problem trying to execute query to find the specific identification document";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_EXECUTE_QUERY = "There was an unexpected problem trying to execute query to find the specific identification document";
		public static final String TECHNICAL_PROBLEM_SET_PARAMETERS_VALUES_QUERY = "There was a problem trying to execute query to find the specific identification document";
		public static final String TECHNICAL_PROBLEM_PREPARED_STATEMENT = "There was a problem trying to prepare the sql statement";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_PREPARED_STATEMENT = "There was an unexpected problem trying to prepare the sql statement";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_SET_PARAMATERS_VALUES_QUERY = "There was an unexpected problem trying to execute query to find the specific identification document";
	}
	
	
	public static class ServiceProviderPostgresqlDAO {
		
		private ServiceProviderPostgresqlDAO() {
				super();
		}
		
		public static final String TECHNICAL_PROBLEM_CREATE_SERVICE_PROVIDER = "There was a problem trying to create the desired service provider in PostgresqlDAOFactory";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_CREATE_SERVICE_PROVIDER = "There was an unexpected problem trying to create the service provider in PostgresqlDAOFactory";
		public static final String TECHNICAL_PROBLEM_UPDATE_SERVICE_PROVIDER = "There was a problem trying to update the desired service provider in PostgresqlDAOFactory";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_SERVICE_PROVIDER = "There was an unexpected problem trying to create the serviceProvider in PostgresqlDAOFactory";
		public static final String TECHNICAL_PROBLEM_FILL_SERVICE_PROVIDER_DTO = "There was a problem filling serviceProviderDTO from the resultSet";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILL_SERVICE_PROVIDER_DTO = "There was an unexpected problem trying to filling serviceProviderDTO from the resultSet";
		public static final String TECHNICAL_PROBLEM_DELETE_SERVICE_PROVIDER_DTO = "There was a problem filling serviceProviderDTO from the resultSet";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_DELETE_SERVICE_PROVIDER_DTO = "There was an unexpected problem trying to filling serviceProviderDTO from the resultSet";
		public static final String TECHNICAL_PROBLEM_EXECUTE_QUERY = "There was a problem trying to execute query to find the specific department";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_EXECUTE_QUERY = "There was an unexpected problem trying to execute query to find the specific department";
		public static final String TECHNICAL_PROBLEM_SET_PARAMETERS_VALUES_QUERY = "There was a problem trying to execute query to find the specific department";
		public static final String TECHNICAL_PROBLEM_PREPARED_STATEMENT = "There was a problem trying to prepare the sql statement";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_PREPARED_STATEMENT = "There was an unexpected problem trying to prepare the sql statement";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_SET_PARAMATERS_VALUES_QUERY = "There was an unexpected problem trying to execute query to find the specific department";
	}
	
	
	public static class ServiceTypePostgresqlDAO {
		
		private ServiceTypePostgresqlDAO() {
				super();
		}
		
		public static final String TECHNICAL_PROBLEM_FILL_SERVICE_TYPE = "There was a problem trying to fill a desired service Type in PostgresqlDAOFactory ";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILL_SERVICE_TYPE = "There was an unexpected problem trying to fill a service Type in PostgresqlDAOFactory";
		public static final String TECHNICAL_PROBLEM_EXECUTE_QUERY = "There was a problem trying to execute query to find the specific service Type";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_EXECUTE_QUERY = "There was an unexpected problem trying to execute query to find the specific serviceType";
		public static final String TECHNICAL_PROBLEM_SET_PARAMETERS_VALUES_QUERY = "There was a problem trying to execute query to find the specific service Type";
		public static final String TECHNICAL_PROBLEM_PREPARED_STATEMENT = "There was a problem trying to prepare the sql statement";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_SET_PARAMATERS_VALUES_QUERY = "There was an unexpected problem trying to execute query to find the specific serviceType";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_PREPARED_STATEMENT = "There was an unexpected problem trying to prepare the sql statement";
	}
	
	
	public static class SubserviceTypePostgresqlDAO {
		
		private SubserviceTypePostgresqlDAO() {
				super();
		}
		
		public static final String TECHNICAL_PROBLEM_FILL_SUB_SERVICE_TYPE = "There was a problem trying to fill a desired SubserviceType in PostgresqlDAOFactory ";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILL_SUB_SERVICE_TYPE = "There was an unexpected problem trying to fill a sub SubserviceType in PostgresqlDAOFactory";
		public static final String TECHNICAL_PROBLEM_EXECUTE_QUERY = "There was a problem trying to execute query to find the specific SuberviceType";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_EXECUTE_QUERY = "There was an unexpected problem trying to execute query to find the specific SubserviceType";
		public static final String TECHNICAL_PROBLEM_SET_PARAMETERS_VALUES_QUERY = "There was a problem trying to execute query to find the specific Subservice Type";
		public static final String TECHNICAL_PROBLEM_PREPARED_STATEMENT = "There was a problem trying to prepare the sql statement";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_SET_PARAMATERS_VALUES_QUERY = "There was an unexpected problem trying to execute query to find the specific serviceType";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_PREPARED_STATEMENT = "There was an unexpected problem trying to prepare the sql statement";
	}
	
	
		public static class ServicePostgresqlDAO {
	
		private ServicePostgresqlDAO() {
				super();
		}
		
		public static final String TECHNICAL_PROBLEM_CREATE_SERVICE = "There was a problem trying to create the desired service in PostgresqlDAOFactory ";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_CREATE_SERVICE = "There was an unexpected problem trying to create the service in PostgresqlDAOFactory";
		public static final String TECHNICAL_PROBLEM_UPDATE_SERVICE = "There was a problem trying to update the desired service in PostgresqlDAOFactory ";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_SERVICE = "There was an unexpected problem trying to create the service in PostgresqlDAOFactory";
		public static final String TECHNICAL_PROBLEM_EXECUTE_QUERY = "There was a problem trying to execute query to find the specific service";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_EXECUTE_QUERY = "There was an unexpected problem trying to execute query to find the specific service";
		public static final String TECHNICAL_PROBLEM_SET_PARAMETERS_VALUES_QUERY = "There was a problem trying to execute query to find the specific service";
		public static final String TECHNICAL_PROBLEM_PREPARED_STATEMENT = "There was a problem trying to prepare the sql statement";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_PREPARED_STATEMENT = "There was an unexpected problem trying to prepare the sql statement";
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
		
		public static final String BUSSINES_USER_EXISTS = " The user is already registered ";
		public static final String BUSSINES_USER_UNEXPECTED = " There was an unexpected trying to register a user problem";
		
	}
	
	public static class CreateServiceUseCaseImpl {
		
		private CreateServiceUseCaseImpl() {
			super();
		}
		
		public static final String BUSSINES_SERVICE_EXISTS = " The service is already registered ";
		public static final String BUSSINES_SERVICE_UNEXPECTED = " There was an unexpected trying to register a service problem";
		
	}
	
	public static class LoginUserUseCaseImpl {
		
		private LoginUserUseCaseImpl() {
			super();
		}
		
		public static final String BUSSINES_USER_DOESNT_EXISTS = "The user trying to log in does not exist ";
		public static final String BUSSINES_USER_INCORRECT_PASSWORD = "the password you have entered is incorrect, please enter a valid password ";
		public static final String BUSSINES_USER_LOGIN_UNEXPECTED = " There was an unexpected trying to login a user problem";
		
	}
	
	public static class FindDocumentIdentificationUseCaseImpl {
		
		private FindDocumentIdentificationUseCaseImpl() {
			super();
		}
		
		public static final String BUSSINES_DOCUMENT_IDENTIFICATION_EXISTS = " The identification document already exists, please choose a valid one";
		public static final String BUSSINES_DOCUMENT_IDENTIFICATION_UNEXPECTED = " unexpected problem when trying to register the identification document";
		
	}
	
	public static class FindServiceTypeUseCaseImpl {
		
		private FindServiceTypeUseCaseImpl() {
			super();
		}
		
		public static final String BUSSINES_SERVICE_TYPE_UNEXPECTED = " There was an unexpected problem in the FindServiceTypeCommand";
		
	}
	
	public static class FindSubserviceTypeUseCaseImpl {
		
		private FindSubserviceTypeUseCaseImpl() {
			super();
		}
		
		public static final String BUSSINES_SUBSERVICE_TYPE_UNEXPECTED = " There was an unexpected problem in the FindSubserviceCommand";
		
	}
	
	
	public static class ResponseUserController {
		
		private ResponseUserController (){
			super();
		}
		
		public static final String USER_CREATED_SUCCESSFULLY = "The user has been created successfully";
		public static final String USER_CREATED_ERROR = "There was an error trying created the user";
		public static final String USER_CREATED_UNEXPECTED_ERROR = "There was a unexpected problem trying to created the user";
		
		public static final String USER_LOGIN_SUCCESSFULLY = "The user has been login successfully";
		public static final String USER_LOGIN_ERROR = "There was an error trying login the user";
		public static final String USER_LOGIN_UNEXPECTED_ERROR = "There was a unexpected problem trying to login the user";
	}
	
	public static class ResponseServiceController {
		
		private ResponseServiceController (){
			super();
		}
		
		public static final String SERVICE_CREATED_SUCCESSFULLY = "The service has been created successfully";
		public static final String SERVICE_CREATED_ERROR = "There was an error trying created the service";
		public static final String SERVICE_CREATED_UNEXPECTED_ERROR = "There was a unexpected problem trying to created the service";

	}
	
	public static class CreateUserValidator {
		
		private CreateUserValidator() {
			super();
		}
		
		public static final String MAIL_IS_DEFAULT_ERROR = "the email you are trying to enter is the default";
		public static final String MAIL_IS_INVALID_FORMAT_ERROR = "The email you are trying to enter has an invalid format";
		public static final String NAME_IS_INVALID_ERROR = "The name does not meet the required number of characters";
		public static final String SURNAME_IS_INVALID_ERROR = "The surname does not meet the required number of characters";
		public static final String PASSWORD_IS_INVALID_ERROR = "the password does not meet the proper length";
	}
	
}
