package com.dbPractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

class Student{
    protected int id;
    protected String name;
    protected String phone;
    protected String city;

    public Student(int id, String name, String phone, String city) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.city = city;
    }

    public Student(String name, String phone, String city) {
        this.name = name;
        this.phone = phone;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

class StudentDao{
    public static boolean insertStudentToDB(Student st){
        boolean flag=false;
        try{
            //jdbc connection.
            Connection con = Connection__Provider_For_MySql.getConnection();
            //Query.
            String query="insert into student(s_name,s_phone,s_city) values(?,?,?)";
            //Prepared statement.
            PreparedStatement pstmt = con.prepareStatement(query);
            //set the value
            pstmt.setString(1, st.getName());
            pstmt.setString(2, st.getPhone());
            pstmt.setString(3, st.getCity());
            //Execute.
            pstmt.executeUpdate();
            flag=true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return flag;
    }

    public static boolean deleteStudentById(int id) {
        boolean flag=false;
        try{
            //jdbc connection.
            Connection con = Connection__Provider_For_MySql.getConnection();
            //Query.
            String query="delete from student where s_id=?";
            //Prepared statement.
            PreparedStatement pstmt = con.prepareStatement(query);
            //set the value
            pstmt.setInt(1,id);
            //Execute.
            pstmt.executeUpdate();
            flag=true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return flag;
    }

    public static void showAllStudent() {
        try{
            //jdbc connection.
            Connection con = Connection__Provider_For_MySql.getConnection();
            //Query.
            String query="select * from student";
            //statement.
            Statement stmt = con.createStatement();
            //Execute.
            ResultSet set = stmt.executeQuery(query);
            while (set.next()){
                System.out.println("Id:"+set.getInt("s_id")+" Name:"+ set.getString("s_name")+" Phone:"+set.getString("s_phone")+ "  City:"+set.getString("s_city"));
                System.out.println("+++++++++++++++++++");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static boolean updateStudentById(int id, Student st){
        boolean flag=false;
        try{
            //jdbc connection.
            Connection con = Connection__Provider_For_MySql.getConnection();
            //Query.
            String query="update student set s_name=?, s_phone=?, s_city=? where s_id=?";
            //Prepared statement.
            PreparedStatement pstmt = con.prepareStatement(query);
            //set the value
            pstmt.setString(1,st.getName());
            pstmt.setString(2, st.getPhone());
            pstmt.setString(3,st.getCity());
            pstmt.setInt(4, id);
            //Execute.
            pstmt.executeUpdate();
            flag=true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return flag;
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
           // Connection con = Connection__Provider_For_MySql.getConnection();
            /*
            String query = "create table student(s_id int(11) primary key auto_increment, s_name varchar(100) not null, s_phone varchar(12), s_city varchar(50))";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Table successfully created.");
            con.close();
             */
            while (true){
                System.out.println("*************************");
                System.out.println("Press 1 to Add student");
                System.out.println("Press 2 to Delete student");
                System.out.println("Press 3 to Update student");
                System.out.println("Press 4 to Display student");
                System.out.println("Press 5 to exit app");
                System.out.println("*************************");
                System.out.print("Enter your choice : ");
                int choice = sc.nextByte();

                if (choice == 1){
                    //Add
                    System.out.print("Enter student name : ");
                    String name = br.readLine();
                    System.out.print("Enter student phone no : ");
                    String phone = br.readLine();
                    System.out.print("Enter student city : ");
                    String city = br.readLine();

                    //create student object.
                    Student st = new Student(name,phone,city);
                    boolean ans=StudentDao.insertStudentToDB(st);
                    if (ans){
                        System.out.println(st);
                        System.out.println("Student added successfully.");
                    }else {
                        System.out.println("Some error occur.");
                    }

                }else if (choice==2){
                    //delete
                    System.out.print("Enter student id : ");
                    int id = sc.nextByte();
                    boolean ans = StudentDao.deleteStudentById(id);
                    if(ans){
                        System.out.println("Record deleted");
                    }else {
                        System.out.println("Some error occur");
                    }
                }else if (choice==3){
                    //update
                    System.out.print("Enter id :");
                    int id= sc.nextByte();
                    System.out.print("Enter student name : ");
                    String name = br.readLine();
                    System.out.print("Enter student phone no : ");
                    String phone = br.readLine();
                    System.out.print("Enter student city : ");
                    String city = br.readLine();
                    //create student object.
                    Student st = new Student(name,phone,city);
                    boolean ans = StudentDao.updateStudentById(id,st);
                    if (ans){
                        System.out.println("Update successfully");
                    }else {
                        System.out.println("Some error occur.");
                    }
                }else if (choice==4){
                    //display
                    StudentDao.showAllStudent();
                }else if (choice==5){
                    //exit
                    break;
                }else{
                    System.out.println("Invalid choice.");
                }
            }
            System.out.println("Thanks for using application, See you soon.");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
