/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.Class;
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
public class ClassDAO extends MyDAO {

    public void newClass(String subject) {
        ArrayList<model.Class> n = getClassesBySubject(subject);
        xSql = "INSERT INTO Class(id,subject,time) VALUES(?,?,?)";
        try {
            int count = 1;
            ps = con.prepareStatement(xSql);
            for (model.Class a : n) {
                count++;
            }
            String i;
            if (count < 10) {
                i = "_0" + String.valueOf(count);
            } else {
                i = "_" + String.valueOf(count);
            }
            String xId = subject + i;
            int randomtime=0;
            if (subject.equals("MAE101")) {
                randomtime=0;
            }
            if (subject.equals("PRF192")) {
                randomtime=1;
            }
            if (subject.equals("MAD101")) {
                randomtime=2;
            }
            if (subject.equals("PRO192")) {
                randomtime=3;
            }
            if (subject.equals("JPD113")) {
                randomtime=4;
            }
            if (subject.equals("LAB211")) {
                randomtime=5;
            }
            if (subject.equals("MAS291")) {
                randomtime=6;
            }
            if (subject.equals("JPD123")) {
                randomtime=7;
            }
            if (subject.equals("PRJ301")) {
                randomtime=8;
            }
            if (subject.equals("JPD316")) {
                randomtime=9;
            }
            if (subject.equals("PRM392")) {
                randomtime=10;
            }
            String xTime = "Slot" + String.valueOf((count+randomtime)% 7+1);
            ps.setString(1, xId);
            ps.setString(2, subject);
            ps.setString(3, xTime);
            rs = ps.executeQuery();
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Class> getClasses() {
        xSql = "select * from Class";
        String xId, subject, xtime;
        Class x = null;
        ArrayList<Class> t = new ArrayList();
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                xId = rs.getString("id");
                subject = rs.getString("subject");
                xtime = rs.getString("time");
                x = new Class(xId, subject, xtime);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);

    }

    public ArrayList<Class> getClassesBySubject(String subject) {
        xSql = "select * from Class where subject = ?";
        String xId, xtime;
        Class x = null;
        ArrayList<Class> t = new ArrayList();
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, subject);
            rs = ps.executeQuery();
            while (rs.next()) {
                xId = rs.getString("id");
                xtime = rs.getString("time");
                x = new Class(xId, subject, xtime);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public Class getClassesById(String id) {
        xSql = "select * from Class where id = ?";
        String xSubject, xtime;
        Class x = null;

        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                xSubject = rs.getString("subject");
                xtime = rs.getString("time");
                x = new Class(id, xSubject, xtime);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }

    public String getLatestClassIdBySubject(String subject) {
        xSql = "select * from Class where subject=?";
        String xId = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, subject);
            rs = ps.executeQuery();
            while (rs.next()) {
                xId = rs.getString("id");
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (xId);
    }
     public void updateTime (String Class_id, String xTime) {
        xSql = "update Class set time = '"+xTime+"' where id = '"+Class_id+"'";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();           
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
