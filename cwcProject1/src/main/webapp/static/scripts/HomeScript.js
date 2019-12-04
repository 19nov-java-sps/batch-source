let token = sessionStorage.getItem("token");
let employeeApi = "http:/localhost:8080/Project1/api/employees"

document.getElementById('logout-btn').addEventListener("click", logout);
document.getElementById('profile').addEventListener("click", getMyInfo);
//document.getElementById('contact').addEventListener("click", getMyManager);
document.getElementById('new-reim-option').addEventListener("click", newReimPage);
document.getElementById('update-info').addEventListener("click", updateInfoPage);
//document.getElementById('regis-empl').addEventListener("click", registerEmpl);
document.getElementById('view-empls').addEventListener("click", getEmployees); 
if(!token){
	window.location.href="http://localhost:8080/Project1/login";
} else {
	let tokenArr = token.split(":");

	if(tokenArr.length === 2){
		
		if (tokenArr[1]) {
			document.getElementById('manager-sidebar').hidden = false;
			//document.getElementByID('my-reim-option').hidden = true; 
		} else {
			document.getElementById('contact').hidden = false;
		}
		

		
		let baseUrl = "http://localhost:8080/Project1/api/employees?id=";
		sendAjaxGet(baseUrl+tokenArr[0], displayEmplInfo);
	} else {
		window.location.href="http://localhost:8080/Project1/afterifclause";
	}
}

function sendAjaxGet(url, callback){
	let xhr = new XMLHttpRequest();
	xhr.open("GET", url);
	
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200) {
			callback(this);
		} 
	}

//	xhr.setRequestHeader("Authorization", token);
	xhr.send();
}

function displayEmplInfo(xhr, heading = 'My Profile'){
	let empl = JSON.parse(xhr.response);
	console.log(empl);
	
	let main = document.createElement("Div");
	main.id = "main";
	document.getElementById("content").appendChild(main);
	
	let title = document.createElement("h4");
	document.getElementById("main").appendChild(title);
	title.innerText = heading;
	
	let table = document.createElement("table");
	table.className = "table table-bordered";
	document.getElementById("main").appendChild(table);
	
	table.innerHTML = `<tr><th> Name </th> <th> Email</th> <th> Position </th></tr>
		              <tr><td>${empl.firstName} ${empl.lastName}</td>
		              <td>${empl.email}</td>
		              <td>${empl.position}</td> </tr>`
	
	
	
	
//	
//	<td>${empl.firstName} ${empl.lastName}</td></tr>
//	<tr><th>Email </th><td>${empl.email}</td></tr>
//	<tr><th>Phone </th><td>${empl.phone}</td></tr>
//	<tr><th>Position </th><td>${empl.position}</td></tr>
//	<tr><th>Department </th><td>${empl.department.deptName}</td></tr>
//	;
//	
}

function logout() {
	sessionStorage.clear();
	window.location.href="http://localhost:8080/Project1/login";
}

function getMyInfo() {
	if (document.getElementById("main")) {		
		document.getElementById("main").remove();
	}
	
	let tokenArr = token.split(":");
	let baseUrl = "http://localhost:8080/Project1/api/employees?id=";
	sendAjaxGet(baseUrl + tokenArr[0], displayEmplInfo, 'My Profile');

}

function getEmployees(){
	let xhr = new XMLHttpRequest();
	xhr.open("GET", "http:/localhost:8080/Project1/api/employees?id=2");
	
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200) {
			displayEmployeeList(this);
		} 
	}

	xhr.setRequestHeader("Authorization", token);
	xhr.send();
}

function displayEmployeeList(xhr) {
	let employeeJSON = JSON.parse(xhr.response)
	console.log(employeeJSON)
}

//function getMyManager() {
//	if (document.getElementById("main")) {		
//		document.getElementById("main").remove();
//	}
//	
//	let tokenArr = token.split(":");
//	let baseUrl = "http://localhost:8080/Project1/api/employees?id=";
//	sendAjaxGet(baseUrl + tokenArr[2], displayEmplInfo, 'My Manager');
//}

function newReimPage() {
	let xhr
	window.location.href="http://localhost:8080/Project1/reimbursement/new";
}

function updateInfoPage() {
	window.location.href="http://localhost:8080/Project1/employee/update";
}

//function registerEmpl() {
//	window.location.href="http://localhost:8080/Project1/employee/new";
//}

