document.getElementById("login-btn").addEventListener("click", requestLogin);

function requestLogin() {

	let url = "http://localhost:8087/Project1/login";
	let xhr = new XMLHttpRequest();
	xhr.open("POST", url);

	xhr.onreadystatechange = function(){
		if (this.readyState === 4 && this.status === 200) {
			let auth = xhr.getResponseHeader("Authorization");
			sessionStorage.setItem("token", auth);
			window.location.href="http://localhost:8087/Project1/home";
		} 
		
	
		
		if (this.readyState === 4) {
			console.log(this);
		}

	}
	
	let email = document.getElementById("email").value;
	let password = document.getElementById("password").value;
	
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
	
	let requestBody = `email=${email}&password=${password}`;
	xhr.send(requestBody);
}