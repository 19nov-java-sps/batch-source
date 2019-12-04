document.getElementById("login-btn").addEventListener("click",sendAjaxGet )


function sendAjaxGet(){
	let xhr = new XMLHttpRequest();
	let url = "http://localhost:8080/ERS/api/pendingreimbursements";
	let id = document.getElementById("id").value;
	xhr.open("GET", url);
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			let reimbursements=JSON.parse(xhr.response);
		

			let table = document.getElementById("empl-table");
			table.hidden = false;


			for(let reimbursement of reimbursements){
				if(reimbursement.userId==id){
				let newRow = document.createElement("tr");
				
				newRow.innerHTML= `<td>${reimbursement.reasonForReimbursement}</td><td>${reimbursement.reimbursementAmount}</td><td>${reimbursement.userId}</td>`;
				table.appendChild(newRow);
				}
				else{
					
					continue;
				}
				
			}
		
		
		}
	}
	
	xhr.send();
}


/*
function displayEmployees(employeesJSON){
	let employees = JSON.parse(employeesJSON);
	
	let table = document.getElementById("empl-table");
	table.hidden = false;


	for(let employee of employees){
		
		let newRow = document.createElement("tr");
		
		newRow.innerHTML= `<td>${employee.firstName}</td><td>${employee.lastName}</td>`;
		table.appendChild(newRow);
		
	}
}
*/