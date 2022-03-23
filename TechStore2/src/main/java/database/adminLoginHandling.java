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
            String mail = "";
            String pass = "";
            PreparedStatement stmt = connection.prepareStatement("SELECT email,password FROM \"public\".admins;");
            ResultSet res = stmt.executeQuery();
            while (res.next()) {
                mail = res.getString(1);
                pass = res.getString(2);
                if (mail.equals(admin.getEmail()) && pass.equals(admin.getPassword())) {
                    System.out.println("Success");
                    return new MessageFromDB(true, "Account Exist");
                } else {
                    System.out.println("Not Exist");
                    return new MessageFromDB(false, "Account doesnt Exist, Please Try Again");
                }
            }
        } catch (SQLException ex) {
            System.err.println("error");
        }
        DataHandling.closeConnection();
        return new MessageFromDB(false, "Account doesnt Exist, Please Try Again");
    }
}
