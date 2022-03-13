<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="assets/css/style.css">
        <title>Add product</title>
    </head>
    <body>
        <form action="/TechStore/validateAddProduct" enctype="multipart/form-data" method="POST">
            <div class="form-group">
                <label for="productname">Product name</label>
                <input type="text" class="form-control" id="productname" name="productname" required>
            </div><!-- End .form-group -->

            <div class="form-group">
                <label for="description">Description</label>
                <input type="text" class="form-control" id="description" name="description" required>
            </div><!-- End .form-group -->

            <div class="form-group">
                <label for="price">Price</label>
                <input type="number" class="form-control" id="price" name="price" required>
            </div><!-- End .form-group -->

            <div class="form-group">
                <label for="category">Category</label>
                <select id="category" name="category">
                    <option value="phone">Phone</option>
                    <option value="laptop">Laptop</option>
                </select>
            </div><!-- End .form-group -->

            <div class="form-group">
                <label for="quantity">Quantity</label>
                <input type="number" class="form-control" id="quantity" name="quantity" required>
            </div><!-- End .form-group -->

            <div class="form-group">
                <label for="image">Image:</label>
                <input type="file"  accept="image/*" id="image" name="image">
            </div><!-- End .form-group -->

            <input type="submit" value="ADD" />

        </form>
    </body>
</html>
