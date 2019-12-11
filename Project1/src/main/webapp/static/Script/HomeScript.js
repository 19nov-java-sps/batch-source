let token = sessionStorage.getItem("token");
let invoiceURL = "http://localhost:8080/Project1/api/invoices";
let loginURL = "http://localhost:8080/Project1/login";
let userURL = "http://localhost:8080/Project1/api/users";
let tokenArr = token.split(":")
const universalID = tokenArr[0];
document.getElementById("resolvedRequests").addEventListener("click", getAjaxResolved);
document.getElementById("logout-btn").addEventListener("click", getAjaxLogOut);
document.getElementById("viewProfile").addEventListener("click", getAjaxProfile);
document.getElementById("update-User").addEventListener("click", sendAjaxUpdate);
document.getElementById("send-invoice").addEventListener("click", sendAjaxInvoice);
document.getElementById("viewAllEmployees").addEventListener("click", getAjaxAllUsers);
document.getElementById("viewAllPendingRequests").addEventListener("click", getAjaxAllPending);
document.getElementById("viewAllResolvedRequests").addEventListener("click", getAjaxAllResolved);
document.getElementById("lookup-invoice").addEventListener("click", getAjaxSingleRequests);
document.getElementById("approveOrDeny").addEventListener("click", getAjaxToBeResolved);
document.getElementById("pendingRequests").addEventListener("click", getAjaxPending);



if(!token){
	window.location.href="http://localhost:8080/Project1/login";
} else {
	let tokenArr = token.split(":");
	if (tokenArr[0] === "0") {
		
		window.location.href="http://localhost:8080/Project1/login";
	}
	if(tokenArr.length===2){
		let baseUrl = "http://localhost:8080/Project1/api/users?id=";
		sendAjaxGet(baseUrl+tokenArr[0], displayName);
	} else {
		window.location.href="http://localhost:8080/Project1/login";
	}
}

document.getElementById("back-btn").onclick = function(){
	
	window.location.reload();
}

document.getElementById("approveOrDeny").onclick = function(){
	 
	 document.getElementById("approveOrDeny").innerHTML = "&#128077 Approve or Deny &#128078"
	 document.getElementById("approveOrDeny").disabled = true;
	 document.getElementById("viewAllEmployees").style.display = "none"; 
	 document.getElementById("viewRequestsOfASingleEmployee").style.display = "none"; 
	 document.getElementById("viewAllPendingRequests").style.display = "none";
	 document.getElementById("viewAllResolvedRequests").style.display = "none";
	 document.getElementById("logout-btn").style.display = "none"; 
	 
	 document.getElementById("toBeResolvedTable").style.display = "block";
	 
}

document.getElementById("viewRequestsOfASingleEmployee").onclick = function(){
	 
	 document.getElementById("viewRequestsOfASingleEmployee").innerHTML = "&#128269 Employee Request Lookup:"
	 document.getElementById("viewRequestsOfASingleEmployee").disabled = true;
	 document.getElementById("viewAllEmployees").style.display = "none"; 
	 document.getElementById("approveOrDeny").style.display = "none"; 
	 document.getElementById("viewAllPendingRequests").style.display = "none";
	 document.getElementById("viewAllResolvedRequests").style.display = "none";
	 document.getElementById("logout-btn").style.display = "none"; 
	 
	 document.getElementById("employee-request-lookup").style.display = "block";
}

document.getElementById("viewAllResolvedRequests").onclick = function(){
	 
	 document.getElementById("viewAllResolvedRequests").innerHTML = "&#128221 All Resolved Reimbursement Requests:"
	 document.getElementById("viewAllResolvedRequests").disabled = true;
	 document.getElementById("viewAllEmployees").style.display = "none"; 
	 document.getElementById("approveOrDeny").style.display = "none"; 
	 document.getElementById("viewAllPendingRequests").style.display = "none";
	 document.getElementById("viewRequestsOfASingleEmployee").style.display = "none";
	 document.getElementById("logout-btn").style.display = "none"; 
	 
	 document.getElementById("resolvedTable").style.display = "block";
	 
	 
}

