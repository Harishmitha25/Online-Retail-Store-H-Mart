var id=document.getElementById("stock").getAttribute("data-id");
var quantity=document.getElementById("stock").getAttribute("data-quantity");
alert("Required quantity is in stock.");
window.location.href="/cartCheck?id="+id+"&quantity="+quantity;