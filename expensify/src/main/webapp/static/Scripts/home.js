document.getElementById("btn").addEventListener("click", requestLogin);

function requestLogin() {

	let url = "http://localhost:8080/expensify/home";
	let xhr = new XMLHttpRequest();
	xhr.open("POST", url);

	xhr.onreadystatechange = function(){
		if (this.readyState === 4 && this.status === 200) {
			let auth = xhr.getResponseHeader("Authorization");
			sessionStorage.setItem("token", auth);
			window.location.href="http://localhost:8080/expensify/landing";
		} 
		
		if (this.readyState === 4) {
			console.log(this);
		}

	}
	
	let username = document.getElementById("username").value;
	let password = document.getElementById("passwordString").value;
	
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
	
	let requestBody = `username=${username}&password=${password}`;
	xhr.send(requestBody);
	
}