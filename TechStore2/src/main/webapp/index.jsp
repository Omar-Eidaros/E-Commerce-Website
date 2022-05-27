<%@page import="cartHandling.Cart"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="cartHandling.CartItem"%>
<%@page import="java.util.ArrayList"%>
<%@page import="database.Product"%>
<%@ include file="header.jsp" %>

<script type="text/javascript" src="assets/scripts/scriptForDisplayProducts.js"></script>


<main class="main">
    <div class="intro-slider-container mb-4">
        <div class="intro-slider owl-carousel owl-simple owl-nav-inside" data-toggle="owl" data-owl-options='{
             "nav": false, 
             "dots": true,
             "responsive": {
             "992": {
             "nav": true,
             "dots": false
             }
             }
             }'>
            <div class="intro-slide" style="background-image: url(https://images.unsplash.com/photo-1494698853255-d0fa521abc6c?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Nnx8YXBwbGUlMjBsYXB0b3B8ZW58MHx8MHx8&w=1000&q=80);">
                <div class="container intro-content">
                    <h3 class="intro-subtitle text-primary">SEASONAL PICKS</h3><!-- End .h3 intro-subtitle -->
                    <h1 class="intro-title">Get All <br>The Good Stuff</h1><!-- End .intro-title -->
                    <a href="category.html" class="btn btn-outline-primary-2">
                        <span>DISCOVER MORE</span>
                        <i class="icon-long-arrow-right"></i>
                    </a>
                </div><!-- End .intro-content -->
            </div><!-- End .intro-slide -->

            <div class="intro-slide" style="background-image: url(https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/macbook-air-og-202011?wid=1200&hei=630&fmt=jpeg&qlt=95&.v=1604278672000);">
                <div class="container intro-content">
                    <h3 class="intro-subtitle text-primary">all at 50% off</h3><!-- End .h3 intro-subtitle -->
                    <h1 class="intro-title text-white">The Most Beautiful <br>Novelties In Our Shop</h1><!-- End .intro-title -->

                    <a href="category.html" class="btn btn-outline-primary-2 min-width-sm">
                        <span>SHOP NOW</span>
                        <i class="icon-long-arrow-right"></i>
                    </a>
                </div><!-- End .intro-content -->
            </div><!-- End .intro-slide -->
        </div><!-- End .intro-slider owl-carousel owl-simple -->

        <span class="slider-loader"></span><!-- End .slider-loader -->
    </div><!-- End .intro-slider-container -->

    <div class="container">
        <div class="toolbox toolbox-filter">
            <div class="toolbox-left">
                <a href="#" class="filter-toggler">Filters</a>

            </div><!-- End .toolbox-left -->
            <!--            <div class="toolbox-right">
                            <ul class="nav-filter product-filter">
                                <li class="active"><a href="#" data-filter="*">All</a></li>
                                <li><a href="#" data-filter=".phone">Phone</a></li>
                                <li><a href="#" data-filter=".laptob">Laptop</a></li>
                            </ul>
                        </div> End .toolbox-right -->
        </div><!-- End .filter-toolbox -->

        <div class="widget-filter-area" id="product-filter-area">
            <a href="#" onclick="cleanSearch()" class="widget-filter-clear">Clean All</a>

            <div class="filter-area-wrapper">
                <form id="searchForm">

                    <div class="row">

                        <div class="col-sm-6 col-lg-3">
                            <div class="widget">
                                <h3 class="widget-title">
                                    Category :
                                </h3><!-- End .widget-title -->

                                <div class="filter-items">
                                    <div class="filter-item">
                                        <div class="custom-control custom-checkbox">
                                            <input type="radio" class="custom-control-input" value="all"  id="category-1" name="category">
                                            <label class="custom-control-label" for="category-1">ALL</label>
                                        </div><!-- End .custom-checkbox -->
                                    </div><!-- End .filter-item -->

                                    <div class="filter-item">
                                        <div class="custom-control custom-checkbox">
                                            <input type="radio" class="custom-control-input" value="phone" id="category-2" name="category">
                                            <label class="custom-control-label" for="category-2">Phone</label>
                                        </div><!-- End .custom-checkbox -->
                                    </div><!-- End .filter-item -->

                                    <div class="filter-item">
                                        <div class="custom-control custom-checkbox">
                                            <input type="radio" class="custom-control-input" value="laptob" id="category-3" name="category">
                                            <label class="custom-control-label" for="category-3">Laptop</label>
                                        </div><!-- End .custom-checkbox -->
                                    </div><!-- End .filter-item -->

                                </div><!-- End .filter-items -->
                            </div><!-- End .widget -->
                        </div><!-- End .col-sm-6 col-lg-3 -->

                        <div class="col-sm-6 col-lg-3">
                            <div class="widget">
                                <h3 class="widget-title">
                                    Price:
                                </h3><!-- End .widget-title -->

                                <div class="filter-price">
                                    <div class="filter-price-text">
                                        Price Range:
                                        <span id="filter-price-range"></span>
                                    </div><!-- End .filter-price-text -->

                                    <div id="price-slider"></div><!-- End #price-slider -->
                                </div><!-- End .filter-price -->
                            </div><!-- End .widget -->
                        </div><!-- End .col-sm-6 col-lg-3 -->



                        <div class="col-sm-6 col-lg-3">
                            <a onclick="getQueryFromSearch()" href="#" class="btn btn-primary btn-round"><span>Search</span><i class="icon-long-arrow-right"></i></a>
                        </div>

                    </div><!-- End .row -->
                </form>
            </div><!-- End .filter-area-wrapper -->
        </div><!-- End #product-filter-area.widget-filter-area -->

        <div class="products-container" id="products-container" data-layout="fitRows">


            <div class="product-item Phone sale col-6 col-md-4 col-lg-3">
                <div class="product product-4">
                    <figure class="product-media">
                        <span class="product-label">Sale</span>
                        <a href="product.html">
                            <img src="assets/images/demos/demo-11/products/product-5.jpg" alt="Product image" class="product-image">
                        </a>

                        <div class="product-action-vertical">
                            <a href="#" class="btn-product-icon btn-wishlist btn-expandable"><span>add to wishlist</span></a>
                        </div><!-- End .product-action -->

                        <div class="product-action">
                            <a href="popup/quickView.html" class="btn-product btn-quickview" title="Quick view"><span>quick view</span></a>
                        </div><!-- End .product-action -->
                    </figure><!-- End .product-media -->

                    <div class="product-body">
                        <h3 class="product-title"><a href="product.html">Foldable Tray Table</a></h3><!-- End .product-title -->
                        <div class="product-price">
                            <span class="new-price">$320.00</span>
                            <span class="old-price">Was $480.00</span>
                        </div><!-- End .product-price -->
                        <div class="product-nav product-nav-dots">
                            <a href="#" class="active" style="background: #333333;"><span class="sr-only">Color name</span></a>
                            <a href="#" style="background: #cba374;"><span class="sr-only">Color name</span></a>
                        </div><!-- End .product-nav -->

                        <div class="product-action">
                            <a href="#" class="btn-product btn-cart"><span>add to cart</span><i class="icon-long-arrow-right"></i></a>
                        </div><!-- End .product-action -->
                    </div><!-- End .product-body -->
                </div><!-- End .product -->
            </div><!-- End .product-item -->

            <div class="product-item Laptop sale col-6 col-md-4 col-lg-3">
                <div class="product product-4">
                    <figure class="product-media">
                        <span class="product-label">Sale</span>
                        <a href="product.html">
                            <img src="assets/images/demos/demo-11/products/product-12.jpg" alt="Product image" class="product-image">
                        </a>

                        <div class="product-action-vertical">
                            <a href="#" class="btn-product-icon btn-wishlist btn-expandable"><span>add to wishlist</span></a>
                        </div><!-- End .product-action -->

                        <div class="product-action">
                            <a href="quickView.html" class="btn-product btn-quickview" title="Quick view"><span>quick view</span></a>
                        </div><!-- End .product-action -->
                    </figure><!-- End .product-media -->

                    <div class="product-body">
                        <h3 class="product-title"><a href="product.html">Carronade Large Suspension Lamp</a></h3><!-- End .product-title -->
                        <div class="product-price">
                            <span class="new-price">$892.00</span>
                            <span class="old-price">Was $939.00</span>
                        </div><!-- End .product-price -->
                        <div class="product-nav product-nav-dots">
                            <a href="#" class="active" style="background: #dddad5;"><span class="sr-only">Color name</span></a>
                            <a href="#" style="background: #825a45;"><span class="sr-only">Color name</span></a>
                        </div><!-- End .product-nav -->

                        <div class="product-action">
                            <a href="#" class="btn-product btn-cart"><span>add to cart</span><i class="icon-long-arrow-right"></i></a>
                        </div><!-- End .product-action -->
                    </div><!-- End .product-body -->
                </div><!-- End .product -->
            </div><!-- End .product-item -->
        </div><!-- End .products-container -->
    </div><!-- End .container -->
 
</main><!-- End .main -->

<%@ include file="footer.jsp" %>
<%@include file="footerBody.jsp" %>
<%--<jsp:include page="footer.jsp" />--%> 