<%@include file="/WEB-INF/pages/template/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link href="/resources/style/main.css">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


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
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h4>Thông tin cá nhân</h4>

                <form:form
                        class="row contact_us_form"
                        method="POST"
                        action="/user/user-info"
                        modelAttribute="userForm"
                >
                    <spring:bind path="name">
                        <div class="form-group col-md-6">
                            <h7>Tên Khách Hàng</h7>
                            <form:input type="text" class="form-control" id="nameCustomer" name="name"
                                        value='${user.name}' placeholder="Tên" path="name"/>
                        </div>
                    </spring:bind>

                    <spring:bind path="email">
                        <div class="form-group col-md-6">
                            <h7>Email</h7>
                            <form:input type="email" class="form-control" id="emailCustomer" name="email" path="email"
                                        value='${user.email}' placeholder="Email" readonly="readonly"/>
                        </div>
                    </spring:bind>

                    <div class="form-group col-md-6">
                        <h7>Tài khoản</h7>
                        <input type="text" class="form-control" id="userName" value="${user.email}"
                               placeholder="Tài khoản" name="account" readonly="readonly"/>
                    </div>
                    <%--                    <div class="form-group col-md-6">--%>
                    <%--                        <h7>Mật khẩu</h7>--%>
                    <%--                        <input type="password" class="form-control" id="passWord" value="" placeholder="Mật khẩu" disabled>--%>
                    <%--                    </div>--%>
                    <spring:bind path="phone">
                        <div class="form-group col-md-6">
                            <h7>Số điện thoại</h7>
                            <form:input type="tel" class="form-control" id="" name="phone" value='${user.phone}'
                                        placeholder="Số điện thoại" path="phone"/>
                        </div>
                    </spring:bind>

                    <spring:bind path="birthday">
                        <div class="form-group col-md-6">
                            <h7>Ngày sinh</h7>
                            <form:input type="date" class="form-control" id="numberCustomer" name="birthday"
                                        value='${user.birthday}' path="birthday" placeholder="Ngày sinh"/>
                        </div>
                    </spring:bind>


                    <div class="form-group col-md-12">
                        <button type="submit" value="submit" class="btn btn-primary"
                                style="border-radius: 5px; width: 180px">Cập nhập
                        </button>
                    </div>
                </form:form>

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
                                    <p style="color:grey; margin: 0;">19/02/2022</p>
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
                                    <p style="color:grey; margin: 0;">19/02/2022</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="user-addresses">
                    <select id="cities-options" onchange="getCityId()"
                    <c:forEach var="item" items="${cities}">
                        <option value=${item.provinceID}>${item.provinceName}</option>
                    </c:forEach>
                    </select>
                    <select id="districts-options">
                    <%-- Data from js below --%>
                    </select>
                </div>
            </div>
        </div>
    </div>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script>

    function getCityId() {
        const city = document.getElementById('cities-options');
        const city_id = city.value;
        console.log(city_id)

        // get api quận từ cái id của city
            $.ajax({
                type: 'GET',
                url: '/user/get-district/' + city_id,
                dataType: 'json',
                contentType: 'application/json',
                success: function (result) {
                    let districtsOptions = document.getElementById('districts-options');
                    result.data.forEach(item =>{
                        let option = document.createElement("option");
                        option.innerHTML = item.DistrictName;
                        option.value = item.DistrictID;
                        districtsOptions.appendChild(option, 1);
                    })
                }
            });

    }

</script>


<%@include file="/WEB-INF/pages/template/footer.jsp" %>
