
document.getElementById("login-btn").addEventListener("click", requestLogin);


function requestLogin(){
	console.log("I am in login.js requestLogin method");
	let url = "http://localhost:8080/Project1/login";
	let xhr = new XMLHttpRequest();
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status===200){
			console.log("I am in login.js requestLogin if readystate = 4 & 200 method");
			// set authorization in our browser for future request
			let auth = xhr.getResponseHeader("Authorization");
			sessionStorage.setItem("token", auth);
			console.log("log from login js " + auth);
			window.location.href="http://localhost:8080/Project1/index";
			
		}
		if(this.readyState === 4 ){
			console.log(this);
		}
	}
	
	
	let user = document.getElementById("username").value;
	let pass = document.getElementById("password").value;
	
	console.log("User and password from not if login.js requestLogin method"+ user + password);
	
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
	
	let requestBody = `username=${user}&password=${pass}`;
	
	xhr.send(requestBody);
	
	
}