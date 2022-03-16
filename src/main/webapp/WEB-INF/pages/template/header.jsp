<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page isELIgnored="false" %>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <meta charset="utf-8">--%>
<%--    <meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1">--%>
<%--    <meta name="description" content="">--%>
<%--    <meta name="author" content="">--%>
<%--    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>

<%--    <script src="https://code.jquery.com/jquery-3.6.0.js"--%>
<%--            integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>--%>
<%--&lt;%&ndash;    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">&ndash;%&gt;--%>
<%--&lt;%&ndash;    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <link href="https://pay.vnpay.vn/lib/vnpay/vnpay.css" rel="stylesheet" />&ndash;%&gt;--%>

<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">--%>

<%--    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">--%>



<%--&lt;%&ndash;    user_info page&ndash;%&gt;--%>

<%--&lt;%&ndash;    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"> </script>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">&ndash;%&gt;--%>
<%--&lt;%&ndash;    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <link href="<c:url value="/resources/style/user_info.css"/>" rel="stylesheet">&ndash;%&gt;--%>


<%--    <title>Coffee Store</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="navbar-wrapper" style="margin-top:0;">--%>
<%--    <nav class="navbar navbar-inverse navbar-fixed-top">--%>
<%--        <div class="container">--%>
<%--            <div class="navbar-header">--%>
<%--                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"--%>
<%--                        aria-expanded="false" aria-controls="navbar">--%>
<%--                    <span class="sr-only">Toggle navigation</span>--%>
<%--                    <span class="icon-bar"></span>--%>
<%--                    <span class="icon-bar"></span>--%>
<%--                    <span class="icon-bar"></span>--%>
<%--                </button>--%>

<%--            </div>--%>
<%--            <div id="navbar" class="navbar-collapse collapse">--%>
<%--                <ul class="nav navbar-nav">--%>

<%--                    <li><a href="#"> <img src="<c:url value="/resources/images/logo.png"/>" alt="logo" class="logo">--%>
<%--                    </a></li>--%>
<%--                    <li class=""><a href="#">Coffee Online Shop</a></li>--%>
<%--                    <li>--%>
<%--                        <a href="<c:url value="/"/>">--%>
<%--                            Home--%>
<%--                        </a>--%>
<%--                    </li>--%>
<%--                    <li>--%>
<%--                        <a href="<c:url value="/products" />">--%>
<%--                            Products--%>
<%--                        </a>--%>
<%--                    </li>--%>
<%--                    <li>--%>
<%--                        <a href="<c:url value="/about" />">--%>
<%--                            About--%>
<%--                        </a>--%>
<%--                    </li>--%>
<%--                    <li>--%>
<%--                        <a href="<c:url value="/contact" />">--%>
<%--                            Contact--%>
<%--                        </a>--%>
<%--                    </li>--%>


<%--                </ul>--%>

<%--                <div class="line"></div>--%>

<%--                <ul class="nav navbar-nav pull-right">--%>
<%--                    <c:if test="${pageContext.request.userPrincipal.name!=null}">--%>
<%--                        <form id="logoutForm" method="POST" action="/logout">--%>
<%--                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
<%--                        </form>--%>

<%--                        <li><a>Welcome: ${pageContext.request.userPrincipal.name} </a></li>--%>
<%--                        <li><a href="<c:url value="/user/cart"/>">Cart</a></li>--%>
<%--                        <li><a onclick="document.forms['logoutForm'].submit()" style="cursor: pointer">Logout</a></li>--%>


<%--                        <c:if test="${pageContext.request.userPrincipal.name == 'Admin'}">--%>
<%--                            <li><a href="<c:url value="/admin"/>">Admin Page</a></li>--%>
<%--                        </c:if>--%>

<%--                    </c:if>--%>

<%--                    <c:if test="${pageContext.request.userPrincipal.name == null}">--%>

<%--                        <li><a href="<c:url  value="/auth/login"/>">--%>
<%--                            Login--%>
<%--                        </a></li>--%>
<%--                        <li><a href="<c:url  value="/auth/register"/>">--%>
<%--                            Register--%>
<%--                        </a></li>--%>
<%--                    </c:if>--%>


<%--                </ul>--%>


<%--            </div>--%>
<%--        </div>--%>
<%--    </nav>--%>

<%--</div>--%>
<%--</body>--%>

<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>--%>

