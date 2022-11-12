package edu.uco.budget.data.dao.relational.sqlserver;

import static edu.uco.budget.crosscutting.helper.UUIDHelper.getUUIDAsString;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import edu.uco.budget.crosscutting.exception.data.DataCustomException;
import edu.uco.budget.crosscutting.messages.Messages;
import edu.uco.budget.data.dao.YearDAO;
import edu.uco.budget.data.dao.relational.DAORelational;
import edu.uco.budget.domain.YearDTO;

public final class YearSqlServerDAO extends DAORelational implements YearDAO{

	public YearSqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public final void create(YearDTO year) {
		final var sqlInsert = "INSERT INTO Year (id, year) VALUES (?, ?)";

		try (final var preparedStatement = getConnection().prepareStatement(sqlInsert)) {

			preparedStatement.setString(1, year.getIdAsString());
			preparedStatement.setShort(2, year.getYearNumber());

			preparedStatement.executeUpdate();

		} catch(final SQLException exception) {
			String message = Messages.YearSqlServerDAO.TECHNICAL_PROBLEM_CREATE_YEAR.concat(year.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		} catch (final Exception exception) {
			String message = Messages.YearSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_CREATE_YEAR.concat(year.getIdAsString());
			throw DataCustomException.createTechnicalException(message ,exception);
		}

	}

	@Override
	public final List<YearDTO> find(YearDTO year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final void update(YearDTO year) {
		final var sqlUpdate = "UPDATE Year SET year = ? WHERE id = ?";

		try (final var preparedStatement = getConnection().prepareStatement(sqlUpdate)) {

			preparedStatement.setShort(1, year.getYearNumber());
			preparedStatement.setString(2, year.getIdAsString());

			preparedStatement.executeUpdate();

		} catch (SQLException exception ) {
			String message =  Messages.YearSqlServerDAO.TECHNICAL_PROBLEM_UPDATE_YEAR.concat(year.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		} catch (Exception exception) {
			String message =  Messages.YearSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_CREATE_YEAR.concat(year.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		}
	}

	@Override
	public final void delete(UUID id) {

		final var sqlDelete = "DELETE FROM Year WHERE id = ?";
		final var idAsString = getUUIDAsString(id);

		try (final var preparedStatement = getConnection().prepareStatement(sqlDelete)) {
			preparedStatement.setString(1, idAsString);
		} catch(SQLException exception) {
			String message = Messages.YearSqlServerDAO.TECHNICAL_PROBLEM_DELETE_YEAR.concat(idAsString);
			throw DataCustomException.createTechnicalException(message, exception);
		} catch (Exception exception) {
			String message = Messages.YearSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_DELETE_YEAR.concat(idAsString);
			throw DataCustomException.createTechnicalException(message, exception);
		}

	}

}
