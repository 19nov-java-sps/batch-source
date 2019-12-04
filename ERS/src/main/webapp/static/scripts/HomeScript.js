document.getElementById("home-page").addEventListener("click", editView);
//document.getElementById("home-page").addEventListener("click", getView);
document.getElementById("logout-btn").addEventListener("click", getAjaxLogOut);
//document.getElementById("myprofile").addEventListener("click", getProfileInfo);

let token = sessionStorage.getItem("token");
let loginURL = "http://localhost:8080/ERS/login";


// checking of token is null, valid, or neither
if (!token) {
	window.location.href = "http://localhost:8080/ERS/tokennull";
} else {
	let tokenArr = token.split(":");
	if (tokenArr.length === 2) {
		let baseUrl = "http://localhost:8080/ERS/api/employee?id=";
		sendAjaxGet(baseUrl + tokenArr[0], editView);
	} else {
		window.location.href = "http://localhost:8080/ERS/error";
	}
}

// this function is invoked within the if/else statement above
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


//function getView() {
// let tokenArr = token.split(":");
//
//	sendAjaxGet(baseUrl + tokenArr[0], editView);
//}
// will manipulate the home page depending on if user is a manager or not
function editView(xhr) {
	console.log(xhr.response);
	let empl = JSON.parse(xhr.response);
	if (empl.isManager == true) {
		document.getElementById("view-employees").hidden = false;
		document.getElementById("search-bar").hidden = false;
		document.getElementById("create-reimbursement").hidden = true;
	}

}

// will log you out once you click logout button
function getAjaxLogOut() {
	sessionStorage.clear();
	window.location.href = loginURL;
}

//function getProfileInfo() {
// let tokenArr = token.split(":");
//	let baseUrl = "http://localhost:8080/ERS/api/employee?id=";
//	sendAjaxGet(baseUrl + tokenArr[0], displayEmployeeById);
//}


//function displayEmployeeById(e){
//	console.log(e);
//	let employee = JSON.parse(e.response);
//	
//	let div = document.createElement("div");
//	div.id = "div";
//	document.getElementById("display").appendChild(div);
//	
//	let table = document.createElement("TABLE");
//	table.setAttribute("class", "border_class");
//	document.getElementById("div").appendChild(table);
//	table.hidden = false;
//	
//	let header = document.createElement("th");
//	document.getElementById("div").appendChild(header);
//	let empId= "EMPLOYEE ID";
//	let empName= "USERNAME";
//	let isMan="MANAGER?";
//	header.innerHTML= 
//	table.appendChild(header);
		
//		let newRow = document.createElement("tr");
//		document.getElementById("div").appendChild(newRow);
//		
//		newRow.innerHTML= `<td>${empId}</td><td>${empName}</td><td>${isMan}</td>`;
//		table.appendChild(newRow);
//		newRow.innerHTML= `<td>${employee.employeeID}</td><td>${employee.fullName}</td><td>${employee.isManager}</td>`;
//		table.appendChild(newRow);
//	
//
//
//}



// function displayEmployeePage(xhr) {
// let employee = JSON.parse(xhr.response);
// console.log(employee);
// document.getElementById("employee-page").innerHTML = user.username;
//
// }
