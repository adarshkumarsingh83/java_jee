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
import java.sql.Statement;
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
        final ResultSet resultSet = callableStatement.executeQuery();
        if (resultSet != null) {
            final List<Employee> employeeList = new ArrayList<Employee>();
            while (resultSet.next()) {
                employeeList.add(new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
            }
            return employeeList;
        }
        return null;
    }

    @Override
    public Employee getEmployee(Integer empId) throws Exception {
        final String sqlQuery = PropertiesReader.getProperty("sql.SelectEmployee");
        final Connection connection = ConnectionFactory.getConnection();
        final CallableStatement callableStatement = connection.prepareCall(sqlQuery);
        callableStatement.setInt("EMP_NO", empId);
        final ResultSet resultSet = callableStatement.executeQuery();
        if (resultSet != null && resultSet.next()) {
            Employee employee = null;
            employee = new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
            return employee;
        }
        return null;
    }

    @Override
    public String deleteEmployee(Integer empId) throws Exception {
        String result=null;
        final String sqlQuery = PropertiesReader.getProperty("sql.DeleteEmployee");
        final Connection connection = ConnectionFactory.getConnection();
        final CallableStatement callableStatement = connection.prepareCall(sqlQuery);
        callableStatement.setInt("EMP_NO", empId);
        final ResultSet resultSet  = callableStatement.executeQuery();
        if (resultSet != null && resultSet.next()) {
           result=resultSet.getString(1);
        }
        return result;
    }

    @Override
    public String updateEmployee(Employee employee) throws Exception {
        String result=null;
        final String sqlQuery = PropertiesReader.getProperty("sql.UpdateEmployee");
        final Connection connection = ConnectionFactory.getConnection();
        final CallableStatement callableStatement = connection.prepareCall(sqlQuery);
        callableStatement.setInt("EMP_NO", employee.getEmpNo());
        callableStatement.setString("EMP_NAME", employee.getEmpName());
        callableStatement.setString("EMP_EMAIL", employee.getEmpEmail());
        final ResultSet resultSet  = callableStatement.executeQuery();
        if (resultSet != null && resultSet.next()) {
            result=resultSet.getString(1);
        }
        return result;
    }

    @Override
    public String saveEmployee(Employee employee) throws Exception {
        String result=null;
        final String sqlQuery = PropertiesReader.getProperty("sql.InsertEmployee");
        final Connection connection = ConnectionFactory.getConnection();
        final CallableStatement callableStatement = connection.prepareCall(sqlQuery);
        callableStatement.setInt("EMP_NO", employee.getEmpNo());
        callableStatement.setString("EMP_NAME", employee.getEmpName());
        callableStatement.setString("EMP_EMAIL", employee.getEmpEmail());
        final ResultSet resultSet  = callableStatement.executeQuery();
        if (resultSet != null && resultSet.next()) {
            result=resultSet.getString(1);
        }
        return result;
    }
}