document.getElementById("viewAllPendingRequests").onclick = function(){
	 
	 document.getElementById("viewAllPendingRequests").innerHTML = "&#8987 All Pending Reimbursement Requests:"
	 document.getElementById("viewAllPendingRequests").disabled = true;
	 document.getElementById("viewAllEmployees").style.display = "none"; 
	 document.getElementById("approveOrDeny").style.display = "none"; 
	 document.getElementById("viewAllResolvedRequests").style.display = "none";
	 document.getElementById("viewRequestsOfASingleEmployee").style.display = "none";
	 document.getElementById("logout-btn").style.display = "none"; 
	 
	 document.getElementById("pendingTable").style.display = "block";
}

document.getElementById("viewAllEmployees").onclick = function(){
	 
	 document.getElementById("viewAllEmployees").innerHTML = "&#128106 All Employees:"
	 document.getElementById("viewAllEmployees").disabled = true;
	 document.getElementById("approveOrDeny").style.display = "none"; 
	 document.getElementById("viewAllPendingRequests").style.display = "none"; 
	 document.getElementById("viewAllResolvedRequests").style.display = "none";
	 document.getElementById("viewRequestsOfASingleEmployee").style.display = "none";
	 document.getElementById("logout-btn").style.display = "none"; 
}


document.getElementById("submit-invoice").onclick = function(){
	 
	 document.getElementById("submit-invoice").innerHTML = "&#128197 Create Invoice:"
	 document.getElementById("submit-invoice").disabled = true;
	 document.getElementById("viewProfile").style.display = "none"; 
	 document.getElementById("update-profile").style.display = "none"; 
	 document.getElementById("pendingRequests").style.display = "none";
	 document.getElementById("resolvedRequests").style.display = "none";
	 document.getElementById("logout-btn").style.display = "none"; 
	 
	 document.getElementById("new-invoice-form").style.display = "block";
}


document.getElementById("update-profile").onclick = function(){
	 
	 document.getElementById("update-profile").innerHTML = "&#128194 Update Profile:"
	 document.getElementById("update-profile").disabled = true;
	 document.getElementById("viewProfile").style.display = "none"; 
	 document.getElementById("submit-invoice").style.display = "none"; 
	 document.getElementById("pendingRequests").style.display = "none";
	 document.getElementById("resolvedRequests").style.display = "none";
	 document.getElementById("logout-btn").style.display = "none"; 
	 
	 document.getElementById("updateForm").style.display = "block";
}

document.getElementById("viewProfile").onclick = function(){
	 
	 document.getElementById("viewProfile").innerHTML = "&#128193 Employee Profile:"
	 document.getElementById("viewProfile").disabled = true;
	 document.getElementById("update-profile").style.display = "none"; 
	 document.getElementById("submit-invoice").style.display = "none"; 
	 document.getElementById("pendingRequests").style.display = "none";
	 document.getElementById("resolvedRequests").style.display = "none";
	 document.getElementById("logout-btn").style.display = "none"; 
}

document.getElementById("pendingRequests").onclick = function(){
	 
	 document.getElementById("pendingRequests").innerHTML = "&#8987 Pending Reimbursement Requests:"
	 document.getElementById("pendingRequests").disabled = true;
	 document.getElementById("viewProfile").style.display = "none"; 
	 document.getElementById("update-profile").style.display = "none"; 
	 document.getElementById("submit-invoice").style.display = "none"; 
	 document.getElementById("resolvedRequests").style.display = "none";
	 document.getElementById("logout-btn").style.display = "none"; 
}

document.getElementById("resolvedRequests").onclick = function(){
	 
	 document.getElementById("resolvedRequests").innerHTML = "&#128077 Resolved Reimbursement Requests:"
	 document.getElementById("resolvedRequests").disabled = true;
	 document.getElementById("viewProfile").style.display = "none"; 
	 document.getElementById("update-profile").style.display = "none"; 
	 document.getElementById("submit-invoice").style.display = "none"; 
	 document.getElementById("pendingRequests").style.display = "none";
	 document.getElementById("logout-btn").style.display = "none"; 
}

