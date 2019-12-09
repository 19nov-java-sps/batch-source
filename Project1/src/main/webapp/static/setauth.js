token = sessionStorage.getItem("token");

if(!token){
	window.location.href="http://localhost:8080/AuthDemo/login";
} else {
	document.getElementById("auth").value = token;
}
