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
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
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
            if (resultSet != null) {
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
