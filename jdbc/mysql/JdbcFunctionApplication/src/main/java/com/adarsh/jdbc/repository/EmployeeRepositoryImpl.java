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



import com.adarsh.jdbc.entity.Employee;
import com.adarsh.jdbc.properties.PropertiesReader;
import com.adarsh.jdbc.database.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
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
        final List<Employee> employeeList = new ArrayList<Employee>();
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
