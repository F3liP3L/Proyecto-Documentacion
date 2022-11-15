package edu.uco.quickjob.data.dao.relational.postgresql;

import static edu.uco.quickjob.crosscutting.helper.UUIDHelper.getUUIDAsString;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import edu.uco.quickjob.crosscutting.exception.data.DataCustomException;
import edu.uco.quickjob.crosscutting.messages.Messages;
import edu.uco.quickjob.data.dao.ServiceDAO;
import edu.uco.quickjob.data.dao.relational.DAORelational;
import edu.uco.quickjob.domain.ServiceDTO;

public class ServicePostgresqlDAO extends DAORelational implements ServiceDAO {

	public ServicePostgresqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(ServiceDTO service) {
		final var sqlInsert = "INSERT INTO public.servicio(codigo, nombre, descripcion, estado, tipo_subservicio_codigo)VALUES (?, ?, ?, ?, ?)";
		try (final var preparedStatement = getConnection().prepareStatement(sqlInsert)) {
			
			preparedStatement.setString(1, service.getIdAsString());
			preparedStatement.setString(2, service.getName());
			preparedStatement.setString(3, service.getDescription());
			preparedStatement.setBoolean(4, service.isState());
			preparedStatement.setString(5, service.getSubSevice().getIdAsString());
			
			preparedStatement.executeUpdate();
			
		} catch(final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.QualificationPostgresqlDAO.TECHNICAL_PROBLEM_CREATE_QUALIFICATION, exception); 
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.QualificationPostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_CREATE_QUALIFICATION ,exception);
		}
		
	}

	@Override
	public List<ServiceDTO> find(ServiceDTO service) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(ServiceDTO service) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		final var sqlDelete = "DELETE FROM public.servicio WHERE codigo = ?";
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
