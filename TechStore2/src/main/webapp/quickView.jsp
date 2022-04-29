<%-- 
    Document   : quickView
    Created on : Apr 27, 2022, 2:07:30 AM
    Author     : nora
--%>
<%@page import="java.util.Base64"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.sql.Connection"%>
<%@ include file="header.jsp" %>
<%@page import="database.DataHandling"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String productid = request.getParameter("id");
    Connection conn = DataHandling.getConnection();
    try {
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM products WHERE productid = ? ");
        stmt.setInt(1, Integer.parseInt(productid));
        ResultSet res = stmt.executeQuery();
        while (res.next()) {

            InputStream inputStream = res.getBinaryStream("image");
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead = -1;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            byte[] imageBytes = outputStream.toByteArray();
            String base64Image = "data:image/gif;base64," + Base64.getEncoder().encodeToString(imageBytes);

%>
<main class="main">
    <div class="container quickView-container">
        <div class="quickView-content">
            <div class="row">
                <div class="col-lg-7 col-md-6">
                    <div class="row">
                        <div class="product-left">
                            <a href="#one" class="carousel-dot active">
                                <img id="productImage" src=<%=base64Image%>  >
                            </a>
                        </div>
                        <div class="product-right">
                            <div class="owl-carousel owl-theme owl-nav-inside owl-light mb-0" data-toggle="owl" data-owl-options='{
                                 "dots": false,
                                 "nav": false, 
                                 "URLhashListener": true,
                                 "responsive": {
                                 "900": {
                                 "nav": true,
                                 "dots": true
                                 }
                                 }
                                 }'>

                                <div class="intro-slide" data-hash="one">
                                    <img src=<%=base64Image%>>
                                </div><!-- End .intro-slide -->

                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-5 col-md-6">
                    <h2 class="product-title" id="productTitle"><%=res.getString(2)%></h2>
                    <h3 class="product-price" id="productPrice"><%=res.getString(4)%></h3>

                    <div class="ratings-container">
                        <div class="ratings">
                            <div class="ratings-val" style="width: 20%;"></div><!-- End .ratings-val -->
                        </div><!-- End .ratings -->
                        <span class="ratings-text" id="productRating">( 2 Reviews )</span>
                    </div><!-- End .rating-container -->

                    <p class="product-txt" id="productDescription"><%=res.getString(3)%></p>





                    <!--                    <div class="details-filter-row details-row-size">
                                            <label for="qty">Qty:</label>
                                            <div class="product-details-quantity">
                                                <input type="number" id="qty" class="form-control" value="1" min="1" max="10" step="1" data-decimals="0" required>
                                            </div> End .product-details-quantity 
                                        </div> End .details-filter-row -->

                    <div class="product-details-action" onclick=<%=productid%>>
                        <a href="#" class="btn-product btn-cart" ><span>add to cart</span></a>
                    </div>

                </div>
            </div>
        </div>
    </div>
</main>

<%
        }
        res.close();
        res = null;
    } catch (Exception e) {
        out.println(e);
    }
%>
<%@ include file="footer.jsp" %>
