function calcCountCart() {
    let cart = localStorage.getItem("cart")
        ? JSON.parse(localStorage.getItem("cart"))
        : [];
    const countCart = document.getElementById("countCart");

    let total = 0;
    for (let i = 0; i < cart.length; i++) total += parseInt(cart[i].quantity);

    countCart.innerText = total;
}

calcCountCart();

function addToCart(productId, quantity) {
    let cart = localStorage.getItem("cart")
        ? JSON.parse(localStorage.getItem("cart"))
        : [];
    const countCart = document.getElementById("countCart");

    let total = parseInt(countCart.innerText);
    console.log(total)
    let isExisted = false;
    if (cart.length) {
        for (let i = 0; i < cart.length; i++) {
            if (cart[i].product_id === productId) {
                cart[i].quantity += parseInt(quantity);
                total += cart[i].quantity;

                isExisted = true;
            }
        }
    }

    if (!isExisted) {
        cart.push({
            product_id: productId,
            quantity: parseInt(quantity)
        });
        total += quantity;
    }

    localStorage.setItem("cart", JSON.stringify(cart));
    countCart.innerText = total ? total : 0;
}