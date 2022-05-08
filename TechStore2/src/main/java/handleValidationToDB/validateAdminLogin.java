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
import javax.servlet.http.HttpSession;

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
            account = alh.checkAdminLogin(account);
            if (account.getAdminid() != -1) {
                HttpSession session = request.getSession(true);
                session.setAttribute("isAdminAuth", "true");
                session.setAttribute("adminId", account.getAdminid());
                session.setAttribute("email", account.getEmail());
                session.setAttribute("name", account.getAdminname());
                out.print("t");
                //response.sendRedirect("admin/displayProducts.jsp");
            } else {
                out.print("f");
            }
        } catch (SQLException ex) {
        }
    }

}
