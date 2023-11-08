package com.employeerecords;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DBConnection {
    static Connection conn = null;
    public static Connection createDBConnection(){
        try{
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:src/records.db");
            System.out.println("Successfully connected to dB");
            Statement statement = conn.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 s

            //TODO: create tables
//            statement.executeUpdate("drop table if exists employees");
//            String createManagers = "create table if not exists managers(id integer primary key autoincrement, name varchar(255), age integer, jobTitle varchar(255),salary integer, department varchar(255)";
            String createquery = "create table if not exists employees(id integer primary key autoincrement, name varchar(255), age integer, jobTitle varchar(255),salary integer,managerId integer references companies(id))";
//            statement.executeUpdate(createManagers);
            statement.executeUpdate(createquery);
//            Statement stmt = conn.createStatement();
//            stmt.execute("create  table if not exists employee(id integer primary key, )");

        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
