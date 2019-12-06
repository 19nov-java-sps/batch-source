document.getElementById("update-btn").addEventListener("click", updateEmployee);

 let auth = sessionStorage.getItem("token");
 let tokenArr = auth.split(":");
 let id = tokenArr[0];

 function updateEmployee() {
 let url = "http://localhost:8080/ERS/updateemployee";
 let xhr = new XMLHttpRequest();
 xhr.open("POST", url);
 xhr.onreadystatechange = function() {
 // if (this.readyState == 4) {
 //
 // }
 if (this.readyState === 4 && this.status === 200) {
 window.location.href = "http://localhost:8080/ERS/home";
 }

 }
 let fullname = document.getElementById("fullname").value;
 let username = document.getElementById("username").value;
 let password = document.getElementById("password").value;
 let thisID = id;

 xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
 let requestBody = `fullname=${fullname}&username=${username}&password=${password}&thisID=${id}`;
 xhr.send(requestBody);

 }

//let auth = sessionStorage.getItem("token");
//let tokenArr = auth.split(":");
//let id = tokenArr[0];
//
//function updateEmployee() {
//	let url = "http://localhost:8080/ERS/updateemployee";
//	let xhr = new XMLHttpRequest();
//	xhr.open("POST", url);
//	xhr.onreadystatechange = function() {
////		if (this.readyState == 4) {
////			console.log(this);
////		}
//		if (this.readyState === 4 && this.status === 200) {
//			// set authorization in our browser for future request
//
//			window.location.href = "http://localhost:8080/ERS/home";
//
//		}
//
//	}
//	let firstname = document.getElementById("firstname").value;
//	let lastname = document.getElementById("lastname").value;
//	let email = document.getElementById("email").value;
//	let password = document.getElementById("password").value;
//	let thisID = id;
//
//	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
//	let requestBody = `firstname=${firstname}&lastname=${lastname}&email=${email}&password=${password}&thisID=${id}`;
//	console.log(requestBody);
//	xhr.send(requestBody);
//
//}
