document.getElementById("pending-req").addEventListener("click", viewAllPending);
document.getElementById("resolved-req").addEventListener("click", viewAllResolved);

function viewAllPending() {
	
	let url = "http://localhost:8080/Project1/api/reimbursements/pending";
	sendAjaxGetReims(url, displayAllReims, 'Pending');
}

function viewAllResolved() {
	
	let url = "http://localhost:8080/Project1/api/reimbursements/resolved";
	sendAjaxGetReims(url, displayAllReims, 'Resolved');
}

function sendAjaxGetReims(url, callback, type){
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

function displayAllReims(xhr, type) {
	
	if (document.getElementById("main")) {		
		document.getElementById("main").remove();
	}
	
	let main = document.createElement("Div");
	main.id = "main";
	document.getElementById("content").appendChild(main);
	
	let reims = JSON.parse(xhr.response);
	
	if (reims.length === 0) {
		document.getElementById('main').innerHTML = `<h3>No ${type} Reimbursement Available<h3>`;
	} else {
		
		let title = document.createElement("h4");
		document.getElementById("main").appendChild(title);
		title.innerText = `All ${type} Reimbursement`;
		
		let table = document.createElement("Table");
		table.className = "table table-bordered table-striped";
		document.getElementById("main").appendChild(table);
		
		if (type === 'Pending') {
			let head = document.createElement("thead");
			head.className = "thead-light";
			head.innerHTML = `<tr>
			<th>Id</th>
			<th>Amount</th>
			<th>Employee</th>
			<th>Submit Date</th>
			</tr>`
			table.appendChild(head);
			
			let body = document.createElement("tbody");
			
			reims.forEach(r => {
				let newRow = document.createElement("tr");
				let description = r.description.length ? '' : r.description;
				
				newRow.innerHTML= `<td>${r.reimId}</td>
				<td>${r.amount}</td>
				<td>${r.submitBy.firstName} ${r.submitBy.lastName}</td>
				<td>${r.submitDate.slice(0, 16)}</td>`;
				body.appendChild(newRow);
			})
			
			table.appendChild(body);
		} else {
			let head = document.createElement("thead");
			head.className = "thead-light";
			head.innerHTML = `<tr>
			<th>Id</th>
			<th>Amount</th>
			<th>Result</th>
			<th>Employee</th>
			<th>Submit Date</th>
			<th>Manager</th>
			<th>Resolved Date</th>
			</tr>`;
			table.appendChild(head);
			
			let body = document.createElement("tbody");
			
			reims.forEach(r => {
				let newRow = document.createElement("tr");
				let description = r.description.length ? '' : r.description;
				let reason = r.reason.length ? '' : r.reason;
				
				newRow.innerHTML= `<td>${r.reimId}</td>
				<td>${r.amount}</td>
				<td>${r.result}</td>
				<td>${r.submitBy.firstName} ${r.submitBy.lastName}</td>
				<td>${r.submitDate.slice(0, 16)}</td>
				<td>${r.resolvedBy.firstName} ${r.resolvedBy.lastName}</td>
				<td>${r.resolvedDate.slice(0, 16)}</td>`;
				
				body.appendChild(newRow);
			})
			
			table.appendChild(body);
		}
	}
}

