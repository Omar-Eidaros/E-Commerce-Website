/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package handleValidationToDB;

import com.google.gson.Gson;
import database.MessageFromDB;
import database.Product;
import database.productManaging;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nora
 */
public class validateDisplayProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            PrintWriter out = response.getWriter();
            productManaging PM = new productManaging();

            String whichCategory = request.getParameter("category");
            String whichPriceFrom = request.getParameter("min");
            String whichPriceTo = request.getParameter("max");

            if (request.getParameter("category") == null || request.getParameter("category").equalsIgnoreCase("all")) {
                whichCategory = "all";
            }
            if (request.getParameter("min") == null) {
                whichPriceTo = "-1";
            }

            if (request.getParameter("max") == null) {
                whichPriceFrom = "-1";
            }

            Vector<Product> products = PM.searchProduct(Integer.parseInt(whichPriceFrom), Integer.parseInt(whichPriceTo), whichCategory);
            Gson gson = new Gson();
            String allProducts = gson.toJson(products);
            out.println(allProducts);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
