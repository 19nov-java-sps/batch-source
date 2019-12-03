let token = sessionStorage.getItem("token");

let invoiceURL = "http://localhost:8080/expensify/api/invoices"
let employeesURL = "http://localhost:8080/expensify/employee/edit"

document.getElementById("fetchInvoice").addEventListener("click", sendAjaxGetInvoices)

document.getElementById("signOut").addEventListener("click", logOut)


console.log(token, "sessionStorage")
	
if(!token){
	window.location.href="http://localhost:8080/expensify/pop";
} else {
	let tokenArr = token.split(":")
	if(tokenArr.length === 2){
		let baseUrl = "http://localhost:8080/expensify/api/employees?id=";
		sendAjaxGet(baseUrl+tokenArr[0], displayInfo);
	} else {
		window.location.href="http://localhost:8080/expensify/hello";
	}
}

function sendAjaxEdit(URL,callback){
	let xhr = new XMLHttpRequest();
	xhr.open("POST", employeesURL );
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200) {
			callback(this);
		} 
	}
	let username = document.getElementById("username").value;
	let password = document.getElementById("passwordString").value;
	
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
	
	let requestBody = `username=${username}&password=${password}`;
	xhr.send(requestBody);
	
}

function sendAjaxGetInvoices(URL, callback){
	let xhr = new XMLHttpRequest();
	xhr.open("GET", invoiceURL);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200) {
			populate(this);
		} 
	}
	xhr.setRequestHeader("Authorization", token);
	xhr.send();
}

function populate(xhr){
	let invoiceJson = JSON.parse(xhr.response)
	console.log(invoiceJson)
	
	let invoiceList = document.getElementById("invoiceList")
	
	for( let i = 0; i < invoiceJson.length; i++){
		
		let div  = document.createElement("div")
		let h1 = document.createElement("h1")
		let span = document.creatElement("span")
		div.appendChild(h1).appendChild(span)
		invoiceList.appendChild(div)
	
	}
}

function deleteInvoice(){
	console.log("button pressed")
}

function sendAjaxGet(url, callback){
	let xhr = new XMLHttpRequest();
	xhr.open("GET", url);
	
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200) {
			callback(this);
		} 
	}

	xhr.setRequestHeader("Authorization", token);
	xhr.send();
}

function displayInfo(xhr) {
	let empl = JSON.parse(xhr.response);
	console.log(empl)
	document.getElementById("full_name").innerHTML = empl.fullname
	if (empl.manager) {
		document.getElementById("search").hidden = false
		document.getElementById("manager_status").innerHTML = "Manager"
		document.getElementById("fetchInvoice").hidden = false
		
	}
}


function logOut() {
	sessionStorage.clear;
	window.location.href="http://localhost:8080/expensify/home"
}