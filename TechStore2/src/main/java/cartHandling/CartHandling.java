/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cartHandling;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import database.Product;
import database.productManaging;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Salma
 */
public class CartHandling extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        PrintWriter x = response.getWriter();
        try {
            processRequest(request, response);
            String itemId = request.getParameter("cart_item");
            String action = request.getParameter("action");
            HttpSession cartSesion = request.getSession(false);
            productManaging pm = new productManaging();

            Product p = pm.getProductById(itemId);
            ArrayList<CartItem> items = (ArrayList<CartItem>) cartSesion.getAttribute("cartItems");
            Cart cartArr = new Cart();
            int cash = (int) cartSesion.getAttribute("balance");

            if (cartSesion.getAttribute("userId") != null) {
                switch (action) {
                    //adding new item or increase quantity of existing one
                    case "add":
                        CartItem ci = new CartItem(p, 1);
                        if (items != null) {
                            cartArr.setCartItems(items);
                            if (cartArr.getTotalCost() + ci.getPrice() > cash) {
                                System.err.println("exceeded balace");
                                x.println(gson.toJson(new Cart("balance exceeded", cartArr.getCartItems())));
                            } else {
                                if (cartArr.checkExistance(ci.getProductid())) {
                                    cartArr.repeatedElementCart(ci.getProductid());
                                    x.println(gson.toJson(new Cart("increase quantity", cartArr.getCartItems())));
                                } else {
                                    System.err.println("newElement");
                                    cartArr.addToCart(ci);
                                    x.println(gson.toJson(new Cart("added", cartArr.getCartItems())));
                                }
                            }
                        } else {

                            cartArr.addToCart(ci);
                            cartSesion.setAttribute("cartItems", cartArr.getCartItems());
                            x.println(gson.toJson(new Cart("added", cartArr.getCartItems())));

                        }

                        break;
                    //remove item from cart
                    case "remove":
                        cartArr.setCartItems(items);
                        System.err.println("removed");
                        cartArr.removeFromCart(Integer.valueOf(itemId));
                        x.println("{\"totalcost\":" + cartArr.getTotalCost() + ",\"count\":" + cartArr.size() + "}");
                        break;
                    //clear all cart
                    case "clear":
                        cartArr.setCartItems(items);
                        cartArr.clearCart();
                        break;
                }

            } else {
                System.out.print("notlogged");

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
