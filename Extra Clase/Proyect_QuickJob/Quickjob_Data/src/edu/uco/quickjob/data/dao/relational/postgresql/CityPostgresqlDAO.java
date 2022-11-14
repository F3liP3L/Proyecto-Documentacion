package edu.uco.quickjob.data.dao.relational.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.uco.quickjob.crosscutting.exception.data.DataCustomException;
import edu.uco.quickjob.crosscutting.messages.Messages;
import edu.uco.quickjob.data.dao.CityDAO;
import edu.uco.quickjob.data.dao.relational.DAORelational;
import edu.uco.quickjob.domain.CityDTO;
import edu.uco.quickjob.domain.CountryDTO;
import edu.uco.quickjob.domain.DepartmentDTO;

public class CityPostgresqlDAO extends DAORelational implements CityDAO{

	public CityPostgresqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public List<CityDTO> find() {
		var parameters = new ArrayList<Object>();

		final var sqlBuilder = new StringBuilder();

		createSelectFrom(sqlBuilder);

		createOrderBy(sqlBuilder);

		return prepareAndExecuteQuery(sqlBuilder, parameters);
	}
	
	private final List<CityDTO> prepareAndExecuteQuery(StringBuilder sqlBuilder, List<Object> parameters) {
		try (final var preparedStatement = getConnection().prepareStatement(sqlBuilder.toString())){

			setParameterValues(preparedStatement, parameters);

			return executeQuery(preparedStatement);

		}  catch (final DataCustomException exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.DepartmentPostgresqlDAO.TECHNICAL_PROBLEM_PREPARED_STATEMENT, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.DepartmentPostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_PREPARED_STATEMENT, exception);
		}
	}

	private final void createOrderBy(final StringBuilder stringBuilder) {
		stringBuilder.append("Order By C.nombre ASC, ");
		stringBuilder.append("         D.nombre ASC, ");
		stringBuilder.append("         P.nombre ASC ");
	}


	private final void setParameterValues(final PreparedStatement preparedStatement, final List<Object> parameters) {
		try {
			for (int index = 0; index < parameters.size(); index++) {
				preparedStatement.setObject(index + 1, parameters.get(index));
			}
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.CountryPostgresqlDAO.TECHNICAL_PROBLEM_SET_PARAMETERS_VALUES_QUERY, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.CountryPostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_SET_PARAMATERS_VALUES_QUERY, exception);
		}
	}

	private final List<CityDTO> fillResults (final ResultSet resultset) {
		try {
			var results = new ArrayList<CityDTO>();
			while(resultset.next()){
				results.add(fillCityDTO(resultset));
		}
			return results;
		} catch (final DataCustomException exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.CityPostgresqlDAO.TECHNICAL_PROBLEM_FILL_CITY_DTO, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.CityPostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILL_RESULTS_CITY, exception);
		}
	}

	private final List<CityDTO> executeQuery(PreparedStatement preparedStatement){
		try (final var resultSet = preparedStatement.executeQuery()) {

			return fillResults(resultSet);

		} catch (DataCustomException exception) {
			throw exception;
		} catch (SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.CityPostgresqlDAO.TECHNICAL_PROBLEM_EXECUTE_QUERY ,exception);
		} catch (Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.CityPostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_EXECUTE_QUERY,exception);
		}
	}


	private final CityDTO fillCityDTO (final ResultSet resultset) {
		try {
			CountryDTO country = CountryDTO.create(resultset.getString("idCountry"), resultset.getString("countryName"));
			DepartmentDTO department = DepartmentDTO.create(resultset.getString("idDepartment"), resultset.getString("departmentName"), country);
			return CityDTO.create(resultset.getString("idCity"), resultset.getString("cityName"), department);
		} catch (final DataCustomException exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.CityPostgresqlDAO.TECHNICAL_PROBLEM_FILL_CITY_DTO, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.CityPostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILL_RESULTS_CITY, exception);
		}

	}


	private final void createSelectFrom(final StringBuilder sqlBuilder) {

		sqlBuilder.append("SELECT C.codigo AS idCity, ");
		sqlBuilder.append("         C.nombre AS cityName, ");
		sqlBuilder.append("         C.departamento_codigo AS idDepartment, ");
		sqlBuilder.append("         D.nombre AS departmentName, ");
		sqlBuilder.append("         D.pais_codigo AS idCountry, ");
		sqlBuilder.append("         P.nombre AS countryName ");
		sqlBuilder.append("FROM     ciudad C ");
		sqlBuilder.append("INNER JOIN departamento D ");
		sqlBuilder.append("ON    C.departamento_codigo = D.codigo ");
		sqlBuilder.append("INNER JOIN pais P ");
		sqlBuilder.append("ON C.departamento_codigo = D.codigo ");
	}

}
