/*
 * Copyright (c) 2015 Espark And ©Adarsh Development Services @copyright All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Espark nor the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
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
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 */
public class EmployeeRepositoryImpl implements EmployeeRepository {


    @Override
    public List<Employee> getAllEmployee() throws Exception {
        final String sqlQuery = PropertiesReader.getProperty("sql.SelectAllEmployee");
        final Connection connection = ConnectionFactory.getConnection();
        final Statement statementSELECT = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        final ResultSet resultSet = statementSELECT.executeQuery(sqlQuery);
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
        final String sqlQuery = PropertiesReader.getProperty("sql.SelectEmployee")
                .replaceAll("@EMPNO", empId.toString());;
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
        final String sqlQuery = PropertiesReader.getProperty("sql.DeleteEmployee")
                .replaceAll("@EMPNO", empId.toString());
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
        return (result > 0 ? employee : null);
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
