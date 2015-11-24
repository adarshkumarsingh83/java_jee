/*
 * Copyright © MeritTrac Services Pvt. Ltd.
 * All Rights Reserved.
 */

package com.adarsh.jdbc.entity;
/*
 * {@inheritDoc}
*/

/**
 * @Product : Employee provide implementation of the specification
 *                    provided for the ...    
 */


/**
 * @author $CreatedBy Adarsh_K
 * @author $LastChangedBy: Adarsh_K
 * @version $Revision: 1.0 $, $Date:: 4/6/13 11:47 AM
 * @see
 */

public class Employee {

    private Integer empNo;
    private String empName;
    private String empEmail;

    public Employee() {
        super();
    }

    public Employee(Integer empNo, String empName, String empEmail) {
        this();
        this.empNo = empNo;
        this.empName = empName;
        this.empEmail = empEmail;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empNo=" + empNo +
                ", empName='" + empName + '\'' +
                ", empEmail='" + empEmail + '\'' +
                '}';
    }
}
