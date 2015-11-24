/*
 * Copyright © MeritTrac Services Pvt. Ltd.
 * All Rights Reserved.
 */

package com.adarsh.jdbc.repository;
/*
 * {@inheritDoc}
*/

/**
 * @Product : EmployeeRepository provide implementation of the specification
 *                    provided for the ...    
 */


import com.adarsh.jdbc.entity.Employee;

import java.util.List;

/**
 * @author $CreatedBy Adarsh_K
 * @author $LastChangedBy: Adarsh_K
 * @version $Revision: 1.0 $, $Date:: 4/6/13 11:49 AM
 * @see
 */

public interface EmployeeRepository {

    public List<Employee> getAllEmployee()throws Exception;

    public Employee getEmployee(final Integer empId)throws Exception;

    public boolean deleteEmployee(final Integer empId)throws Exception;

    public boolean updateEmployee(final Employee employee)throws Exception;

    public boolean saveEmployee(final Employee employee)throws Exception;
}
