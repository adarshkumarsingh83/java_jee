package com.adarsh.persistance.dao;

import com.adarsh.persistance.domain.EmployeeBean;
import com.adarsh.persistance.repository.EmployeeRepository;

import java.util.List;

public class DataAccessObject {

    static {
        System.out.println("static block of the DataAccessObject class ");
    }

    public DataAccessObject() {
        System.out.println("constructor of the DataAccessObject class ");
    }


    public int insertEmployeeRecord(EmployeeBean employeeBean) throws Exception {
        return new EmployeeRepository().insertEmployeeRecord(employeeBean);
    }

    public List selectEmployeeRecord() throws Exception {
        return new EmployeeRepository().selectEmployeeRecord();
    }


}
 
