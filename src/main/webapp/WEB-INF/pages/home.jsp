<%@include file="/WEB-INF/pages/template/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- hero area -->
<div class="hero-area hero-bg">
    <div class="container">
        <div class="row">
            <div class="col-lg-9 offset-lg-2 text-center">
                <div class="hero-text">
                    <div class="hero-text-tablecell">
                        <p class="subtitle">The Stylist Coffee & Best Quality</p>
                        <h1>Coffee Shop</h1>
<%--                        <div class="hero-btns">--%>
<%--                            <a href="shop.html" class="boxed-btn">Fruit Collection</a>--%>
<%--                            <a href="contact.html" class="bordered-btn">Contact Us</a>--%>
<%--                        </div>--%>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- end hero area -->

<!-- features list section -->
<div class="list-section pt-80 pb-80">
    <div class="container">

        <div class="row">
            <div class="col-lg-4 col-md-6 mb-4 mb-lg-0">
                <div class="list-box d-flex align-items-center">
                    <div class="list-icon">
                        <i class="fas fa-shipping-fast"></i>
                    </div>
                    <div class="content">
                        <h3>Giao hàng nhanh</h3>
                        <p>Giao hàng trong 3 ngày</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 mb-4 mb-lg-0">
                <div class="list-box d-flex align-items-center">
                    <div class="list-icon">
                        <i class="fas fa-phone-volume"></i>
                    </div>
                    <div class="content">
                        <h3>Hỗ trợ 24/7</h3>
                        <p>Nhận hỗ trợ 24/7</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="list-box d-flex justify-content-start align-items-center">
                    <div class="list-icon">
                        <i class="fas fa-sync"></i>
                    </div>
                    <div class="content">
                        <h3>Hoàn trả</h3>
                        <p>Hoàn tiền sản phẩm trong vòng 7 ngày</p>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<!-- end features list section -->

<!-- product section -->
<div class="product-section mt-150 mb-150">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 offset-lg-2 text-center">
                <div class="section-title">
                    <h3><span class="orange-text">Sản phẩm</span> Nestle Cafe</h3>
                </div>
            </div>
        </div>

        <div class="row products-home">
            <c:if test="${!error.equals('list nest cafes products is empty!')}">
                <c:forEach var="item" items="${list_nestcafe_products}">
                    <div class="col-lg-4 col-md-6 text-center">
                        <div class="single-product-item">
                            <a href="/product/${item.pr_id}">
                                <div class="product-image">
                                    <img src="${item.prImg_url}" alt="">
                                </div>
                            </a>
                            <h3 style="font-size: 18px">${item.pr_name}</h3>
                            <h4 style="font-size: 18px">${item.pr_price} đ</h4>
                            <p class="product-price"><span>${item.pr_description}</span></p>
                            <a href="cart.html" class="cart-btn"><i class="fas fa-shopping-cart">

                            </i>Thêm vào giỏ</a>
                        </div>
                    </div>
                </c:forEach>
            </c:if>
        </div>
    </div>
</div>

<div class="latest-news pt-150 pb-150">
    <div class="container">

        <div class="row">
            <div class="col-lg-8 offset-lg-2 text-center">
                <div class="section-title">
                    <h3><span class="orange-text">Vina</span> Cafe</h3>
                </div>
            </div>
        </div>

        <div class="row">
            <c:if test="${!error.equals('list vina cafes products is empty!')}">
                <c:forEach var="item" items="${list_vinastar_product}">
                    <div class="col-lg-4 col-md-6 text-center">
                        <div class="single-product-item">
                            <a href="/product/${item.pr_id}">
                                <div class="product-image">
                                    <img class="" src="${item.prImg_url}" alt="">
                                </div>
                            </a>
                            <h3 style="font-size: 18px">${item.pr_name}</h3>
                            <h4 style="font-size: 18px">${item.pr_price} đ</h4>
                            <p class="product-price"><span>${item.pr_description}</span></p>
                            <a href="cart.html" class="cart-btn"><i class="fas fa-shopping-cart">

                            </i>Thêm vào giỏ</a>
                        </div>
                    </div>
                </c:forEach>
            </c:if>
        </div>

        <div class="row">
            <div class="col-lg-12 text-center">
                <a href="/brands/all" class="boxed-btn">Các Thương Hiệu</a>
            </div>
        </div>
    </div>
</div>


<%@include file="/WEB-INF/pages/template/footer.jsp" %>