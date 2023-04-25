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
    public ArrayList<Class> getClasses(){
        xSql = "select * from Class";
        String xId, subject, xtime;
        Class x = null;
        ArrayList<Class> t = new ArrayList();
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            if (rs.next()) {
                xId = rs.getString("id");
                subject = rs.getString("subject");
                xtime = rs.getString("time");
                x = new Class(xId, subject,xtime);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    
    }
    
    public ArrayList<Class> getClassesBySubject(String subject){
        xSql = "select * from Class where subject = ?";
        String xId, xtime;
        Class x = null;
        ArrayList<Class> t = new ArrayList();
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, subject);
            rs = ps.executeQuery();
            if (rs.next()) {
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
}
