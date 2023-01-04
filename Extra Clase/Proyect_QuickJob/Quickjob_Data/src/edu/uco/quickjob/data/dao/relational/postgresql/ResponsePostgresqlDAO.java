package edu.uco.quickjob.data.dao.relational.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.uco.quickjob.crosscutting.exception.data.DataCustomException;
import edu.uco.quickjob.crosscutting.messages.Messages;
import edu.uco.quickjob.data.dao.ResponseDAO;
import edu.uco.quickjob.data.dao.relational.DAORelational;
import edu.uco.quickjob.domain.ResponseDTO;

public class ResponsePostgresqlDAO extends DAORelational implements ResponseDAO {

	public ResponsePostgresqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(ResponseDTO response) {
		final var sqlInsert = "INSERT INTO public.respuesta(codigo, descripcion, pregunta_codigo, prestador_servicio_codigo)VALUES (?, ?, ?, ?)";
		try (final var preparedStatement = getConnection().prepareStatement(sqlInsert)) {
			
			preparedStatement.setString(1,  response.getIdAsString());
			preparedStatement.setString(2, response.getDescription());
			preparedStatement.setString(3, response.getQuestion().getIdAsString());
			preparedStatement.setString(4, response.getServiceProvider().getIdAsString());
			
			preparedStatement.executeUpdate();
			
		} catch(final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.ResponsePostgresqlDAO.TECHNICAL_PROBLEM_CREATE_RESPONSE, exception); 
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.ResponsePostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_CREATE_RESPONSE ,exception);
		}
	}

	@Override
	public List<ResponseDTO> find(ResponseDTO response) {
		return null;
	}

}
