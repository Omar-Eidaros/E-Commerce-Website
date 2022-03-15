/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package handleValidationToDB;

import database.productManaging;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nora
 */
public class validateSearchProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            PrintWriter out = response.getWriter();
            productManaging PM = new productManaging();

            String category = request.getParameter("category");
            String min = request.getParameter("min");
            String max = request.getParameter("max");

            if (category != null && !category.isEmpty() && min != null && !min.isEmpty() && max != null && !max.isEmpty()) {
                PM.searchProduct(Integer.parseInt(min), Integer.parseInt(max), category);
                out.println("done");
            } else {
                out.println("erroe");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
