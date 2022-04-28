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
            String itemId = request.getParameter("add_cart");
            HttpSession cartSesion = request.getSession(false);
            productManaging pm = new productManaging();
            Product p = pm.getProductById(itemId);
            int quantity = 1;
            p.setQuantity(quantity);
             
            ArrayList<Product> cartItems = (ArrayList<Product>) cartSesion.getAttribute("cartItems");
            if (cartItems == null) {
                 cartSesion.setAttribute("cartItems", Cart.getCartItems());
                Cart.addToCart(p);
               
               
            } else {
                
                  Cart.setCartItems(cartItems);
                if (Cart.checkExistance(p)) {
                     Cart.deleteFromCart(p);
                    
                } else {
                   Cart.addToCart(p);
                      
                }
            }
           
             x.print(cartSesion.getAttribute("cartItems"));
          
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
