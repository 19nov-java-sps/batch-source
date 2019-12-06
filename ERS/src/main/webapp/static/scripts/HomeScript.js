document.getElementById("home-page").addEventListener("click", editView);
document.getElementById("logout-btn").addEventListener("click", getAjaxLogOut);

let token = sessionStorage.getItem("token");
let loginURL = "http://localhost:8080/ERS/login";

// checking of token is null, valid, or neither
if (!token) {
	window.location.href = "http://localhost:8080/ERS/TokenIsNull";
} else {
	let tokenArr = token.split(":");
	if (tokenArr.length === 2) {
		let baseUrl = "http://localhost:8080/ERS/api/employee?id=";
		sendAjaxGet(baseUrl + tokenArr[0], editView);
	} else {
		window.location.href = "http://localhost:8080/ERS/error";
	}
}

function sendAjaxGet(url, callback) {
	let xhr = new XMLHttpRequest();
	xhr.open("GET", url);
	xhr.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {
			callback(this);
		}
	}

	xhr.setRequestHeader("Authorization", token);

	xhr.send();
}

// will manipulate the home page depending on if user is a manager or not
function editView(xhr) {
	console.log(xhr.response);
	let empl = JSON.parse(xhr.response);
	if (empl.isManager == true) {
		document.getElementById("view-employees").hidden = false;
		document.getElementById("employee-requests").hidden = false;

	}

}

// will log you out once you click logout button
function getAjaxLogOut() {
	sessionStorage.clear();
	window.location.href = loginURL;
}