function sendAjaxDenied(e){
	
	let url = "http://localhost:8080/Project1/denied";
	let xhr = new XMLHttpRequest();
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status===200){
		let auth = xhr.getResponseHeader("Authorization");
		window.location.href="http://localhost:8080/Project1/home";
		
		}
	}
	
	let pending = false;
	let approved = false;
	let denied = true;
	let resolved = true;
	let invoiceId = e.path[2].cells[1].innerText;
	
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	let requestBody = `pending=${pending}&approved=${approved}&denied=${denied}&resolved=${resolved}&invoiceId=${invoiceId}`;
	xhr.send(requestBody);
}

function sendAjaxApproved(e){
	
	let url = "http://localhost:8080/Project1/approved";
	let xhr = new XMLHttpRequest();
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status===200){
		let auth = xhr.getResponseHeader("Authorization");
		window.location.href="http://localhost:8080/Project1/home";
		
		}
	}
	
	let pending = false;
	let approved = true;
	let denied = false;
	let resolved = true;
	let invoiceId = e.path[2].cells[1].innerText;
	
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	let requestBody = `pending=${pending}&approved=${approved}&denied=${denied}&resolved=${resolved}&invoiceId=${invoiceId}`;
	xhr.send(requestBody);
}


function getAjaxToBeResolved(url, callback){
	let xhr = new XMLHttpRequest();
	xhr.open("GET", invoiceURL);
	xhr.onreadystatechange = function(){
		if(this.readyState===4 && this.status===200){
			displayToBeResolved(this);
		}
	}
	xhr.setRequestHeader("Authorization",token);
	xhr.send();	
}

function displayToBeResolved(xhr){
	let toBeResolvedJson = JSON.parse(xhr.response);

	console.log(toBeResolvedJson);
	
	
	   for(let i=0; i < toBeResolvedJson.length; i++){
		   
			if(toBeResolvedJson[i].pending == true) {
				
				// Find a <table> element with id="pendingTable":
				let toBeResolvedTable = document.getElementById("toBeResolvedTable");
				
				// Create an empty <tr> element and add it to the 1st position of the table:
				let row = toBeResolvedTable.insertRow(1);
				
				// Insert new cells (<td> elements) at the 1st and 2nd position of the "new" <tr> element:
				let cell1 = row.insertCell(0);
				let cell2 = row.insertCell(1);
				let cell3 = row.insertCell(2);
				let cell4 = row.insertCell(3);
				let cell5 = row.insertCell(4);
				let cell6 = row.insertCell(5);
				
				// Add some text to the new cells:
			
				if(toBeResolvedJson[i].userId == 1){
					cell1.innerHTML = "Peter Nguyen";
					cell2.innerHTML = `${toBeResolvedJson[i].invoiceId}`;
					cell3.innerHTML = `${toBeResolvedJson[i].description}`;
					cell4.innerHTML = `$${toBeResolvedJson[i].amount}`;
					cell5.innerHTML = `<button type="button" id="approve-btn" class="btn btn-success btn-sm">&#128077</button>`;
					cell6.innerHTML = `<button type="button" id="deny-btn" class="btn btn-danger btn-sm">&#128078</button>`;
					document.getElementById("approve-btn").addEventListener("click", sendAjaxApproved);
					document.getElementById("deny-btn").addEventListener("click", sendAjaxApproved);

				}else{
					cell1.innerHTML = "Ryan Carstons";
					cell2.innerHTML = `${toBeResolvedJson[i].invoiceId}`;
					cell3.innerHTML = `${toBeResolvedJson[i].description}`;
					cell4.innerHTML = `$${toBeResolvedJson[i].amount}`;
					cell5.innerHTML = `<button type="button" id="approve-btn" class="btn btn-success btn-sm">&#128077</button>`;
					cell6.innerHTML = `<button type="button" id="deny-btn" class="btn btn-danger btn-sm">&#128078</button>`;
					document.getElementById("approve-btn").addEventListener("click", sendAjaxApproved);
					document.getElementById("deny-btn").addEventListener("click", sendAjaxApproved);

				}
			}
				
		}	
			
}


