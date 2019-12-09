document.getElementById("pending-reim").addEventListener("click", viewPending);
document.getElementById("resolved-reim").addEventListener("click", viewResolved);

function viewPending() {
	
	let tokenArr = token.split(":");
	
	let baseUrl = "http://localhost:8080/Project1/api/reimbursements/pending?id=";
	sendAjaxGetReims(baseUrl + tokenArr[0], displayEmplReim, 'Pending');
}

function viewResolved() {
	
	let tokenArr = token.split(":");
	
	let baseUrl = "http://localhost:8080/Project1/api/reimbursements/resolved?id=";
	sendAjaxGetReims(baseUrl + tokenArr[0], displayEmplReim, 'Resolved');
}

function sendAjaxGetReims(url, callback, type) {
	let xhr = new XMLHttpRequest();
	xhr.open("GET", url);
	
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200) {
			callback(this, type);
		} else if (this.readyState === 4){
			window.location.href="http://localhost:8080/Project1/login";
		}
	}

	xhr.setRequestHeader("Authorization", token);
	xhr.send();
}

function displayEmplReim(xhr, type) {
	
	if (document.getElementById("main")) {		
		document.getElementById("main").remove();
	}
	
	let main = document.createElement("Div");
	main.id = "main";
	document.getElementById("content").appendChild(main);
	
	let reims = JSON.parse(xhr.response);
	
	if (reims.length === 0) {
		document.getElementById('main').innerHTML = `<h3>No ${type} Reimbursements<h3>`;
	} else {
		
		let title = document.createElement("h4");
		document.getElementById("main").appendChild(title);
		title.innerText = `${type} Reimbursements`;
		
		let table = document.createElement("Table");
		table.className = "table table-bordered table-striped";
		document.getElementById("main").appendChild(table);
		
		if (type === 'Pending') {
			let head = document.createElement("thead");
			head.className = "thead-light";
			head.innerHTML = `<tr>
			<th>Id</th>
			<th>Amount</th>
			<th>Submit Date</th>
			<th>Description</th>
			</tr>`
			table.appendChild(head);
			
			let body = document.createElement("tbody");
			
			reims.forEach(r => {
				let newRow = document.createElement("tr");
				let description = r.description.length ? r.description : '';
				
				newRow.innerHTML= `<td>${r.reimId}</td>
				<td>${r.amount}</td>
				<td>${r.submitDate.slice(0, 16)}</td>
				<td>${description}</td>`;
				body.appendChild(newRow);
			})
			
			table.appendChild(body);
		} else {
			let head = document.createElement("thead");
			head.className = "thead-light";
			head.innerHTML = `<tr>
			<th>Id</th>
			<th>Amount</th>
			<th>Submit Date</th>
			<th>Description</th>
			<th>Result</th>
			<th>Manager</th>
			<th>Resolved Date</th>
			<th>Reason</th>
			</tr>`;
			table.appendChild(head);
			
			let body = document.createElement("tbody");
			
			reims.forEach(r => {
				let newRow = document.createElement("tr");
				let description = r.description.length ? r.description : '';
				let reason = r.reason.length ? r.reason : '';
				
				newRow.innerHTML= `<td>${r.reimId}</td>
				<td>${r.amount}</td>
				<td>${r.submitDate.slice(0, 16)}</td>
				<td>${description}</td>
				<td>${r.result}</td>
				<td>${r.resolvedBy.firstName} ${r.resolvedBy.lastName}</td>
				<td>${r.resolvedDate.slice(0, 16)}</td>
				<td>${reason}</td>`;
				
				body.appendChild(newRow);
			})
			
			table.appendChild(body);
		}
	}
}