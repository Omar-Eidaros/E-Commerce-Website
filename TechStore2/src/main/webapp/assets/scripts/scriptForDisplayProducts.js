/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */


/////////////////////////////////////////////////////////////// script for display product /////////////////////////////////////////////////////////////////////////////

var queryString = "";
window.onload = getProductsBasedOnUrl;


function getProductsBasedOnUrl() {
   
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

                        <div class="product-action"  onclick="add(${data.productid})">
                         
                            <a  class="btn-product btn-cart"  ><span >add to cart</span><i class="icon-long-arrow-right"></i></a>
                        </div><!-- End .product-action -->
                    </div><!-- End .product-body -->
                </div><!-- End .product -->
            </div><!-- End .product-item -->`;
    return x;
}

  



function loading()
{
    document.getElementById("products-container").innerHTML = "";
    document.getElementById("products-container").innerHTML = "<div  class='product-item' style='width: 100% ;text-align: center;font-size: 27px;font-weight: 600'> loading.......</div>";

} 

function add(x){
    $.getScript("assets/scripts/cart.js",function(){
               addTocart(x);
});
}


