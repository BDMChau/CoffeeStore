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

         <div class="col-lg-24 col-md-12">
            <div>

            </div>
         </div>

         <div style="width: 100%" >
            <div class="cart-buttons">
               <a href="#" class="cart-btn">Xác nhận thanh toán</a>
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
