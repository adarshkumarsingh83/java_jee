package com.adarsh.persistance.domain;
import java.io.*;

public class EmployeeBean implements Serializable{

  private Integer empId=null;
  private String empName=null;
  private String empDept=null;
  private Double empSal=null;
  
   static{
	   System.out.println("static block of the EmployeeBean class ");	    
   }
  
   { System.out.println("instatnse block of the EmployeeBean class ");}

   public EmployeeBean(){
	   System.out.println("constructor of the EmployeeBean class ");
   }
   
   public Integer getEmpId() {
	   return empId;
   }

   public void setEmpId(Integer empId) {
	   this.empId = empId;
   }

   public String getEmpName() {
	   return empName;
   }

   public void setEmpName(String empName) {
	   this.empName = empName;
   }

   public String getEmpDept() {
	   return empDept;
   }

   public void setEmpDept(String empDept) {
	   this.empDept = empDept;
   }

   public Double getEmpSal() {
	   return empSal;
   }

   public void setEmpSal(Double empSal) {
	   this.empSal = empSal;
   }
   
   public void displayEmployee(){
	   
	        System.out.println("Employee id "+this.getEmpId());
	         System.out.println("Employee Name "+this.getEmpName());
	         System.out.println("Employee Dept "+this.getEmpDept());
	         System.out.println("Employee Salary "+this.getEmpSal());	   
    }
}
