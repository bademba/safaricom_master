/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brian.payments.dao;

/**
 *
 * @author BADEMBA
 */
import com.brian.db.DBConnector;
import java.sql.*;
 
public class UserDAO {      
     public static boolean login(String username, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBConnector.getMysqlDBConnection();
            ps = con.prepareStatement(
                    "SELECT username, password FROM webusers WHERE username= ? and password= ? ");
            ps.setString(1, username);
            ps.setString(2, password);
 
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
                System.out.println(CommonUtils.currDate()+""+CommonUtils.currTime()+""+rs.getString("username")+"-logged in");
                return true;
            }
            else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
            return false;
        } finally {
//            DBConnector.close(con);
        }
    }
}