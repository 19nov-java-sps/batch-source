let token = sessionStorage.getItem("token");

if (!token) {
	window.location.href = "http://localhost:8080/ERS/tokennull";
} else {
	let tokenArr = token.split(":");
	if (tokenArr.length === 2) {
		let baseUrl = "http://localhost:8080/ERS/api/employee?id=";
		sendAjaxGet(baseUrl + tokenArr[0], displayAllEmployees);
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

function displayAllEmployees(employee) {

	let empl = JSON.parse(employee.response);
	let table = document.getElementById("empl-table");
	console.log(employee);

//	 for(let emp of empl){
	let newRow = document.createElement("tr");

	newRow.innerHTML = `<td>${empl.employeeID}</td><td>${empl.fullName}</td>`;
	table.appendChild(newRow);
	
//	 }

}