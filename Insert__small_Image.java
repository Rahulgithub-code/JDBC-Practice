package com.dbPractice;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.sql.SQLException;

public class Insert__small_Image {
    public static void main(String[] args) {
        try {
            //getting connection.
            Connection c = Connection__Provider_For_MySql.getConnection();
            /*
            // create query for image table;
            // blob= binary large object, storing less than 65kb.
            // longblob for large images.
            String q = "create table images(id int primary key auto_increment, pic blob);";

            //create statement.
            Statement stmt = c.createStatement();
            stmt.executeUpdate(q);
            System.out.println("Table is created");
             */

            // create query for insert image.
            String q = "insert into images(pic) values (?)";
            PreparedStatement pstmt = c.prepareStatement(q);

            //file input stream
            //FileInputStream image1 = new FileInputStream("pic.jpeg");

            //file chooser
            JFileChooser jfc = new JFileChooser();
            jfc.showOpenDialog(null);
            File file = jfc.getSelectedFile();
            FileInputStream image1 = new FileInputStream(file);
            pstmt.setBinaryStream(1,image1,image1.available());
            pstmt.executeUpdate();
            //System.out.println("uploading done.");
            JOptionPane.showMessageDialog(null,"Success");
        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
