package com.adarsh.persistance.repository;

import com.adarsh.persistance.domain.EmployeeBean;
import com.adarsh.persistance.util.DataBaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Adarsh
 * Date: 9/27/12
 * Time: 3:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class EmployeeRepository {

    private Connection connectionObject = null;

    public EmployeeRepository() {
    }

    public int insertEmployeeRecord(EmployeeBean employeeBean) throws Exception {
        int result = 0;
        connectionObject = DataBaseConnection.getDataBaseConnection();
        try {
            Statement statementObject = connectionObject.createStatement();
            String insertQuery = "insert into Employee values(" + employeeBean.getEmpId() + ",'" + employeeBean.getEmpName() + "','" + employeeBean.getEmpDept() + "','" + employeeBean.getEmpSal() + "')";
            result = statementObject.executeUpdate(insertQuery);

        } catch (Exception e) {
            e.printStackTrace();
        }
        connectionObject.close();
        return result;
    }


    public List selectEmployeeRecord() {
        List<EmployeeBean> employee = new ArrayList<EmployeeBean>();
        try {
            connectionObject = DataBaseConnection.getDataBaseConnection();
            Statement statementObject = connectionObject.createStatement();
            String selectQuery = "select * from Employee";
            ResultSet employeeResult = statementObject.executeQuery(selectQuery);

            while (employeeResult.next()) {
                EmployeeBean eb = new EmployeeBean();
                eb.setEmpId(employeeResult.getInt(1));
                eb.setEmpName(employeeResult.getString(2));
                eb.setEmpDept(employeeResult.getString(3));
                eb.setEmpSal(employeeResult.getDouble(4));
                employee.add(eb);
            }

            connectionObject.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }
}
