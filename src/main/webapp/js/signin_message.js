var count=document.getElementById("signin").getAttribute("data-signin");
if(count>0){
alert("Signin successful");
window.location.href="UserPage.jsp";

}
else {
alert("Error occurred while signing in.");
window.location.href="UserPage.jsp";
}