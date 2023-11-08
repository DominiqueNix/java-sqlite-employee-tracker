package com.employeerecords.DaoInt;

import com.employeerecords.Models.Employee;

public interface EmployeeInt {
    //see all employees
    public void allEmployees();
    public void seeOneEmployee(int id);
    //add an employee
    public void addEmployee(Employee emp);
    //update and employee
    public void updateEmployee(String updateField,String updateValue,int id);
    //delete an employee
    public void deleteEmployee(int id);
}
