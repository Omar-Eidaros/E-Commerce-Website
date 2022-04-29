<%-- 
    Document   : reviews
    Created on : Apr 27, 2022, 3:35:16 AM
    Author     : nora
--%>
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
            <div class="order">
                <div class="order-date">Order Date 20-1-2020 </div>
                <div class="review-products">
                    <div class="review-product">
                        <div class="media border p-3">
                            <img src="assets/images/demos/demo-11/logo.png" alt="John Doe" class="mr-3 mt-3 rounded-circle" style="width:60px;">
                            <div class="media-body">
                                <h4>Category <small><i>title</i></small></h4>
                                <p>discription.</p>
                                <form>
                                    <div class="rate">
                                        <input type="hidden" name="productid" value="1">
                                        <input type="hidden" name="orderid" value="1">
                                        <label>rates: </label>
                                        <input type="number" min="0" max="5" name="rates" />
                                        <button type="submit" class="btn btn-primary" onclick="setRatingToProduct()">Rate</button>
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

                    <div class="review-product">
                        <div class="media border p-3">
                            <img src="assets/images/demos/demo-11/logo.png" alt="John Doe" class="mr-3 mt-3 rounded-circle" style="width:60px;">
                            <div class="media-body">
                                <h4>Category <small><i>title</i></small></h4>
                                <p>discription.</p>
                                <form>
                                    <div class="rate">
                                        <input type="hidden" name="productid" value="1">
                                        <input type="hidden" name="orderid" value="1">
                                        <label>rates: </label>
                                        <input type="number" min="0" max="5" name="rates" />
                                        <button type="submit" class="btn btn-primary ">Rate</button>
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
                    <div class="review-product">
                        <div class="media border p-3">
                            <img src="assets/images/demos/demo-11/logo.png" alt="John Doe" class="mr-3 mt-3 rounded-circle" style="width:60px;">
                            <div class="media-body">
                                <h4>Category <small><i>title</i></small></h4>
                                <p>discription.</p>
                                <form>
                                    <div class="rate">
                                        <input type="hidden" name="productid" value="1">
                                        <input type="hidden" name="orderid" value="1">
                                        <label>rates: </label>
                                        <input type="number" min="0" max="5" name="rates" />
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

                </div>
                <div class="total-order">Total order 100LE</div>
            </div>



            <div class="order">
                <div class="order-date">Order Date 20-1-2020 </div>
                <div class="review-products">
                    <div class="review-product">
                        <div class="media border p-3">
                            <img src="assets/images/demos/demo-11/logo.png" alt="John Doe" class="mr-3 mt-3 rounded-circle" style="width:60px;">
                            <div class="media-body">
                                <h4>Category <small><i>title</i></small></h4>
                                <p>discription.</p>
                                <form>
                                    <div class="rate">
                                        <input type="hidden" name="productid" value="1">
                                        <input type="hidden" name="orderid" value="1">
                                        <label>rates: </label>
                                        <input type="number" min="0" max="5" name="rates" />
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


                    <div class="review-product">
                        <div class="media border p-3">
                            <img src="assets/images/demos/demo-11/logo.png" alt="John Doe" class="mr-3 mt-3 rounded-circle" style="width:60px;">
                            <div class="media-body">
                                <h4>title <small><i>Category</i></small></h4>
                                <p>discription.</p>
                                <form>
                                    <div class="rate">
                                        <input type="hidden" name="productid" value="1">
                                        <input type="hidden" name="orderid" value="1">
                                        <label>rates: </label>
                                        <input type="number" min="0" max="5"" name="rates" />
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
                </div>
                <div class="total-order">Total order 100LE</div>
            </div>


        </div>
    </div>
</main>

<%@ include file="footer.jsp" %>
