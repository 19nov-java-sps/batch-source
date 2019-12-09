document.getElementById("approve-btn").addEventListener("click",
		AjaxPutApproved);
document.getElementById("deny-btn").addEventListener("click", AjaxPutDenied);

let token = sessionStorage.getItem("token");
let tokenArr = token.split(":");
let managerId = tokenArr[0];
console.log(token);
console.log(tokenArr);
console.log(managerId);

function AjaxPutApproved() {

	let url = "http://localhost:8080/ERS/approved";
	let xhr = new XMLHttpRequest();
	xhr.open("POST", url);
	xhr.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {
			let auth = xhr.getResponseHeader("Authorization");
			// window.location.href = "http://localhost:8080/ERS/home";

		}
	}

	let pending = false;
	let approved = true;
	let denied = false;
	let resolved = true;
	let reimbursementID = document.getElementById("approve-deny-id").value;
	console.log(reimbursementID)

	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	let requestBody = `pending=${pending}&approved=${approved}&denied=${denied}&resolved=${resolved}&reimbursementID=${reimbursementID}`;
	xhr.send(requestBody);

	 window.location.href = "http://localhost:8080/ERS/home";

}

function AjaxPutDenied() {

	let url = "http://localhost:8080/ERS/denied";
	let xhr = new XMLHttpRequest();
	xhr.open("POST", url);
	xhr.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {
			let auth = xhr.getResponseHeader("Authorization");
			// window.location.href = "http://localhost:8080/ERS/home";

		}
	}

	let pending = false;
	let approved = false;
	let denied = true;
	let resolved = true;
	let reimbursementID = document.getElementById("approve-deny-id").value;
	console.log(reimbursementID)

	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	let requestBody = `pending=${pending}&approved=${approved}&denied=${denied}&resolved=${resolved}&reimbursementID=${reimbursementID}`;
	console.log(requestBody)
	xhr.send(requestBody);
	 window.location.href = "http://localhost:8080/ERS/home";

}