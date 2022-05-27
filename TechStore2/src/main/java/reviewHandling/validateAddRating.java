/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package reviewHandling;

import database.Admin;
import database.MongoDBHandler;
import database.Review;
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
 * @author nora
 */
public class validateAddRating extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        Review review = new Review(request.getParameter("orderid"), request.getParameter("userid"),
        request.getParameter("productid"), Integer.parseInt(request.getParameter("rates")));
        MongoDBHandler.addNewReview(review);
        response.sendRedirect("reviews.jsp");

    }

}
