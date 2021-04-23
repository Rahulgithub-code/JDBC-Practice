package com.dbPractice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Update_Existing_Data_By_ID {
    public static void main(String[] args) {
        try{
            Connection con = Connection__Provider_For_MySql.getConnection();
            String query="update table1 set tname=?, tcity=? where tId=?";
            Scanner sc = new Scanner(System.in);
            System.out.print("Name : ");
            String name =sc.nextLine();
            System.out.print("City : ");
            String city = sc.nextLine();
            System.out.print("Id : ");
            int id = sc.nextByte();
            System.out.println(name+" "+city+" "+id);
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1,name);
            pstmt.setString(2,city);
            pstmt.setInt(3,id);
            pstmt.executeUpdate();
            System.out.println("Update successfully.");
            con.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
