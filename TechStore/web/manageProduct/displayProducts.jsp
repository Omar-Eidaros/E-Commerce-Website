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
        <%   for (Product p : products) { %>
        <h1>product id : <%= p.getProductid()%> </h1>
        <h1>product name : <%= p.getProductname() %> </h1>
        <h1>description : <%= p.getDescription()%> </h1>
        <h1>price : <%= p.getPrice()%> </h1>
        <h1>category : <%= p.getCategory()%> </h1>
        <h1>image :  </h1>
        <%
        
        
        %>
        <img src="data:image/gif;base64,+<%= p.getBase64Image()%>+"/>
        <h1>quantity :  <%= p.getQuantity()%> </h1>
        <% }%>

    </body>
</html>
