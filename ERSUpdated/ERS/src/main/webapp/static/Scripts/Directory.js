console.log("hi from directory.js")

let requestUrl = "http://localhost:8080/FrontControllerDemo/api/employees";

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
		
		let newRow = document.createElement("tr");
		
		newRow.innerHTML= `<td>${employee.name}</td><td>${employee.department.name}</td>`;
		table.appendChild(newRow);
		
	}
}