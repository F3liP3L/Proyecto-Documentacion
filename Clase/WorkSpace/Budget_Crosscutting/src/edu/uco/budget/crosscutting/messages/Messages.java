package edu.uco.budget.crosscutting.messages;

public class Messages {
	
	private Messages() {
		super();
	}

	public static class DAOFactory {
		
		private DAOFactory() {
			super();
		}
		
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
	
	
	public static class SqlServerDAOFactory {
		
		private SqlServerDAOFactory() {
			super();
		}		
		
		public static final String TECHNICAL_PROBLEM_INIT_TRANSACTION = "There was a problem trying to init transaction with the current connection in SQLServerDAOFactory";
		public static final String TECHNICAL_PROBLEM_OPEN_CONNECTION = "There was a problem trying to open connection in SQLServerDAOFactory";
		
	}
	
	
	
	public static class BudgetSqlServerDAO {
		
		private BudgetSqlServerDAO() {
			super();
		}
		
		public static final String TECHNICAL_PROBLEM_CREATE_BUDGET = "There was a problem trying to create the desired budget in SQLServerDAOFactory with id = ";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_CREATE_BUDGET = "There was an unexpected problem trying to create the budget in SQLServerDAOFactory with id = ";
		public static final String TECHNICAL_PROBLEM_UPDATE_BUDGET = "There was a problem trying to update the desired budget in SQL Server DAOFactory with id = ";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_BUDGET = "There was an unexpected problem trying to update the budget in SQLServerDAOFactory with id = ";
		public static final String TECHNICAL_PROBLEM_DELETE_BUDGET = "There was a problem trying to delete the desired budget in SQL Server DAOFactory with id = ";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_DELETE_BUDGET = "There was an unexpected problem trying to delete the budget in SQLServerDAOFactory with id = ";
		public static final String TECHNICAL_PROBLEM_FILL_RESULTS_BUDGET = "There was a problem recovering results from the select the desired budget in SQL Server DAOFactory with id = ";
		
		public static final String TECHNICAL_PROBLEM_FILL_BUDGET_DTO = "There was a problem filling BudgetDTO from the resultSet";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILL_BUDGET_DTO = "There was an unexpected problem trying to filling BudgetDTO from the resultSet";
		
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILL_RESULTS_BUDGET = "There was a unexpected problem trying to recovering results from the resultSet";

		public static final String TECHNICAL_PROBLEM_EXECUTE_QUERY = "There was a problem trying to execute query to find the specific budgets";

		public static final String TECHNICAL_UNEXPECTED_PROBLEM_EXECUTE_QUERY = "There was an unexpected problem trying to execute query to find the specific budgets";
		
		public static final String TECHNICAL_PROBLEM_SET_PARAMETERS_VALUES_QUERY = "There was a problem trying to execute query to find the specific budgets";
		
		
		public static final String TECHNICAL_PROBLEM_PREPARED_STATEMENT = "There was a problem trying to prepare the sql statement";
		
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_PREPARED_STATEMENT = "There was an unexpected problem trying to prepare the sql statement";
		
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_SET_PARAMATERS_VALUES_QUERY = "There was an unexpected problem trying to execute query to find the specific budgets";
		
		
		
	}
	
	public static class PersonSqlServerDAO {
		
		private PersonSqlServerDAO() {
			super();
		}
		
		public static final String TECHNICAL_PROBLEM_CREATE_PERSON = "There was a problem trying to create the desired person in SQLServerDAOFactory with id = ";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_CREATE_PERSON = "There was an unexpected problem trying to create the person in SQLServerDAOFactory with id = ";
		public static final String TECHNICAL_PROBLEM_UPDATE_PERSON = "There was a problem trying to update the desired person in SQL Server DAOFactory with id = ";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_PERSON = "There was an unexpected problem trying to update the person in SQLServerDAOFactory with id = ";
		public static final String TECHNICAL_PROBLEM_DELETE_PERSON = "There was a problem trying to delete the desired person in SQL Server DAOFactory with id = ";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_DELETE_PERSON = "There was an unexpected problem trying to delete the person in SQLServerDAOFactory with id = ";
		public static final String TECHNICAL_PROBLEM_SELECT_PERSON = "There was a problem trying to select the desired person in SQL Server DAOFactory with id = ";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_SELECT_PERSON = "There was an unexpected problem trying to select the person in SQLServerDAOFactory with id = ";
		
	}
	
public static class YearSqlServerDAO {
		
		private YearSqlServerDAO() {
			super();
		}
		
		public static final String TECHNICAL_PROBLEM_CREATE_YEAR = "There was a problem trying to create the desired year in SQLServerDAOFactory with id = ";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_CREATE_YEAR = "There was an unexpected problem trying to create the year in SQLServerDAOFactory with id = ";
		public static final String TECHNICAL_PROBLEM_UPDATE_YEAR = "There was a problem trying to update the desired year in SQL Server DAOFactory with id = ";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_YEAR = "There was an unexpected problem trying to update the year in SQLServerDAOFactory with id = ";
		public static final String TECHNICAL_PROBLEM_DELETE_YEAR = "There was a problem trying to delete the desired year in SQL Server DAOFactory with id = ";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_DELETE_YEAR = "There was an unexpected problem trying to delete the year in SQLServerDAOFactory with id = ";
		public static final String TECHNICAL_PROBLEM_SELECT_YEAR = "There was a problem trying to select the desired year in SQL Server DAOFactory with id = ";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_SELECT_YEAR = "There was an unexpected problem trying to select the year in SQLServerDAOFactory with id = ";
		
	}

public static class UUIDHelper {
	
	private UUIDHelper() {
		super();
	}
	
	public static final String TECHNICAL_UUID_FROM_STRING_INVALID = " The UUID to convert doesnot have a valid format";
	public static final String TECHNICAL_UUID_FROM_STRING_UNEXPECTED_ERROR = " There was  convert doesnot have a valid format";
}

public static class CreateBudgetUseCaseImpl {
	
	private CreateBudgetUseCaseImpl() {
		super();
	}
	
	public static final String BUSSINES_BUDGET_EXISTS = " The UUID to convert doesnot have a valid format";
	
	public static final String BUSSINES_UNEXPECTED = " There was an unexpected problem";
	
}


	
}
