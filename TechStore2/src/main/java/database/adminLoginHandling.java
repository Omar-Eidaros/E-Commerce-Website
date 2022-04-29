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

    private Connection connection = DataHandling.getConnection();

    public MessageFromDB checkAdminLogin(Admin admin) throws SQLException {
        try {

            PreparedStatement stmt = connection.prepareStatement("SELECT email,password FROM admins where email=? and password = ?");
            stmt.setString(1, admin.getEmail());
            stmt.setString(2, admin.getPassword());

            ResultSet res = stmt.executeQuery();
            while (res.next()) {
                System.out.println("Success");
                return new MessageFromDB(true, "Account Exist");

            }
        } catch (SQLException ex) {
            System.err.println("error");
        }
        System.out.println("Not Exist");
        return new MessageFromDB(false, "Account doesnt Exist, Please Try Again");
    }
}
