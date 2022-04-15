<%@include file="/WEB-INF/pages/template/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<div class="breadcrumb-section breadcrumb-bg">
   <div class="container">
      <div class="row">
         <div class="col-lg-8 offset-lg-2 text-center">
            <div class="breadcrumb-text">
               <h1>Thanh Toán</h1>
            </div>
         </div>
      </div>
   </div>
</div>

<div class="checkout-section mt-150 mb-150">
   <div class="container">
      <div class="row">
         <div class="col-lg-24 col-md-12">
            <div class="cart-table-wrap">
               <table id="cart-table" class="cart-table">
                  <thead class="cart-table-head">
                  <tr class="table-head-row">
                     <th class="id">ID</th>
                     <th class="image">Hình Ảnh</th>
                     <th class="name">Tên SP</th>
                     <th class="price">Giá (vnd)</th>
                     <th class="quantity">Số Lượng</th>
                     <th class="total">Tổng</th>
                  </tr>
                  </thead>
                  <tbody>

                  </tbody>
               </table>
            </div>
         </div>


         <div class="col-lg-24 col-md-12" style="margin-top: 30px">
            <div class="user-addresses">
               <div class="addresses">
                  <div class="address" style="padding-top: 18px;">
                     <div style="display: flex;">
                        <div class="field">
                           <h5>Địa chỉ giao hàng</h5>
                           <div>
                              <label>Địa chỉ:</label>
                              <p id="address">${address.address}</p>
                           </div>
                           <div>
                              <label>Tỉnh/tp:</label>
                              <p id="city">${address.city_province}</p>
                           </div>
                           <div>
                              <label>Quận/huyện:</label>
                              <p>${address.district}</p>
                           </div>
                           <div>
                              <label>Phường/xã:</label>
                              <p>${address.ward}</p>
                           </div>
                        </div>
                        <a href="/user/user-info" style="margin: 35px 0 0 10px;">
                           <button class="btn btn-warning">Sửa Địa chỉ</button>
                        </a>
                     </div>
                  </div>
               </div>
            </div>

            <div class="shipping-methods" style="margin:15px 0 0 10px ;display: inline-block" >
               <h5>Vận chuyển</h5>
                  <div class="shipping-unit" style="display: flex" >
                     <label> Đơn vị vận chuyển:</label>
                     <p>Giao Hàng Nhanh</p>
                     <img width="50" style="margin: -10px 0 0 10px" src="https://web5s.com.vn/van-don-giao-hang-nhanh/imager_105801.jpg" alt=""/>
                  </div>
                  <div class="shipping-fee" style="background: white">
                     <c:if test="${not empty shipping_fee_err}">
                        <p style="color: red">Lỗi tính phí ship, kiểm tra lại địa chỉ của bạn!</p>
                     </c:if>
                     <c:if test="${empty shipping_fee_err}">
                        <div class="shipping-fee" style="display: flex">
                           <label>Phí vận chuyển: </label>
                           <p>${shipping_fee.total}đ</p>
                        </div>
                        <div class="shipping-method" style="display: flex">
                           <label>Phương thức vận chuyển: </label>
                           <p>${shipping_fee.serviceName}</p>
                        </div>
                        <div class="shipping-announcement" style="color: cornflowerblue ;display: flex">
                           <label> Thông báo: </label>
                           <p style="color: cornflowerblue">${shipping_fee.message}</p>
                        </div>
                     </c:if>
                  </div>
            </div>


            <div class="payment-methods" style="margin-top: 30px">
               <h5>Phương thức thanh toán</h5>

               <div class="form-check method" style="background: white">
                  <input name="payment-method" style="cursor: pointer" class="form-check-input" type="radio"
                         value="vnpay" id="method-vnpay">

                  <label
                     style="background: white; border-radius: 3px; border: 1px solid #80808080; padding: 10px; margin-top: -12px"
                     class="form-check-label" for="method-vnpay">
                     <img src="https://pay.vnpay.vn/images/logo.png" alt="" width="100px" title="Thanh toán với vnpay"/>
                  </label>

               </div>
               <div class="form-check method">
                  <input name="payment-method" style="cursor: pointer" class="form-check-input" type="radio" value="cod"
                         id="method-cod" checked>

                  <label
                     style="background: white; border-radius: 3px; border: 1px solid #80808080; padding: 5px; margin-top: -7px"
                     class="form-check-label" for="method-cod">Thanh toán khi nhận hàng (COD)</label>
               </div>
            </div>
         </div>

         <div style="width: 100%">
            <div class="cart-buttons">
               <a class="cart-btn" id="cart-btn-order" onclick="makeOrder(${shipping_fee.total}) ">Đặt Hàng</a>
            </div>
         </div>
      </div>
   </div>
