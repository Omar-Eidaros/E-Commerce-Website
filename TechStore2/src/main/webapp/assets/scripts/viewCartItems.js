/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
  $("document").ready( function () {
        var items=$("#sessionInfo").val();
  
   $.each(JSON.parse(items),function(index, value){
        $("#rows").append(cartItem(value));
       
    });
    }); 

   
 function  cartItem (data) {
    var total = data.prodq * data.price
    let item = `
<tr>
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
											<td class="price-col">${data.price}</td>
											<td class="quantity-col">
                                                <div class="cart-product-quantity">
                                                    <input type="number" class="form-control" value=${data.prodq} min="1" max=${data.quantity} step="1" data-decimals="0" required>
                                                </div><!-- End .cart-product-quantity -->
                                            </td>
											<td class="total-col">$${total}</td>
											<td class="remove-col"><button class="btn-remove"><i class="icon-close"></i></button></td>
										</tr>`
    return item;
}  