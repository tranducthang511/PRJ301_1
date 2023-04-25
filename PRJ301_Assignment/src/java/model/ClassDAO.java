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
    public ArrayList<String> getClassesBySubject(String subject){
        xSql = "select * from Class where subject = ?";
        String xId;
        Class x = null;
        ArrayList<String> t = new ArrayList();
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, subject);
            rs = ps.executeQuery();
            if (rs.next()) {
                xId = rs.getString("id");
                x = new Class(xId, subject);
                t.add(x.getId());
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }
}
