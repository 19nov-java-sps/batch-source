
let requestUrl = "http://localhost:8080/Project1/employees";

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

function displayEmployees(emplJSON){
	let employees = JSON.parse(emplJSON);
	
	let table = document.getElementById("empl-table");
	table.hidden = false;
	
	for(let empl of employees){
		
		let newRow = document.createElement("tr");
	
		newRow.innerHTML= `<td>${empl.emplId}</td><td>${empl.firstName}</td><td>${empl.lastName}</td><td>${empl.depart}</td><td>${empl.reportTo}</td>`;
		table.appendChild(newRow);
		
	}
}