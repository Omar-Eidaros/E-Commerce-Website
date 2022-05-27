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

    String message;

    private ArrayList<CartItem> cartItems = new ArrayList<CartItem>();

    public Cart() {
        this.cartItems.clear();
    }

    public Cart(String message, ArrayList<CartItem> c) {
        this.message = message;
        this.cartItems = c;
    }

    public Cart(ArrayList<CartItem> c) {

        this.cartItems = c;
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
                if (pr.getProdq() + 1 <= pr.getQuantity()) {
                    pr.setProdq(pr.getProdq() + 1);

                } else {
                    pr.setProdq(pr.getQuantity());
                }
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

    public int size() {
        return this.cartItems.size();
    }

    public void decFromCart(int id) {
        for (CartItem pr : this.cartItems) {
            if (pr.getProductid() == id) {
                if (pr.getProdq() - 1 > 0) {
                    pr.setProdq(pr.getProdq() - 1);
                    break;
                } else {
                    this.cartItems.remove(pr);
                    break;
                }
            }

        }
    }

    public static ArrayList<Integer> getItemsId(ArrayList<CartItem> cart) {

        ArrayList<Integer> items = new ArrayList<>();
        for (CartItem c : cart) {
            items.add(c.getProductid());
        }
        return items;
    }
}
