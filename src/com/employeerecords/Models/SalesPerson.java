package com.employeerecords.Models;

public class SalesPerson extends Employee{
    private String salesTarget;

    SalesPerson(){};
    SalesPerson(int employeeId, String name, int age, String jobTitle, int salary, String salesTarget, int mamangerID){
        super(employeeId, name, age, jobTitle, salary, mamangerID);
        this.salesTarget = salesTarget;
    }
    public String getSalesTarget() {
        return salesTarget;
    }

    public void setSalesTarget(String salesTarget) {
        this.salesTarget = salesTarget;
    }
}
