package edu.uco.budget.data.dao.relational.sqlserver;

import static edu.uco.budget.crosscutting.helper.UUIDHelper.getUUIDAsString;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import edu.uco.budget.crosscutting.exception.data.DataCustomException;
import edu.uco.budget.crosscutting.messages.Messages;
import edu.uco.budget.data.dao.PersonDAO;
import edu.uco.budget.data.dao.relational.DAORelational;
import edu.uco.budget.domain.PersonDTO;

public final class PersonSqlServerDAO extends DAORelational implements PersonDAO {

	public PersonSqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public final void create(PersonDTO person) {
		final var sqlInsert = "INSERT INTO Person (id, idCard, firstName, secondName, firstSurname, secondSurname ) VALUES (?, ?, ?, ?, ?, ?)";
		
		try (final var preparedStatement = getConnection().prepareStatement(sqlInsert)) {
			
			preparedStatement.setString(1, person.getIdAsString());
			preparedStatement.setString(2, person.getIdCard());
			preparedStatement.setString(3, person.getFirstName());
			preparedStatement.setString(4, person.getSecondName());
			preparedStatement.setString(5, person.getFirstSurname());
			preparedStatement.setString(6, person.getSecondName());
			
			preparedStatement.executeUpdate();
			
		} catch(final SQLException exception) {
			String message = Messages.PersonSqlServerDAO.TECHNICAL_PROBLEM_CREATE_PERSON.concat(person.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception); 
		} catch (final Exception exception) {
			String message = Messages.PersonSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_CREATE_PERSON.concat(person.getIdAsString());
			throw DataCustomException.createTechnicalException(message ,exception);
		}
	}

	@Override
	public final List<PersonDTO> find(PersonDTO person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final void update(PersonDTO person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void delete(UUID id) {
		
		final var sqlDelete = "DELETE FROM Person WHERE id = ?";
		final var idAsString = getUUIDAsString(id);
		
		try (final var preparedStatement = getConnection().prepareStatement(sqlDelete)) {
			preparedStatement.setString(1, idAsString);
		} catch(SQLException exception) {
			String message = Messages.PersonSqlServerDAO.TECHNICAL_PROBLEM_DELETE_PERSON.concat(idAsString);
			throw DataCustomException.createTechnicalException(message, exception);
		} catch (Exception exception) {
			String message = Messages.PersonSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_DELETE_PERSON.concat(idAsString);
			throw DataCustomException.createTechnicalException(message, exception);
		}	
		
	}

}
