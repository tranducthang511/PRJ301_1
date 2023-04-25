package model;

import java.sql.Date;
import java.util.*;
import java.sql.*;

/**
 *
 * @author thangtdhe160619
 */
public class StudentDAO extends MyDAO {

    public Student getStudentByEmail(String xEmail) {
        xSql = "select * from Student where email = ?";
        String xId;
        String xName;
        Date xDOB;
        Boolean xGender;
        String xPassword;
        Student x = null;
        int myInt;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, xEmail);
            rs = ps.executeQuery();
            if (rs.next()) {
                xId = rs.getString("id");
                xName = rs.getString("name");
                xDOB = rs.getDate("dob");
                myInt = rs.getInt("gender");
                if (myInt == 1) {
                    xGender = true;
                } else {
                    xGender = false;
                }
                xPassword = rs.getString("password");
                x = new Student(xId, xName, xDOB, xGender, xEmail, xPassword);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }
    
    public Student getStudentById(String xId) {
        xSql = "select * from Student where id = ?";
        String xEmail;
        String xName;
        Date xDOB;
        Boolean xGender;
        String xPassword;
        Student x = null;
        int myInt;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, xId);
            rs = ps.executeQuery();
            if (rs.next()) {
                xName = rs.getString("name");
                xDOB = rs.getDate("dob");
                myInt = rs.getInt("gender");
                if (myInt == 1) {
                    xGender = true;
                } else {
                    xGender = false;
                }
                xEmail = rs.getString("email");
                xPassword = rs.getString("password");
                x = new Student(xId, xName, xDOB, xGender, xEmail, xPassword);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }
}
