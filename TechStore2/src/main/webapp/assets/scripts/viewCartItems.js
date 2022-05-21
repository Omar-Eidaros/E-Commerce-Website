/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
var subtotal = 0;
var items = [];
var shvalue = 0;
$("document").ready(function () {
    items = $("#sessionInfo").val();
    display(JSON.parse(items));
    




});

function getship(x) {
    shvalue = parseInt($("#" + x).val());
    var totalorder = shvalue +parseInt($("#subTotal").html());

    $("#total").html( totalorder);
}

function inc(x) {
     
    var maxq=$(x).closest('tr').find("input[type='hidden']").val();
    var q=$(x).closest('tr').find("input[type='text']").val();
     var id = $(x).closest('tr').attr('id');
     var prpprice=parseInt(document.getElementById("total"+id.toString()).innerHTML)+parseInt(document.getElementById("price"+id.toString()).innerHTML)
     if(prpprice>parseInt(document.getElementById("price"+id.toString()).innerHTML)*maxq){
       
         alert("no more product in stock")
     }else{
             $.getScript("assets/scripts/cart.js", function () {
       addTocart(id);
   });
    
   
    document.getElementById("total"+id.toString()).innerHTML=prpprice
    var cost= parseInt($("#subTotal").html())+parseInt(parseInt(document.getElementById("price"+id.toString()).innerHTML))
    $("#subTotal").html(cost)
   $("#total").html(cost+shvalue)
   
     }

    
}
function dec(x) {

         var id = $(x).closest('tr').attr('id');
    $.getScript("assets/scripts/cart.js", function () {
        decreaseCart(id);
    });
     
      var prpprice=parseInt(document.getElementById("total"+id.toString()).innerHTML)-parseInt(document.getElementById("price"+id.toString()).innerHTML)
    document.getElementById("total"+id.toString()).innerHTML=prpprice
    var cost= parseInt($("#subTotal").html())-parseInt(parseInt(document.getElementById("price"+id.toString()).innerHTML))
    $("#subTotal").html(cost)
   $("#total").html(cost+shvalue)
    if(prpprice==0){        
        $(x).closest('tr').remove();
    }
   
}
 


function display(data) {
    
    $.each(data, function (index, value) {
        $("#rows").append(cartItem(value));
        subtotal += value.price*value.prodq;

    });
    $("#subTotal").html(subtotal);
    $("#total").html(subtotal);
}



function clearIt() {
    document.getElementById("rows").innerHTML = "";
    document.getElementById("subTotal").innerHTML = "0";
    document.getElementById("total").innerHTML = "0";
    $("#total").html( shvalue);
    $.getScript("assets/scripts/cart.js", function () {
        clearCart();


    });

}

function deleete(x){
      var id = $(x).closest('tr').attr('id');
   var cost= parseInt($("#subTotal").html())-parseInt(parseInt(document.getElementById("price"+id.toString()).innerHTML))
    $("#subTotal").html(cost)
   $("#total").html(cost+shvalue)
      $(x).closest('tr').remove()
      $.getScript("assets/scripts/cart.js", function () {
       removeFromCart(id);
    });
    
}

function  cartItem(data) {
    var idn="total"+data.productid.toString();
    var idp="price"+data.productid.toString();
    var total = data.prodq * data.price
    let item = `
<tr id=${data.productid}>
											<td class="product-col">
												<div class="product">
													<figure class="product-media">
														<a href="quickView.jsp?id=${data.productid}" title="Quick view" class="product-image" style="user-select: auto;height: fit-content;">
                                                                                                               <img src="data:image/gif;base64,${data.base64Image}" alt="product" style="user-select: auto;fit-content;">
                                            </a>
													</figure>

													<h3 class="product-title">
														<a >${data.productname}</a>
													</h3><!-- End .product-title -->
												</div><!-- End .product -->
											</td>
											<td id=${idp} class="price-col">${data.price}</td>
											<td class="quantity-col">
                                                    
                                                <input type="hidden" value=${data.quantity}>
                                                <div class="cart-product-quantity">
                                                    <input type="number" class="form-control"  value=${data.prodq} min="1" max=${data.quantity} step="1" data-decimals="0" required >
                                                </div><!-- End .cart-product-quantity -->
                                            </td>
											<td  class="total-col"><span>$</span><span id=${idn}>${total}</span></td>
											<td class="remove-col"><button class="btn-remove" onclick="deleete(this)"><i class="icon-close"></i></button></td>
										</tr>`
    return item;
}



