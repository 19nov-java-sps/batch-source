let token = sessionStorage.getItem("token");
let tokenArr = token.split(":");
let id= tokenArr[0];
let baseurl = "http://localhost:8080/ERS/api/allpending";

sendAjaxGet(baseurl, showAllManagerPending);

function sendAjaxGet(url, callback){
	console.log("ajax call made");
	let xhr = new XMLHttpRequest();
	xhr.open("GET", baseurl);
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			callback(xhr);
		}
	}
	
	xhr.setRequestHeader("Authorization", token);
	xhr.send();
}

function showAllManagerPending(xhr){
	let manpend = JSON.parse(xhr.response);
	console.log(manpend);
	let table = document.getElementById("man-pending-table");

	for(let pend of manpend){
		let newRow = document.createElement("tr");
		newRow.innerHTML= `<td>${pend.employeeID}</td><td>${pend.reimbursementID}</td><td>${pend.amount}</td><td>${pend.reason}</td>`;
			table.appendChild(newRow);
	
	}
}