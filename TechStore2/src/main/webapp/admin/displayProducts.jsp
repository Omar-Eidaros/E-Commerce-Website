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

    String displayPriceFrom = request.getParameter("min") == null ? "20" : request.getParameter("min");
    String displayPriceTo = request.getParameter("max") == null ? "550" : request.getParameter("max");
%>


<!DOCTYPE html>


<%@ include file="headerAdmin.jsp" %>


<style>
    .card {
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
        max-width: 300px;
        margin: auto;
        text-align: center;
        font-family: arial;
        padding: 0px
    }

    .price {
        color: green;
        font-size: 22px;
    }

    .txt-blue {
        color: #009CFF ;
        font-size: 19px;
    }

    .btns {
        display: flex;
        place-content: center;
    }
    .search{
        background-color: #FFF;
        padding: 5px 10px;
        border-radius: 16px;
        margin: 20px 0px 10px;
        display: flow-root;
        width: 90%;
    }

    .search .form-select
    {
        width: 25%;
        display:initial;
    }

    .search form
    {
        display: flex;
        gap: 15px;
        justify-content: center;
        place-items: center;
    }

    .select-price p
    {
        margin: 0;
        text-align: center;
    }

</style>


<script>
    function show_value(which, val)
    {
        document.getElementById(which).innerHTML = val;
    }
</script>
<!--   search product   -->

<div class="container-fluid pt-4 px-4">
    <div class="row bg-light rounded align-items-center justify-content-center mx-0">

        <div class="search">
            <form action="displayProducts.jsp" method="GET">

                <label for="category" >Category</label>
                <select class="form-select" aria-label="Default select example" id="category" name="category" >
                    <option value="all" >All</option>
                    <option value="phone" >Phone</option>
                    <option value="laptob">Laptob</option>
                </select>                       

                <div class="select-price">
                    <p>  <span>From</span>   <span id="price-from"><%=displayPriceFrom%></span> </p>
                    <input type="range" min="0" max="499"  class="range" name="min" id="min" onchange="show_value('price-from', this.value)" value=<%=displayPriceFrom%> /> 
                </div>
                <div class="select-price">
                    <p> <span>To</span>   <span id="price-to"><%=displayPriceTo%></span> </p>
                    <input type="range" min="500" max="1000"  class="range" name="max" id="max" onchange="show_value('price-to', this.value)" value=<%=displayPriceTo%> />
                </div>

                <input type="submit" class="btn btn-primary m-2" value="search" />
            </form>
        </div>
        <!--   display products   -->


        <%   for (Product p : products) {%>


        <div class="card">
            <img src="data:image/gif;base64,<%= p.getBase64Image()%> " alt=<%= p.getProductid()%> style="width:100%">
            <h4><%= p.getProductname()%></h4>
            <p class="price">LE <%= p.getPrice()%></p>
            <p><%= p.getDescription()%></p>
            <p class="txt-blue">Category <%= p.getCategory()%></p>
            <p class="txt-blue">Quantity <%= p.getQuantity()%></p>

            <!--to delete product-->
            <div class="btns">
                <form action="/TechStore/validateDeleteProduct" method="GET">
                    <input type="hidden" name="id" value=<%= p.getProductid()%> />
                    <input type="submit" class="btn btn-danger m-2"  value="delete"/>
                </form>

                <!--to edit product-->
                <form action="addProduct.jsp" method="GET">
                    <input type="hidden" name="id" value=<%= p.getProductid()%> />
                    <input type="hidden" name="productname" value=<%= p.getProductname()%> />
                    <input type="hidden" name="description" value=<%= p.getDescription()%> />
                    <input type="hidden" name="price" value=<%= p.getPrice()%> />
                    <input type="hidden" name="category" value=<%= p.getCategory()%> />
                    <input type="hidden" name="quantity" value=<%= p.getQuantity()%> />
                    <input type="submit" class="btn btn-warning m-2" value="Edit"/>
                </form>
            </div>
        </div>
        <% }%>

    </div>
</div>

<%@ include file="footerAdmin.jsp" %>