</div>

<!-- Modal -->
<div class="modal fade" id="exampleModal2" tabindex="-1" role="dialog"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
   <div class="modal-dialog" role="document">
      <div class="modal-content">
         <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Thông báo</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
               <span aria-hidden="true">&times;</span>
            </button>
         </div>
         <div class="modal-body" id="modal-body-message">
            Đơn hàng đã được thực hiện
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-primary" id="btn-save"
                    onclick="directToUserInfo()">Xem đơn hàng
            </button>
         </div>
      </div>
   </div>
   <script>

       function directToUserInfo() {
           console.log("line 165")
           window.location.href = "/user/user_info.jsp"
       }

       async function getProducts() {
           const cart = localStorage.getItem("cart") ? JSON.parse(localStorage.getItem("cart")) : [];
           if (!cart.length) return;

           const ids = cart.map(item => item.product_id)
           try {
               const res = await fetch('/product/get-products', {
                   method: 'POST',
                   headers: {
                       'Content-Type': 'application/json',
                   },
                   body: JSON.stringify({product_ids: ids}),
               })
               const dataRes = await res.json();

               if (dataRes.err) {
                   console.log("login required!");
                   return;
               }

               const products = dataRes.products;
               products.forEach(product => {
                   for (let i = 0; i < cart.length; i++) {
                       if (product.pr_id === cart[i].product_id) {
                           product.quantity = cart[i].quantity;
                           product.total = product.quantity * product.pr_price;
                           break;
                       }
                   }
               })

               renderTable(products);
           } catch (err) {
               console.log(err)
           }
       }

       getProducts();

       async function makeOrder(shippingFee) {
           const city = document.getElementById("city").innerHTML;
           const addres = document.getElementById("address").innerHTML;

           const products = localStorage.getItem("products") ? JSON.parse(localStorage.getItem("products")) : [];
           if (!products.length) {
               alert("Đơn hàng trống!");
               return;
           }
           let total = shippingFee;
           for (let i = 0; i < products.length; i++) total += products[i].total;

           const paymentMethods = document.getElementsByName("payment-method");
           let method = null;
           for (let i = 0; i < paymentMethods.length; i++) {
               if (paymentMethods[i].checked === true) {
                   method = paymentMethods[i].value;
                   break;
               }
           }
           try {
               const data = {
                   shipping_fee: parseInt(shippingFee),
                   total: total,
                   products: products,
                   address: {
                       address: addres,
                       city: city
                   },
               };
               switch (method) {
                   case "vnpay":
                       console.log("dataRes")
                       const res = await fetch('/payment/pay_with_vnpay', {
                           method: 'POST',
                           headers: {
                               'Content-Type': 'application/json',
                           },
                           body: JSON.stringify(data),
                       })
                       const dataRes = await res.json();

                       if (dataRes) {
                           window.location.href = dataRes.paymentUrl;
                       }
                       break;
                   case "cod":
                       console.log("dataRes")
                       const response = await fetch('/payment/pay_with_cod', {
                           method: 'POST',
                           headers: {
                               'Content-Type': 'application/json',
                           },
                           body: JSON.stringify(data),
                       })
                       const dataResp = await response.json();
                       console.log("asdas")
                       if (dataResp) {
                           window.location.href = "/user/user-info"
                           localStorage.removeItem("cart");
                           localStorage.removeItem("products");
                       }
                       break;
                   default:
                       return;
               }
           } catch (err) {
               console.log(err)
           }
       }

       function renderTable(products) {
           products.forEach(product => {
               let rows = "";
               rows += "<tr>" +
                   "<td class='id'>" + product.pr_id + "</td>" +
                   "<td class='image'>" + "<img class='img-cart-product' src=" + product.prImg_url + " alt=''/>" + "</td>" +
                   "<td style='max-width: 200px' class='name'>" + product.pr_name + "</td>" +
                   "<td class='price'>" + product.pr_price + "</td>" +
                   "<td class='quantity'>" + product.quantity + "</td>" +
                   "<td class='total' id='totalvalue" + product.pr_id + "' >" + product.total + "</td>" +
                   "</tr>";

               $(rows).appendTo("#cart-table tbody");
           })
       }
   </script>


   <%@include file="/WEB-INF/pages/template/footer.jsp" %>
