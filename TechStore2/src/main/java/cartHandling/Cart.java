/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cartHandling;

import java.util.ArrayList;

/**
 *
 * @author Salma
 */
public class Cart {

    private static ArrayList<CartItem> cartItems = new ArrayList<CartItem>();

    public static ArrayList<CartItem> getCartItems() {
        return cartItems;
    }

    public static void setCartItems(ArrayList<CartItem> cartItems) {
        Cart.cartItems = cartItems;
    }

    public static void addToCart(CartItem c) {

        Cart.cartItems.add(c);

    }

    public static void repeatedElementCart(int id) {
        for (CartItem pr : Cart.cartItems) {
            if (pr.getProductid() == id) {
                pr.setQuantity(pr.getQuantity() + 1);
            }

        }

    }

    public static void removeFromCart(int id) {
        for (CartItem pr : Cart.cartItems) {
            if (pr.getProductid() == id) {
                Cart.cartItems.remove(pr);
                break;

            }
        }
    }

    public static void clearCart() {
        Cart.cartItems.clear();
    }

    public static boolean checkExistance(int id) {

        for (CartItem pr : Cart.cartItems) {
            if (pr.getProductid() == id) {
                return true;

            }
        }
        return false;
    }

}
