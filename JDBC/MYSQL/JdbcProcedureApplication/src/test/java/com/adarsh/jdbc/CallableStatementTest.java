/*
 * Copyright © MeritTrac Services Pvt. Ltd.
 * All Rights Reserved.
 */

package com.adarsh.jdbc;
/*
 * {@inheritDoc}
*/

/**
 * @Product : CallableStatementTest provide implementation of the specification
 *                    provided for the ...    
 */


import com.adarsh.jdbc.entity.Employee;
import com.adarsh.jdbc.repository.EmployeeRepository;
import com.adarsh.jdbc.repository.EmployeeRepositoryImpl;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author $CreatedBy Adarsh_K
 * @author $LastChangedBy: Adarsh_K
 * @version $Revision: 1.0 $, $Date:: 4/6/13 5:21 PM
 * @see
 */

public class CallableStatementTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CallableStatementTest.class);
    private EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();

    @Test
    public void selectAll() throws Exception {
        List<Employee> employeeList = employeeRepository.getAllEmployee();
        for (Employee employee : employeeList) {
            LOGGER.info(employee.toString());
        }
    }

    @Test
    public void selectOne() throws Exception {
        final Employee employee = employeeRepository.getEmployee(1);
        LOGGER.info(employee.toString());
    }

    @Test
    public void saveEmployee() throws Exception {
        Employee employee=new Employee(7,"sonu","sonu@singh");
        final String result= employeeRepository.saveEmployee(employee);
        LOGGER.info("Employee inserted "+result);
    }

    @Test
    public void updateEmployee()throws Exception{
        Employee employee=new Employee(7,"Sonu Singh","sonu@singh.com");
        final String result= employeeRepository.updateEmployee(employee);
        LOGGER.info("Employee Updated "+result);
    }

    @Test
    public void deleteEmployee()throws Exception{
        final String result= employeeRepository.deleteEmployee(7);
        LOGGER.info("Employee Deleted "+result);
    }
}
