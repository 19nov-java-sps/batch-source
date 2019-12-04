
let requestUrl = "http://localhost:8080/ERS/api/finalreimbursements";

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

sendAjaxGet(requestUrl, displayPendingReimbursements);

function displayPendingReimbursements(reimbursementsJSON){
	let reimbursements = JSON.parse(reimbursementsJSON);
	
	let table = document.getElementById("re_table");
	table.hidden = false;


	for(let reimbursement of reimbursements){
		
		let newRow = document.createElement("tr");
		
		newRow.innerHTML= `<td>${reimbursement.reasonForReimbursement}</td><td>${reimbursement.reimbursementAmount}</td><td>${reimbursement.userId}</td><td>${reimbursement.resolvedBy}</td><td>${reimbursement.pending}</td><td>${reimbursement.status}</td>`;
		table.appendChild(newRow);
		
	}
}