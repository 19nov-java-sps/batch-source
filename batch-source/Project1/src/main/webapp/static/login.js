
document.getElementById("login-btn").addEventListener("click", requestLogin);


function requestLogin(){
	let url = "http://localhost:8080/Project1/login";
	let xhr = new XMLHttpRequest();
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status===200){
			// set authorization in our browser for future request
			let auth = xhr.getResponseHeader("Authorization");
			sessionStorage.setItem("token", auth);
			console.log(auth);
			window.location.href="http://localhost:8080/Project1/index";
		}
		if(this.readyState === 4 ){
			console.log(this);
		}
	}
	let user = document.getElementById("user-name").value;
	let pass = document.getElementById("user-pass").value;
	
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
	
	let requestBody = `userName=${user}&passWord=${pass}`;
	
	xhr.send(requestBody);
	
	
}