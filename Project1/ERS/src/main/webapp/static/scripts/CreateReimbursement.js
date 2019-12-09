document.getElementById("create-request-btn").addEventListener("click",
		createReimbursement);

let auth = sessionStorage.getItem("token");
let tokenArr = auth.split(":");
let id = tokenArr[0];
console.log(auth);
console.log(tokenArr);
console.log(id);

function createReimbursement() {
	console.log("I am creating reimbursement")

	let url = "http://localhost:8080/ERS/createreimbursement";
	let xhr = new XMLHttpRequest();
	xhr.open("POST", url);
	xhr.onreadystatechange = function() {

		if (this.readyState === 4 && this.status === 200) {
			window.location.href = "http://localhost:8080/ERS/home";

			console.log("readyState=4, status=200");
		}

	}
	let reason = document.getElementById("reason").value;
	let amount = document.getElementById("amount").value;
	console.log(reason);
	console.log(amount);

	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
	let requestBody = `reason=${reason}&amount=${amount}&id=${id}&manager=${tokenArr[1]}&pending=${true}&approve=${false}&denied=${false}&resolved=${false}`;
	console.log(requestBody);
	xhr.send(requestBody);

	window.location.href = "http://localhost:8080/ERS/home";

}
