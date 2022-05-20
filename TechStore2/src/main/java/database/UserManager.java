/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import database.DataHandling;
import database.MessageFromDB;
import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Salma
 */
public class UserManager {

    private static Connection conn = DataHandling.getConnection();

    public static MessageFromDB RegisterNewUser(String username, String email, String password, Date birthDate, String phoneNumber, String[] interest, String job, String street, String city) throws SQLException {
        try {
            Array a = conn.createArrayOf("text", interest);
            String registerQuery = "INSERT INTO users (username ,email "
                    + ",password ,birthdate,phonenumber ,interest,job,address )\n"
                    + "     VALUES (? ,? ,? ,? ,? ,? ,?,ROW(?,?))";

            PreparedStatement insertStatement = conn.prepareStatement(registerQuery);
            insertStatement.setString(1, username);

            insertStatement.setString(2, email);

            insertStatement.setString(3, password);
            insertStatement.setDate(4, birthDate);

            insertStatement.setString(5, phoneNumber);

            insertStatement.setArray(6, a);
            insertStatement.setString(7, job);
            insertStatement.setString(8, street);
            insertStatement.setString(9, city);

            int isInsert = insertStatement.executeUpdate();

            if (isInsert == 1) {
                return new MessageFromDB(true, "Done add user");
            } else {
                return new MessageFromDB(false, "cannot add");
            }
        } catch (SQLException ex) {

            return new MessageFromDB(false, "duplication");

        } catch (Exception e) {
            e.printStackTrace();
            return new MessageFromDB(false, "please try again");
        }
    }

    public static boolean searchEmail(String email) throws SQLException {
        PreparedStatement stmt;

        stmt = conn.prepareStatement("select email from users where email =?");
        stmt.setString(1, email);
        ResultSet res = stmt.executeQuery();
        return res.next();

    }

    public static boolean searchPhone(String phone) throws SQLException {
        PreparedStatement stmt;

        stmt = conn.prepareStatement("select phonenumber from users where phonenumber =?");
        stmt.setString(1, phone);
        ResultSet res = stmt.executeQuery();
        return res.next();

    }

    public static int getUserId(String email) throws SQLException {

        PreparedStatement stmt;
        stmt = conn.prepareStatement("select userid from users where email =?");
        stmt.setString(1, email);
        ResultSet res = stmt.executeQuery();
        while (res.next()) {
            return res.getInt("userid");

        }
        return -1;
    }

    public static int getUserBalance(String email) throws SQLException {

        PreparedStatement stmt;
        stmt = conn.prepareStatement("select creditlimit from users where email =?");
        stmt.setString(1, email);
        ResultSet res = stmt.executeQuery();
        while (res.next()) {
            return res.getInt("creditlimit");

        }
        return -1;
    }

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
            System.err.println("error : " + ex);
        }
        user.setUserId(-1);
        return user;
    }

    public static List<User> getAllUsers(){
        List<User> users = new ArrayList<User>();
        try {
            PreparedStatement stmt = DataHandling.getConnection().prepareStatement("SELECT userid, username, email, password, phonenumber, creditlimit FROM users");
            ResultSet res = stmt.executeQuery();
            while (res.next()) {
                users.add(new User(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getInt(6)));
            }
        } catch (SQLException ex) {
            System.err.println("error : " + ex);
        }
        return users;
    }

}
