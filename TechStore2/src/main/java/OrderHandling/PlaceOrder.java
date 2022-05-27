/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package OrderHandling;

import cartHandling.Cart;
import cartHandling.CartItem;
import database.Order;
import database.OrderHandling;
import database.UserManager;
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
public class PlaceOrder extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

        }
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
        try {
            PrintWriter out = response.getWriter();
            HttpSession ses = request.getSession(false);
            String shipping = (String) ses.getAttribute("shipping");
            ArrayList<CartItem> orderItems = (ArrayList<CartItem>) ses.getAttribute("cartItems");
            String tot = (String) ses.getAttribute("totalprice");
            int balance = (int) ses.getAttribute("balance");
            int id = (int) ses.getAttribute("userId");
            long millis = System.currentTimeMillis();
            java.sql.Date orderDate = new java.sql.Date(millis);
            int total = Integer.valueOf(shipping) + Integer.valueOf(tot);
            if (total <= balance) {
                UserManager.editUser(balance - total, id);
                Order ordered = new Order(id, Cart.getItemsId(orderItems), total, orderDate);
                OrderHandling.insertNewOrder(ordered);
                OrderOperations.ChangeItemsQuatity(orderItems);
                orderItems.clear();
                ses.setAttribute("cartItems", orderItems);
                ses.setAttribute("totalprice", "0");
                ses.setAttribute("shipping", "0");
                out.print("okay");
            } else if (total == 0) {
                out.print("nothing");

            } else {
                out.print("notokay");
            }
        } catch (SQLException e) {
            System.out.println("OrderHandling.PlaceOrder.doGet()" + e.getMessage());
        }

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
