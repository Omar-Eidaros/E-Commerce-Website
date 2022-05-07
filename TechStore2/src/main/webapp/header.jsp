<%-- 
    Document   : header
    Created on : Apr 4, 2022, 10:35:09 AM
    Author     : nora
--%>

<%@page import="com.google.gson.Gson"%>
<%@page import="cartHandling.CartItem"%>
<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<%
  
ArrayList<CartItem>items=(ArrayList<CartItem>)session.getAttribute("cartItems");
 GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
 String ci=gson.toJson(items);
%>

<!-- molla/index-11.html  22 Nov 2019 09:58:23 GMT -->
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Tech Store</title>
    <meta name="keywords" content="HTML5 Template">
    <meta name="description" content="Molla - Bootstrap eCommerce Template">
    <meta name="author" content="p-themes">
    <!-- Favicon -->
    <link rel="apple-touch-icon" sizes="180x180" href="assets/images/icons/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="assets/images/icons/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="assets/images/icons/favicon-16x16.png">
    <link rel="manifest" href="assets/images/icons/site.html">
    <link rel="mask-icon" href="assets/images/icons/safari-pinned-tab.svg" color="#666666">
    <link rel="shortcut icon" href="assets/images/icons/favicon.ico">
    <meta name="apple-mobile-web-app-title" content="Molla">
    <meta name="application-name" content="Molla">
    <meta name="msapplication-TileColor" content="#cc9966">
    <meta name="msapplication-config" content="assets/images/icons/browserconfig.xml">
    <meta name="theme-color" content="#ffffff">
    <link rel="stylesheet" href="assets/vendor/line-awesome/line-awesome/line-awesome/css/line-awesome.min.css">
    <!-- Plugins CSS File -->
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/plugins/owl-carousel/owl.carousel.css">
    <link rel="stylesheet" href="assets/css/plugins/magnific-popup/magnific-popup.css">
    <!-- Main CSS File -->
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/css/plugins/nouislider/nouislider.css">
    <link rel="stylesheet" href="assets/css/demos/demo-11.css">
    <link rel="stylesheet" href="/TechStore2/assets/css/register.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    
</head>

<body>
     <input type="hidden" id="sessionInfo" value=<%=ci%>>
    <div class="page-wrapper">
        <header class="header ">
            <div class="header-middle sticky-header">
                <div class="container">
                    <div class="header-left">
                        <button class="mobile-menu-toggler">
                            <span class="sr-only">Toggle mobile menu</span>
                            <i class="icon-bars"></i>
                        </button>
                        
                        <a href="index.html" class="logo">
                            <img src="assets/images/demos/demo-11/logo.png" alt="Molla Logo" width="82" height="25">
                        </a>
                    </div><!-- End .header-left -->

                    <div class="header-right">

                        <nav class="main-nav">
                            <ul class="menu sf-arrows">
                                <li class="megamenu-container active">
                                    <a href="index.jsp" class="sf-with-ul">Home</a>
                                </li>
                                <li>
                                    <a href="reviews.jsp" class="sf-with-ul">Reviews</a>
                                </li>
                                 <li><a href="/TechStore2/login.jsp"><i class="icon-user" style="user-select: auto;"></i>Login</a></li>

                            </ul><!-- End .menu -->
                        </nav><!-- End .main-nav -->
  
                        <div class="dropdown cart-dropdown">
                            <a href="#" class="dropdown-toggle" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" data-display="static">
                                <i class="icon-shopping-cart"></i>
                                <span class="cart-count" id="cart_count" style="user-select: auto;position: absolute;bottom: 76%;right: 13%;">0</span>
                                
                            </a>

            <div class="dropdown-menu dropdown-menu-right show"  style="user-select: auto;height: fit-content;">
                                <div class="dropdown-cart-products" id="cart-container" style="user-select: auto;">
                                    <div id="contain-product"></div>

                                <div class="dropdown-cart-total" style="user-select: auto;">
                                    <span style="user-select: auto;">Total</span>

                                    <span class="cart-total-price" id="total_price" style="user-select: auto;">$00.00</span>
                                </div><!-- End .dropdown-cart-total -->

                                <div class="dropdown-cart-action" style="user-select: auto;">
                                    <a href="cart.jsp" class="btn btn-primary" style="user-select: auto;">View Cart</a>
                                    <a href="checkout.html" class="btn btn-outline-primary-2" style="user-select: auto;"><span style="user-select: auto;">Checkout</span><i class="icon-long-arrow-right" style="user-select: auto;"></i></a>
                                </div><!-- End .dropdown-cart-total -->
                            </div>
                       
                        </div><!-- End .cart-dropdown -->
                    </div><!-- End .header-right -->
                </div><!-- End .container -->
            </div><!-- End .header-middle -->
        </header><!-- End .header -->
       <!-- comment -->
       <script>
         window.onload=load()
         function load (){
          $.getScript("assets/scripts/cart.js",function(){
        var cartItems=$("#sessionInfo").val();
        displayCart(JSON.parse(cartItems))
    });}
       </script>
      
