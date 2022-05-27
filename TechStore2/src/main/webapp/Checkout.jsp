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

    int id = (int) session.getAttribute("userId");
    User user = database.UserManager.getUserById(id);
    String shipping=(String)session.getAttribute("shipping");
    String total=(String)session.getAttribute("totalprice");
    Double tot=0.0;
   if (shipping.equalsIgnoreCase("notselected")){
       tot=Double.valueOf(total);
   }else{
   tot=Double.valueOf(total)+Double.valueOf(shipping);
   }
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
                    
                </div><!-- End .checkout-discount -->
                <form >
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
                                        <% 
                                        if(items == null) 
                                         items = new ArrayList<>();
                                            for (CartItem cis : items) {%>
                                        <tr>
                                            <td><a href="quickView.jsp"><%=cis.getProductname()%></a></td>
                                            <td>$<%=cis.getPrice()%></td>
                                        </tr>
                                        <%}%>

                                        <tr class="summary-subtotal">
                                            <td>Subtotal:</td>
                                            <td id="stot">$<%=total%></td>
                                        </tr><!-- End .summary-subtotal -->
                                        <tr>
                                            <td>Shipping:</td>
                                            <% String stype = "";
                                                switch (shipping) {
                                                    case "20":
                                                        stype = "Express";
                                                        break;
                                                    case "10":
                                                        stype = "Standard";
                                                        break;
                                                    default:
                                                        stype = "Free Shipping";
                                                        break;
                                                }
                                            %>
                                            <td><%=stype%></td>
                                        </tr>
                                        <tr class="summary-total">
                                            <td>Total:</td>
                                            <td id="total">$<%=tot%></td>
                                        </tr><!-- End .summary-total -->
                                    </tbody>
                                </table><!-- End .table table-summary -->

                                <!-- End .accordion -->

                                <button type="button"  class="btn btn-outline-primary-2 btn-order btn-block" id="order">
                                    <span class="btn-text">Place Order</span>
                                    <span class="btn-hover-text">Proceed to Checkout</span>
                                </button>
                                <div id="myModal" class="modal">
                             <div class="modal-dialog modal-notify modal-info" role="document" style="user-select: auto;height: 50%;">
                                 <!--Content-->
                                 <div class="modal-content text-center" style="height: 90%; user-select: auto;">
                                   <!--Header-->
                                   <div class="modal-header d-flex justify-content-center" style="user-select: auto;">
                                       <p id="messageh" class="heading" style="user-select: auto;color: #cd9b66;">Be always up to date</p>
                                   </div>

                                   <!--Body-->
                               <div class="row" style="user-select: auto;height: 56%;">
                               <div class="col-3" style="user-select: auto;">
                                 <p style="user-select: auto;"></p>
                                 <p class="text-center" style="user-select: auto;"><i class="fa fa-shopping-cart fa-5x" style="user-select: auto;color: #e5ae6c;margin-top: 10%"></i></p>
                               </div>

                               <div class="col-9" style="user-select: auto;">
                                   <p></p>
                                   <p id="messageb" style="margin-top: 10%;">Do you need more time to make a purchase decision?</p>
                                 
                               </div>
                             </div>

                                   <!--Footer-->
                                   <div class="modal-footer flex-center" style="align-items: end;user-select: auto;height: 32%;">
                                     <a href="index.jsp" class="btn btn-outline-primary-2 btn-order btn-block" style="user-select: auto;"> <span class="btn-text" style="user-select: auto;">Continue Shopping</span> <span class="btn-hover-text" style="user-select: auto;">Continue Shopping</span></a>
                                     <a href="cart.jsp" type="button" class="btn btn-outline-primary-2 btn-order btn-block" style="user-select: auto;"><span class="btn-text" style="user-select: auto;">View Cart</span><span class="btn-hover-text" style="user-select: auto;">View Cart</span></a>
                                   </div>
                                 </div>
                                 <!--/.Content-->
                               </div>
                            
                               </div>
                              </div>

                            </div><!-- End .summary -->
                        </aside><!-- End .col-lg-3 -->
                    </div><!-- End .row -->
                </form>
            </div><!-- End .container -->
        </div><!-- End .checkout -->
    </div><!-- End .page-content -->
  
</main><!-- End .main -->
<script>
     var modal = document.getElementById("myModal");
      
    $( "#order" ).click(function() {
       
   $.get("/TechStore2/PlaceOrder", function(data, status){
   console.log(data);
  checkStatus(data);
  });
});

window.onclick = function(event) {
  if (event.target === modal) {
    modal.style.display = "none";
  }};
  function checkStatus(data){
      if(data=="okay"){
          $.getScript("assets/scripts/cart.js", function () {
        clearCart();
    });
       modal.style.display = "block";   
          $("#messageh").html("Order Done  Sucssefully ");
          $("#messageb").html("An SMS will be sent shortly to your phone");
          $("#total").html("$0");
          $("#total").html("$0");
           $("#stot").html("$0");
      }else if(data=="notokay"){
          modal.style.display = "block"; 
           $("#messageh").html("Order Can't be Completed ");
          $("#messageb").html("You dont have enough Credit");
      }else{
          
           modal.style.display = "block"; 
           $("#messageh").html("Order Can't be Completed ");
          $("#messageb").html("You dont have items in cart");
      }
      
  };
</script>
<%@include file="footer.jsp" %>