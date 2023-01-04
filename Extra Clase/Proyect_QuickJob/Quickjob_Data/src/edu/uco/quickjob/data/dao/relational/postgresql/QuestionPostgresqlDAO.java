package edu.uco.quickjob.data.dao.relational.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.uco.quickjob.crosscutting.exception.data.DataCustomException;
import edu.uco.quickjob.crosscutting.messages.Messages;
import edu.uco.quickjob.data.dao.QuestionDAO;
import edu.uco.quickjob.data.dao.relational.DAORelational;
import edu.uco.quickjob.domain.QuestionDTO;

public class QuestionPostgresqlDAO extends DAORelational implements QuestionDAO {

	public QuestionPostgresqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(QuestionDTO question) {
		final var sqlInsert = "INSERT INTO public.pregunta(codigo, descripcion, cliente_codigo)VALUES (?, ?, ?)";
		try (final var preparedStatement = getConnection().prepareStatement(sqlInsert)) {
			
			preparedStatement.setString(1,  question.getIdAsString());
			preparedStatement.setString(2, question.getDescription());
			preparedStatement.setString(3, question.getCustomer().getIdAsString());
			
			preparedStatement.executeUpdate();
			
		} catch(final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.QuestionPostgresqlDAO.TECHNICAL_PROBLEM_CREATE_QUESTION, exception); 
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.QuestionPostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_CREATE_QUESTION ,exception);
		}
	}

	@Override
	public List<QuestionDTO> find(QuestionDTO question) {
		return null;
	}

}
