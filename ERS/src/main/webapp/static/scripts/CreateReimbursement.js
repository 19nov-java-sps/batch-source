//document.getElementById("request-btn").addEventListener("click",
//		createReimbursement);
//
//function createReimbursement() {
//	console.log("creating reimb")
//
//	let url = "http://localhost:8080/ERS/createreimbursement";
//	let xhr = new XMLHttpRequest();
//	xhr.open("POST", url);
//	xhr.onreadystatechange = function() {
//
//		if (this.readyState === 4 && this.status === 200) {
//
//			window.location.href = "http://localhost:8080/ERS/home";
//
//		}
//
//	}
//	let description = document.getElementById("description").value;
//	let amount = document.getElementById("amount").value;
//	let auth = sessionStorage.getItem("token");
//	let tokenArr = auth.split(":");
//	let id = tokenArr[0];
//	console.log(description);
//
//	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
//	let requestBody = `descritption=${description}&amount=${amount}&id=${id}`;
//	xhr.send(requestBody);
//
//}