// const countCart = document.getElementById("countCart")
// const count = localStorage.getItem("aa");
//
// countCart.innerText = count ? count : 0;


function addToCart(productId){
    console.log(productId)
    localStorage.setItem("aa",productId);
    const countCart = document.getElementById("countCart")
    const count = localStorage.getItem("aa");

    countCart.innerText = count ? count : 0;
}