<%-- 
    Document   : userLogin
    Created on : Mar 15, 2022, 5:41:14 PM
    Author     : Omar Samir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="/TechStore/validateUserLogin" method="POST">
            <div class="form-group">
                <label for="singin-email">Username or email address *</label>
                <input type="text" class="form-control" id="singin-email" name="singin-email" required>
            </div><!-- End .form-group -->

            <div class="form-group">
                <label for="singin-password">Password *</label>
                <input type="password" class="form-control" id="singin-password" name="singin-password" required>
            </div><!-- End .form-group -->

            <div class="form-footer">
                <button type="submit" class="btn btn-outline-primary-2">
                    <span>LOG IN</span>
                    <i class="icon-long-arrow-right"></i>
                </button>

                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="signin-remember">
                    <label class="custom-control-label" for="signin-remember">Remember Me</label>
                </div><!-- End .custom-checkbox -->

                <a href="#" class="forgot-link">Forgot Your Password?</a>
            </div><!-- End .form-footer -->
        </form>
    </body>
</html>
