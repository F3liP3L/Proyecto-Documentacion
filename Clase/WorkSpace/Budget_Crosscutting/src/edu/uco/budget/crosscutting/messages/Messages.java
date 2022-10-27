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
		public static final String TECHNICAL_PROBLEM_SELECT_BUDGET = "There was a problem trying to select the desired budget in SQL Server DAOFactory with id = ";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_SELECT_BUDGET = "There was an unexpected problem trying to select the budget in SQLServerDAOFactory";
		
		
	}
	
}