function sendAjaxResolved(){
	let url = "http://localhost:8080/Project1/resolved";
	let xhr = new XMLHttpRequest();
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status===200){
		let auth = xhr.getResponseHeader("Authorization");
		window.location.href="http://localhost:8080/Project1/home";
		
		}
	}
	
	
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	let requestBody = `firstName=${firstName}&lastName=${lastName}&userId=${universalID}`;
	xhr.send(requestBody);
}


function getAjaxSingleRequests(url, callback){
	let xhr = new XMLHttpRequest();
	xhr.open("GET", invoiceURL);
	xhr.onreadystatechange = function(){
		if(this.readyState===4 && this.status===200){
			displayRequestLookUp(this);
		}
	}
	xhr.setRequestHeader("Authorization",token);
	xhr.send();	
}



function displayRequestLookUp(xhr){
	
	let employeeId = document.getElementById("employeeId").value;

	let requestLookUpJson = JSON.parse(xhr.response);
	

	   for(let i=0; i < requestLookUpJson.length; i++){
				
				let employeeRequestTable = document.getElementById("employeeRequestTable");
				
				// Add some text to the new cells:
				
			if(requestLookUpJson[i].userId == employeeId){
				
				// Create an empty <tr> element and add it to the 1st position of the table:
				let row = employeeRequestTable.insertRow(1);
				
				// Insert new cells (<td> elements) at the 1st and 2nd position of the "new" <tr> element:
				let cell1 = row.insertCell(0);
				let cell2 = row.insertCell(1);
				let cell3 = row.insertCell(2);
	
				switch(employeeId){
				case '1':
					cell1.innerHTML = "Peter Nguyen";
					cell2.innerHTML = `${requestLookUpJson[i].description}`;
					cell3.innerHTML = `$${requestLookUpJson[i].amount}`;
					break;
				case '2':
					cell1.innerHTML = "Ryan Carstons";
					cell2.innerHTML = `${requestLookUpJson[i].description}`;
					cell3.innerHTML = `$${requestLookUpJson[i].amount}`;
					break;
					}
				document.getElementById("employeeRequestTable").style.display = "block";
				document.getElementById("lookup-invoice").disabled = true;
			}
			
			if(employeeId != 1 && employeeId !=2){
				
				document.getElementById("lookup-invoice").disabled = true;
				setTimeout(function(){
					window.location.href="http://localhost:8080/Project1/home"
				}, 2000);
				document.getElementById("bad-request").style.display = "block";
			}
			
	 }
}


function getAjaxAllResolved(url, callback){
	let xhr = new XMLHttpRequest();
	xhr.open("GET", invoiceURL);
	xhr.onreadystatechange = function(){
		if(this.readyState===4 && this.status===200){

			displayAllResolved(this);
		}
	}
	xhr.setRequestHeader("Authorization",token);
	xhr.send();	
}

function displayAllResolved(xhr){
	let resolvedJson = JSON.parse(xhr.response);
	

	   for(let i=0; i < resolvedJson.length; i++){
			if(resolvedJson[i].resolved == true) {
				
				// Find a <table> element with id="pendingTable":
				let resolvedTable = document.getElementById("resolvedTable");
				
				// Create an empty <tr> element and add it to the 1st position of the table:
				let row = resolvedTable.insertRow(1);
				
				// Insert new cells (<td> elements) at the 1st and 2nd position of the "new" <tr> element:
				let cell1 = row.insertCell(0);
				let cell2 = row.insertCell(1);
				let cell3 = row.insertCell(2);
				let cell4 = row.insertCell(3);
				
				// Add some text to the new cells:
				
				if(resolvedJson[i].userId == 1){
					cell1.innerHTML = "Peter Nguyen";
				}else{
					cell1.innerHTML = "Ryan Carstons";
				}
				cell2.innerHTML = `${resolvedJson[i].description}`;
				cell3.innerHTML = `$${resolvedJson[i].amount}`;
				cell4.innerHTML = "Carolyn Rehm";
			}	
	   }


}




