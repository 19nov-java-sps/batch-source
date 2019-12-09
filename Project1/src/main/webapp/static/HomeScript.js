let token = sessionStorage.getItem("token");
//console.log(token);

if(!token){
	window.location.href="http://localhost:8080/AuthDemo/login";
} else {
	sendAjaxGet( "http://localhost:8080/AuthDemo/api/getUserInfo", displayName );
}

/*
 * if we are not redirected when checking for the token, a request will be made to 
 * the url for that particular user 
 */

function sendAjaxGet(url, callback){
	let xhr = new XMLHttpRequest();
	xhr.open("GET", url);
	xhr.onreadystatechange = function(){
		if(this.readyState===4 && this.status===200){
			callback(this);
		} else if (this.readyState===4){
			window.location.href="http://localhost:8080/AuthDemo/login";
		}
	}
	xhr.setRequestHeader("Authorization",token);
	xhr.send();
}

function displayName(xhr){
	let user = JSON.parse(xhr.response);
    console.log(user);
    if(document.getElementById("user"))
    	document.getElementById("user").innerHTML = user.username;
    if(document.getElementById("role"))
    	document.getElementById("role").innerHTML = user.userRole;
    if(document.getElementById("password"))
    	document.getElementById("password").innerHTML = user.password;
    if(document.getElementById("user_id"))
    	document.getElementById("user_id").innerHTML = user.id;
	
}
