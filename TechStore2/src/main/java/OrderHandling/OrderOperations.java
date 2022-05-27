/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OrderHandling;

import cartHandling.CartItem;
import database.Product;
import database.productManaging;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Salma
 */
public class OrderOperations {

    public static void ChangeItemsQuatity(ArrayList<CartItem> orderItems) {
        try {
            productManaging pm = new productManaging();
            for (CartItem c : orderItems) {
                Product p = pm.getProductById(String.valueOf(c.getProductid()));
                c.setQuantity(p.getQuantity() - c.getProdq());
                p.setQuantity(p.getQuantity() - c.getProdq());
                pm.editProduct(p);
            }
        } catch (SQLException e) {
            System.out.println("OrderHandling.OrderOperations.ChangeItemsQuatity()" + e.getMessage());
        }

    }
}