function getAjaxAllPending(url, callback){
	let xhr = new XMLHttpRequest();
	xhr.open("GET", invoiceURL);
	xhr.onreadystatechange = function(){
		if(this.readyState===4 && this.status===200){
			displayAllPending(this);
		}
	}
	xhr.setRequestHeader("Authorization",token);
	xhr.send();	
}

function displayAllPending(xhr){
	let pendingJson = JSON.parse(xhr.response);
	
	   for(let i=0; i < pendingJson.length; i++){
			if(pendingJson[i].pending == true) {
				
				// Find a <table> element with id="pendingTable":
				let pendingTable = document.getElementById("pendingTable");
				
				// Create an empty <tr> element and add it to the 1st position of the table:
				let row = pendingTable.insertRow(1);
				
				// Insert new cells (<td> elements) at the 1st and 2nd position of the "new" <tr> element:
				let cell1 = row.insertCell(0);
				let cell2 = row.insertCell(1);
				let cell3 = row.insertCell(2);
				
				// Add some text to the new cells:
				
				if(pendingJson[i].userId == 1){
					cell1.innerHTML = "Peter Nguyen";
				}else{
					cell1.innerHTML = "Ryan Carstons";
				}
				cell2.innerHTML = `${pendingJson[i].description}`;
				cell3.innerHTML = `$${pendingJson[i].amount}`;
			}	
	   }

}

function getAjaxAllUsers(url, callback){
	let xhr = new XMLHttpRequest();
	xhr.open("GET", userURL);
	xhr.onreadystatechange = function(){
		if(this.readyState===4 && this.status===200){
			displayAllUsers(this);
		}
	}
	xhr.setRequestHeader("Authorization",token);
	xhr.send();	
	
}

function displayAllUsers(xhr){
	let employeeJson = JSON.parse(xhr.response);

	let div = document.createElement("div");
	
	for(let i=0; i < employeeJson.length; i++){
		let divContainer = document.createElement("div");
		let employee = document.createElement("div");
		
		employee.innerHTML = `<br> &#128100: ${employeeJson[i].firstName} ${employeeJson[i].lastName}`;
		divContainer.appendChild(employee)
		viewAllEmployees.appendChild(divContainer);
	}
}


function sendAjaxInvoice(){
	let url = "http://localhost:8080/Project1/new-invoice";
	let xhr = new XMLHttpRequest();
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status===200){
		let auth = xhr.getResponseHeader("Authorization");
		window.location.href="http://localhost:8080/Project1/home";
		
		}
	}
	
	let userId = universalID;
	let amount = document.getElementById("amount").value;
	let description = document.getElementById("description").value;
	let pending = true;
	let approved = false;
	let denied = false;
	let resolved = false;
	
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	let requestBody = `userId=${universalID}&amount=${amount}&description=${description}&pending=${pending}&approved=${approved}&denied=${denied}&resolved=${resolved}`;
	xhr.send(requestBody);
}

function sendAjaxUpdate(){
	let url = "http://localhost:8080/Project1/update";
	let xhr = new XMLHttpRequest();
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status===200){
		let auth = xhr.getResponseHeader("Authorization");
		window.location.href="http://localhost:8080/Project1/home";
		
		}
	}
	
	let firstName = document.getElementById("firstName").value;
	let lastName = document.getElementById("lastName").value;
	
		
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	let requestBody = `firstName=${firstName}&lastName=${lastName}&userId=${universalID}`;
	xhr.send(requestBody);
}



function getAjaxPending() {
	let xhr = new XMLHttpRequest();
	xhr.open("GET", invoiceURL);
	xhr.onreadystatechange = function(){
		if(this.readyState===4 && this.status===200){
			displayPending(this);
		}
	}
	xhr.setRequestHeader("Authorization",token);
	xhr.send();	
}


function displayPending(xhr) {
	let pendingJson = JSON.parse(xhr.response);
	
	   for(let i=0; i < pendingJson.length; i++){
			if(pendingJson[i].pending == true && pendingJson[i].userId == universalID) {
				let divContainer = document.createElement("div");
				let invoice = document.createElement("div");
				
				invoice.innerHTML = `<br> &#128203: ${pendingJson[i].description}: $${pendingJson[i].amount}`;
				divContainer.appendChild(invoice)
				pendingRequests.appendChild(divContainer);
			
			}
	   }
}


