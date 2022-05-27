
   
function  cart_item (data) {
    
    let item = ` <div class="product" id=${data.productid} style="user-select: auto;height: fit-content;">
                                        <div class="product-cart-details" style="user-select: auto;">
                                            <h4 class="product-title" style="user-select: auto;">
                                                <a href="quickView.jsp?id=${data.productid}" title="Quick view" style="user-select: auto;\">${data.productname}</a>
                                            </h4>

                                            <span class="cart-product-info" style="user-select: auto;">
                                                <span class="cart-product-qty" style="user-select: auto;">${data.prodq}</span>
                                                 x${data.price}
                                            </span>
                                        </div><!-- End .product-cart-details -->

                                        <figure class="product-image-container" style="user-select: auto;">
                                            <a href="quickView.jsp?id=${data.productid}" title="Quick view" class="product-image" style="user-select: auto;height: fit-content;">
                                                <img src="data:image/gif;base64,${data.base64Image}" alt="product" style="user-select: auto;">
                                            </a>
                                        </figure>
                                        <span  class="btn-remove" title="Remove Product"  style="user-select: auto;" onclick="removeFromCart(${data.productid})"><i class="icon-close" style="user-select: auto;"></i></span>
                                    </div><!-- End .product -->`;
    return item;
}
function addTocart(x){
   
    $("#contain-product").html("");
         console.log(x);
    $.post("/TechStore2/CartHandling",{cart_item:x,action:"add"},function(data){
        action(data);
  
  
     // console.log(arr['message']);
    //displayCart(data);
});
    
}
function action(data){
    console.log($.parseJSON(data))
    
   var arr=$.parseJSON(data);
     
    if (arr.message=="out of stock"){
        alert(arr.message)
        displayCart(arr.cartItems)
     }else{
         displayCart(arr.cartItems)
     }
    
}
function removeFromCart(x){
        //$("#contain-product").html("");
     document.getElementById(x).remove();   
    $.post("/TechStore2/CartHandling",{cart_item:x,action:"remove"},function(data){
       
       $("#cart_count").html(JSON.parse(data)["count"]);
    $("#total_price").html(JSON.parse(data)["totalcost"]);
    })
    
}

function decreaseCart(x){
        $("#contain-product").html("");
    $.post("/TechStore2/CartHandling",{cart_item:x,action:"dec"},function(data){
      var arr=$.parseJSON(data); 
     displayCart(arr.cartItems)
    })
    
}

 function clearCart(){
        
    $.post("/TechStore2/CartHandling",{action:"clear"},function(data){
     $("#cart_count").html("0");
    $("#total_price").html("0");
    $("#contain-product").html("");
    });
    
} 

 function displayCart(data){   
    var items_count=0;
    var total_price=0;
    $.each(data,function(index, value){
        $("#contain-product").append(cart_item(value));
        items_count+=value.prodq;
        total_price+=value.prodq*value.price;
    });
    $("#cart_count").html(items_count);
    $("#total_price").html(total_price);
    }

