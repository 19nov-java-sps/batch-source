let token = sessionStorage.getItem("token");
let tokenArr = token.split(":");
let id= tokenArr[0];
let baseurl = "http://localhost:8080/ERS/api/pendingreimbursement";

sendAjaxGet(baseurl, getPendingReimbursements);

function sendAjaxGet(url, callback) {
	 console.log("ajax call made")
	 let xhr = new XMLHttpRequest();
	 xhr.open("GET", baseurl);
	 xhr.onreadystatechange = function() {
	 if (this.readyState === 4 && this.status === 200) {
	 callback(this);
	 	}
	 }
	 
	 xhr.setRequestHeader("Authorization", token);
	 xhr.send();
	 }

	 function getPendingReimbursements(xhr) {
	 let reimbursements = JSON.parse(xhr.response);
	 console.log(reimbursements)
		 let table = document.getElementById("pending-table");
		
		 for(let reimbursement of reimbursements){
		 if(reimbursement.reimbursementID==id){
		 let newRow = document.createElement("tr");
				
		 newRow.innerHTML=
		 `<td>${reimbursement.employeeID}</td><td>${reimbursement.reimbursementID}</td><td>${reimbursement.amount}</td><td>${reimbursement.reason}</td>`;
		 table.appendChild(newRow);
		 }
			
	 }
 
	 }