package com.employeerecords.DaoImp;

import com.employeerecords.DaoInt.EmployeeInt;
import com.employeerecords.DBConnection;
import com.employeerecords.Models.Employee;

import java.sql.*;

public class EmployeeImp implements EmployeeInt {
    Connection conn;
    @Override
    public void allEmployees() {
        conn = DBConnection.createDBConnection();
        String query = "select * from employees";
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.printf("-----------------------%n");
            System.out.printf("   Employee's Table    %n");
            System.out.printf("-----------------------%n");
            System.out.printf("| %-5s | %-10s | %-5s | %-10s | %-7s | %-10s |%n", "ID", "Name", "Age", "Job Title", "Salary", "ManagerId");
            System.out.printf("-----------------------%n");

            while (rs.next()){
                System.out.printf("| %-5s | %-10s | %-5s | %-10s | %-7s | %-10s |%n",
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6));
                System.out.printf("-----------------------%n");
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
    @Override
    public void seeOneEmployee(int id){
        conn = DBConnection.createDBConnection();
        String query = "select * from employees where id=" +id;
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.printf("-----------------------%n");
            System.out.printf("   Employee Data    %n");
            System.out.printf("-----------------------%n");
            System.out.printf("| %-5s | %-10s | %-5s | %-10s | %-7s | %-10s |%n", "ID", "Name", "Age", "Job Title", "Salary", "ManagerId");
            System.out.printf("-----------------------%n");
            while (rs.next()){
                System.out.printf("| %-5s | %-10s | %-5s | %-10s | %-7s | %-10s |%n",
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6));
                System.out.printf("-----------------------%n");
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void addEmployee(Employee emp) {
        conn = DBConnection.createDBConnection();
        String query = "insert into employees values(?,?,?,?,?,?)";
        try{
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, emp.getEmployeeId());
            pstmt.setString(2, emp.getName());
            pstmt.setInt(3, emp.getAge());
            pstmt.setString(4, emp.getJobTitle());
            pstmt.setInt(5, emp.getSalary());
            pstmt.setInt(6, emp.getManagerID());
            int cnt = pstmt.executeUpdate();
            if(cnt != 0){
                System.out.println("Employee successfully added");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void updateEmployee(String updateField, String updateValue, int id) {
        Connection conn = DBConnection.createDBConnection();

        String query = "update employees set " + updateField + " = ? where id = ?";
        try{

            PreparedStatement pstmt = conn.prepareStatement(query);
//            pstmt.setString(1, updateField);
            pstmt.setString(1, updateValue);
            pstmt.setInt(2, id);
            int cnt = pstmt.executeUpdate();
            if(cnt != 0){
                System.out.println("Employee Updated");
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteEmployee(int id) {
        Connection conn = DBConnection.createDBConnection();
        String query = "delete from employees where id = ?";

        try{

            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            int cnt = pstmt.executeUpdate();
            if (cnt != 0)
                System.out.println("Employee Removed");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
