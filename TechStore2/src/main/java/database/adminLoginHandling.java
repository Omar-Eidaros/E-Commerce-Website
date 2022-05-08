/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Omar Samir
 */
public class adminLoginHandling {

    public Admin checkAdminLogin(Admin admin) throws SQLException {
        try {

            PreparedStatement stmt = DataHandling.getConnection().prepareStatement("SELECT adminid,adminname FROM admins where email=? and password = ?");
            stmt.setString(1, admin.getEmail());
            stmt.setString(2, admin.getPassword());

            ResultSet res = stmt.executeQuery();
            while (res.next()) {
                System.out.println("Success");
                admin.setAdminid(res.getInt(1));
                admin.setAdminname(res.getString(2));
                return admin;
            }
        } catch (SQLException ex) {
            System.err.println("error");
        }
        System.out.println("Not Exist");
        admin.setAdminid(-1);
        return admin;
    }
}
