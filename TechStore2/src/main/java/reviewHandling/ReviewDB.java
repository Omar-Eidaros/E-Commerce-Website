/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reviewHandling;

import database.DataHandling;
import database.MongoDBHandler;
import database.Order;
import database.Product;
import database.Review;
import database.productManaging;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nora
 */
public class ReviewDB {

    private static Connection conn = DataHandling.getConnection();

    public static List<Order> getAllOrdersPerUser(int idUser) {
        List<Order> orders = new ArrayList<Order>();
        List<Product> products = null;

        try {
            PreparedStatement stmt = DataHandling.getConnection().prepareStatement("SELECT orderid, totalprice, orderdate, order_items FROM orders where userid=?");
            stmt.setInt(1, idUser);
            ResultSet res = stmt.executeQuery();
            while (res.next()) {
                Array idProducts = res.getArray(4);
                products = new ArrayList<Product>();
                Integer[] idProductsArr = (Integer[]) idProducts.getArray();
                for (int i = 0; i < idProductsArr.length; i++) {
                    Product p = new productManaging().getProductById(String.valueOf(idProductsArr[i]));
                    //String orderId, String userId, String productId
                    float rating = MongoDBHandler.retriveRatingOrderUserProduct(new Review(String.valueOf(res.getInt(1)), String.valueOf(idUser), String.valueOf(idProductsArr[i])));
                    p.setRating(rating);
                    products.add(p);
                }
                orders.add(new Order(res.getInt(1), res.getInt(2), res.getDate(3), products));
                products = null;

            }
        } catch (SQLException ex) {
            System.err.println("error : " + ex);
        }
        return orders;
    }
}
