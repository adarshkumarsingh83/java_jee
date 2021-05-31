package com.adarsh.bean;

import java.io.Serializable;

/*
* @author Adarsh
* @author $LastChangedBy: adarsh $
* @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
*/
public class Employee extends Person implements Serializable {

    private int empNumber;

    public void setEmpNumber(int empNumber) {
        this.empNumber = empNumber;
    }

    public int getEmpNumber() {
        return empNumber;
    }
}
