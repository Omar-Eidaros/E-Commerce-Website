<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ include file="headerAdmin.jsp" %>
<%
    String isEdit = request.getParameter("id");
    
    String titlePage = "Add New Product";
    String action = "/TechStore/validateAddProduct";
    String nameBtn = "Add";

    
    String productname = "";
    String description = " ";
    String price = " ";
    String category = " ";
    String quantity = " ";
//    String image = "";
    
    if (isEdit != null) {
        action = "/TechStore/validateEditProduct";
        productname = request.getParameter("productname");
        description = request.getParameter("description");
        price = request.getParameter("price");
        category = request.getParameter("category");
        quantity = request.getParameter("quantity");
//        image = request.getParameter("image");
        titlePage = "Edit Product";
        nameBtn = "Edit";
    }


%>

<!-- Blank Start -->
<div class="container-fluid pt-4 px-4">
    <div class="row bg-light rounded align-items-center justify-content-center mx-0">

        <!--<div class="col-sm-12 col-xl-6">-->
        <div class="bg-light rounded h-100 p-4">
            <h6 class="mb-4"><%=titlePage%></h6>
            <form
                action=<%= action%>
                enctype="multipart/form-data"
                method="POST"
                >               
                <div class="row mb-3">
                    <label for="productname" class="col-sm-2 col-form-label">Product name</label>
                    <div class="col-sm-10">
                        <input type="text"  class="form-control" id="productname" name="productname" required value=<%= productname %> >
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="description" class="col-sm-2 col-form-label">Description</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="description" name="description" required value=<%= description %> >
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="price" class="col-sm-2 col-form-label">Price</label>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" id="price" name="price" required  value=<%= price %> >
                    </div>
                </div>



                <div class="row mb-3">
                    <label for="category" class="col-sm-2 col-form-label">Category</label>
                    <div class="col-sm-10">
                        <select class="form-select mb-3" aria-label="Default select example" id="category" name="category"  value=<%= category %> >
                            <option value="phone">Phone</option>
                            <option value="laptob">Laptob</option>
                        </select>                       
                    </div>
                </div>





                <div class="row mb-3">
                    <label for="quantity" class="col-sm-2 col-form-label">Quantity</label>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" id="quantity" name="quantity" required value=<%= quantity %> >
                    </div>
                </div>



                <div class="row mb-3">
                    <label for="image" class="form-label">Image</label>
                    <input class="form-control" type="file" accept="image/*" id="image" name="image" >
                </div>


                <button type="submit" class="btn btn-primary" style="width: 25%;
                        float: right"><%=nameBtn%></button>
            </form>
            <!--</div>-->
        </div>

    </div>
</div>
<!-- Blank End -->


<%@ include file="footerAdmin.jsp" %>
