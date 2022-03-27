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
               <h1>Thông Tin</h1>
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

            <div class="user-addresses">
               <div>
                  <div class="fields">
                     <div class="field">
                        <label>Tỉnh/tp:</label>
                        <select class="form-select" id="cities-options" onchange="getCityId()"
                        <c:forEach var="item" items="${cities}">
                           <option value=${item.provinceID}>${item.provinceName}</option>
                        </c:forEach>
                        </select>
                     </div>

                     <div class="field">
                        <label>Quận/huyện:</label>
                        <select class="form-select" id="districts-options" onchange="getDistrictId()">
                           <%-- Data from js below --%>
                        </select>
                     </div>

                     <div class="field">
                        <label>Phường/xã:</label>
                        <select class="form-select" id="wards-options">
                           <%-- Data from js below --%>
                        </select>
                     </div>

                     <div class="field">
                        <label>Địa chỉ:</label>
                        <input id="address-detail" class="form-control" type="text"
                               placeholder="Địa chỉ cụ thể"/>

                     </div>
                  </div>

                  <button onclick="updateAddress()" class="btn btn-primary">Thêm địa chỉ</button>
               </div>

               <div style="height: 50px"></div>

               <div class="addresses">
                  <c:forEach var="item" items="${addresses}">
                     <div class="address">
                        <div style="display: flex; justify-content: space-between">
                           <div class="field">
                              <div>
                                 <label>Địa chỉ:</label>
                                 <p>${item.address}</p>
                              </div>

                              <div>
                                 <label>Tỉnh/tp:</label>
                                 <p>${item.city_province}</p>
                              </div>

                              <div>
                                 <label>Quận/huyện:</label>
                                 <p>${item.district}</p>
                              </div>

                              <div>
                                 <label>Phường/xã:</label>
                                 <p>${item.ward}</p>
                              </div>
                           </div>

                           <div style="display: flex; flex-direction: column; justify-content: space-between">
                              <div class="form-check" style="text-align: center">
                                 <c:if test="${item.is_main == true}">
                                    <input
                                       class="form-check-input"
                                       type="radio"
                                       id="addressdefault${item.id}"
                                       onclick="setDefaultAddress(${item.id})"
                                       checked
                                    >
                                 </c:if>
                                 <c:if test="${item.is_main == false}">
                                    <input
                                       class="form-check-input"
                                       type="radio"
                                       id="addressdefault${item.id}"
                                       onclick="setDefaultAddress(${item.id})"
                                    >
                                 </c:if>
                              </div>

                              <div>
                                 <button type="button" class="btn btn-light" data-toggle="modal"
                                         data-target="#exampleModal" style="width: 60px; height: 35px"
                                         onclick="setDelAddressIdToDel(${item.id}, 'set')">
                                    Xoá
                                 </button>
                              </div>

                           </div>
                        </div>
                     </div>
                  </c:forEach>
               </div>
            </div>


            <div style="height: 2px;width: 40%;background: gray;margin: 50px 0 30px 0"></div>

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


               <spring:bind path="phone">
                  <div class="form-group col-md-6">
                     <h7>Số điện thoại</h7>
                     <form:input maxlength="10" type="tel" class="form-control" id="" name="phone" value='${user.phone}'
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

         </div>
      </div>
   </div>
</div>


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
   <div class="modal-dialog" role="document">
      <div class="modal-content">
         <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Xoá địa chỉ?</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
               <span aria-hidden="true">&times;</span>
            </button>
         </div>
         <div class="modal-body" id="modal-body-message">
            Bạn có chắc muốn xoá địa chỉ?
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="setDelAddressIdToDel(0, 'del')" >Đóng
            </button>
            <button type="button" class="btn btn-primary" id="btn-save"
                    onclick="deleteAddress()">Xoá địa chỉ
            </button>
         </div>
      </div>
   </div>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script>

    function getCityId() {
        const city = document.getElementById('cities-options');
        const city_id = city.value;

        // get api quận từ cái id của city
        $.ajax({
            type: 'GET',
            url: '/user/get-district/' + city_id,
            dataType: 'json',
            contentType: 'application/json',
            success: function (result) {
                let districtsOptions = document.getElementById('districts-options');
                districtsOptions.innerHTML = "";
                districtsOptions.value = "";
                result.data.forEach(item => {
                    let option = document.createElement("option");
                    option.innerHTML = item.DistrictName;
                    option.value = item.DistrictID;
                    districtsOptions.appendChild(option, 1);
                })
            }
        });

    }

    function getDistrictId() {
        const district = document.getElementById('districts-options');
        const district_id = district.value;
        $.ajax({
            type: 'GET',
            url: '/user/get-ward/' + district_id,
            dataType: 'json',
            contentType: 'application/json',
            success: function (result) {
                let wardsOptions = document.getElementById('wards-options');
                wardsOptions.innerHTML = "";
                wardsOptions.value = "";
                result.data.forEach(item => {
                    let option = document.createElement("option");
                    option.innerHTML = item.WardName;
                    option.value = item.WardCode;
                    wardsOptions.appendChild(option, 1);
                })
            }
        });
    }

    async function updateAddress() {
        const city = document.getElementById("cities-options");
        const district = document.getElementById("districts-options");
        const ward = document.getElementById("wards-options");
        const detail = document.getElementById("address-detail");

        //city.selectedOptions[0].text
        if (!city.value || !district.value || !ward.value || !detail.value) {
            alert("Hãy nhập đủ thông tin")
            return;
        }


        const data = {
            city: city.selectedOptions[0].text,
            district: district.selectedOptions[0].text,
            ward: ward.selectedOptions[0].text,
            detail: detail.value,
        }

        try {
            const res = await fetch('/user/update-address', {
                method: 'POST', // or 'PUT'
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(data),
            })
            const dataRes = await res.json();

            if (dataRes.msg) location.reload();
        } catch (err) {
            console.log(err)
        }
    }

    async function setDefaultAddress(addressId) {
        // const isDefault = document.getElementById("addressdefault" + addressId)
        // if (isDefault.checked == true) return;

        try {
            const res = await fetch('/user/update-default-address', {
                method: 'POST', // or 'PUT'
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({address_id: addressId}),
            })
            const dataRes = await res.json();

            if (dataRes.msg) location.reload();
        } catch (err) {
            console.log(err)
        }
    }

    function setDelAddressIdToDel(id, type){
        if(type === "set") localStorage.setItem('address_id_del',JSON.stringify(id))
        else localStorage.removeItem('address_id_del')
    }

    async function deleteAddress() {
      const addressId = localStorage.getItem("address_id_del") ? JSON.parse(localStorage.getItem("address_id_del")) : null;

         try {
            const res = await fetch('/user/delete-address', {
                method: 'POST', // or 'PUT'
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({address_id: addressId}),
            })
            const dataRes = await res.json();

            if (dataRes.msg) {
                location.reload();
                localStorage.removeItem('address_id_del');
            }

            if (dataRes.err) {
                const errMessage = document.getElementById("modal-body-message");
                errMessage.innerHTML = "";
                errMessage.append("Xoá thất bại");

                const hideButton = document.getElementById("btn-save");
                hideButton.style.display = "none";
            }

        } catch (err) {
            alert(err)
        }
    }

</script>
<%@include file="/WEB-INF/pages/template/footer.jsp" %>
