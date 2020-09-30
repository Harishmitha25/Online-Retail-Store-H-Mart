var check=document.getElementById("edit-grocery").getAttribute("data-edit-grocery");
if(check){
alert("Grocery Item updated successfully");
window.location.href="EditGrocery.jsp";

}
else {
alert("Error occurred while updating grocery item.");
window.location.href="EditGrocery.jsp";
}