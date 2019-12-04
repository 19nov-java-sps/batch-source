
	let auth = sessionStorage.getItem("token");
	let tokenArr = auth.split(":");
	let id= tokenArr[0];
let requestUrl = "http://localhost:8080/ERS/api/employees";

function sendAjaxGet(url, callback){
	let xhr = new XMLHttpRequest();
	
	xhr.open("GET", url);
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			callback(xhr.response);
		}
	}
	
	xhr.send();
}

sendAjaxGet(requestUrl, displayEmployees);

function displayEmployees(employeesJSON){
	let employees = JSON.parse(employeesJSON);
	
	let table = document.getElementById("empl-table");
	table.hidden = false;


	for(let employee of employees){
		if(id==employee.id){
		let newRow = document.createElement("tr");
		newRow.innerHTML= `<td>${employee.firstName}</td><td>${employee.lastName}</td><td>${employee.emailAddress}</td><td>${employee.password}</td><td>${employee.employeeType}</td>`;
		table.appendChild(newRow);
		}
		
		else{
			continue;
		}
	}
}