<%--</html>--%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Responsive Bootstrap4 Shop Template, Created by Imran Hossain from https://imransdesign.com/">

    <!-- title -->
    <title>Coffee Store</title>

    <!-- favicon -->
    <link rel="shortcut icon" type="image/png" href="assets/img/favicon.png">
    <!-- google font -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap" rel="stylesheet">
    <!-- fontawesome -->
    <link rel="stylesheet" href="../../../resources/assets/css/all.min.css">
    <!-- bootstrap -->
    <link rel="stylesheet" href="../../../resources/assets/bootstrap/css/bootstrap.min.css">
    <!-- owl carousel -->
    <link rel="stylesheet" href="../../../resources/assets/css/owl.carousel.css">
    <!-- magnific popup -->
    <link rel="stylesheet" href="../../../resources/assets/css/magnific-popup.css">
    <!-- animate css -->
    <link rel="stylesheet" href="../../../resources/assets/css/animate.css">
    <!-- mean menu css -->
    <link rel="stylesheet" href="../../../resources/assets/css/meanmenu.min.css">
    <!-- main style -->
    <link rel="stylesheet" href="../../../resources/assets/css/main.css">
    <!-- responsive -->
    <link rel="stylesheet" href="../../../resources/assets/css/responsive.css">
    <%--    /////////////////////////////////  --%>
    <%--   custom style     --%>
    <link href="<c:url value="/resources/style/main.css"/>" rel="stylesheet">

</head>
<body>

<!--PreLoader-->
<div class="loader">
    <div class="loader-inner">
        <div class="circle"></div>
    </div>
</div>
<!--PreLoader Ends-->

<!-- header -->
<div class="top-header-area" id="sticker">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-sm-12 text-center">
                <div class="main-menu-wrap">
                    <!-- logo -->
                    <div class="site-logo">
                        <a href="../home.jsp">
                            <img src="assets/img/logo.png" alt="">
                        </a>
                    </div>
                    <!-- logo -->

                    <!-- menu start -->
                    <nav class="main-menu">
                        <ul>
                            <li class="current-list-item"><a href="#">Home</a>
                                <ul class="sub-menu">
                                    <li><a href="../home.jsp">Static Home</a></li>
                                    <li><a href="../home.jsp">Slider Home</a></li>
                                </ul>
                            </li>
                            <li><a href="about.html">About</a></li>
                            <li><a href="#">Pages</a>
                                <ul class="sub-menu">
                                    <li><a href="404.jsp">404 page</a></li>
                                    <li><a href="about.jsp">About</a></li>
                                    <li><a href="/cart">Cart</a></li>
                                    <li><a href="checkout.jsp">Check Out</a></li>
                                    <li><a href="contact.jsp">Contact</a></li>
                                    <li><a href="news.jsp">News</a></li>
                                    <li><a href="/shop">Shop</a></li>
                                    <li><a href="/brand">Brand</a></li>
                                    <li><a href="/userrr">User-Info</a> </li>
                                </ul>
                            </li>
                            <li><a href="news.jsp">News</a>
                                <ul class="sub-menu">
                                    <li><a href="news.jsp">News</a></li>
                                    <li><a href="single-news.jsp">Single News</a></li>
                                </ul>
                            </li>
                            <li><a href="contact.jsp">Contact</a></li>
                            <li><a href="shop.jsp">Shop</a>
                                <ul class="sub-menu">
                                    <li><a href="shop.jsp">Shop</a></li>
                                    <li><a href="checkout.jsp">Check Out</a></li>
                                    <li><a href="single-product.jsp">Single Product</a></li>
                                    <li><a href="cart.jsp">Cart</a></li>
                                </ul>
                            </li>
                            <li>
                                <div class="header-icons">
                                    <a class="shopping-cart" href="cart.jsp"><i class="fas fa-shopping-cart"></i></a>
                                    <a class="mobile-hide search-bar-icon" href="#"><i class="fas fa-search"></i></a>
                                </div>
                            </li>
                        </ul>
                    </nav>
                    <a class="mobile-show search-bar-icon" href="#"><i class="fas fa-search"></i></a>
                    <div class="mobile-menu"></div>
                    <!-- menu end -->
                </div>
            </div>
        </div>
    </div>
</div>
<!-- end header -->

<!-- search area -->
<div class="search-area">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <span class="close-btn"><i class="fas fa-window-close"></i></span>
                <div class="search-bar">
                    <div class="search-bar-tablecell">
                        <h3>Search For:</h3>
                        <input type="text" placeholder="Keywords">
                        <button type="submit">Search <i class="fas fa-search"></i></button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- end search area -->