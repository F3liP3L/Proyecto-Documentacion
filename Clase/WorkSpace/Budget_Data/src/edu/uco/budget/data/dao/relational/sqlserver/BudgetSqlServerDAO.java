package edu.uco.budget.data.dao.relational.sqlserver;

import static edu.uco.budget.crosscutting.helper.UUIDHelper.getUUIDAsString;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import edu.uco.budget.crosscutting.exception.data.DataCustomException;
import edu.uco.budget.crosscutting.helper.ObjectHelper;
import edu.uco.budget.crosscutting.helper.UUIDHelper;
import edu.uco.budget.crosscutting.messages.Messages;
import edu.uco.budget.data.dao.BudgetDAO;
import edu.uco.budget.data.dao.relational.DAORelational;
import edu.uco.budget.domain.BudgetDTO;
import edu.uco.budget.domain.PersonDTO;
import edu.uco.budget.domain.YearDTO;

public final class BudgetSqlServerDAO extends DAORelational implements BudgetDAO {

	public BudgetSqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public final void create(BudgetDTO budget) {
		final var sqlInsert = "INSERT INTO Budget (id, idYear, idPerson) VALUES (?, ?, ?)";

		try (final var preparedStatement = getConnection().prepareStatement(sqlInsert)) {

			preparedStatement.setString(1, budget.getIdAsString());
			preparedStatement.setString(2, budget.getYear().getIdAsString());
			preparedStatement.setString(3, budget.getPerson().getIdAsString());

			preparedStatement.executeUpdate();

		} catch(final SQLException exception) {
			String message = Messages.BudgetSqlServerDAO.TECHNICAL_PROBLEM_CREATE_BUDGET.concat(budget.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		} catch (final Exception exception) {
			String message = Messages.BudgetSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_CREATE_BUDGET.concat(budget.getIdAsString());
			throw DataCustomException.createTechnicalException(message ,exception);
		}
	}

	@Override
	public final List<BudgetDTO> find(BudgetDTO budget) {

		var parameters = new ArrayList<Object>();

		final var sqlBuilder = new StringBuilder();

		createSelectFrom(sqlBuilder);

		createWhere(sqlBuilder, budget, parameters);

		createOrderBy(sqlBuilder);

		return prepareAndExecuteQuery(sqlBuilder, parameters);
	}


	private final List<BudgetDTO> prepareAndExecuteQuery(StringBuilder sqlBuilder, List<Object> parameters) {
		try (final var preparedStatement = getConnection().prepareStatement(sqlBuilder.toString())){

			setParameterValues(preparedStatement, parameters);

			return executeQuery(preparedStatement);

		}  catch (final DataCustomException exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.BudgetSqlServerDAO.TECHNICAL_PROBLEM_PREPARED_STATEMENT, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.BudgetSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_PREPARED_STATEMENT, exception);
		}
	}

	private final void createOrderBy(final StringBuilder stringBuilder) {
		stringBuilder.append("Order By Pe.idCard ASC, ");
		stringBuilder.append("         Ye.year ASC ");
	}


