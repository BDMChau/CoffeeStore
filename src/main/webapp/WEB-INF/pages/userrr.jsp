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
                <h4>Thông tin cá nhân</h4>

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
                        <button type="submit" value="submit" class="btn btn-primary" style="border-radius: 5px; width: 180px">Cập nhập</button>
                    </div>
                </form>

                <div style="width: 60%;height: 2px;text-align: center;margin: 20px auto; background: gray"></div>

                <div class="history-order">
                    <h4 class="title">
                        Các đơn hàng đã đặt
                    </h4>

                    <div class="orders">
                        <div class="order" style="border-radius: 5px; background: #F5F5F5">
                            <div style="padding: 20px">

                                <div class="product">
                                    <div style="display: flex">
                                        <img
                                                src="https://olptienganh.vn/wp-content/uploads/2022/01/99-Hinh-anh-Doremon-cute-De-thuong-Dep-nhat.jpg"
                                                alt=""
                                                width="100"
                                                height="100"
                                        />
                                        <div class="product-info">
                                            <p style="margin: 0">
                                                title-producttitle-producttitle-producttitle-producttitle-producttitle-producttitle-producttitle-producttitle-producttitle-product
                                            </p>
                                            <p style="color:grey; margin: 0;">45000đ/1</p>
                                            <p style="color:grey; margin: 0;">Số lượng đặt: 100</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="product">
                                    <div style="display: flex">
                                        <img
                                                src="https://olptienganh.vn/wp-content/uploads/2022/01/99-Hinh-anh-Doremon-cute-De-thuong-Dep-nhat.jpg"
                                                alt=""
                                                width="100"
                                                height="100"
                                        />
                                        <div class="product-info">
                                            <p style="margin: 0">
                                                title-producttitle-producttitle-producttitle-producttitle-producttitle-producttitle-producttitle-producttitle-producttitle-product
                                            </p>
                                            <p style="color:grey; margin: 0;">45000đ/1</p>
                                            <p style="color:grey; margin: 0;">Số lượng đặt: 100</p>
                                        </div>
                                    </div>
                                </div>

                                <div style="width: 70%;height: 1px;margin: 25px auto 10px auto; background: gray"></div>

                                <div class="order-info">
                                    <p style="margin: 0; font-size: 16px;">
                                        Tổng số tiền:
                                        <span style="font-weight: 500; font-size: 22px; color: #EE4D2D">45000000đ</span>
                                    </p>
                                    <p style="color:grey; margin: 0;" >19/02/2022</p>
                                </div>
                            </div>
                        </div>

                        <div class="order" style="border-radius: 5px; background: #F5F5F5">
                            <div style="padding: 20px">

                                <div class="product">
                                    <div style="display: flex">
                                        <img
                                                src="https://olptienganh.vn/wp-content/uploads/2022/01/99-Hinh-anh-Doremon-cute-De-thuong-Dep-nhat.jpg"
                                                alt=""
                                                width="100"
                                                height="100"
                                        />
                                        <div class="product-info">
                                            <p style="margin: 0">
                                                title-producttitle-producttitle-producttitle-producttitle-producttitle-producttitle-producttitle-producttitle-producttitle-product
                                            </p>
                                            <p style="color:grey; margin: 0;">45000đ/1</p>
                                            <p style="color:grey; margin: 0;">Số lượng đặt: 100</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="product">
                                    <div style="display: flex">
                                        <img
                                                src="https://olptienganh.vn/wp-content/uploads/2022/01/99-Hinh-anh-Doremon-cute-De-thuong-Dep-nhat.jpg"
                                                alt=""
                                                width="100"
                                                height="100"
                                        />
                                        <div class="product-info">
                                            <p style="margin: 0">
                                                title-producttitle-producttitle-producttitle-producttitle-producttitle-producttitle-producttitle-producttitle-producttitle-product
                                            </p>
                                            <p style="color:grey; margin: 0;">45000đ/1</p>
                                            <p style="color:grey; margin: 0;">Số lượng đặt: 100</p>
                                        </div>
                                    </div>
                                </div>

                                <div style="width: 70%;height: 1px;margin: 25px auto 10px auto; background: gray"></div>

                                <div class="order-info">
                                    <p style="margin: 0; font-size: 16px;">
                                        Tổng số tiền:
                                        <span style="font-weight: 500; font-size: 22px; color: #EE4D2D">45000000đ</span>
                                    </p>
                                    <p style="color:grey; margin: 0;" >19/02/2022</p>
                                </div>
                            </div>
                        </div>
                    </div>







                </div>
            </div>
        </div>
    </div>
</div>





<%@include file="/WEB-INF/pages/template/footer.jsp" %>
