document.getElementById("search-id-btn").addEventListener("click", searchPendingId);
let token = sessionStorage.getItem("token");



//let baseUrl = "http://localhost:8080/ERS/api/pendingreimbursement?userid=";

// function searchPendingId(){
// let xhr = new XMLHttpRequest();
// let empid = document.getElementById("employeeid").value;
// console.log(empid)
// xhr.open("GET",
// "http://localhost:8080/ERS/api/pendingreimbursement?employeeID=" +
// `${empid}`);
//	
// xhr.onreadystatechange = function(){
// if(xhr.readyState==4 && xhr.status==200){
// console.log(xhr)
// let viewPendingById = JSON.parse(xhr.response);
// console.log(viewPendingById);
// let table = document.getElementById = ("search-invoice-table");
//
// for(let pendingId of viewPendingById){
// if(pendingId.employeeID == empid){
// let newRow = document.createElement("tr");
//				
// newRow.innerHTML=
// `<td>${pendingId.employeeID}</td><td>${pendingId.reimbursementID}</td><td>${pendingId.amount}</td>
// <td>${pendingId.reason}</td>`;
// table.appendChild(newRow);
// }
//								
// }
//		
// }
// }
// xhr.setRequestHeader("Authorization", token)
//	
// xhr.send();
// }




function searchPendingId(){
	let xhr = new XMLHttpRequest();
	let url = "http://localhost:8080/ERS/api/pendingreimbursement";
	let id = document.getElementById("inputid").value;
	xhr.open("GET", url);
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			let invoiceObj = JSON.parse(xhr.response);
	

			let table = document.getElementById("search-invoice-table");

			for(let invoice of invoiceObj){
				
				if(invoice.employeeID === Number(id)){
					console.log(invoice);
				let newRow = document.createElement("tr");
				
				newRow.innerHTML= `<td>${invoice.employeeID}</td><td>${invoice.reimbursementID}</td><td>${invoice.amount}</td>
				<td>${invoice.reason}</td>`;
				table.appendChild(newRow);
				}
								
			}
		
		}
	}
	xhr.setRequestHeader("Authorization", token)
	
	xhr.send();
}