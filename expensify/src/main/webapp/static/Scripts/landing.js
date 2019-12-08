let token = sessionStorage.getItem("token");
const currentUser = token.split(":")[0]
let invoiceURL = "http://localhost:8080/expensify/api/invoices"
let employeesURL = "http://localhost:8080/expensify/employees"
	
document.getElementById("fetchInvoice").addEventListener("click", sendAjaxGetInvoices)
document.getElementById("fetchResolved").addEventListener("click", fetchResolveInvoices)
document.getElementById("fetchEmployee").addEventListener("click", fetchEmployees)
document.getElementById("editEmployee").addEventListener("click", forwardToEditPage)
document.getElementById("findInvoices").addEventListener("click", invoiceSearchByEmployeeId)
document.getElementById("signOut").addEventListener("click", logOut)
document.getElementById("createInvoices").addEventListener("click", create)
document.getElementById("submit-btn").addEventListener("click", createNewInvoice)
document.getElementById("pendingInvoices").addEventListener("click", fetchMyPendingInvoices)
document.getElementById("myResolvedInvoice").addEventListener("click", fetchMyResolvedInvoices)
document.getElementById("approve-btn").addEventListener("click", approveInvoice)
document.getElementById("deny-btn").addEventListener("click", denyInvoice)


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

function fetchMyResolvedInvoices(){
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
			document.getElementById("createInvoice").style.display = "none"
			let invoiceList = document.getElementById("invoiceList")
			invoiceList.hidden = false
			
			for (let invoice of invoices){
				let div = document.createElement("div")
			if (invoice.resolved === true && invoice.pending === false && invoice.userId === Number(currentUser)) {
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
	

function fetchMyPendingInvoices(){
	fetch("http://localhost:8080/expensify/api/invoices", {
		headers: { Authorization: `${token}`}
	})
	.then(
			res => {
				if (res.status === 200) {
					return res.json()
				} else {
					console.log("error")
				}
			})
				.then(invoices => {
					document.getElementById("createInvoice").style.display = "none"
						document.getElementById("listOfMyPendingInvoices").style.display = "block"
						let container = document.getElementById("listOfMyPendingInvoices")
					
							for (let invoice of invoices){
								if(invoice.userId===Number(currentUser)){
									console.log(invoice)
										let media = document.createElement("div")
										let image = document.createElement("img")
										let mediaBody = document.createElement("div")
										let heading = document.createElement("h5")
										let cardText = document.createElement("p")
										media.setAttribute("class", "media")
										image.setAttribute("class", "mr-3")
										image.src = `https://mdbootstrap.com/img/Photos/Avatars/img%20(${invoice.userId}).jpg`
										mediaBody.setAttribute("class", "media-body")
										heading.innerHTML = invoice.amount
										heading.setAttribute("class", "mt-0")
										cardText.setAttribute("class", "card-text")
										cardText.innerHTML = invoice.description
										mediaBody.appendChild(cardText)
										mediaBody.appendChild(heading)
										media.appendChild(image)
										media.appendChild(mediaBody)
										container.appendChild(media)
										let lineBreak = document.createElement("br")
										container.appendChild(lineBreak)
										container.appendChild(lineBreak)
										container.appendChild(lineBreak)
									}}
					}
				)
	}
			
				
		



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

function approveInvoice() {
	let invoiceId = document.getElementById("invoiceId").value
	let pending = false
	let approved = true
	let rejected = false
	let resolved = true
	
	let xhr = new XMLHttpRequest();
	xhr.open("POST", `http://localhost:8080/expensify/api/invoice/approve`);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200) {
			callback(this);
		} 
	}
	xhr.setRequestHeader("Authorization", token);
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
	let requestbody = `pending=${pending}&approved=${approved}&denied=${rejected}&resolved=${resolved}&invoiceId=${invoiceId}`
	xhr.send(requestbody);
}


function denyInvoice(){
	let invoiceId = document.getElementById("invoiceId").value
	
	fetch(`http://localhost:8080/expensify/api/invoice/deny`, {
		method:  "POST",
		body:`invoiceId=${invoiceId}`,
		headers: {
			Authorization: `${token}`,
			'Content-Type': 'application/x-www-form-urlencoded'
		}
	})
	.then(res => {
		if (res.status === 200) {
			return res.json()
		} else {
			console.log("error")
		}
	})
	
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
	let image = document.getElementById('pic')
	image.src = `https://mdbootstrap.com/img/Photos/Avatars/img%20(${currentUser}).jpg`
	if (empl.manager === true) {
		document.getElementById("search").hidden = false
		document.getElementById("manager_status").innerHTML = "Manager"
		document.getElementById("fetchInvoice").hidden = false
		document.getElementById("fetchEmployee").hidden = false
		console.log("A manager logged in")
	} else {
		document.getElementById("fetchInvoice").hidden = true
		document.getElementById("approveOrDeny").style.display = "none"
		document.getElementById("fetchEmployee").hidden = true
		document.getElementById("search").hidden = true
		document.getElementById("fetchResolved").hidden = true
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
	
function create(){
	document.getElementById("createInvoice").hidden = false
	
}

function createNewInvoice () {
	let amount = document.getElementById("amount").value
	let description = document.getElementById("description").value
	fetch(`http://localhost:8080/expensify/api/invoice/create?userid=${currentUser}`, {
		method:  "POST",
		body:`amount=${amount}&description=${description}`,
		headers: {
			Authorization: `${token}`,
			'Content-Type': 'application/x-www-form-urlencoded'
		}
	})
	.then(res => res.json())
	.catch(error => console.log(error))
	document.getElementById("createInvoice").style.display = "none"
	
}



function forwardToEditPage(){
	window.location.href="http://localhost:8080/expensify/edit"
}


function logOut() {
	sessionStorage.clear;
	window.location.href="http://localhost:8080/expensify/home"
}