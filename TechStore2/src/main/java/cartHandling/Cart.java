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

    private ArrayList<CartItem> cartItems = new ArrayList<CartItem>();

    public Cart() {
        cartItems.clear();
    }

    public ArrayList<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(ArrayList<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public void addToCart(CartItem c) {

        this.cartItems.add(c);

    }

    public void repeatedElementCart(int id) {
        for (CartItem pr : this.cartItems) {
            if (pr.getProductid() == id) {
                pr.setQuantity(pr.getQuantity() + 1);
            }

        }

    }

    public void removeFromCart(int id) {
        for (CartItem pr : this.cartItems) {
            if (pr.getProductid() == id) {
                this.cartItems.remove(pr);
                break;

            }
        }
    }

    public void clearCart() {
        this.cartItems.clear();
    }

    public boolean checkExistance(int id) {

        for (CartItem pr : this.cartItems) {
            if (pr.getProductid() == id) {
                return true;

            }
        }
        return false;
    }

    public int getTotalCost() {
        int total = 0;
        for (CartItem ci : this.cartItems) {
            total += ci.getPrice();
            System.err.println(total);
        }
        return total;
    }
}
