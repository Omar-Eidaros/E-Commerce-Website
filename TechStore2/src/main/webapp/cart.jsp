<%-- 
    Document   : cart
    Created on : May 7, 2022, 3:17:13 PM
    Author     : Salma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include  file="header.jsp" %>
<script src="assets/scripts/viewCartItems.js"></script>

<body>
    <main class="main">
        <div class="page-header text-center" style="background-image: url('assets/images/page-header-bg.jpg')">
            <div class="container">
                <h1 class="page-title">Shopping Cart<span>Shop</span></h1>
            </div><!-- End .container -->
        </div><!-- End .page-header -->
        <nav aria-label="breadcrumb" class="breadcrumb-nav">
            <div class="container">
                <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
                        <li class="breadcrumb-item"><a href="index.jsp">Shop</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Shopping Cart</li>
                </ol>
            </div><!-- End .container -->
        </nav><!-- End .breadcrumb-nav -->




            <div class="page-content">
            	<div class="cart">
	                <div class="container">
	                	<div class="row">
	                		<div class="col-lg-9">
	                			<table class="table table-cart table-mobile">
									<thead>
										<tr>
											<th>Product</th>
											<th>Price</th>
											<th>Quantity</th>
											<th>Total</th>
											<th></th>
										</tr>
									</thead>

                                                                        <tbody id="rows">
										
                                                                        </tbody>
								</table><!-- End .table table-wishlist -->

	                			
			            			
                                                                <button  id="clear" class="btn btn-outline-dark-2" ><span onclick="clearIt()">CLEAR CART</span><i class="icon-refresh"></i></button>
		            			
	                		</div><!-- End .col-lg-9 -->
	                		<aside class="col-lg-3">
	                			<div class="summary summary-cart">
	                				<h3 class="summary-title">Cart Total</h3><!-- End .summary-title -->

	                				<table class="table table-summary">
	                					<tbody>
                                                                <form>
	                						<tr class="summary-subtotal">
	                							<td>Subtotal:</td>
                                                                        <input type="hidden" name="sub" id="sub">
                                                                                <td ><span>$</span><span id="subTotal">0</span></td>
	                						</tr><!-- End .summary-subtotal -->
	                						<tr class="summary-shipping">
	                							<td>Shipping:</td>
	                							<td>&nbsp;</td>
	                						</tr>

	                						<tr class="summary-shipping-row">
	                							<td>
													<div class="custom-control custom-radio">
                                                                                                            <input type="radio" id="free-shipping" name="shipping" value="0" class="custom-control-input" onclick="getship(this.id)"required>
														<label class="custom-control-label" for="free-shipping">Free Shipping</label>
													</div><!-- End .custom-control -->
	                							</td>
	                							<td>$0.00</td>
	                						</tr><!-- End .summary-shipping-row -->

	                						<tr class="summary-shipping-row">
	                							<td>
	                								<div class="custom-control custom-radio">
                                                                                            <input type="radio" id="standart-shipping" name="shipping" value="10" class="custom-control-input" onclick="getship(this.id)" required >
														<label class="custom-control-label" for="standart-shipping">Standard:</label>
													</div><!-- End .custom-control -->
	                							</td>
	                							<td>$10.00</td>
	                						</tr><!-- End .summary-shipping-row -->

	                						<tr class="summary-shipping-row">
	                							<td>
	                								<div class="custom-control custom-radio">
                                                                                            <input type="radio" id="express-shipping" name="shipping" value="20" class="custom-control-input" onclick="getship(this.id)" required>
														<label class="custom-control-label" for="express-shipping">Express:</label>
													</div><!-- End .custom-control -->
	                							</td>
	                							<td>$20.00</td>
	                						</tr><!-- End .summary-shipping-row -->

	                						

	                						<tr class="summary-total">
	                							<td>Total:</td>
                                                                                 <input type="hidden" name="total" id="tot">
                                                                                <td ><span >$</span><span id="total">0</span></td>
                                                                              
	                						</tr><!-- End .summary-total -->
	                					</tbody>
	                				</table><!-- End .table table-summary -->

                                                        <a href="#" id="check2" class="btn btn-outline-primary-2 btn-order btn-block">PROCEED TO CHECKOUT</a>
	                			</div><!-- End .summary -->

		            			<a href="index.jsp" class="btn btn-outline-dark-2 btn-block mb-3"><span>CONTINUE SHOPPING</span><i class="icon-refresh"></i></a>
	                		</aside><!-- End .col-lg-3 -->
	                	</div><!-- End .row -->
	                </div><!-- End .container -->
                </div><!-- End .cart -->
            </div><!-- End .page-content -->
        </main><!-- End .main -->
        <script>
            $("#check2").on('click',function(){
               
                var total=$("#total").html();
                var shipping=0;
                if ($('input[name="shipping"]:checked').length > 0) {
                    shipping=$('input[name="shipping"]:checked').val();
}
            $.post("handlingCheckout",{orderPrice:total,shipping:shipping}, function(data, status){
                console.log(data)
                     window.location = 'Checkout.jsp';
  });
             
            });
        </script>

    <%@include file="footer.jsp" %>
<%@include file="footerBody.jsp" %>