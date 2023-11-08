package com.employeerecords.Models;

public class Manager extends Employee{
    private String department;

    Manager(){};
    Manager(int employeeId, String name, int age, String jobTitle, int salary, String department, int managerId){
        super(employeeId,name, age, jobTitle, salary, managerId);
        this.department = department;
    }
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
