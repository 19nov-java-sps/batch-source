
document.getElementById("login-btn").addEventListener("click", requestLogin);


function requestLogin(){
	
	let url = "http://localhost:8080/ERS/login";
	let xhr = new XMLHttpRequest();
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status===200){
			// set authorization in our browser for future request
			let auth = xhr.getResponseHeader("Authorization");
			sessionStorage.setItem("token", auth);
			let tokenArr = auth.split(":");
			if(tokenArr[1]=="General"){
				window.location.href="http://localhost:8080/ERS/employee";
			}
			else{
				window.location.href="http://localhost:8080/ERS/manager";
			}
			
			
		}
		if(this.readyState === 4 ){
			console.log(this);
		}
	}
	let email = document.getElementById("email").value;
	let pass = document.getElementById("password").value;

	console.log(email);
	console.log(pass);
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
	
	let requestBody = `email=${email}&password=${pass}`;
	
	xhr.send(requestBody);
	
	
}