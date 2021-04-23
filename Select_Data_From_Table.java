package com.dbPractice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Select_Data_From_Table {
    public static void main(String[] args) {
        try{
            Connection con = Connection__Provider_For_MySql.getConnection();
            String query = "select * from table1";
            Statement stmt = con.createStatement();
            ResultSet data = stmt.executeQuery(query);
            while (data.next()){
                int id = data.getInt("tID");
                String name = data.getString("tname");
                String city = data.getString(3);
                System.out.format("Id : %d , Name: %s, City: %s \n",id,name,city);
            }
            con.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());

        }
    }
}
