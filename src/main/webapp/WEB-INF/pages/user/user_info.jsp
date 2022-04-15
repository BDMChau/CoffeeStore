<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
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
               <h1>Thông Tin Cá Nhân</h1>
            </div>
         </div>
      </div>
   </div>
</div>
<div class="cart-section mt-150 mb-150">
   <div class="container">
      <div class="row">
         <div class="col-lg-12">
            <h4>Thông tin địa chỉ</h4>

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
                                       title="Đặt làm mặc định"
                                       id="addressdefault${item.id}"
                                       onclick="setDefaultAddress(${item.id})"
                                       checked
                                    >
                                 </c:if>
                                 <c:if test="${item.is_main == false}">
                                    <input
                                       class="form-check-input"
                                       type="radio"
                                       title="Đặt làm mặc định"
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


            <div style="height: 2px;width: 40%;background: gray;margin: 50px 0 15px 0"></div>
            <h4 style="">Thông tin khách hàng</h4>

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

            <div id="history-order" class="history-order">
               <h4 class="title">
                  Các đơn hàng đã đặt
               </h4>
            </div>
            <c:if test="${user_orders.size() == 0}">
               <div>
                  <h4 id="order-empty-notifi" style="text-align: center ; margin: 50px 0 0 0;">Bạn chưa có đơn hàng
                     nào</h4>
               </div>
            </c:if>
            <div id="orders" class="orders"></div>
            <nav aria-label="Page navigation">
               <ul class="pagination">
<%--                  <li class="page-item">--%>
<%--                     <a class="page-link" href="#" aria-label="Previous">--%>
<%--                        <span aria-hidden="true">&laquo;</span>--%>
<%--                        <span class="sr-only">Previous</span>--%>
<%--                     </a>--%>
<%--                  </li>--%>
                  <c:if test="${total_page_orders != 0}">
                     <c:forEach var="i" begin="1" end="${total_page_orders}">
                        <li id="page-${i}" class="page-item">
                           <a id="page-link" class="page-link" onclick="getOrdersData(${i})">${i}</a>
                        </li>
                     </c:forEach></c:if>
<%--                  <li class="page-item">--%>
<%--                     <a class="page-link" href="#" aria-label="Next">--%>
<%--                        <span aria-hidden="true">&raquo;</span>--%>
<%--                        <span class="sr-only">Next</span>--%>
<%--                     </a>--%>
<%--                  </li>--%>
               </ul>
            </nav>
            <%--Session--%>
            <div id="sessiondathanhtoan"
                 style="visibility: hidden;opacity: 0"><%=session.getAttribute("isdoneorder")%>
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
               <button type="button" class="btn btn-secondary" data-dismiss="modal"
                       onclick="setDelAddressIdToDel(0, 'del')">Đóng
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
       function nextPrevBtnPagi(){

       }

       async function getOrdersData(i, stt) {
           const prevPageActivatedIndex = localStorage.getItem("pageActivatedIndex") ? JSON.parse(localStorage.getItem("pageActivatedIndex")) : "";
           if (prevPageActivatedIndex && (prevPageActivatedIndex === i && !stt)) return;

           const page = document.getElementById("page-" + i).textContent;
           try {
               const res = await fetch('/order/get_user_orders/' + page, {
                   method: 'GET', // or 'PUT'
                   headers: {
                       'Content-Type': 'application/json',
                   },
               })
               const dataRes = await res.json();
               if (dataRes.user_orders) {
                   console.log(dataRes.user_orders)
                   renderOrders(dataRes.user_orders)

                   // append active page-item
                   if (prevPageActivatedIndex) {
                       const pageItem = document.getElementById("page-" + prevPageActivatedIndex);
                       pageItem.classList.remove("active")
                   }

                   const pageItem = document.getElementById("page-" + i);
                   pageItem.classList.add("active");

                   localStorage.setItem("pageActivatedIndex", JSON.stringify(i));
               }
           } catch (err) {
               console.log(err)
           }
       }

       function renderOrders(orders) {
           const orders_id = document.getElementById("orders"); //1st
           orders.forEach(order_info => {
               let orderDiv = document.createElement("div")
               orderDiv.classList.add("order");
               let orderProductDiv = document.createElement("div");
               orderProductDiv.classList.add("order-product");
               order_info.orderDetailDTOS.forEach(product => {
                   let productImg = document.createElement('img');
                   productImg.src = product.prImg_url;
                   productImg.classList.add("product-image")

                   //product-info//
                   let productName = document.createElement('p');
                   productName.innerHTML = product.product_name;
                   productName.classList.add("product-name")

                   let productPrice = document.createElement('p');
                   productPrice.innerHTML = "đơn giá: " + product.price + "đ";
                   productPrice.classList.add("product-price")

                   let productQuantity = document.createElement('p');
                   productQuantity.innerHTML = "Số lượng đặt: " + product.product_quantity;
                   productQuantity.classList.add("product-quantity")

                   let productInfoDiv = document.createElement("div")
                   productInfoDiv.appendChild(productName)
                   productInfoDiv.appendChild(productPrice)
                   productInfoDiv.appendChild(productQuantity)
                   //product-info//
                   let productDiv = document.createElement("div");
                   productDiv.classList.add("product");
                   productDiv.appendChild(productImg)
                   productDiv.appendChild(productInfoDiv)

                   let outerProductDiv = document.createElement("div");
                   outerProductDiv.appendChild(productDiv)
                   //order-product/////
                   orderProductDiv.appendChild(outerProductDiv)
               })
               //order-info////////
               //total-bill//1
               let totalBill = document.createElement('span');
               totalBill.innerText = "Tổng tiền: " + order_info.total_bill + "đ";
               totalBill.classList.add("total-bill")

               let totalBillStyle = document.createElement("p");
               totalBillStyle.appendChild(totalBill)
               //total-bill//

               //created-at//2
               let createdAt = document.createElement('p');
               const now = new Date(order_info.created_at);
               const offsetMs = now.getTimezoneOffset() * 60 * 1000;
               const dateLocal = new Date(now.getTime() - offsetMs);
               const dateString = dateLocal.toISOString().slice(0, 19).replace(/-/g, "/").replace("T", " ");

               createdAt.innerHTML = "Thời gian: " + dateString;
               createdAt.classList.add("created-at")
               //created-at//

               let orderInfoDiv = document.createElement("div")
               orderInfoDiv.appendChild(totalBillStyle)
               orderInfoDiv.appendChild(createdAt)
               //order-info////////
               let orderStyleDiv = document.createElement("div")
               orderStyleDiv.classList.add("order-style")

               orderProductDiv.appendChild(orderStyleDiv);
               orderProductDiv.appendChild(orderInfoDiv);
               //order-product//////
               orderDiv.appendChild(orderProductDiv);
               ///////
               orders_id.appendChild(orderDiv)

           })
       }


       function removeItemLocalStorage() {
           const session = document.getElementById('sessiondathanhtoan');
           if (session) {
               localStorage.removeItem("cart");
               localStorage.removeItem("products");
           }
       }


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

                   getDistrictId();
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

       function setDelAddressIdToDel(id, type) {
           if (type === "set") localStorage.setItem('address_id_del', JSON.stringify(id))
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


       ////////// execute //////////
       removeItemLocalStorage()
       getCityId();
       getOrdersData(1, "init");
   </script>
   <%@include file="/WEB-INF/pages/template/footer.jsp" %>
