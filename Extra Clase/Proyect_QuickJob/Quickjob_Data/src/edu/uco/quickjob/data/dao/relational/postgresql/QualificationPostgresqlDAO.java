package edu.uco.quickjob.data.dao.relational.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.uco.quickjob.crosscutting.exception.data.DataCustomException;
import edu.uco.quickjob.crosscutting.messages.Messages;
import edu.uco.quickjob.data.dao.QualificationDAO;
import edu.uco.quickjob.data.dao.relational.DAORelational;
import edu.uco.quickjob.domain.QualificationDTO;

public class QualificationPostgresqlDAO extends DAORelational implements QualificationDAO {

	protected QualificationPostgresqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(QualificationDTO qualification) {
		final var sqlInsert = "INSERT INTO public.calificacion(codigo, puntuacion, cliente_codigo, servicio_codigo) VALUES (?, ?, ?, ?)";
		try (final var preparedStatement = getConnection().prepareStatement(sqlInsert)) {
			
			preparedStatement.setString(1, qualification.getIdAsString());
			preparedStatement.setInt(2, qualification.getScore());
			preparedStatement.setString(3, qualification.getCustomer().getIdAsString());
			preparedStatement.setString(4, qualification.getService().getIdAsString());
			
			preparedStatement.executeUpdate();
			
		} catch(final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.QualificationPostgresqlDAO.TECHNICAL_PROBLEM_CREATE_QUALIFICATION, exception); 
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.QualificationPostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_CREATE_QUALIFICATION ,exception);
		}
		
	}

	@Override
	public List<QualificationDTO> find(QualificationDTO qualification) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(QualificationDTO qualification) {
		final var sqlUpdate = "UPDATE public.calificacion SET puntuacion=? WHERE codigo = ?";
		
		try (final var preparedStatement = getConnection().prepareStatement(sqlUpdate)) {
			
			
			preparedStatement.setInt(1, qualification.getScore());
			preparedStatement.setString(2, qualification.getIdAsString());
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException exception ) {
			String message =  Messages.QualificationPostgresqlDAO.TECHNICAL_PROBLEM_UPDATE_QUALIFICATION;
			throw DataCustomException.createTechnicalException(Messages.QualificationPostgresqlDAO.TECHNICAL_PROBLEM_UPDATE_QUALIFICATION, exception);
		} catch (Exception exception) {
			String message =  Messages.QualificationPostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_QUALIFICATION;
			throw DataCustomException.createTechnicalException(Messages.QualificationPostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_QUALIFICATION, exception);
		}
	}

}
