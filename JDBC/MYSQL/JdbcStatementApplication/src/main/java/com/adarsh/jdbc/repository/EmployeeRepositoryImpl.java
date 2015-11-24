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
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
        final Statement statementSELECT = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        final ResultSet resultSet = statementSELECT.executeQuery(sqlQuery);
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
    public Employee getEmployee(Integer empId) throws Exception {
        final String sqlQuery = PropertiesReader.getProperty("sql.SelectAllEmployee");
        final Connection connection = ConnectionFactory.getConnection();
        final Statement statementSELECT = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        final ResultSet resultSet = statementSELECT.executeQuery(sqlQuery);
        if (resultSet != null && resultSet.next()) {
            Employee employee = null;
            employee = new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
            return employee;
        }
        return null;
    }

    @Override
    public boolean deleteEmployee(Integer empId) throws Exception {
        final String sqlQuery = PropertiesReader.getProperty("sql.DeleteEmployee").replaceAll("@EMPNO", empId.toString());
        final Connection connection = ConnectionFactory.getConnection();
        final Statement statementDelete = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        int result = statementDelete.executeUpdate(sqlQuery);
        return (result > 0 ? true : false);
    }

    @Override
    public Employee updateEmployee(Employee employee) throws Exception {
        final String sqlQuery = PropertiesReader.getProperty("sql.UpdateEmployee")
                .replaceFirst("@EMPNAME", employee.getEmpName())
                .replaceFirst("@EMPEMAIL", employee.getEmpEmail())
                .replaceFirst("@EMPNO", employee.getEmpNo().toString());
        final Connection connection = ConnectionFactory.getConnection();
        final Statement statementDelete = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        int result = statementDelete.executeUpdate(sqlQuery);
        return employee;
    }

    @Override
    public boolean saveEmployee(Employee employee) throws Exception {
        final String sqlQuery = PropertiesReader.getProperty("sql.InsertEmployee")
                .replaceFirst("@EMPNO", employee.getEmpNo().toString())
                .replaceFirst("@EMPNAME", employee.getEmpName())
                .replaceFirst("@EMPEMAIL", employee.getEmpEmail());
        final Connection connection = ConnectionFactory.getConnection();
        final Statement statementDelete = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        int result = statementDelete.executeUpdate(sqlQuery);
        return (result > 0 ? true : false);
    }
}
