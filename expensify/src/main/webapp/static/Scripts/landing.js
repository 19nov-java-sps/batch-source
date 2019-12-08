let token = sessionStorage.getItem("token");
let invoiceURL = "http://localhost:8080/expensify/api/invoices"
let employeesURL = "http://localhost:8080/expensify/employees"
document.getElementById("fetchInvoice").addEventListener("click", sendAjaxGetInvoices)
document.getElementById("fetchResolved").addEventListener("click", fetchResolveInvoices)
document.getElementById("fetchEmployee").addEventListener("click", fetchEmployees)
document.getElementById("editEmployee").addEventListener("click", forwardToEditPage)
document.getElementById("findInvoices").addEventListener("click", invoiceSearchByEmployeeId)
document.getElementById("signOut").addEventListener("click", logOut)


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


function fetchResolveInvoices(){
	fetch(invoiceURL, {
		headers: {
			Authorization: `${token}`
		}
	})
	.then(res => {
		if (res.status === 200) {
			return res.json()
		} else {
			console.log("error")
		}
		})
		.then(invoices => {
			let invoiceList = document.getElementById("invoiceList")
			invoiceList.hidden = false
			
			for (let invoice of invoices){
				let div = document.createElement("div")
			if (invoice.resolved === true && invoice.pending === false) {
				div.innerHTML = `${invoice.description}`
				invoiceList.appendChild(div)
				console.log(invoice)
			}
			}
		})
	
	
}


function sendAjaxGetInvoices(){
	fetch("http://localhost:8080/expensify/api/invoices", {
		headers: {
			Authorization: `${token}`
		}
	})
	.then(res => {
		if (res.status === 200) {
			return res.json()
		} else {
			console.log("error")
		}
		})
		.then(invoices => {
			let invoiceList = document.getElementById("invoiceList")
			invoiceList.hidden = false
			for (let invoice of invoices){
				let div = document.createElement("div")
			if (invoice.pending === true) {
				div.innerHTML = `${invoice.description}`
				invoiceList.appendChild(div)
				console.log(invoice)
			}
			}
		})
}
	

//document.getElementById("employeeDirectory").hidden = true

function postInvoice(url, callback){
	

	let xhr = new XMLHttpRequest();
	xhr.open("POST", employeesURL );
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200) {
			callback(this);
		} 
	}
	let description = document.getElementById("Description").value;
	let amount = document.getElementById("Amount").value;
	
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
	xhr.setRequestHeader("Authorization", token)
	
	let requestBody = `description=${description}&amount=${amount}`;
	xhr.send(requestBody);
	
}




function fetchEmployees(){
	console.log("Button press")
	fetch("http://localhost:8080/expensify/api/employees", {
		headers: {
			Authorization: `${token}`
		}
	}).then(res => {
		if (res.status  ===  200){
			return res.json()
		} else {
			console.log("error")
		}
	}).then(data => {
		document.getElementById("employeeDirectory").hidden = false
		let list = document.getElementById("employeeDirectory")
		for (let employee of data){
			console.log(employee)
			let li = document.createElement("li")
			list.appendChild(li)
			let image = document.createElement("img")
			list.appendChild(image)
			image.src = `https://mdbootstrap.com/img/Photos/Avatars/img%20(${employee.userId}).jpg`
			let name = document.createElement("h4")
			name.innerText = `${employee.fullname}`
			li.appendChild(name)
			
		}})}


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
	if (empl.manager === true) {
//		document.getElementById("search").hidden = false
		document.getElementById("manager_status").innerHTML = "Manager"
		document.getElementById("fetchInvoice").hidden = false
		document.getElementById("fetchEmployee").hidden = false
		console.log("A manager logged in")
	} else {
		document.getElementById("fetchInvoice").hidden = true
		document.getElementById("fetchEmployee").hidden = true
		console.log("A regular employee logged in")
	}
}

function invoiceSearchByEmployeeId() {

	let userid = document.getElementById("id").value 
	fetch(`http://localhost:8080/expensify/api/searchinvoice?userid=${userid}`, {
		headers: {
			Authorization: `${token}`
		}
	})
	.then(res => res.json())
	.then(invoiceJson => {
		let div =  document.getElementById("locatedInvoice")
		for (let invoice of invoiceJson) {
			let h1 = document.createElement('h1')
			h1.innerText = invoice.description
			div.appendChild(h1)
		}
		
	})
	
}
	



function forwardToEditPage(){
	window.location.href="http://localhost:8080/expensify/edit"
}


function logOut() {
	sessionStorage.clear;
	window.location.href="http://localhost:8080/expensify/home"
}