function getAjaxResolved(url, callback, id) {
	let xhr = new XMLHttpRequest();
	xhr.open("GET", invoiceURL);
	xhr.onreadystatechange = function(){
		if(this.readyState===4 && this.status===200){
			displayResolved(this);
		}
	}
	xhr.setRequestHeader("Authorization",token);
	xhr.send();	
}

function displayResolved(xhr) {
	let resolvedJson = JSON.parse(xhr.response);
		
		let div = document.createElement("div");
	
	for(let i=0; i < resolvedJson.length; i++){
		if(resolvedJson[i].resolved == true && resolvedJson[i].userId == universalID){
			div.innerHTML = `<br> &#128221: ${resolvedJson[i].description}: $${resolvedJson[i].amount}`;
			resolvedRequests.appendChild(div);
		}
	}
}


function getAjaxProfile(url, callback){
	let xhr = new XMLHttpRequest();
	xhr.open("GET", userURL);
	xhr.onreadystatechange = function(){
		if(this.readyState===4 && this.status===200){
			displayUserProfile(this);
		}
	}
	xhr.setRequestHeader("Authorization",token);
	xhr.send();	
	
}

function displayUserProfile(xhr){
	let userInfoJson = JSON.parse(xhr.response);
	let loggedInName = document.getElementsByTagName("span")

	
	for(let i=0; i < userInfoJson.length; i++){
			
			let div = document.createElement("div");
			
			if(userInfoJson[i].firstName == loggedInName[0].innerHTML){
				div.innerHTML = `<br><p>&#128100: ${userInfoJson[i].firstName} ${userInfoJson[i].lastName}</p>`;
				viewProfile.appendChild(div);
			}
		}
}


function sendAjaxGetProfile(url, callback){
	let xhr = new XMLHttpRequest();
	xhr.open("GET", "http://localhost:8080/Project1/api/users?id=1");
	xhr.onreadystatechange = function(){
		if(this.readyState===4 && this.status===200){
			displayUserProfile(this);
		}
	}
	xhr.setRequestHeader("Authorization",token);
	xhr.send();
}


function sendAjaxGet(url, callback){
	let xhr = new XMLHttpRequest();
	xhr.open("GET", url);
	xhr.onreadystatechange = function(){
		if(this.readyState===4 && this.status===200){
			callback(this);
		}
	}
	xhr.setRequestHeader("Authorization",token);
	xhr.send();
}


function displayName(xhr, id){
	let userJson = JSON.parse(xhr.response);
	document.getElementById("user").innerHTML = userJson.firstName;
	
	if (userJson.manager == true){
		
		document.getElementById("menu").style.display = "block";
		document.getElementById("welcome").style.display = "block";
		document.getElementById("back-btn").style.display = "block";
		document.getElementById("logout-btn").style.display = "block";
		document.getElementById("approveOrDeny").style.display = "block"; 
		document.getElementById("viewAllEmployees").style.display = "block"; 
		document.getElementById("viewAllPendingRequests").style.display = "block"; 
		document.getElementById("viewAllResolvedRequests").style.display = "block";
		document.getElementById("viewRequestsOfASingleEmployee").style.display = "block";

	}else{
		
		document.getElementById("menu").style.display = "block";
		document.getElementById("welcome").style.display = "block";
		document.getElementById("viewProfile").style.display = "block"; 
		document.getElementById("update-profile").style.display = "block"; 
		document.getElementById("submit-invoice").style.display = "block"; 
		document.getElementById("pendingRequests").style.display = "block";
		document.getElementById("resolvedRequests").style.display = "block";
		document.getElementById("logout-btn").style.display = "block";
		document.getElementById("back-btn").style.display = "block";


	}
}


function getAjaxLogOut(){
	
	sessionStorage.clear();
	window.location.href= loginURL;

}
