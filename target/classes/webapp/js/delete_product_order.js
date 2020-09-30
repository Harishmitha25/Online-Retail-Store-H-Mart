var orderId=document.getElementById("order").getAttribute("data-order-id");
var productId=document.getElementById("order").getAttribute("data-product-id");
alert("Confirm product order deletion");
window.location.href="/deleteProductOrder?orderId="+orderId+"&productId="+productId;