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
    let valueMin = urlParams.get('min') || 20;
    let valueMax = urlParams.get('max') || 550;

    document.getElementById("min").setAttribute("value",valueMin);
    document.getElementById("max").setAttribute("value", valueMax);
    document.getElementById("price-from").textContent = valueMin;
    document.getElementById("price-to").textContent = valueMax;
    document.getElementById("category").selectedIndex = urlParams.get('category') == "phone" ? "1" : urlParams.get('category') == "laptob" ? "2" : "0";

    callAjax();
}


// to get data product 

function getQueryFromSearch() {
    loading();
//    e.preventdefault();
// Get the form
    let form = document.getElementById('searchForm');

// Get all field data from the form
    let data = new FormData(form);

// Convert to a query string
    queryString = "?" + new URLSearchParams(data).toString();
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
        document.getElementById("contain-all-cards").innerHTML = "";
        let newUrl = "/TechStore2/admin/displayProducts.jsp" + queryString;
        window.history.pushState('', 'Admin', newUrl);
        var allDataToDisplay = JSON.parse(request.responseText);
        allDataToDisplay.map(data => {
            document.getElementById("contain-all-cards").innerHTML += card(data);
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
    let x = `<div class = "card" >
    <img src="data:image/gif;base64,${data.base64Image}" alt="${data.productid}" style="width:100%;height:200px">
<h4>${data.productname}</h4>
<p class="price">LE ${data.price}</p>
    <p>${data.description}</p>
    <p class="txt-blue">Category ${data.category}</p>
    <p class="txt-blue">Quantity ${data.quantity}</p>
<div class="btns">
    <form action="/TechStore/validateDeleteProduct" method="GET">
    <input type="hidden" name="id" value="${data.productid}" />
                <input type="submit" class="btn btn-danger m-2"  value="delete"/>
            </form>
        
            <form action="addProduct.jsp" method="GET">
                <input type="hidden" name="productid" value="${data.productid}" />
                <input type="hidden" name="productname" value="${data.productname}" />
                <input type="hidden" name="description" value="${data.description}" />
                <input type="hidden" name="price" value="${data.price}" />
    <input type="hidden" name="category" value="${data.category}" />
    <input type="hidden" name="quantity" value="${data.quantity}" />
    <input type="submit" class="btn btn-warning m-2" value="Edit"/>
</form>
</div>
</div>`;
    return x;
}


function loading()
{
    document.getElementById("contain-all-cards").innerHTML = "";
    document.getElementById("contain-all-cards").innerHTML = "<div style='width: 100% ;text-align: center;margin: 32px;font-size: 50px;font-weight: 600'> loading.......</div>";

} 