
	let auth = sessionStorage.getItem("token");
	let tokenArr = auth.split(":");
	let id= tokenArr[0];
let requestUrl = "http://localhost:8080/ERS/api/pendingreimbursements";

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

sendAjaxGet(requestUrl, displayPending);

function displayPending(reimbursementJSON){
	let reimbursements = JSON.parse(reimbursementJSON);
	
	let table = document.getElementById("re_table");
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