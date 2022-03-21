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
    String message = request.getParameter("resMessage");
    String status = request.getParameter("resStatus");

%>


<!DOCTYPE html>


<%@ include file="headerAdmin.jsp" %>



<!--   search product   -->

<div class="container-fluid pt-4 px-4">
    <div class="row bg-light rounded align-items-center justify-content-center mx-0">
        <div style="text-align:center;margin: 35px 0 11px">

            .<% if (status.equalsIgnoreCase("true")) {%>
            <i class='far fa-grin-stars' style='font-size:50px;color:green'></i>
            <p style='font-size:50px;color:green'><%=message%></p>

            <% } else {%>
            <i class='far fa-window-close' style='font-size:50px;color:red'></i>
            <p style='font-size:50px;color:red'><%=message%></p>
            <% }%>



        </div>

    </div>
</div>

<%@ include file="footerAdmin.jsp" %>

