/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cartHandling;

import database.Product;
import java.io.InputStream;
import java.util.ArrayList;

/**
 *
 * @author Salma
 */
public class Cart {

    private static ArrayList<Product> cartItems = new ArrayList<Product>();

    public static ArrayList<Product> getCartItems() {
        return cartItems;
    }

    public static void setCartItems(ArrayList<Product> cartItems) {
        Cart.cartItems = cartItems;
    }

    public static void addToCart(Product p) {

        Cart.cartItems.add(p);

    }

    public static void deleteFromCart(Product p) {
        
        Cart.cartItems.remove(Cart.cartItems.indexOf(p));
    }

    public static void clearCart() {
        Cart.cartItems.clear();
    }

    public static boolean checkExistance(Product p) {

        for (Product pr : Cart.cartItems) {
            return pr.getProductid() == p.getProductid();

        }
        return false;}

}
