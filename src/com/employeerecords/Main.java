package com.employeerecords;

import com.employeerecords.DaoImp.EmployeeImp;
import com.employeerecords.DaoInt.EmployeeInt;
import com.employeerecords.Models.Employee;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeInt Empdao = new EmployeeImp();
        System.out.println("Welcome to Employee Records System");
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("1.Employee Menu\n2.Manager Menu\n3.SalesPerson Menu");
            int ch = scanner.nextInt();

            switch (ch){
                case 1:
                    System.out.println("Welcome to Employee Menu");
                    System.out.println("1. See All Employees\n2.See one employee\n3.Add Employee\n4.Update Employee\n5.Delete Employee");
                    int empch = scanner.nextInt();
                    switch (empch){
                        case 1:
                        Empdao.allEmployees();
                        break;
                        case 2:
                            System.out.println("Enter Employee ID:");
                            int oneId = scanner.nextInt();
                            Empdao.seeOneEmployee(oneId);
                            break;
                        case 3:
                            Employee emp = new Employee();

                            System.out.println("Enter id");
                            int id = scanner.nextInt();

                            System.out.println("Enter name:");
                            String name = scanner.next();

                            System.out.println("Enter age:");
                            int age = scanner.nextInt();

                            System.out.println("Enter Job Title:");
                            String jobTitle = scanner.next();

                            System.out.println("Enter salary:");
                            int salary = scanner.nextInt();

                            System.out.println("Enter Manager id:");
                            int managerId = scanner.nextInt();

                            emp.setEmployeeId(id);
                            emp.setName(name);
                            emp.setAge(age);
                            emp.setJobTitle(jobTitle);
                            emp.setSalary(salary);
                            emp.setManagerID(managerId);

                            Empdao.addEmployee(emp);
                        break;
                        case 4:
                            System.out.println("Enter Employee ID:");
                            int upId = scanner.nextInt();
                            System.out.println("Update Which Field?\n1.name\n2.age\n3.Job Title\n4.Salary\n5.managerId");
                            int upCh = scanner.nextInt();
                            String updatedField= null;
                            switch (upCh){
                                case 1:
                                    updatedField = "name";
                                    break;
                                case 2:
                                    updatedField = "age";
                                    break;
                                case 3:
                                    updatedField = "jobTitle";
                                    break;
                                case 4:
                                    updatedField = "salary";
                                    break;
                                case 5:
                                    updatedField = "managerId";
                                    break;
                            }
                            System.out.println("Input Update:");
                            String updatedValue = scanner.next();
                            Empdao.updateEmployee(updatedField, updatedValue, upId);
                            break;
                        case 5:
                            System.out.println("Enter Id:");
                            int delId = scanner.nextInt();

                            Empdao.deleteEmployee(delId);
                            break;
                    }
                break;
            }
        }while(true);
    }
}
