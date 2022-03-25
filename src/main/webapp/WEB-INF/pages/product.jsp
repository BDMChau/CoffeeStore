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
                        <h3 style="color: white">Sản Phẩm</h3>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container product-page">
    <div class="row" style="flex-direction: column">
        <div style="display: flex">
            <div class="thumbnail">
                <img class="thumbnail-img" src=${product_info.prImg_url} alt="" width="300" height="350"/>
            </div>
            <div class="title" style="display: flex;flex-direction: column;justify-content: space-between">
                <div>
                    <div class="name">
                        <h3>${product_info.bra_name}</h3>
                    </div>

                    <div class="price">
                        <h5>${product_info.pr_price} đ</h5>
                    </div>

                    <div class="rating">
                        <p>${product_info.count_views} lượt xem</p>
                    </div>
                    <div class="rating">
                        <p>${product_info.rating_star}/5 <i style="color: #f3be46" class="fa fa-star"></i></p>
                    </div>
                </div>

                <form style="margin: 0; display: flex;flex-direction: column">
                    <input
                            type="number"
                            id="quantity"
                            name="quantity"
                            min="1"
                            placeholder="Số lượng"
                            value=1
                    >

                    <button class="btn btn-primary" type="submit" style="width: 160px; height: 45px">
                        <i class="fas fa-shopping-cart"></i>
                        Thêm vào giỏ
                    </button>
                </form>
            </div>
        </div>

        <div style="margin-top: 30px;">
            <h5>Mô tả sản phẩm</h5>
            <p>${product_info.pr_description}</p>
        </div>

        <div style="margin-top: 100px;">
            <h5>Sản phẩm của thương hiệu</h5>
            <div class="thumbnail">
                <img class="thumbnail-img" src=${product_info.bra_logo} alt="" width="130" height="100"/>
            </div>
            <b>${product_info.bra_name}</b>
        </div>
    </div>
</div>


<%@include file="/WEB-INF/pages/template/footer.jsp" %>

