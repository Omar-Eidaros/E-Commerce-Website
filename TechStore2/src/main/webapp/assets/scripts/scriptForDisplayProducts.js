/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */


/////////////////////////////////////////////////////////////// script for display product /////////////////////////////////////////////////////////////////////////////

var queryString = "";
window.onload = getProductsBasedOnUrl;


function getProductsBasedOnUrl() {
      $("#contain-product").html("");
    var cartItems=$("#sessionInfo").val();
     displayCart(cartItems);
    loading();
    queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    let valueMin = urlParams.get('min') || 0;
    let valueMax = urlParams.get('max') || 750;
//
//    document.getElementById("min").setAttribute("value",valueMin);
//    document.getElementById("max").setAttribute("value", valueMax);
//    document.getElementById("price-from").textContent = valueMin;
//    document.getElementById("price-to").textContent = valueMax;

    changeRadioButtonDisplay(urlParams.get('category'))
    callAjax();
}

function changeRadioButtonDisplay(val)
{
    let idCategory = val == "phone" ? "category-2" : val == "laptob" ? "category-3" : "category-1";
    let radiobtn = document.getElementById(idCategory);
    radiobtn.checked = true;
}


// to get data product 

function getQueryFromSearch() {
    loading();
//    e.preventdefault();
// Get the form
    let form = document.getElementById('searchForm');
    let priceFromElem = document.getElementsByClassName("noUi-handle-lower")[0];
    let priceToElem = document.getElementsByClassName("noUi-handle-upper")[0];
    let priceFrom = Math.floor(priceFromElem.getAttribute("aria-valuenow"))
    let priceTo = Math.floor(priceToElem.getAttribute("aria-valuenow"))

//    console.log(priceFrom.getAttribute("aria-valuenow"))
//    console.log(priceTo.getAttribute("aria-valuenow"))

// Get all field data from the form
    let data = new FormData(form);
//&min=20&max=550
// Convert to a query string
    queryString = "?" + new URLSearchParams(data).toString() + "&min=" + priceFrom + "&max=" + priceTo;
//    console.log(queryString)

    callAjax();

}


function cleanSearch()
{
    loading();
    changeRadioButtonDisplay("all")

    queryString = "";

    callAjax();
}



function callAjax()
{
    var url = "/TechStore2/validateDisplayProduct" + queryString;

    if (window.XMLHttpRequest) {

        request = new XMLHttpRequest();

    } else if (window.ActiveXObject) {

        request = new ActiveXObject("Microsoft.XMLHTTP");
    }

    try {
        request.onreadystatechange = sendInfo;
        request.open("GET", url, true);
        request.send();

    } catch (e) {
        alert("Unable to connect server");
    }
}

function sendInfo() {
    if (request.readyState == 1) {
        console.log("1");
    }

    if (request.readyState == 2) {
        console.log("2");

    }
    if (request.readyState == 3) {
        console.log("3");
    }

    if (request.readyState == 4) {
        document.getElementById("products-container").innerHTML = "";
        let newUrl = "/TechStore2/index.jsp" + queryString;
        window.history.pushState('', 'Admin', newUrl);
        //console.log(request.responseText)
        var allDataToDisplay = JSON.parse(request.responseText);
        allDataToDisplay.map(data => {
            document.getElementById("products-container").innerHTML += card(data);
        }
        )
    }
}



function show_value(which, val)
{
    document.getElementById(which).innerHTML = val;
}


// display card product
var card = (data) => {
    let productLabel = data.quantity > 0 ? "" : "<span class='product-label'>Out of stock</span>"
    let x = `<div class="product-item ${data.category} sale col-6 col-md-4 col-lg-3">
                <div class="product product-4">
                    <figure class="product-media">
                        ${productLabel}
                            <img src="data:image/gif;base64,${data.base64Image}" alt="Product image" class="product-image">
                        <div class="product-action">
                            <a href="quickView.jsp?id=${data.productid}" class="btn-product btn-quickview" title="Quick view"><span>quick view</span></a>
                        </div><!-- End .product-action -->
                    </figure><!-- End .product-media -->

                    <div class="product-body">
                        <h3 class="product-title">${data.productname}</h3><!-- End .product-title -->
                        <div class="product-price">
                            <span class="new-price">$${data.price}</span>
                           <!-- <span class="old-price">Was $939.00</span> -->
                        </div><!-- End .product-price -->

                        <div class="product-action" onclick="addTocart(${data.productid})">
                            <a href="#" class="btn-product btn-cart"  ><span >add to cart</span><i class="icon-long-arrow-right"></i></a>
                        </div><!-- End .product-action -->
                    </div><!-- End .product-body -->
                </div><!-- End .product -->
            </div><!-- End .product-item -->`;
    return x;
}

var cart_item = (data) => {
    
    let item = ` <div class="product" style="user-select: auto;height: fit-content;">
                                        <div class="product-cart-details" style="user-select: auto;">
                                            <h4 class="product-title" style="user-select: auto;">
                                                <a href="quickView.jsp?id=${data.productid}" title="Quick view" style="user-select: auto;\">${data.productname}</a>
                                            </h4>

                                            <span class="cart-product-info" style="user-select: auto;">
                                                <span class="cart-product-qty" style="user-select: auto;">${data.quantity}</span>
                                                x ${data.price}
                                            </span>
                                        </div><!-- End .product-cart-details -->

                                        <figure class="product-image-container" style="user-select: auto;">
                                            <a href="quickView.jsp?id=${data.productid}" title="Quick view" class="product-image" style="user-select: auto;height: fit-content;">
                                                <img src="data:image/gif;base64,${data.base64Image}" alt="product" style="user-select: auto;">
                                            </a>
                                        </figure>
                                        <span  class="btn-remove" title="Remove Product" style="user-select: auto;" onclick="removeFromCart(${data.productid})"><i class="icon-close" style="user-select: auto;"></i></span>
                                    </div><!-- End .product -->`;
    return item;
}



function loading()
{
    document.getElementById("products-container").innerHTML = "";
    document.getElementById("products-container").innerHTML = "<div  class='product-item' style='width: 100% ;text-align: center;font-size: 27px;font-weight: 600'> loading.......</div>";

} 

function addTocart(x){
    $("#contain-product").html("");
         console.log(x);
    $.post("/TechStore2/CartHandling",{cart_item:x,action:"add"},function(data){
    console.log(JSON.parse(data));
    displayCart(data);
});
    
}

function removeFromCart(x){
        $("#contain-product").html("");
    $.post("/TechStore2/CartHandling",{cart_item:x,action:"remove"},function(data){
    console.log(JSON.parse(data));
          displayCart(data);
    });
    
}

 function clearCart(x){
         console.log(x)
    $.post("/TechStore2/CartHandling",{cart_item:x,action:"clear"},function(data){
  console.log(JSON.parse(data));
    displayCart(data);
    });
    
} 

function displayCart(data){
    
     var arr=$.parseJSON(data);
    var items_count=0;
    var total_price=0;
    
    $.each(arr,function(index, value){
        $("#contain-product").append(cart_item(value));
        items_count+=value.quantity;
        total_price+=value.quantity*value.price;
    });
    $("#cart_count").html(items_count);
    $("#total_price").html(total_price);
    }
