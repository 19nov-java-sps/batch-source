let token = sessionStorage.getItem("token");
let tokenArr = token.split(":");
let id= tokenArr[0];
let baseurl = "http://localhost:8080/ERS/api/resolvedreimbursement";

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
	 let resolved = JSON.parse(xhr.response);
	 console.log(resolved)
		 let table = document.getElementById("resolved-table");
		
		 for(let res of resolved){
		 if(res.reimbursementID == id){
		 let newRow = document.createElement("tr");
				
		 newRow.innerHTML=
		 `<td>${res.employeeID}</td><td>${res.reimbursementID}</td><td>${res.amount}</td><td>${res.reason}</td>
			 <td>${res.approved}</td><td>${res.denied}</td><td>${res.resolved}</td>`;
		 table.appendChild(newRow);
		 }
			
	 }
 
}

