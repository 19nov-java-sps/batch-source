let token = sessionStorage.getItem("token");
// console.log(token);

if (!token) {
	window.location.href = "http://localhost:8080/ERS/login";
} else {
	let tokenArr = token.split(":");
	console.log(tokenArr);
	if (tokenArr.length === 2) {
		let baseUrl = "http://localhost:8080/ERS/api/users?id=";
		sendAjaxGet(baseUrl + tokenArr[0], displayName);
	} else {
		window.location.href = "http://localhost:8080/ERS/login";
	}
}

/*
 * if we are not redirected when checking for the token, a request will be made
 * to the url for that particular user
 */

function sendAjaxGet(url, callback) {
	let xhr = new XMLHttpRequest();
	xhr.open("GET", url);
	xhr.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {
			callback(this);
		} else if (this.readyState === 4) {
			window.location.href = "http://localhost:8080/ERS/login";
		}
	}
	xhr.setRequestHeader("Authorization", token);
	xhr.send();
}

function displayName(xhr) {
	let employee = JSON.parse(xhr.response);
	// console.log(employee);
	document.getElementById("user").innerHTML = user.username;

}