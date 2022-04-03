/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package registerHandling;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Salma
 */
public class Registeration extends HttpServlet {

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
        processRequest(request, response);
           try {
            PrintWriter out = response.getWriter();
            processRequest(request, response);
            String name = request.getParameter("username");
            String email = request.getParameter("register-email");
            String password = request.getParameter("register-password");
            String birthDate = request.getParameter("register-date");
            String phone = request.getParameter("register-phone");
            String city = request.getParameter("city");
            String street = request.getParameter("street");
            String intersets[] = request.getParameterValues("interests");
            String job = request.getParameter("register-job");

           String checkError = RegisterValidation.checkError(name, email, password, birthDate, phone, intersets, job, street, city);
            if ("".equals(checkError)){
             //   RequestDispatcher rd=request.getRequestDispatcher("/TechStore2/UserRegistration/CodeValidation.jsp");
             //   rd.forward(request, response);
                //UserManager.RegisterNewUser(name, email, password, Date.valueOf(birthDate), phone, intersets, job, street, city);
            }else{
            
            out.println(checkError);
            }
           
          
        } catch (SQLException ex) {
            Logger.getLogger(Registeration.class
                    .getName()).log(Level.SEVERE, null, ex);
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
