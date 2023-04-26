/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.Class_Student;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Class_StudentDAO extends MyDAO {

    public void insert(String cl, String user_id) {
       xSql = "INSERT INTO Class_Student(class_id,student_id) VALUES(?,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, cl);
            ps.setString(2, user_id);
            rs = ps.executeQuery();
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public void delete(String class_id, String user_id) {
       xSql = "Delete Class_Student where class_id ='"+class_id+"' and student_id='"+user_id+"'";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<String> FindStudyingClass(String user_id){
        xSql = "Select * from Class_Student where student_id=?";
        ArrayList<String> t = new ArrayList();
        try {
            
            ps = con.prepareStatement(xSql);
            ps.setString(1, user_id);
            rs = ps.executeQuery();
            while(rs.next()){
                String xClass_id = rs.getString("class_id");
                t.add(xClass_id);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }
    public ArrayList<String> FindStudentInClass(String class_id){
        xSql = "Select * from Class_Student where class_id=?";
        ArrayList<String> t = new ArrayList();
        try {
            
            ps = con.prepareStatement(xSql);
            ps.setString(1, class_id);
            rs = ps.executeQuery();
            while(rs.next()){
                String xStudent_id = rs.getString("student_id");
                t.add(xStudent_id);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }
}
