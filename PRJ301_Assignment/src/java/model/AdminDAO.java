package model;

import model.Admin;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import query.Query;

/**
 *
 * @author admin
 */
public class AdminDAO extends MyDAO {

    public Admin getAdminByUsername(String username) {
        xSql = "select * from Admin where email = ?";
        int xId;
        String xName;
        Date xDOB;
        Boolean xGender;
        String xPassword;
        Admin x = null;
        int myInt;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                xId = rs.getInt("id");
                xName = rs.getString("name");
                xDOB=rs.getDate("dob");
                myInt = rs.getInt("gender");
                if (myInt == 1) {
                    xGender = true;
                } else {
                    xGender = false;
                }
                xPassword=rs.getString("password");
                x = new Admin(xId, xName,xDOB, xGender, username, xPassword);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }
}
