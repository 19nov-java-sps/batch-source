//document.getElementById("update-btn").addEventListener("click", updateEmployee);
//
//let auth = sessionStorage.getItem("token");
//let tokenArr = auth.split(":");
//let id = tokenArr[0];
//console.log(auth);
//console.log(tokenArr);
//console.log(id);
//
//function updateEmployee() {
//	let url = "http://localhost:8080/ERS/updateemployee";
//	let xhr = new XMLHttpRequest();
//	xhr.open("POST", url);
//	xhr.onreadystatechange = function() {
//
//		if (this.readyState === 4 && this.status === 200) {
//
//		}
//
//	}
//	let fullname = document.getElementById("fullname").value;
//	let username = document.getElementById("username").value;
//	let password = document.getElementById("password").value;
//	// let thisID = id;
//	console.log(fullname)
//	console.log(username)
//	console.log(password)
//	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
//	let requestBody = `fullName=${fullname}&userName=${username}&passWord=${password}&id=${id}&manager=${tokenArr[1]}`;
//	console.log(requestBody)
//	xhr.send(requestBody);
//
//	window.location.href = "http://localhost:8080/ERS/home";
//}
