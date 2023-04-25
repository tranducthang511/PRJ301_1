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
}
