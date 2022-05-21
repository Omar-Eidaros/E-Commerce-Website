<%-- 
    Document   : Checkout
    Created on : May 21, 2022, 1:34:41 PM
    Author     : Salma
--%>

<%@page import="database.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="header.jsp" %>
<%
    int id= (int)session.getAttribute("userId");
    User user=database.UserManager.getUserById(id);
    System.out.println(user);
%>
        <main class="main">
        	<div class="page-header text-center" style="background-image: url('assets/images/page-header-bg.jpg')">
        		<div class="container">
        			<h1 class="page-title">Checkout<span>Shop</span></h1>
        		</div><!-- End .container -->
        	</div><!-- End .page-header -->
            <nav aria-label="breadcrumb" class="breadcrumb-nav">
                <div class="container">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                        <li class="breadcrumb-item"><a href="#">Shop</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Checkout</li>
                    </ol>
                </div><!-- End .container -->
            </nav><!-- End .breadcrumb-nav -->

            <div class="page-content">
            	<div class="checkout">
	                <div class="container">
            			<div class="checkout-discount">
            				<form action="#">
        						
            					
            				</form>
            			</div><!-- End .checkout-discount -->
            			<form action="#">
		                	<div class="row">
		                		<div class="col-lg-9">
		                			<h2 class="checkout-title">Billing Details</h2><!-- End .checkout-title -->
		                				<div class="row">
		                					<div class="col-sm-6">
		                						<label>User Name *</label>
                                                                                <input type="text" class="form-control" disabled="disabled" id="fname" value=<%=user.getName()%>>
		                					</div><!-- End .col-sm-6 -->

		                					
		                				</div><!-- End .row -->

	            						
	            						

	            						
	            						

	            						<label>Street address *</label>
                                                                <input type="text" id="street" disabled="disabled" class="form-control" value=<%= user.getStreet()%> >
	            						

	            						<div class="row">
		                					<div class="col-sm-6">
		                						<label>Town / City *</label>
                                                                                <input id="city" type="text" class="form-control" required="" disabled="disabled" value=<%=user.getCity()%>>
		                					</div><!-- End .col-sm-6 -->

		                					<!-- End .col-sm-6 -->
		                				</div><!-- End .row -->

		                				<div class="row">
		                					<!-- End .col-sm-6 -->

		                					<div class="col-sm-6">
		                						<label>Phone *</label>
                                                                                <input id="phone" type="tel" class="form-control" required="" disabled="disabled" value=<%=user.getPhone()%>>
		                					</div><!-- End .col-sm-6 -->
		                				</div><!-- End .row -->

	                					<label>Email address *</label>
                                                                <input type="email"  id="email"class="form-control" disabled="disabled" value=<%=user.getEmail()%>>

	        							<!-- End .custom-checkbox -->

										<!-- End .custom-checkbox -->

	                					
	        							
		                		</div><!-- End .col-lg-9 -->
		                		<aside class="col-lg-3">
		                			<div class="summary">
		                				<h3 class="summary-title">Your Order</h3><!-- End .summary-title -->

		                				<table class="table table-summary">
		                					<thead>
		                						<tr>
		                							<th>Product</th>
		                							<th>Total</th>
		                						</tr>
		                					</thead>

		                					<tbody>
                                                                            <% int sub=0;
                                                                                for (CartItem cis:items){%>
		                						<tr>
                                                                                    <td><a href="quickView.jsp"><%=cis.getProductname()%></a></td>
		                							<td>$<%=cis.getPrice()%></td>
		                						</tr>
                                                                                 <%sub+=cis.getPrice();}%>
		                						
		                						<tr class="summary-subtotal">
		                							<td>Subtotal:</td>
		                							<td>$<%=sub%></td>
		                						</tr><!-- End .summary-subtotal -->
		                						<tr>
		                							<td>Shipping:</td>
                                                                                        <% String stype="";
                                                                                        switch(request.getParameter("shipping")){
                                                                                            case "20":
                                                                                                stype="Express";
                                                                                                break;
                                                                                            case "10":
                                                                                                stype="Standard";
                                                                                                break;
                                                                                            default:                                                                                        
                                                                                                stype="Free Shipping";
                                                                                                break;
                                                                                        }
                                                                                        %>
                                                                                        <td><%=stype%></td>
		                						</tr>
		                						<tr class="summary-total">
		                							<td>Total:</td>
                                                                                        <td>$<%=request.getParameter("total")%></td>
		                						</tr><!-- End .summary-total -->
		                					</tbody>
		                				</table><!-- End .table table-summary -->

		                				<!-- End .accordion -->

		                				<button type="submit" class="btn btn-outline-primary-2 btn-order btn-block">
		                					<span class="btn-text">Place Order</span>
		                					<span class="btn-hover-text">Proceed to Checkout</span>
		                				</button>
		                			</div><!-- End .summary -->
		                		</aside><!-- End .col-lg-3 -->
		                	</div><!-- End .row -->
            			</form>
	                </div><!-- End .container -->
                </div><!-- End .checkout -->
            </div><!-- End .page-content -->
        </main><!-- End .main -->

        <%@include file="footer.jsp" %>