	private final void setParameterValues(final PreparedStatement preparedStatement, final List<Object> parameters) {
		try {
			for (int index = 0; index < parameters.size(); index++) {
				preparedStatement.setObject(index + 1, parameters.get(index));
			}
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.BudgetSqlServerDAO.TECHNICAL_PROBLEM_SET_PARAMETERS_VALUES_QUERY, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.BudgetSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_SET_PARAMATERS_VALUES_QUERY, exception);
		}
	}

	private final List<BudgetDTO> fillResults (final ResultSet resultset) {
		try {
			var results = new ArrayList<BudgetDTO>();
			while(resultset.next()){
				results.add(fillBudgetDTO(resultset));
		}
			return results;
		} catch (final DataCustomException exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(null, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(null, exception);
		}
	}

	private final List<BudgetDTO> executeQuery(PreparedStatement preparedStatement){
		try (final var resultSet = preparedStatement.executeQuery()) {

			return fillResults(resultSet);

		} catch (DataCustomException exception) {
			throw exception;
		} catch (SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.BudgetSqlServerDAO.TECHNICAL_PROBLEM_EXECUTE_QUERY ,exception);
		} catch (Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.BudgetSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_EXECUTE_QUERY,exception);
		}
	}


	private final BudgetDTO fillBudgetDTO (final ResultSet resultset) {
		try {
			return BudgetDTO.create(resultset.getString("IdBudget"), fillPersonDTO(resultset), fillYearDTO(resultset));
		} catch (final DataCustomException exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.BudgetSqlServerDAO.TECHNICAL_PROBLEM_FILL_RESULTS_BUDGET, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.BudgetSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILL_RESULTS_BUDGET, exception);
		}
	}

	private final PersonDTO fillPersonDTO(final ResultSet resultset) {
		try {
			return PersonDTO.create(resultset.getString("IdPerson"), resultset.getString("IdCardPerson"), resultset.getString("FirstNamePerson"), resultset.getString("SecondNamePerson"), resultset.getString("FirstSurnamePerson"), resultset.getString("SecondSurnamePerson"));
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.BudgetSqlServerDAO.TECHNICAL_PROBLEM_FILL_RESULTS_BUDGET, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.BudgetSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILL_RESULTS_BUDGET, exception);
		}
	}

	private final YearDTO fillYearDTO(final ResultSet resultset) {
		try {
			return YearDTO.create(resultset.getString("IdYear"), resultset.getShort("NumberYear"));
		} catch (final SQLException exception ) {
			throw DataCustomException.createTechnicalException(Messages.BudgetSqlServerDAO.TECHNICAL_PROBLEM_FILL_RESULTS_BUDGET, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.BudgetSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILL_RESULTS_BUDGET, exception);
		}
	}


	private final void createSelectFrom(final StringBuilder sqlBuilder) {

		sqlBuilder.append("SELECT   Bu.Id AS IdBudget, ");
		sqlBuilder.append("         Bu.idYear AS IdYear, ");
		sqlBuilder.append("         Ye.year AS NumberYear, ");
		sqlBuilder.append("         Bu.idPerson AS IdPerson, ");
		sqlBuilder.append("         Pe.idCard AS IdCardPerson, ");
		sqlBuilder.append("         Pe.firstName AS FirstNamePerson, ");
		sqlBuilder.append("         Pe.secondName AS SecondNamePerson, ");
		sqlBuilder.append("			Pe.firstSurname AS FirstSurnamePerson, ");
		sqlBuilder.append("			Pe.secondSurname AS SecondSurnamePerson ");
		sqlBuilder.append("FROM     Budget Bu ");
		sqlBuilder.append("INNER JOIN Year Ye ");
		sqlBuilder.append("ON    Bu.idYear = Ye.id ");
		sqlBuilder.append("INNER JOIN Person Pe ");
		sqlBuilder.append("ON    Bu.idPerson = Pe.id ");

	}

	private final void createWhere(final StringBuilder sqlBuilder, final BudgetDTO budget, final List<Object> parameters) {

		var setWhere = true;

		if(!ObjectHelper.isNull(budget)) {

			if(!UUIDHelper.isDefaultUUID(budget.getId())) {
				sqlBuilder.append("WHERE Bu.id = ? ");
				setWhere = false;
				parameters.add(budget.getIdAsString());
			}

			if(UUIDHelper.isDefaultUUID(budget.getYear().getId())) {
				sqlBuilder.append(setWhere ? "WHERE ": "AND ").append("Bu.idYear = ? ");
				setWhere = false;
				parameters.add(budget.getYear().getIdAsString());
			}

			if(UUIDHelper.isDefaultUUID(budget.getPerson().getId())) {
				sqlBuilder.append(setWhere ? "WHERE ": "AND ").append("Bu.idPerson = ? ");
				parameters.add(budget.getPerson().getIdAsString());
			}
		}
	}


	@Override
	public final void update(BudgetDTO budget) {

		final var sqlUpdate = "UPDATE Budget SET idYear = ?, idPerson = ? WHERE id = ?";

		try (final var preparedStatement = getConnection().prepareStatement(sqlUpdate)) {

			preparedStatement.setString(1, budget.getYear().getIdAsString());
			preparedStatement.setString(2, budget.getPerson().getIdAsString());
			preparedStatement.setString(3, budget.getIdAsString());

			preparedStatement.executeUpdate();

		} catch (SQLException exception ) {
			String message = Messages.BudgetSqlServerDAO.TECHNICAL_PROBLEM_UPDATE_BUDGET.concat(budget.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		} catch (Exception exception) {
			String message = Messages.BudgetSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_BUDGET.concat(budget.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		}
	}

	@Override
	public final void delete(UUID id) {

		final var sqlDelete = "DELETE FROM Budget WHERE id = ?";
		final var idAsString = getUUIDAsString(id);

		try (final var preparedStatement = getConnection().prepareStatement(sqlDelete)) {
			preparedStatement.setString(1, idAsString);
		} catch(SQLException exception) {
			String message = Messages.BudgetSqlServerDAO.TECHNICAL_PROBLEM_DELETE_BUDGET.concat(idAsString);
			throw DataCustomException.createTechnicalException(message, exception);
		} catch (Exception exception) {
			String message = Messages.BudgetSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_DELETE_BUDGET.concat(idAsString);
			throw DataCustomException.createTechnicalException(message, exception);
		}
	}

}
