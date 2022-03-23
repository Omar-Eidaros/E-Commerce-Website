/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package handleValidationToDB;

import database.MessageFromDB;
import database.Product;
import database.productManaging;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author nora
 */
@MultipartConfig
public class validateEditProduct extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            productManaging PM = new productManaging();
            MessageFromDB res;
            Part filePart = request.getPart("image");
            InputStream inputStream = filePart.getInputStream();

            if (( filePart.getInputStream().read()) != -1) {
                Product product = new Product(Integer.parseInt(request.getParameter("productid")), request.getParameter("productname"), request.getParameter("description"), Integer.parseInt(request.getParameter("price")), request.getParameter("category"), inputStream, Integer.parseInt(request.getParameter("quantity")));
                res = PM.editProduct(product);
            } else {
                Product productWithOutImage = new Product(Integer.parseInt(request.getParameter("productid")), request.getParameter("productname"), request.getParameter("description"), Integer.parseInt(request.getParameter("price")), request.getParameter("category"), Integer.parseInt(request.getParameter("quantity")));
                res = PM.editProduct(productWithOutImage);

            }

            response.sendRedirect("admin/response.jsp?resMessage=" + res.getMessage() + "&resStatus=" + res.getStatus());

        } catch (Exception e) {
            System.out.println(e + " : error at validate edit product");
        }

    }

}
