<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page isELIgnored="false" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Responsive Bootstrap4 Shop Template, Created by Imran Hossain from https://imransdesign.com/">

    <!-- title -->
    <title>Coffee Store</title>


    <%--    /////////////////////////////////  --%>
    <%--   custom style     --%>
    <link href="<c:url value="/resources/style/main.css"/>" rel="stylesheet">


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
                        <a href="index.html">
                            <img src="../../../resources/assets/img/logo.png" alt="">
                        </a>
                    </div>
                    <!-- logo -->

                    <!-- menu start -->
                    <nav class="main-menu">
                        <ul>
                            <%-- class="current-list-item"--%>
                            <li ><a href="/">Home</a></li>
                            <li><a href="about.html">About</a></li>

                            <li><a href="news.html">News</a></li>
                            <li>
                                <a class="mobile-hide search-bar-icon" href="#"><i class="fas fa-search" style="font-size: 15px"></i></a>
                            </li>

                            <li>
                                <div class="header-icons">
                                    <a class="shopping-cart" href="cart.html"><i class="fas fa-shopping-cart" style="font-size: 15px"></i></a>
                                    <a class="user-page" href="/user-page"><i class="fas fa-user" style="font-size: 15px"></i></a>
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