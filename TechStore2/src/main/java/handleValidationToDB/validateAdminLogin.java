/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package handleValidationToDB;

import database.Admin;
import database.MessageFromDB;
import database.adminLoginHandling;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Omar Samir
 */
public class validateAdminLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        adminLoginHandling alh = new adminLoginHandling();
        Admin account = new Admin();

        account.setEmail(request.getParameter("singin-email"));
        account.setPassword(request.getParameter("singin-password"));

        try {
            MessageFromDB ms = alh.checkAdminLogin(account);
            if (ms.getStatus()) {
                response.sendRedirect("index.html");
            } else {
                response.sendRedirect("erroradminlogin.html");
            }
        } catch (SQLException ex) {
        }
    }

}
