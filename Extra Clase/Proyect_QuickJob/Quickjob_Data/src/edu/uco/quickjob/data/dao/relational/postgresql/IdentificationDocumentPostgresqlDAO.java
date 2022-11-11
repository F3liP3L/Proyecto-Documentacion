package edu.uco.quickjob.data.dao.relational.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.uco.quickjob.crosscutting.exception.data.DataCustomException;
import edu.uco.quickjob.crosscutting.messages.Messages;
import edu.uco.quickjob.data.dao.IdentificationDocumentDAO;
import edu.uco.quickjob.data.dao.relational.DAORelational;
import edu.uco.quickjob.domain.IdentificationDocumentDTO;

public class IdentificationDocumentPostgresqlDAO extends DAORelational implements IdentificationDocumentDAO {

	protected IdentificationDocumentPostgresqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(IdentificationDocumentDTO identificationDocument) {
		final var sqlInsert = "INSERT INTO public.documento_identificacion(codigo, nombre, apellido, fecha_nacimiento, fecha_expedimiento, lugar_expedicion, sexo, numero_identificacion, lugar_nacimiento, tipo_identificacion_codigo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (final var preparedStatement = getConnection().prepareStatement(sqlInsert)) {
			
			preparedStatement.setString(1, identificationDocument.getIdAsString());
			preparedStatement.setString(2, identificationDocument.getName());
			preparedStatement.setString(3, identificationDocument.getSurname());
			preparedStatement.setDate(4, identificationDocument.getBirthDate());
			preparedStatement.setDate(5, identificationDocument.getExpeditionDate());
			preparedStatement.setString(6, identificationDocument.getExpeditionSite());
			preparedStatement.setString(7, identificationDocument.getIdentificationNumber());
			preparedStatement.setString(8, identificationDocument.getSex());
			preparedStatement.setString(9, identificationDocument.getPlaceOfBirth().getIdAsString());
			preparedStatement.setString(10, identificationDocument.getIdentificationNumber());
			
			preparedStatement.executeUpdate();
			
		} catch(final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.QualificationPostgresqlDAO.TECHNICAL_PROBLEM_CREATE_QUALIFICATION, exception); 
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.QualificationPostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_CREATE_QUALIFICATION ,exception);
		}
		
	}
	

	@Override
	public List<IdentificationDocumentDTO> find(IdentificationDocumentDTO identificationDocument) {
		return null;
	}

	@Override
	public void update(IdentificationDocumentDTO identificationType) {
		
	}

}
