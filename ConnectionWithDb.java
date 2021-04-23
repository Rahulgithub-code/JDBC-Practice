package com.dbPractice;

import java.sql.*;

public class ConnectionWithDb {
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
            if (con.isClosed()){
                System.out.println("Connection is closed.");
            }else{
                System.out.println("Database is connected.");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
