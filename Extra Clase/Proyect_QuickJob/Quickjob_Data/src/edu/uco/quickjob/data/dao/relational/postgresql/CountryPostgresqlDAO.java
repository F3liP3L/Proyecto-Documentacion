package edu.uco.quickjob.data.dao.relational.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.uco.quickjob.crosscutting.exception.data.DataCustomException;
import edu.uco.quickjob.crosscutting.messages.Messages;
import edu.uco.quickjob.data.dao.CountryDAO;
import edu.uco.quickjob.data.dao.relational.DAORelational;
import edu.uco.quickjob.domain.CountryDTO;

public class CountryPostgresqlDAO extends DAORelational implements CountryDAO {

	public CountryPostgresqlDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public List<CountryDTO> find(CountryDTO country) {
		
		final var sqlBuilder = new StringBuilder();
		
		createSelectFrom(sqlBuilder);

		return prepareAndExecuteQuery(sqlBuilder);
	}
	
	private final void createSelectFrom(final StringBuilder sqlBuilder) {

		sqlBuilder.append("SELECT codigo AS idCountry ");
		sqlBuilder.append("         nombre AS countryName ");
		sqlBuilder.append("         FROM public.pais ");
		
	}
	
	private final List<CountryDTO> prepareAndExecuteQuery(StringBuilder sqlBuilder) {
		try (final var preparedStatement = getConnection().prepareStatement(sqlBuilder.toString())){
			
			return executeQuery(preparedStatement);
			
		}  catch (final DataCustomException exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.CountryPostgresqlDAO.TECHNICAL_PROBLEM_PREPARED_STATEMENT, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.CountryPostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_PREPARED_STATEMENT, exception);
		}		
	}
	
	private final List<CountryDTO> fillResults (final ResultSet resultset) {
		try {
			var results = new ArrayList<CountryDTO>();
			while(resultset.next()){
				results.add(fillCountryDTO(resultset));
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
	
	private final List<CountryDTO> executeQuery(PreparedStatement preparedStatement){
		try (final var resultSet = preparedStatement.executeQuery()) {
			
			return fillResults(resultSet);
			
		} catch (DataCustomException exception) {
			throw exception;
		} catch (SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.CountryPostgresqlDAO.TECHNICAL_PROBLEM_EXECUTE_QUERY ,exception);
		} catch (Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.CountryPostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_EXECUTE_QUERY,exception);
		}
	}
	

	private final CountryDTO fillCountryDTO (final ResultSet resultset) {
		try {
			return CountryDTO.create(resultset.getString("idCountry"), resultset.getString("countryName")); 
		} catch (final DataCustomException exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.CountryPostgresqlDAO.TECHNICAL_PROBLEM_FILL_COUNTRY_DTO, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.CountryPostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILL_RESULTS_COUNTRY, exception);
		}
	}
	

}
