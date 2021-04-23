package com.dbPractice;

import java.sql.*;

public class Insert_JDBC {
    public static void main(String[] args) {
        try
        {
            // Load the driver.
            Class.forName("com.mysql.cj.jdbc.Driver");

            //creating a connection.
            String url = "jdbc:mysql://localhost:3306/demo";
            String user_name="root";
            String password="rahulkr@1230";
            Connection con = DriverManager.getConnection(url,user_name,password);

            //create a query.
            String q = "create table table1(tId int(20) primary key auto_increment, tname varchar(200) not null, tcity varchar(200))";

            //create a statement.
            Statement stmt = con.createStatement();
            stmt.executeUpdate(q);
            System.out.println("Table is created");
            con.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
