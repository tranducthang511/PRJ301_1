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

/**
 *
 * @author admin
 */
public class SubjectsStatusDAO extends MyDAO {

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
                x = new SubjectsStatus(xId, xMAE101, xPRF192, xMAD101, xPRO192, xJPD113,xLAB211,xMAS291,xJPD123,xPRJ301,xJPD316,xPRM392);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }
}
