/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package handleValidationToDB;

import java.io.IOException;
//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.User;
import database.userLoginHandling;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Omar Samir
 */
public class validateUserLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //PrintWriter out = response.getWriter();
            User account = new User();

            account.setEmail(request.getParameter("singin-email"));
            account.setPassword(request.getParameter("singin-password"));

            User user = userLoginHandling.checkLogin(account);

            if (user.getUserId() != -1) {
                HttpSession session = request.getSession(true);
                session.setAttribute("isAuth", "true");
                session.setAttribute("userId", user.getUserId());
                session.setAttribute("email", user.getEmail());
                session.setAttribute("name", user.getName());
                session.setAttribute("balance", user.getCreditLimit());
                response.sendRedirect("index.jsp");

            } else {
                response.sendRedirect("login.jsp?isLogin=false");
            }
        } catch (SQLException ex) {
        }
    }
}
