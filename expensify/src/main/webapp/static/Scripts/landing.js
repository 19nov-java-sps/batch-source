let token = sessionStorage.getItem("token");
let invoiceURL = "http://localhost:8080/expensify/api/invoices"

if(!token){
	window.location.href="http://localhost:8080/expensify/home";
} else {
	let tokenArr = token.split(":")
	if(tokenArr.length === 2){
		let baseUrl = "http://localhost:8080/expensify/api/employees?id=";
		sendAjaxGet(baseUrl + tokenArr[0], displayInfo);
	} else {
		window.location.href="http://localhost:8080/expensify/home";
	}
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
		
		let div  = document.getElementById("inv")
		div.hidden = false
		let title = document.getElementById("title")
		title.innerHTML = `${invoiceJson[i].description}`
		let amount = document.getElementById("amount")
		amount.innerHTML = `${invoiceJson[i].amount}`
		let button = document.getElementById("btn")
		button.addEventListener("click", deleteInvoice)
		div.appendChild(amount)
		div.appendChild(title)
		div.appendChild(button)
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
		} else if (this.readyState === 4){
			window.location.href="http://localhost:8080/expensify/home";
		}
	}

	xhr.setRequestHeader("Authorization", token);
	xhr.send();
}

function displayInfo(xhr) {
	let empl = JSON.parse(xhr.response);
	console.log(empl)
	document.getElementById("employeeId").innerHTML = `Employee id: ${empl.userId}`
	document.getElementById("full_name").innerHTML = empl.fullname
	if (empl.manager) {
		document.getElementById("search").hidden = false
		document.getElementById("manager_status").innerHTML = "Manager"
		document.getElementById("fetchInvoice").hidden = false
		
	}
}


document.getElementById("fetchInvoice").addEventListener("click", sendAjaxGetInvoices)

document.getElementById("signOut").addEventListener("click", logOut)

function logOut() {
	sessionStorage.clear;
	window.location.href="http://localhost:8080/expensify/home"
}