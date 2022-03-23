<%-- 
    Document   : userLogin
    Created on : Mar 15, 2022, 5:41:14 PM
    Author     : Omar Samir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="database.User, database.userLoginHandling, database.MessageFromDB,java.sql.SQLException" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
            <%
                userLoginHandling ulh = new userLoginHandling();
                User account = new User();
                account.setEmail(request.getParameter("singin-email"));
                account.setPassword(request.getParameter("singin-password"));
                MessageFromDB ms = ulh.checkLogin(account);
                if (ms.getStatus()) {
                    response.sendRedirect("HomePage.html");
                }    
                else {
            %> 
                    <form action="userLogin.jsp" method="POST">
                    <div class="form-group">
                        <p style="color: red">Invalid Email or Password</p>
                        <%@include file="LoginForm.html" %> 
                    </div><!-- End .form-footer -->
                    </form>
            <%
                    }
            %>
        </form>
    </body>
</html>
