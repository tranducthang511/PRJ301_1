/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class OpenClassRequestDAO extends MyDAO{

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
    
}
