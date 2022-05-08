/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

//action="/TechStore2/validateAdminLogin" method="POST"
//var formLogin = document.getElementById("loginAdmin");

function logto() {

    values = $("#loginAdmin").serialize();
    $.ajax({
        url: '/TechStore2/validateAdminLogin',
        method: 'POST',
        data: values,
        success:
                function (resultText) {
                    if (resultText[0] == "t") {
                        window.location.replace("http://localhost:8080/TechStore2/admin/displayProducts.jsp");
                    } else {
                        document.getElementById("error-login").innerHTML = "wrong user name or password ";
                    }
                },
        error: function (jqXHR, exception) {

        }
    }
    );
}