let token = sessionStorage.getItem("token");

document.getElementById("generate").addEventListener("click", sendAjaxPost);

if(!token){
	window.location.href="http://localhost:8080/Project11/login";
} else {
	let tokenArr = token.split(":");
	console.log(tokenArr);
	if (tokenArr[1] == "manager"){
		window.location.href="http://localhost:8080/Project11/manhome";
	}
	if(tokenArr.length===2){
		let requestUrl = "http://localhost:8080/Project11/api/invoices?USERID=";
		sendAjaxGet(requestUrl+tokenArr[0], displayInvoices);
	} else {
		window.location.href="http://localhost:8080/Project11/login";
	}
}


/*
 * if we are not redirected when checking for the token, a request will be made to
 * the url for that particular user
 */

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

function displayName(xhr){
	let user = JSON.parse(xhr.response);
//	console.log(user);
	document.getElementById("DisplayUserNameHere").innerHTML = user.user_name;
	document.getElementById("DisplayUser").innerHTML = user.user_name;

}

function displayInvoices(invoiceJSON){
	let invoices = JSON.parse(invoiceJSON.response);

	let table = document.getElementById("dataTable");
	table.hidden = false;

	for(let inv of invoices){

		let newRow = document.createElement("tr");

		newRow.innerHTML= `<td>${inv.invoice_id}</td><td>${inv.user_id}</td><td>${inv.amount}</td><td>${inv.status}</td><td>${inv.manager_id}</td>`;
		table.appendChild(newRow);

	}
}

function sendAjaxPost(){
	let xhr = new XMLHttpRequest();
	let url = "http://localhost:8080/Project11/invoices";
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(this.readyState===4 && this.status===200){

		}

	}
	let getAmount = document.getElementById("amount").value;
	let userID = token[0];

	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")

	let requestBody = `userid=${userID}&amount=${getAmount}`;

	xhr.send(requestBody);
}
