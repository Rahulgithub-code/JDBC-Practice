package com.dbPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection__Provider_For_MySql {
    private static Connection con;
    public static Connection getConnection(){
        if(con==null){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/youtube","root","");
                System.out.println("Successfully connection establish.");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return con;
    }
}
