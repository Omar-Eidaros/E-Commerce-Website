/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Salma
 */
public class OrderHandling {

    private static Connection conn = DataHandling.getConnection();

    public static void insertNewOrder(Order order) throws SQLException {
        String insertQuery = "INSERT INTO orders (orderdate ,totalprice ,userid ,order_items )\n"
                + "                    VALUES (? ,? ,? ,? )";
        PreparedStatement insertStatement = conn.prepareStatement(insertQuery);
        insertStatement.setDate(1, order.getOrderDate());
        insertStatement.setInt(2, order.getTotalprice());
        insertStatement.setInt(3, order.getUserId());
        insertStatement.setArray(4, (Array) order.getProductIds());
        int isInsert = insertStatement.executeUpdate();
        if (isInsert > 0) {
            System.err.println("inserted");
        } else {
            System.err.println("insert error");
        }
    }

}
