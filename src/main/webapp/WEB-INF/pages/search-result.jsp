<%@include file="/WEB-INF/pages/template/header.jsp" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<div class="hero-area hero-bg" style="height: 45%">
    <div class="container">
        <div class="row">
            <div class="col-lg-9 offset-lg-2 text-center">
                <div class="hero-text">
                    <div class="hero-text-tablecell">
                        <p class="subtitle">The Stylist Coffee & Best Quality</p>
                        <h3 style="color: white">Kết Quả Tìm Kiếm</h3>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container search-page">
    <div class="row">
        <h4 style="width: 100%; margin-top: 20px">Sản phẩm</h4>
        <c:if test="${not empty error}">
            <h3>Không tìm thấy sản phẩm nào</h3>
        </c:if>

        <c:if test="${empty error}">
            <div class="result">
                <c:forEach var="item" items="${product_list}">
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
            </div>
        </c:if>
    </div>
</div>

<%@include file="/WEB-INF/pages/template/footer.jsp" %>