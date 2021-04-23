package com.dbPractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Insert_Dynamic_PreparedStmt {
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

            // getting user value using BufferReader you can also use Scanner class.
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter name : ");
            String name = br.readLine();
            System.out.print("Enter city name : ");
            String city = br.readLine();

            // set value to query
            pstmt.setString(1, name);
            pstmt.setString(2, city);

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
