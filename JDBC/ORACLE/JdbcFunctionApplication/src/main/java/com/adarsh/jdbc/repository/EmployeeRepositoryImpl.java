/*
 * Copyright © MeritTrac Services Pvt. Ltd.
 * All Rights Reserved.
 */

package com.adarsh.jdbc.repository;
/*
 * {@inheritDoc}
*/

/**
 * @Product : EmployeeRepositoryImpl provide implementation of the specification
 *                    provided for the ...    
 */


import com.adarsh.jdbc.database.ConnectionFactory;
import com.adarsh.jdbc.entity.Employee;
import com.adarsh.jdbc.properties.PropertiesReader;
import oracle.jdbc.OracleTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 * @author $CreatedBy Adarsh_K
 * @author $LastChangedBy: Adarsh_K
 * @version $Revision: 1.0 $, $Date:: 4/6/13 11:51 AM
 * @see
 */

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRepositoryImpl.class);

    @Override
    public Employee getEmployee(Integer empId) throws Exception {
        final String sqlQuery = PropertiesReader.getProperty("sql.SelectEmployee");
        final Connection connection = ConnectionFactory.getConnection();
        final CallableStatement callableStatement = connection.prepareCall(sqlQuery);
        callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
        callableStatement.setInt(2, empId);
        callableStatement.registerOutParameter(3, Types.VARCHAR);
        callableStatement.executeQuery();
        ResultSet resultSet = (ResultSet) callableStatement.getObject(1);
        final Object object = callableStatement.getObject(3);
        if (object == null) {
            if (resultSet != null && resultSet.next()) {
                return new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
            }
        } else {
            LOGGER.error(object.toString());
        }
        return new Employee();
    }

    @Override
    public List<Employee> getAllEmployee() throws Exception {
        final String sqlQuery = PropertiesReader.getProperty("sql.selectAllEmployee");
        final Connection connection = ConnectionFactory.getConnection();
        final CallableStatement callableStatement = connection.prepareCall(sqlQuery);
        callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
        callableStatement.registerOutParameter(2, Types.VARCHAR);
        callableStatement.executeQuery();
        ResultSet resultSet = (ResultSet) callableStatement.getObject(1);
        final Object object = callableStatement.getObject(2);
        if (object == null) {
            if (resultSet != null && resultSet.next()) {
                final List<Employee> employeeList = new ArrayList<Employee>();
                while (resultSet.next()) {
                    employeeList.add(new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
                }
                return employeeList;
            }
        } else {
            LOGGER.error(object.toString());
        }
        return null;
    }

    @Override
    public String deleteEmployee(Integer empId) throws Exception {
        String result = null;
        final String sqlQuery = PropertiesReader.getProperty("sql.DeleteEmployee");
        final Connection connection = ConnectionFactory.getConnection();
        final CallableStatement callableStatement = connection.prepareCall(sqlQuery);
        callableStatement.registerOutParameter(1, Types.VARCHAR);
        callableStatement.setInt(2, empId);
        callableStatement.executeQuery();
        final Object resultSet = callableStatement.getObject(1);
        if (resultSet != null) {
            result = resultSet.toString();
        }
        return result;
    }

    @Override
    public String updateEmployee(Employee employee) throws Exception {
        String result = null;
        final String sqlQuery = PropertiesReader.getProperty("sql.UpdateEmployee");
        final Connection connection = ConnectionFactory.getConnection();
        final CallableStatement callableStatement = connection.prepareCall(sqlQuery);
        callableStatement.registerOutParameter(1, Types.VARCHAR);
        callableStatement.setInt(2, employee.getEmpNo());
        callableStatement.setString(3, employee.getEmpName());
        callableStatement.setString(4, employee.getEmpEmail());
        callableStatement.executeQuery();
        final Object resultSet = callableStatement.getObject(1);
        if (resultSet != null) {
            result = resultSet.toString();
        }
        return result;
    }

    @Override
    public String saveEmployee(Employee employee) throws Exception {
        String result = null;
        final String sqlQuery = PropertiesReader.getProperty("sql.InsertEmployee");
        final Connection connection = ConnectionFactory.getConnection();
        final CallableStatement callableStatement = connection.prepareCall(sqlQuery);
        callableStatement.registerOutParameter(1, Types.VARCHAR);
        callableStatement.setInt(2, employee.getEmpNo());
        callableStatement.setString(3, employee.getEmpName());
        callableStatement.setString(4, employee.getEmpEmail());
        callableStatement.executeQuery();
        final Object resultSet = callableStatement.getObject(1);
        if (resultSet != null) {
            result = resultSet.toString();
        }
        return result;
    }
}
