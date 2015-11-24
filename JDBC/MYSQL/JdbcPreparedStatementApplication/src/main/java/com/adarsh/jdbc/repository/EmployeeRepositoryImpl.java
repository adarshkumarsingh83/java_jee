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

import java.sql.Connection;
import java.sql.PreparedStatement;
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
        final String sqlQuery = PropertiesReader.getProperty("sql.SelectAllEmployee");
        final Connection connection = ConnectionFactory.getConnection();
        final PreparedStatement preparedStatementSelect = connection.prepareStatement(sqlQuery);
        final ResultSet resultSet = preparedStatementSelect.executeQuery();
        if (resultSet != null) {
            final List<Employee> employeeList = new ArrayList<>();
            while (resultSet.next()) {
                employeeList.add(new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
            }
            return employeeList;
        }
        return null;
    }

    @Override
    public Employee getEmployee(final Integer empId) throws Exception {
        final String sqlQuery = PropertiesReader.getProperty("sql.SelectEmployee");
        final Connection connection = ConnectionFactory.getConnection();
        PreparedStatement preparedStatementSelect = connection.prepareStatement(sqlQuery);
        preparedStatementSelect.setInt(1, empId);
        final ResultSet resultSet = preparedStatementSelect.executeQuery();
        if (resultSet != null && resultSet.next()) {
            Employee employee = null;
            employee = new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
            return employee;
        }
        return null;
    }

    @Override
    public boolean deleteEmployee(Integer empId) throws Exception {
        final String sqlQuery = PropertiesReader.getProperty("sql.DeleteEmployee");
        final Connection connection = ConnectionFactory.getConnection();
        final PreparedStatement preparedStatementDelete = connection.prepareStatement(sqlQuery);
        preparedStatementDelete.setInt(1, empId);
        int result = preparedStatementDelete.executeUpdate();
        return (result > 0 ? true : false);
    }

    @Override
    public boolean updateEmployee(Employee employee) throws Exception {
        final String sqlQuery = PropertiesReader.getProperty("sql.UpdateEmployee");
        final Connection connection = ConnectionFactory.getConnection();
        final PreparedStatement preparedStatementDelete = connection.prepareStatement(sqlQuery);
        preparedStatementDelete.setString(1, employee.getEmpName());
        preparedStatementDelete.setString(2, employee.getEmpEmail());
        preparedStatementDelete.setInt(3, employee.getEmpNo());
        int result = preparedStatementDelete.executeUpdate();
        return (result > 0 ? true : false);
    }

    @Override
    public boolean saveEmployee(Employee employee) throws Exception {
        final String sqlQuery = PropertiesReader.getProperty("sql.InsertEmployee");
        final Connection connection = ConnectionFactory.getConnection();
        final PreparedStatement preparedStatementInsert = connection.prepareStatement(sqlQuery);
        preparedStatementInsert.setInt(1, employee.getEmpNo());
        preparedStatementInsert.setString(2, employee.getEmpName());
        preparedStatementInsert.setString(3, employee.getEmpEmail());
        int result = preparedStatementInsert.executeUpdate();
        return (result > 0 ? true : false);
    }
}
