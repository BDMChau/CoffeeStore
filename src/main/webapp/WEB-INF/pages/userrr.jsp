<%@include file="/WEB-INF/pages/template/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/resources/style/main.css">


<div class="breadcrumb-section breadcrumb-bg">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 offset-lg-2 text-center">
                <div class="breadcrumb-text">
                    <p>Fresh and Organic</p>
                    <h1>User-Info</h1>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="cart-section mt-150 mb-150">
    <div class="container" >
        <div class="row">
            <div class="col-lg-12">
                <form class="row contact_us_form" action="" method="post" id="contactForm" novalidate="novalidate">
                    <div class="form-group col-md-6">
                        <h7>Tên Khách Hàng</h7>
                        <input type="text" class="form-control" id="nameCustomer" name="nameCustomer" value="" placeholder="Your name">
                    </div>
                    <div class="form-group col-md-6">
                        <h7>Email Khách Hàng</h7>
                        <input type="email" class="form-control" id="emailCustomer" name="email" value=""  placeholder="Email address" disabled>
                    </div>
                    <div class="form-group col-md-6">
                        <h7>Tài khoản</h7>
                        <input type="text" class="form-control" id="userName" value="" placeholder="Tài khoản" disabled>
                    </div>
                    <div class="form-group col-md-6">
                        <h7>Mật khẩu</h7>
                        <input type="password" class="form-control" id="passWord" value="" placeholder="Mật khẩu" disabled>
                    </div>
                    <div class="form-group col-md-6">
                        <h7>Số điện thoại</h7>
                        <input type="tel" class="form-control" id="" name="number" value="" placeholder="Số điện thoại">
                    </div>
                    <div class="form-group col-md-6">
                        <h7>Ngày sinh</h7>
                        <input type="date" class="form-control" id="numberCustomer" name="birthday" value="" placeholder="Số điện thoại">
                    </div>
                    <div class="form-group col-md-12">
                        <button type="submit" value="submit" class="btn order_s_btn form-control" style="border-color: #0b0b0b;border-radius: 2cm">Update</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>





<%@include file="/WEB-INF/pages/template/footer.jsp" %>
