let token = sessionStorage.getItem("token");
let employeesURL = "http://localhost:8080/expensify/api/employees"
let userId = token.split(":")[0]
document.getElementById("update-btn").addEventListener("click", updateEmployee)

function updateEmployee(){
	let xhr = new XMLHttpRequest();
	xhr.open("POST", employeesURL );
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200) {
			window.location.href= "http://localhost:8080/expensify/landing"

		} 
	}
	let password = document.getElementById("password").value;
	let username = document.getElementById("username").value;
	let fullname = document.getElementById("fullname").value;
	
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
	xhr.setRequestHeader("Authorization", token)
	
	let requestBody = `password=${password}&fullname=${fullname}&username=${username}&userId=${userId}`;
	console.log(requestBody)
	xhr.send(requestBody);

	
}

