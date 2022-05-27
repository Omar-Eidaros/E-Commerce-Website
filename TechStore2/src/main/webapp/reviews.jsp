<%-- 
    Document   : reviews
    Created on : Apr 27, 2022, 3:35:16 AM
    Author     : nora
--%>
<%@page import="database.Product"%>
<%@page import="java.util.List"%>
<%@page import="database.Order"%>
<%@page import="reviewHandling.ReviewDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
    .orders{
        background-color: #e4e4e447;
        border-radius: 25px;
        padding: 25px;
    }
    .order{
        background-color: #fff;
        padding: 10px 15px 0;
        border-radius: 15px 15px 0 0;
        margin-bottom: 10px;
    }
    .order-date{
        font-size: 18px;
        font-weight: 600;
        text-align: center;
    }
    .review-product{
        margin-bottom: 10px;
    }
    .total-order{
        text-align: end;
        font-size: 17px;
    }
    .rating {
        display: flex;
        flex-direction: row-reverse;
    }

    .rating > input{
        display:none;
    }

    .rating > label {
        position: relative;
        width: 1.1em;
        font-size: 19px;
        color: orange;
        cursor: pointer;
    }

    .rating > label::before{
        content: "\2605";
        position: absolute;
        opacity: 0;
    }

    .rating > label:hover:before,
    .rating > label:hover ~ label:before {
        opacity: 1 !important;
    }

    .rating > input:checked ~ label:before{
        opacity:1;
    }

    .rating:hover > input:checked ~ label:before{
        opacity: 0.4;
    }
    .rate
    {
        text-align: end;
        display: flex;
        place-items: baseline;
        gap: 5px;
        justify-content: end;
    }

    .input-spinner {
        width: 80px;
    }

</style>
<main class="main">
    <div class="container quickView-container">
        <div class="orders">

            <%
                int id = (int) session.getAttribute("userId");
                List<Order> orders = ReviewDB.getAllOrdersPerUser(id);
                for (Order o : orders) {
            %>

            <div class="order">
                <div class="order-date">Order Date <%=o.getOrderDate()%> </div>
                <div class="review-products">
                    <% for (Product p : o.getProducts()) {%>
                    <div class="review-product">
                        <div class="media border p-3">
                            <img src="data:image/gif;base64,<%=p.getBase64Image()%>" alt="John Doe" class="mr-3 mt-3 rounded-circle" style="width:60px;">
                            <div class="media-body">
                                <h4>Category <%= p.getCategory()%> <small><i><%= p.getProductname()%></i></small></h4>
                                <p><%= p.getDescription()%>.</p>
                                <form action="/TechStore2/validateAddRating" method="post">
                                    <div class="rate">
                                        <input type="hidden" name="productid" value="<%= p.getProductid()%>">
                                        <input type="hidden" name="orderid" value="<%= o.getOrderId()%>">
                                        <input type="hidden" name="userid" value="<%=id%>">

                                        <label>rates: </label>
                                        <input type="number" min="0" value="<%=p.getRating()%>" max="5" name="rates" required/>
                                        <button type="submit" class="btn btn-primary">Rate</button>
                                        <!--<input type="radio" name="rating" value="5" id="5"><label for="5">☆</label>-->
                                        <!--<input type="radio" name="rating" value="4" id="4"><label for="4">☆</label>-->
                                        <!--<input type="radio" name="rating" value="3" id="3"><label for="3">☆</label>-->
                                        <!--<input type="radio" name="rating" value="2" id="2"><label for="2">☆</label>-->
                                        <!--<input type="radio" name="rating" value="1" id="1"><label for="1">☆</label>-->
                                    </div>
                                </form>
                            </div>
                        </div>

                    </div>
                    <% }%>
                </div>
                <div class="total-order">Total order <%= o.getTotalprice()%>LE</div>
            </div>
            <% }%>

        </div>
    </div>
</main>

<%@ include file="footer.jsp" %>


//
//        <script>
//
//
//            let form = document.getElementsByClassName("addReviewToOneProduct");
//
//
//            const  submitvalidation = (e) => {
//                e.preventDefault();
//                values = $("#addReviewToOneProduct").serialize();
//                $.ajax({
//                    url: '/TechStore2/validateAddRating',
//                    method: 'POST',
//                    data: values,
//                    success:
//                            function (resultText) {
//                                if (resultText[0] == "t") {
//                                    alert("Done")
//                                } else {
//                                    alert("Error")
//                                }
//                            },
//                    error: function (jqXHR, exception) {
//
//                    }
//                }
//                );
//            }
//
//            form.addEventListener("submit", submitvalidation);
//
//
//
//        </script>


<%@include file="footerBody.jsp" %>