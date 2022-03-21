/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Salma
 */
public class DataHandling {

    private static String dataBaseUrl = "jdbc:postgresql://bnxyowyoaextmuwl1mr0-postgresql.services.clever-cloud.com:5432/bnxyowyoaextmuwl1mr0";
    private static String userName = "uowc5i0hurqszsjbk8za";
    private static String dataBasePassword = "q1nNa5inzQt7hodysREq";
    private static Connection connection = null;

    public static void startConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(DataHandling.dataBaseUrl, DataHandling.userName, DataHandling.dataBasePassword);
        System.out.println("successfully connected");

    }

    public static void closeConnection() throws SQLException {
        DataHandling.connection.close();
        DataHandling.connection = null;
    }

    public static Connection getConnection() {
        return connection;
    }

}
