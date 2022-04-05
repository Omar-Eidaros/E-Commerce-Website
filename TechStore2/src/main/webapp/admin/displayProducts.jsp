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

    #contain-all-cards{
        display: flex;
        flex-flow: wrap;
        gap: 13px 1px;
    }

</style>


    <script type="text/javascript" src="js/scriptForDisplayProducts.js"></script>



<!--   search product   -->

<div class="container-fluid pt-4 px-4">
    <div class="row bg-light  rounded align-items-center justify-content-center mx-0" id="display-search">

        <div class="search">
            <form id="searchForm">

                <label for="category" >Category</label>
                <select class="form-select" aria-label="Default select example" id="category" name="category" >
                    <option value="all" >All</option>
                    <option value="phone" >Phone</option>
                    <option value="laptob">Laptop</option>
                </select>                       

                <div class="select-price">
                    <p>  <span>From</span>   <span id="price-from">20</span> </p>
                    <input type="range" min="0" max="499"  class="range" name="min" id="min" onchange="show_value('price-from', this.value)" value="20" /> 
                </div>
                <div class="select-price">
                    <p> <span>To</span>   <span id="price-to">550</span> </p>
                    <input type="range" min="500" max="1000"  class="range" name="max" id="max" onchange="show_value('price-to', this.value)" value="550" />
                </div>

                <input type="button" class="btn btn-primary m-2" id="btnSearch" onclick="getQueryFromSearch()" value="search" />
            </form>
        </div>
        <!--   display products   -->
        <div id="contain-all-cards"></div>


    </div>
</div>

<%@ include file="footerAdmin.jsp" %>

