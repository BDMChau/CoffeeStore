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
                        <c:if test="${address != null}">
                           <div class="field">
                              <div>
                                 <label>Địa chỉ:</label>
                                 <p>${address.address}</p>
                              </div>

                              <div>
                                 <label>Tỉnh/tp:</label>
                                 <p>${address.city_province}</p>
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
                        </c:if>

                        <a href="/user/user-info" style="margin-left: 30px;">
                           <button class="btn btn-warning">Sửa Địa chỉ</button>
                        </a>
                     </div>
                  </div>
               </div>
            </div>

            <div class="payment-methods" style="margin-top: 30px">
               <h5>Phí vận chuyển</h5>

               <div class="shipping-fee" style="background: white">
                  <c:if test="${not empty shipping_fee_err}">
                     <p style="color: red">Lỗi tính phí ship, kiểm tra lại địa chỉ của bạn!</p>
                  </c:if>

                  <c:if test="${empty shipping_fee_err}">
                     <h5 style="color: #0075FF">${shipping_fee.total}đ</h5>

                     <h6>Phương thức: <p>${shipping_fee.serviceName}</p></h6>
                     <p>${shipping_fee.message}</p>
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
               <a class="cart-btn" onclick="makeOrder()">Đặt Hàng</a>
            </div>
         </div>
      </div>
   </div>
</div>
</div>

<script>
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

    function makeOrder() {
        const paymentMethods = document.getElementsByName("payment-method");
        let method = null;
        for (let i = 0; i < paymentMethods.length; i++) {
            if (paymentMethods[i].checked === true) {
                method = paymentMethods[i].value;
                break;
            }
        }

        switch (method) {
            case vnpay:
                // code block
                break;
            case cod:

                break;
            default:
                return;
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
