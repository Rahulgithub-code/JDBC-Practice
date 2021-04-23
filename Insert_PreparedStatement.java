package com.dbPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Insert_PreparedStatement {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //creating a connection.
            String url = "jdbc:mysql://localhost:3306/demo";
            String user_name="root";
            String password="rahulkr@1230";
            Connection con = DriverManager.getConnection(url,user_name,password);

            // create a query.
            String q = "insert into table1 (tname,tcity) values (?,?)";
            // get the prepared statement object
            PreparedStatement pstmt = con.prepareStatement(q);

            //set the value to query.
            pstmt.setString(1,"Rahul");
            pstmt.setString(2, "Ranchi");

            //execute.
            pstmt.executeUpdate();
            System.out.println("Data inserted.");
            con.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
