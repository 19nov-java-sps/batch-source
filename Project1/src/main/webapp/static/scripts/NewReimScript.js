let token = sessionStorage.getItem("token");
document.getElementById("return-btn").addEventListener("click", returnHome);

if(!token){
	window.location.href="http://localhost:8080/Project1/login";
} else {
	let tokenArr = token.split(":");
	console.log(tokenArr);
}

//function returnHome() {
//	console.log('return')
//	window.location.href="http://localhost:8080/Project1/home";
//}