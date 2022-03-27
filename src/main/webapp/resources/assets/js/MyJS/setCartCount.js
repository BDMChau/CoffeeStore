function calcCountCart() {
    let cart = localStorage.getItem("cart")
        ? JSON.parse(localStorage.getItem("cart"))
        : [];
    const countCart = document.getElementById("countCart");

    let total = 0;
    if (cart.length) for (let i = 0; i < cart.length; i++) total += cart[i].quantity;

    countCart.innerText = total;
}

calcCountCart();

function addToCart(productId, quantity) {
    let cart = localStorage.getItem("cart")
        ? JSON.parse(localStorage.getItem("cart"))
        : [];
    const countCart = document.getElementById("countCart");

    let total = parseInt(countCart.innerText);
    let isExisted = false;
    if (cart.length) {
        for (let i = 0; i < cart.length; i++) {
            if (cart[i].product_id === productId) {
                cart[i].quantity += quantity;
                total += quantity;

                isExisted = true;
            }
        }
    }

    if (!isExisted) {
        cart.push({
            product_id: productId,
            quantity: quantity
        });
        total += quantity;
    }

    localStorage.setItem("cart", JSON.stringify(cart));
    countCart.innerText = total;
}