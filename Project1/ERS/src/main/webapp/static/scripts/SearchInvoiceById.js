document.getElementById("search-id-btn").addEventListener("click", searchPendingId);
let token = sessionStorage.getItem("token");


function searchPendingId(){
	let xhr = new XMLHttpRequest();
	let url = "http://localhost:8080/ERS/api/pendingreimbursement";
	let id = document.getElementById("inputid").value;
	xhr.open("GET", url);
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			let invoiceObj = JSON.parse(xhr.response);
			console.log(invoiceObj);

			let table = document.getElementById("search-invoice-table");

			for(let invoice of invoiceObj){
				if(invoice.reimbursementID ==  Number(id)) {
					console.log(invoice);
				let newRow = document.createElement("tr");
				newRow.innerHTML= `<td>${invoice.employeeID}</td><td>${invoice.reimbursementID}</td><td>${invoice.amount}</td>
				<td>${invoice.reason}</td>`;
				table.appendChild(newRow);
				} else {
				continue;
				}			
			}
		}
	}
	
	xhr.setRequestHeader("Authorization", token)
	xhr.send();
}