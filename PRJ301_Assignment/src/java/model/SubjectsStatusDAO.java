/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.SubjectsStatus;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class SubjectsStatusDAO extends MyDAO {

    public String checkStatus(String class_id, String student_id) {
        ClassDAO u = new ClassDAO();
        Class y = u.getClassesById(class_id);
        String subject = y.getSubject();
        xSql = "select * from SubjectsStatus where id = ?";
        String check = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, student_id);
            rs = ps.executeQuery();
            if (rs.next()) {
                check = rs.getString(subject);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public SubjectsStatus getSubjectsStatusById(String xId) {
        xSql = "select * from SubjectsStatus where id = ?";
        String xMAE101;
        String xPRF192;
        String xMAD101;
        String xPRO192;
        String xJPD113;
        String xLAB211;
        String xMAS291;
        String xJPD123;
        String xPRJ301;
        String xJPD316;
        String xPRM392;
        SubjectsStatus x = null;
        int myInt;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, xId);
            rs = ps.executeQuery();
            if (rs.next()) {
                xMAE101 = rs.getString("MAE101");
                xPRF192 = rs.getString("PRF192");
                xMAD101 = rs.getString("MAD101");
                xPRO192 = rs.getString("PRO192");
                xJPD113 = rs.getString("JPD113");
                xLAB211 = rs.getString("LAB211");
                xMAS291 = rs.getString("MAS291");
                xJPD123 = rs.getString("JPD123");
                xPRJ301 = rs.getString("PRJ301");
                xJPD316 = rs.getString("JPD316");
                xPRM392 = rs.getString("PRM392");
                x = new SubjectsStatus(xId, xMAE101, xPRF192, xMAD101, xPRO192, xJPD113, xLAB211, xMAS291, xJPD123, xPRJ301, xJPD316, xPRM392);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }

    public ArrayList<String> getNotPassedSubjects(String id) {
        ArrayList<String> t = new ArrayList();
        String xMAE101;
        String xPRF192;
        String xMAD101;
        String xPRO192;
        String xJPD113;
        String xLAB211;
        String xMAS291;
        String xJPD123;
        String xPRJ301;
        String xJPD316;
        String xPRM392;
        xSql = "select * from SubjectsStatus where id = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                xMAE101 = rs.getString("MAE101");
                if (xMAE101.equals("not passed")) {
                    t.add("MAE101");
                }
                xPRF192 = rs.getString("PRF192");
                if (xPRF192.equals("not passed")) {
                    t.add("PRF192");
                }
                xMAD101 = rs.getString("MAD101");
                if (xMAD101.equals("not passed")) {
                    t.add("MAD101");
                }
                xPRO192 = rs.getString("PRO192");
                if (xPRO192.equals("not passed")) {
                    t.add("PRO192");
                }
                xJPD113 = rs.getString("JPD113");
                if (xJPD113.equals("not passed")) {
                    t.add("JPD113");
                }
                xLAB211 = rs.getString("LAB211");
                if (xLAB211.equals("not passed")) {
                    t.add("LAB211");
                }
                xMAS291 = rs.getString("MAS291");
                if (xMAS291.equals("not passed")) {
                    t.add("MAS291");
                }
                xJPD123 = rs.getString("JPD123");
                if (xJPD123.equals("not passed")) {
                    t.add("JPD123");
                }
                xPRJ301 = rs.getString("PRJ301");
                if (xPRJ301.equals("not passed")) {
                    t.add("PRJ301");
                }
                xJPD316 = rs.getString("JPD316");
                if (xJPD316.equals("not passed")) {
                    t.add("JPD316");
                }
                xPRM392 = rs.getString("PRM392");
                if (xPRM392.equals("not passed")) {
                    t.add("PRM392");
                }
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public void update(String subject, String user_id) {
        xSql = "update SubjectsStatus set " + subject + " = 'studying' where id = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, user_id);
            rs = ps.executeQuery();

            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
