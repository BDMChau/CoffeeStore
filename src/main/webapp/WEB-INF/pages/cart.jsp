<%@include file="/WEB-INF/pages/template/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!-- breadcrumb-section -->
<div class="breadcrumb-section breadcrumb-bg">
   <div class="container">
      <div class="row">
         <div class="col-lg-8 offset-lg-2 text-center">
            <div class="breadcrumb-text">
               <h1>Giỏ Hàng</h1>
            </div>
         </div>
      </div>
   </div>
</div>
<!-- end breadcrumb section -->

<!-- cart -->
<div class="cart-section mt-150 mb-150">
   <div class="container">
      <div class="row">
         <div class="col-lg-24 col-md-12">
            <div class="cart-table-wrap">
               <table id="cart-table" class="cart-table">
                  <thead class="cart-table-head">
                  <tr class="table-head-row">
                     <th class="remove"></th>
                     <th class="id">ID</th>
                     <th class="image">Hình Ảnh</th>
                     <th class="name">Tên SP</th>
                     <th class="price">Giá (vnd)</th>
                     <th class="quantity">Số Lượng</th>
                     <th class="total">Tổng</th>
                  </tr>
                  </thead>
                  <tbody>
<%--                  <tr class="table-body-row">--%>
<%--                     <td class="remove"><a href="#"><i class="far fa-window-close"></i></a></td>--%>
<%--                     <td class="image"><img src="assets/img/products/product-img-1.jpg" alt=""></td>--%>
<%--                     <td class="name">Strawberry</td>--%>
<%--                     <td class="price">$85</td>--%>
<%--                     <td class="quantity"><input type="number" placeholder="0"></td>--%>
<%--                     <td class="total">1</td>--%>
<%--                  </tr>--%>
                  </tbody>
               </table>
            </div>
         </div>

         <div id="btn-tt" style="width: 100%" >
               <div class="cart-buttons" id="cart-buttons">
                  <a href="/user/checkout" class="cart-btn">Thanh toán</a>
               </div>
            </div>

            <%--        <div class="coupon-section">--%>
            <%--          <h3>Apply Coupon</h3>--%>
            <%--          <div class="coupon-form-wrap">--%>
            <%--            <form action="index.html">--%>
            <%--              <p><input type="text" placeholder="Coupon"></p>--%>
            <%--              <p><input type="submit" value="Apply"></p>--%>
            <%--            </form>--%>
            <%--          </div>--%>
            <%--        </div>--%>
         </div>
      </div>
   </div>
</div>
<!-- end cart -->

<script>
    function checkCart(){
        const btn = document.getElementById("btn-tt");

        const cart = localStorage.getItem("cart") ? JSON.parse(localStorage.getItem("cart")) : [];
        if (!cart.length) {
            btn.parentNode.removeChild(btn);
        }
    }
    checkCart();

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


            localStorage.setItem("products", JSON.stringify(products));
            renderTable(products);
        } catch (err) {
            console.log(err)
        }
    }

    getProducts();


    function updateCart(id){
      const products = localStorage.getItem("products") ? JSON.parse(localStorage.getItem("products")): [];

      const quantity = document.getElementById("inputquantity" + id).value;
      const total = document.getElementById("totalvalue" + id);

        for (let i = 0; i < products.length; i++) {
            if (products[i].pr_id === id) {
                products[i].quantity = parseInt(quantity);
                products[i].total = products[i].pr_price * products[i].quantity;
                total.innerText = products[i].pr_price * products[i].quantity;
                break;
            }
        }

        const cart = localStorage.getItem("cart") ? JSON.parse(localStorage.getItem("cart")) : [];
        if(cart.length){
            cart.forEach(item => {
                for (let i = 0; i < products.length; i++) {
                    if (products[i].pr_id === item.product_id) {
                        item.quantity = products[i].quantity;
                        break;
                    }
                }
            })
        }

        localStorage.setItem("cart", JSON.stringify(cart));
        localStorage.setItem("products", JSON.stringify(products));
    }

    function deleteProduct(id){
        let cart = localStorage.getItem("cart") ? JSON.parse(localStorage.getItem("cart")) : [];
        let products = localStorage.getItem("products") ? JSON.parse(localStorage.getItem("products")): [];

        cart = cart.filter(item => item.product_id !== id);
        products = products.filter(item => item.pr_id !== id);

        localStorage.setItem("cart", JSON.stringify(cart));
        localStorage.setItem("products", JSON.stringify(products));

        renderTable(products);
    }

    function renderTable(products) {
        $("#cart-table tr").remove();

        products.forEach(product => {
            let rows = "";
            rows += "<tr>" +
                `<td class="remove"><a onclick='deleteProduct(` + product.pr_id + `)' ><i style='font-size: 18px; color: black' class="far fa-window-close"></i></a></td>` +

                "<td class='id'>" + product.pr_id + "</td>" +
                "<td class='image'>" + "<img class='img-cart-product' src=" + product.prImg_url + " alt=''/>" + "</td>" +
                "<td style='max-width: 200px' class='name'>" + product.pr_name + "</td>" +
                "<td class='price'>" + product.pr_price + "</td>" +
                "<td class='quantity'>" + `<input id="inputquantity` + product.pr_id + `" onchange='updateCart(` + product.pr_id + `)' type="number" min="1" value=` + product.quantity + `>` + "</td>" +
                "<td class='total' id='totalvalue" + product.pr_id + "' >" + product.total + "</td>" +
                "</tr>";

            $(rows).appendTo("#cart-table tbody");
        })


    }
</script>

<%@include file="/WEB-INF/pages/template/footer.jsp" %>