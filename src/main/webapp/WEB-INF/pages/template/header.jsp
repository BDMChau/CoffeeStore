<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page isELIgnored="false" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description"
          content="Responsive Bootstrap4 Shop Template, Created by Imran Hossain from https://imransdesign.com/">
<%--    <meta th:name="${_csrf.parameterName}" th:content="${_csrf.token}"/>--%>

    <!-- title -->
    <title>Coffee Store</title>


    <%--    /////////////////////////////////  --%>
    <%--   custom style     --%>
    <link href="<c:url value="/resources/style/main.css"/>" rel="stylesheet">

    <link rel="shortcut icon" type="image/png" href="assets/img/favicon.png">
    <!-- google font -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap" rel="stylesheet">
    <!-- fontawesome -->
    <link rel="stylesheet" href="../../../resources/assets/css/all.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.13.0/css/all.css">

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
    <%--    <script src="https://kit.fontawesome.com/bf4313cc6f.js" crossorigin="anonymous"></script>--%>

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
                        <a href="/">
                            <img src="../../../resources/assets/img/logo.png" alt="">
                        </a>
                    </div>
                    <!-- logo -->

                    <!-- menu start -->
                    <nav class="main-menu">
                        <ul>
                            <%-- class="current-list-item"--%>
                            <li><a href="/">Trang Chủ</a></li>
                            <li><a href="/about">Về Chúng Tôi</a></li>

                            <li>
                                <a class="mobile-hide search-bar-icon" href="#"><i class="fa fa-search"
                                                                                   style="font-size: 15px"></i></a>
                            </li>

                            <li>
                                <div class="header-icons">
                                    <a class="shopping-cart" href="/user/cart">
                                        <div id="countCart" style="
                                                    background: indianred;
                                                    color: white;
                                                    padding: 4.5px;
                                                    border-radius: 50%;
                                                    font-size: 10px;
                                                    position: absolute;
                                                    top: -5px;
                                                    left: 20px;
                                                    width: 26px;
                                                    height: 26px;
                                                    "
                                        >

                                        </div>
                                        <i class="fas fa-shopping-cart" style="font-size: 15px"></i>
                                    </a>

                                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                                        <a class="user-page" href="/user/user-info">
                                            <i class="fas fa-user" style="font-size: 15px"></i>
                                        </a>

                                        <a onclick="document.forms['logoutForm'].submit()" title="Đăng xuất"><i
                                                class="fas fa-sign-out-alt" style="font-size: 15px"></i></a>

                                        <form id="logoutForm" method="GET" action="/logout">
                                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                        </form>
                                    </c:if>

                                    <c:if test="${pageContext.request.userPrincipal.name == null}">
                                        <a class="shopping-cart" href="/auth/login">Đăng nhập</a>
                                    </c:if>
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
                    <%--@elvariable id="searchForm" type=""--%>
                    <div class="search-bar-tablecell">
                        <form:form method="GET" action="/search" name="search">
                            <h3>Search For:</h3>
                            <input type="text" name="keywords" placeholder="Keywords"/>
                            <button type="submit">Search <i class="fas fa-search"></i></button>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%--<script>--%>
<%--    const countCart = document.getElementById("countCart")--%>
<%--    const count = localStorage.getItem("aa");--%>

<%--    countCart.innerText = count ? count : 0;--%>
<%--</script>--%>

<script src="../../../resources/assets/js/MyJS/setCartCount.js"></script>

<!-- end search area -->