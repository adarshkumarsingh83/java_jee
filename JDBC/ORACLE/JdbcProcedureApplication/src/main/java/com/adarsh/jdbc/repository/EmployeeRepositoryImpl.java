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

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author $CreatedBy Adarsh_K
 * @author $LastChangedBy: Adarsh_K
 * @version $Revision: 1.0 $, $Date:: 4/6/13 11:51 AM
 * @see
 */

public class EmployeeRepositoryImpl implements EmployeeRepository {


    @Override
    public List<Employee> getAllEmployee() throws Exception {
        final String storedProcedure = PropertiesReader.getProperty("sql.SelectAllEmployee");
        final Connection connection = ConnectionFactory.getConnection();
        final CallableStatement callableStatement = connection.prepareCall(storedProcedure);
        callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
        callableStatement.registerOutParameter(2, OracleTypes.VARCHAR);
        callableStatement.executeQuery();
        ResultSet resultSet = (ResultSet) callableStatement.getObject(1);
        if (resultSet != null) {
            final List<Employee> employeeList = new ArrayList<Employee>();
            while (resultSet.next()) {
                employeeList.add(new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
            }
            return employeeList;
        }
        return  new ArrayList<Employee>();
    }

    @Override
    public Employee getEmployee(Integer empId) throws Exception {
        final String sqlQuery = PropertiesReader.getProperty("sql.SelectEmployee");
        final Connection connection = ConnectionFactory.getConnection();
        final CallableStatement callableStatement = connection.prepareCall(sqlQuery);
        callableStatement.setInt(1, empId);
        callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
        callableStatement.registerOutParameter(3, OracleTypes.VARCHAR);
        callableStatement.executeQuery();
        final ResultSet resultSet = (ResultSet) callableStatement.getObject(2);
        if (resultSet != null && resultSet.next()) {
            return new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
        }
        return new Employee();
    }

    @Override
    public String deleteEmployee(Integer empId) throws Exception {
        String result = null;
        final String sqlQuery = PropertiesReader.getProperty("sql.DeleteEmployee");
        final Connection connection = ConnectionFactory.getConnection();
        final CallableStatement callableStatement = connection.prepareCall(sqlQuery);
        callableStatement.setInt(1, empId);
        callableStatement.registerOutParameter(2, Types.VARCHAR);
        callableStatement.executeQuery();
        final Object object=callableStatement.getObject(2);
        if (object != null) {
            result=object.toString();
        }
        return result;
    }

    @Override
    public String updateEmployee(Employee employee) throws Exception {
        String result = null;
        final String sqlQuery = PropertiesReader.getProperty("sql.UpdateEmployee");
        final Connection connection = ConnectionFactory.getConnection();
        final CallableStatement callableStatement = connection.prepareCall(sqlQuery);
        callableStatement.setInt(1, employee.getEmpNo());
        callableStatement.setString(2, employee.getEmpName());
        callableStatement.setString(3, employee.getEmpEmail());
        callableStatement.registerOutParameter(4, Types.VARCHAR);
        callableStatement.executeQuery();
        final Object object=callableStatement.getObject(4);
        if (object != null) {
            result=object.toString();
        }
        return result;
    }

    @Override
    public String saveEmployee(Employee employee) throws Exception {
        String result = null;
        final String sqlQuery = PropertiesReader.getProperty("sql.InsertEmployee");
        final Connection connection = ConnectionFactory.getConnection();
        final CallableStatement callableStatement = connection.prepareCall(sqlQuery);
        callableStatement.setInt(1, employee.getEmpNo());
        callableStatement.setString(2, employee.getEmpName());
        callableStatement.setString(3, employee.getEmpEmail());
        callableStatement.registerOutParameter(4, Types.VARCHAR);
        callableStatement.executeQuery();
        final Object object=callableStatement.getObject(4);
        if (object != null) {
            result=object.toString();
        }
        return result;
    }
}
