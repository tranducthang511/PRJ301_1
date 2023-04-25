/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class OpenClassRequestDAO extends MyDAO {

    public void insert(String subject, String user_id) {
        xSql = "INSERT INTO OpenClassRequest(id,subject) VALUES(?,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, user_id);
            ps.setString(2, subject);
            rs = ps.executeQuery();
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void delete(String subject) {
        xSql = "Delete OpenClassRequest where subject=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, subject);
            rs = ps.executeQuery();
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<String> getRequestSubject() {
        xSql = "Select * from OpenClassRequest";
        ArrayList<String> t = new ArrayList();
        try {
            String xSubject;
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                xSubject = rs.getString("subject");
                t.add(xSubject);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }
    
    public ArrayList<String> getRequestUserId(String subject) {
        xSql = "Select * from OpenClassRequest where subject=?";
        ArrayList<String> t = new ArrayList();
        String xId;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, subject);
            rs = ps.executeQuery();          
            while (rs.next()) {
                xId = rs.getString("id");
                t.add(xId);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }
}
