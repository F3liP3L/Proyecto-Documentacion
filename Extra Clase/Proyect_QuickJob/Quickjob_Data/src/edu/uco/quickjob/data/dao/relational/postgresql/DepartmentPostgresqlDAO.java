package edu.uco.quickjob.data.dao.relational.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.uco.quickjob.crosscutting.exception.data.DataCustomException;
import edu.uco.quickjob.crosscutting.helper.ObjectHelper;
import edu.uco.quickjob.crosscutting.helper.UUIDHelper;
import edu.uco.quickjob.crosscutting.messages.Messages;
import edu.uco.quickjob.data.dao.DepartmentDAO;
import edu.uco.quickjob.data.dao.relational.DAORelational;
import edu.uco.quickjob.domain.CountryDTO;
import edu.uco.quickjob.domain.DepartmentDTO;

public class DepartmentPostgresqlDAO extends DAORelational implements DepartmentDAO {

	public DepartmentPostgresqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public final List<DepartmentDTO> find(DepartmentDTO department) {

		var parameters = new ArrayList<Object>();

		final var sqlBuilder = new StringBuilder();

		createSelectFrom(sqlBuilder);

		createWhere(sqlBuilder, department, parameters);

		createOrderBy(sqlBuilder);

		return prepareAndExecuteQuery(sqlBuilder, parameters);
	}


	private final List<DepartmentDTO> prepareAndExecuteQuery(StringBuilder sqlBuilder, List<Object> parameters) {
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
		stringBuilder.append("Order By D.nombre ASC, ");
		stringBuilder.append("         P.nombre ASC ");
	}


	private final void setParameterValues(final PreparedStatement preparedStatement, final List<Object> parameters) {
		try {
			for (int index = 0; index < parameters.size(); index++) {
				preparedStatement.setObject(index + 1, parameters.get(index));
			}
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.DepartmentPostgresqlDAO.TECHNICAL_PROBLEM_SET_PARAMETERS_VALUES_QUERY, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.DepartmentPostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_SET_PARAMATERS_VALUES_QUERY, exception);
		}
	}

	private final List<DepartmentDTO> fillResults (final ResultSet resultset) {
		try {
			var results = new ArrayList<DepartmentDTO>();
			while(resultset.next()){
				results.add(fillDepartmentDTO(resultset));
		}
			return results;
		} catch (final DataCustomException exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.DepartmentPostgresqlDAO.TECHNICAL_PROBLEM_FILL_DEPARTMENT_DTO, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.DepartmentPostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILL_RESULTS_DEPARTMENT, exception);
		}
	}

	private final List<DepartmentDTO> executeQuery(PreparedStatement preparedStatement){
		try (final var resultSet = preparedStatement.executeQuery()) {

			return fillResults(resultSet);

		} catch (DataCustomException exception) {
			throw exception;
		} catch (SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.DepartmentPostgresqlDAO.TECHNICAL_PROBLEM_EXECUTE_QUERY ,exception);
		} catch (Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.DepartmentPostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_EXECUTE_QUERY,exception);
		}
	}


	private final DepartmentDTO fillDepartmentDTO (final ResultSet resultset) {
		try {
			return DepartmentDTO.create(resultset.getString("idDepartment"), resultset.getString("departmentName"), fillCountryDTO(resultset));
		} catch (final DataCustomException exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.DepartmentPostgresqlDAO.TECHNICAL_PROBLEM_FILL_DEPARTMENT_DTO, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.DepartmentPostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILL_RESULTS_DEPARTMENT, exception);
		}
	}

	private final CountryDTO fillCountryDTO(final ResultSet resultset) {
		try {
			return CountryDTO.create(resultset.getString("idCountry"), resultset.getString("countryName"));
		} catch (final SQLException exception ) {
			throw DataCustomException.createTechnicalException(Messages.DepartmentPostgresqlDAO.TECHNICAL_PROBLEM_FILL_DEPARTMENT_DTO, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.DepartmentPostgresqlDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILL_RESULTS_DEPARTMENT, exception);
		}
	}


	private final void createSelectFrom(final StringBuilder sqlBuilder) {

		sqlBuilder.append("SELECT   D.codigo AS idDepartment, ");
		sqlBuilder.append("         D.pais_codigo AS idCountry, ");
		sqlBuilder.append("         D.nombre AS departmentName, ");
		sqlBuilder.append("         P.nombre AS countryName ");
		sqlBuilder.append("FROM     departamento D ");
		sqlBuilder.append("INNER JOIN pais P ");
		sqlBuilder.append("ON    D.pais_codigo = P.codigo ");

	}

	private final void createWhere(final StringBuilder sqlBuilder, final DepartmentDTO department, final List<Object> parameters) {

		var setWhere = true;

		if(!ObjectHelper.isNull(department)) {

			if(!UUIDHelper.isDefaultUUID(department.getId())) {
				sqlBuilder.append("WHERE D.codigo = ? ");
				setWhere = false;
				parameters.add(department.getIdAsString());
			}

			if(UUIDHelper.isDefaultUUID(department.getCountry().getId())) {
				sqlBuilder.append(setWhere ? "WHERE ": "AND ").append("D.pais_codigo = ? ");
				setWhere = false;
				parameters.add(department.getCountry().getIdAsString());
			}
		}
	}
}
