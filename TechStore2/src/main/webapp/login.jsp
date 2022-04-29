<%-- 
    Document   : login
    Created on : Apr 27, 2022, 1:34:02 AM
    Author     : Salma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="header.jsp" %>
  <script type="text/javascript" src="assets/scripts/registerNewUser.js"></script>
     <main class="main">
                <nav aria-label="breadcrumb" class="breadcrumb-nav border-0 mb-0">
                    <div class="container">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                            <li class="breadcrumb-item"><a href="#">Pages</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Login</li>
                        </ol>
                    </div><!-- End .container -->
                </nav><!-- End .breadcrumb-nav -->

                <div class="login-page bg-image pt-8 pb-8 pt-md-12 pb-md-12 pt-lg-17 pb-lg-17"
                     style="background-image: url('/TechStore2/assets/images/backgrounds/login-bg.jpg')">
                    <div class="container">
                        <div class="form-box" style="user-select: auto; display: none" id="code"
                             >
                            <div class="form-tab" style="user-select: auto;">
                                <ul class="nav nav-pills nav-fill" role="tablist" style="user-select: auto;">
                                    <li class="nav-item" style="user-select: auto;">
                                        <a class="nav-link active" id="register-code" data-toggle="tab" href="#register-code" role="tab"
                                           aria-controls="register-code" aria-selected="true" style="user-select: auto;">Code Valdation</a>
                                    </li>
                                    <li class="nav-item" style="user-select: auto;display: none;">
                                        <a class="nav-link" id="register-tab-2" data-toggle="tab" href="#register-2" role="tab"
                                           aria-controls="register-2" aria-selected="false" style="user-select: auto;">Register</a>
                                    </li>
                                </ul>
                                <div class="tab-content" style="user-select: auto;">
                                    <div class="tab-pane fade active show" id="register-code" role="tabpanel" aria-labelledby="signin-tab-2"
                                         style="user-select: auto;">
                                        <form action="#" style="user-select: auto;">
                                            <div class="form-group"
                                                 style="user-select: auto;display: none;text-align: center;justify-content: center;">
                                                
                                            </div><!-- End .form-group -->

                                            <div class="form-group" style="user-select: auto;justify-content: center;">
                                                <label for="singin-password-2" style="user-select: auto;text-align: center;">Enter Code Received</label>
                                                <input type="text" class="form-control" id="validation" name="code"
                                                       required="" style="user-select: auto;" required >
                                            </div><!-- End .form-group -->

                                            <div class="form-footer" style="user-select: auto;">
                                                <button type="button" class="btn btn-outline-primary-2" style="user-select: auto;" onclick="validate()">
                                                    <span style="user-select: auto;">Validate</span>
                                                    <i class="icon-long-arrow-right" style="user-select: auto;"></i>
                                                </button>



                                                <p class="forgot-link" style="user-select: auto;" onclick="resend()">send Again?</p>
                                            </div><!-- End .form-footer -->
                                        </form>
                                        <div class="form-choice" style="user-select: auto;">
                                            <p class="text-center forgot-link" style="user-select: auto;" onclick="requestCall()">Do you want a call instead?</p>


                                        </div><!-- End .row -->
                                    </div><!-- End .form-choice -->
                                </div><!-- .End .tab-pane -->

                            </div><!-- End .tab-content -->
                        </div><!-- End .form-tab -->
                    </div>
                    <div class="form-box" id="block">
                        <div class="form-tab">
                            <ul class="nav nav-pills nav-fill" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link" id="signin-tab-2" data-toggle="tab" href="#signin-2" role="tab"
                                       aria-controls="signin-2" aria-selected="false">Sign In</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link active" id="register-tab-2" data-toggle="tab" href="#register-2"
                                       role="tab" aria-controls="register-2" aria-selected="true">Register</a>
                                </li>
                            </ul>
                            <div class="tab-content">
                                <div class="tab-pane fade" id="signin-2" role="tabpanel" aria-labelledby="signin-tab-2">
                                    <form action="validateUserLogin" method="post">
                                        <div class="form-group">
                                            <label for="singin-email-2">Username or email address *</label>
                                            <input type="text" class="form-control" id="singin-email-2"
                                                   name="singin-email" required>
                                        </div><!-- End .form-group -->

                                        <div class="form-group">
                                            <label for="singin-password-2">Password *</label>
                                            <input type="password" class="form-control" id="singin-password-2"
                                                   name="singin-password" required>
                                        </div><!-- End .form-group -->

                                        <div class="form-footer">
                                            <button type="submit" class="btn btn-outline-primary-2">
                                                <span>LOG IN</span>
                                                <i class="icon-long-arrow-right"></i>
                                            </button>

                                            <div class="custom-control custom-checkbox">
                                                <input type="checkbox" class="custom-control-input"
                                                       id="signin-remember-2">
                                                <label class="custom-control-label" for="signin-remember-2">Remember
                                                    Me</label>
                                            </div><!-- End .custom-checkbox -->

                                            <a href="#" class="forgot-link">Forgot Your Password?</a>
                                        </div><!-- End .form-footer -->
                                    </form>
                                    <div class="form-choice">
                                        <p class="text-center">or sign in with</p>
                                        <div class="row">
                                            <div class="col-sm-6">
                                                <a href="#" class="btn btn-login btn-g">
                                                    <i class="icon-google"></i>
                                                    Login With Google
                                                </a>
                                            </div><!-- End .col-6 -->
                                            <div class="col-sm-6">
                                                <a href="#" class="btn btn-login btn-f">
                                                    <i class="icon-facebook-f"></i>
                                                    Login With Facebook
                                                </a>
                                            </div><!-- End .col-6 -->
                                        </div><!-- End .row -->
                                    </div><!-- End .form-choice -->
                                </div><!-- .End .tab-pane -->
                                <div class="tab-pane fade show active reg" id="register-2" role="tabpanel"
                                     aria-labelledby="register-tab-2">
                                    <form action="Registration.jsp" id="registeration">
                                        <div class="form-group">
                                            <label for="register-email-2">Your email address *</label>
                                            <input type="email" class="form-control" id="register-email-2"
                                                   name="register-email" required>
                                            <p class="error" id="email"></p>

                                        </div><!-- End .form-group -->
                                        <div class="form-group">
                                            <label for="register-email-2">User Name</label>
                                            <input type="text" class="form-control" id="username"
                                                   name="username" required>

                                        </div><!-- End .form-group -->

                                        <div class="form-group">
                                            <label for="register-password-2">Password *</label>
                                            <input type="password" class="form-control" id="register-password-2"
                                                   name="register-password" required>
                                            <p class="error" id="pass"></p>
                                        </div><!-- End .form-group -->
                                        <div class="form-group">
                                            <label for="register-phone-2">Phone *</label>
                                            <input type="text" class="form-control" id="register-phone-2"
                                                   name="register-phone" required>
                                            <p class="error" id="phone"></p>
                                        </div><!-- End .form-group -->
                                        <div class="form-group">
                                            <label for="register-phone-2">Birth date *</label>
                                            <input type="date" class="form-control" id="register-date-2"
                                                   name="register-date" required>
                                            <p class="error" id="bdate"></p>
                                        </div><!-- End .form-group -->
                                        <div class="form-group">
                                            <label for="register-Address-2">Address *</label>
                                            <div class="form_wrap select_box">


                                                <input type="text" name="city" placeholder="city"
                                                       class="form-control city"mid="city">
                                                <div class="error" ></div>



                                                <input type="text" name="street" placeholder="street"
                                                       class="form-control street" id="street">
                                                <div class="error" id="country"></div>

                                            </div>
                                            <p class="error" id="address"></p>
                                        </div><!-- End .form-group -->


                                        <div class="form-group">
                                            <label for="register-job-2">Job *</label>
                                            <input type="text" class="form-control" id="register-job-2"
                                                   name="register-job" required>
                                            <p class="error" id="job"></p>
                                        </div><!-- End .form-group -->
                                        <div class="form-group">
                                            <label>Interests *</label>


                                            <div class="form_wrap ">
                                                <div class="checkbox">

                                                    <input type="checkbox" id="int1" value="smart phones"
                                                           name="interests">smart
                                                    phones

                                                </div>
                                                <div class="checkbox">

                                                    <input type="checkbox" id="int2" value="smart watches"
                                                           name="interests">smart
                                                    watches

                                                </div>
                                                <div class="checkbox">

                                                    <input type="checkbox" id="int3" value="laptobs"
                                                           name="interests">laptobs

                                                </div>


                                            </div>
                                            <p class="error" id="interests"></p>
                                        </div>
                                        <div class="form-footer">
                                            <button type="button" class="btn btn-outline-primary-2" onclick="chkErr()">
                                                <span>SIGN UP</span>
                                                <i class="icon-long-arrow-right"></i>
                                            </button>


                                        </div><!-- End .form-footer -->
                                    </form>
                                    <div class="form-choice">
                                        <p class="text-center">or sign in with</p>
                                        <div class="row">
                                            <div class="col-sm-6">
                                                <a href="#" class="btn btn-login btn-g">
                                                    <i class="icon-google"></i>
                                                    Login With Google
                                                </a>
                                            </div><!-- End .col-6 -->
                                            <div class="col-sm-6">
                                                <a href="#" class="btn btn-login  btn-f">
                                                    <i class="icon-facebook-f"></i>
                                                    Login With Facebook
                                                </a>
                                            </div><!-- End .col-6 -->
                                        </div><!-- End .row -->
                                    </div><!-- End .form-choice -->
                                </div><!-- .End .tab-pane -->
                            </div><!-- End .tab-content -->
                        </div><!-- End .form-tab -->
                    </div><!-- End .form-box -->
                </div><!-- End .container -->
        </div><!-- End .login-page section-bg -->
    </main><!-- End .main -->
  
   <%@ include file="footer.jsp" %>         
