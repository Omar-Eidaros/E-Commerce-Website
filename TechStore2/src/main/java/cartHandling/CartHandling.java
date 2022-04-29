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

            if (cartSesion.getAttribute("userId") != null) {
                switch (action) {
                    //adding new item or increase quantity of existing one
                    case "add":
                        CartItem ci = new CartItem(p, 1);
                        if (items != null) {
                            System.out.print("already session exist");
                            if (Cart.checkExistance(ci.getProductid())) {
                                Cart.repeatedElementCart(ci.getProductid());
                            } else {
                                System.err.println("newElement");
                                Cart.addToCart(ci);
                            }
                        } else {
                            Cart.addToCart(ci);
                            cartSesion.setAttribute("cartItems", Cart.getCartItems());
                            System.out.print("ADDEDD");

                        }

                        break;
                    //remove item from cart
                    case "remove":
                        Cart.removeFromCart(Integer.valueOf(itemId));

                        break;
                    //clear all cart
                    case "clear":
                        Cart.clearCart();
                        break;
                }
                x.print(gson.toJson(cartSesion.getAttribute("cartItems")));
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
