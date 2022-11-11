package edu.uco.quickjob.data.dao.relational.postgresql;

import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getUUIDAsString;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import edu.uco.quickjob.crosscutting.exception.data.DataCustomException;
import edu.uco.quickjob.data.dao.CommentDAO;
import edu.uco.quickjob.data.dao.relational.DAORelational;
import edu.uco.quickjob.domain.CommentDTO;

public class CommentPostgresqlDAO extends DAORelational implements CommentDAO{

	protected CommentPostgresqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(CommentDTO comment) {
		final var sqlInsert = "INSERT INTO public.comentario(codigo, nombre, descripcion, fecha_publicacion, cliente_codigo, servicio_codigo) VALUES (?, ?, ?, ?, ?, ?)";
		try (final var preparedStatement = getConnection().prepareStatement(sqlInsert)) {
			
			preparedStatement.setString(1, comment.getIdAsString());
			preparedStatement.setString(2, comment.getName());
			preparedStatement.setString(3, comment.getDescription());
			preparedStatement.setDate(4, (Date) comment.getPublicationDate());
			
			preparedStatement.executeUpdate();
			
		} catch(final SQLException exception) {
			throw DataCustomException.createTechnicalException(null, exception); 
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(null ,exception);
		}
		
	}

	@Override
	public List<CommentDTO> find(CommentDTO comment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(CommentDTO comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		final var sqlDelete = "DELETE FROM public.comentario WHERE codigo = ?";
		final var idAsString = getUUIDAsString(id);
		
		try (final var preparedStatement = getConnection().prepareStatement(sqlDelete)) {
			preparedStatement.setString(1, idAsString);
		} catch(SQLException exception) {
			throw DataCustomException.createTechnicalException(null, exception);
		} catch (Exception exception) {
			throw DataCustomException.createTechnicalException(null, exception);
		}	
		
	}

}
