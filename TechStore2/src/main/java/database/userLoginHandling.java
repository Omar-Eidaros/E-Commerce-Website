/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import database.DataHandling;
import database.MessageFromDB;
import database.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Omar Samir
 */
public class userLoginHandling {

    public static User checkLogin(User user) throws SQLException {
        try {
            PreparedStatement stmt = DataHandling.getConnection().prepareStatement("SELECT userid, username, creditlimit FROM users where email=? and password=?");
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getPassword());
            ResultSet res = stmt.executeQuery();
            while (res.next()) {
                user.setUserId(res.getInt(1));
                user.setName(res.getString(2));
                user.setCreditLimit(res.getInt(3));
                return user;
            }
        } catch (SQLException ex) {
            System.err.println("error : "+ex);
        }
        user.setUserId(-1);
        return user;
    }
}
