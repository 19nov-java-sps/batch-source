
let requestUrl = "http://localhost:8080/Project1/reimbursements";

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

sendAjaxGet(requestUrl, displayReimbursements);

function displayReimbursements(reimbJSON){
	let reimbursements = JSON.parse(reimbJSON);
	
	let table = document.getElementById("reimb-table");
	table.hidden = false;
	
	for(let reimb of reimbursements){
		
		let newRow = document.createElement("tr");
		
		newRow.innerHTML= `<td>${reimb.descr}</td><td>${reimb.sum}</td>`;
		table.appendChild(newRow);
		
	}
}