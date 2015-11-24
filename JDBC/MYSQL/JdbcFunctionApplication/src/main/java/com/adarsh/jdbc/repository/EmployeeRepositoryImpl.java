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


    @Override
    public Employee getEmployee(Integer empId) throws Exception {
        final String sqlQuery = PropertiesReader.getProperty("sql.SelectEmployee");
        final Connection connection = ConnectionFactory.getConnection();
        final CallableStatement callableStatement = connection.prepareCall(sqlQuery);
        callableStatement.registerOutParameter(1, Types.VARCHAR);
        callableStatement.setInt(2, empId);
        final ResultSet resultSet = callableStatement.executeQuery();
        if (resultSet != null && resultSet.next()) {
            Employee employee = null;
            String[] data = resultSet.getString(1).split(",");
            employee = new Employee(Integer.parseInt(data[0]), data[1], data[2]);
            return employee;
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployee(final String colSeparator,final String rowSeparator) throws Exception {
        final List<Employee> employeeList = new ArrayList<>();
        final String sqlQuery = PropertiesReader.getProperty("sql.selectAllEmployee");
        final Connection connection = ConnectionFactory.getConnection();
        final CallableStatement callableStatement = connection.prepareCall(sqlQuery);
        callableStatement.registerOutParameter(1, Types.VARCHAR);
        callableStatement.setString(2, colSeparator);
        callableStatement.setString(3,rowSeparator);
        final ResultSet resultSet = callableStatement.executeQuery();
        if (resultSet != null && resultSet.next()) {
            String[] empList = resultSet.getString(1).split(rowSeparator);
            for (int i = empList.length-1; i >= 0; i--) {
                String data[] =empList[i].split(colSeparator);
                employeeList.add(new Employee(Integer.parseInt(data[0]), data[1], data[2]));
            }
           return employeeList;
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
        final ResultSet resultSet = callableStatement.executeQuery();
        if (resultSet != null && resultSet.next()) {
            result = resultSet.getString(1);
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
        final ResultSet resultSet = callableStatement.executeQuery();
        if (resultSet != null && resultSet.next()) {
            result = resultSet.getString(1);
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
        final ResultSet resultSet = callableStatement.executeQuery();
        if (resultSet != null && resultSet.next()) {
            result = resultSet.getString(1);
        }
        return result;
    }
}
