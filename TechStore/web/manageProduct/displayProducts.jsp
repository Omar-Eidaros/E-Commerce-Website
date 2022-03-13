<%-- 
    Document   : displayProducts
    Created on : Mar 13, 2022, 1:26:20 AM
    Author     : nora
--%>

<%@page import="java.io.FileOutputStream"%>
<%@page import="java.util.Vector"%>
<%@page import="database.Product"%>
<%@page import="database.productManaging"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    productManaging PM = new productManaging();
    Vector<Product> products = PM.getALLProduct();
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All products</title>
    </head>
    <body>

        <form action="/TechStore/validateSearchProduct" method="GET">
            <label for="category">Category</label>
            <select id="category" name="category">
                                <option value="all">All</option>

                <option value="phone">Phone</option>
                <option value="laptob">Laptob</option>
            </select>
            <input type="range" min="0" max="499" value="20" class="range" name="min" id="min" />
            <input type="range" min="500" max="1000" value="20" class="range" name="max" id="max" />
            <input type="submit" value="search" />
        </form>

        <%   for (Product p : products) {%>
        <h1>product id : <%= p.getProductid()%> </h1>
        <h1>product name : <%= p.getProductname()%> </h1>
        <h1>description : <%= p.getDescription()%> </h1>
        <h1>price : <%= p.getPrice()%> </h1>
        <h1>category : <%= p.getCategory()%> </h1>
        <h1>image :  </h1>
        <%


        %>
        <img src="data:image/gif;base64,<%= p.getBase64Image()%> "/>
        <h1>quantity :  <%= p.getQuantity()%> </h1>
        <form action="/TechStore/validateDeleteProduct" method="GET">
            <input type="hidden" name="id" value=<%= p.getProductid()%> />
            <input type="submit"  value="delete"/>
        </form>
        <% }%>

    </body>
</html>
