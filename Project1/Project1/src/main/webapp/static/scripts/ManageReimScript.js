document.getElementById("pending-req").addEventListener("click", viewAllPending);
document.getElementById("resolved-req").addEventListener("click", viewAllResolved);

function viewAllPending() {
	
	let url = "http://localhost:8080/Project1/api/reimbursements/pending";
	sendAjaxGetReim(url, displayAllReims, 'Pending');
}

function viewAllResolved() {
	
	let url = "http://localhost:8080/Project1/api/reimbursements/resolved";
	sendAjaxGetReim(url, displayAllReims, 'Resolved');
}

function sendAjaxGetReim(url, callback, type){
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

function displayAllReims(xhr, type = 'Pending') {
	
	if (document.getElementById("main")) {		
		document.getElementById("main").remove();
	}
	
	let main = document.createElement("Div");
	main.id = "main";
	document.getElementById("content").appendChild(main);
	
	let reims = JSON.parse(xhr.response);
	
	if (reims.length === 0) {
		document.getElementById('main').innerHTML = `<h3>No ${type} Reimbursement<h3>`;
	} else {
		
		let title = document.createElement("h4");
		document.getElementById("main").appendChild(title);
		title.innerText = `All ${type} Reimbursement`;
		
		let table = document.createElement("Table");
		table.className = "table table-bordered table-hover";
		document.getElementById("main").appendChild(table);
		
//		let caption = document.createElement("Caption");
//		table.appendChild(caption);
		
		if (type === 'Pending') {
			const tokenArr = token.split(':');
			const level = tokenArr[1];
			
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
				if (level > r.submitBy.isManager) {
					let newRow = document.createElement("tr");
					newRow.className = 'pending-row';
	
					newRow.innerHTML= `<td>${r.reimId}</td>
					<td>${r.amount}</td>
					<td>${r.submitBy.firstName} ${r.submitBy.lastName}</td>
					<td>${r.submitDate.slice(0, 16)}</td>`;
					body.appendChild(newRow);
				}
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
			<th>Employee Id</th>
			<th>Submit Date</th>
			<th>Manager</th>
			<th>Resolved Date</th>
			</tr>`;
			table.appendChild(head);
			
			let body = document.createElement("tbody");
			
			reims.forEach(r => {
				let newRow = document.createElement("tr");
				newRow.className = 'resolved-row';
				
				newRow.innerHTML= `<td>${r.reimId}</td>
				<td>${r.amount}</td>
				<td>${r.result}</td>
				<td>${r.submitBy.firstName} ${r.submitBy.lastName}</td>
				<td>${r.submitBy.emplId}</td>
				<td>${r.submitDate.slice(0, 16)}</td>
				<td>${r.resolvedBy.firstName} ${r.resolvedBy.lastName}</td>
				<td>${r.resolvedDate.slice(0, 16)}</td>`;
				
				body.appendChild(newRow);
			})
			
			table.appendChild(body);
		}
	}
	
	let resolvedRows = document.getElementsByClassName("resolved-row");
	for (let i = 0; i < resolvedRows.length; ++i) {
		resolvedRows[i].onclick = viewSingleResolved(event);
	}
	
	let pendingRows = document.getElementsByClassName("pending-row");
	for (let i = 0; i < pendingRows.length; ++i) {
		pendingRows[i].onclick = viewSinglePending(event);
	}
}

function viewSinglePending() {
	return (e) => {
		if (e.target.cellIndex == 0) {
			sessionStorage.setItem("reimId", e.target.innerText);
			window.location.href="http://localhost:8080/Project1/reimbursement/update";
		}
	}
}

function viewSingleResolved() {
	
	return (e) => {
		if (e.target.cellIndex == 0) {
			let url = "http://localhost:8080/Project1/api/reimbursements?id=" + e.target.innerText;
			sendAjaxGetReim(url, displayResolvedById);
		}
	}
}

function displayResolvedById(xhr) {
	
	let r = JSON.parse(xhr.response);
	
	if (document.getElementById("main")) {		
		document.getElementById("main").remove();
	}
		
	let main = document.createElement("Div");
	main.id = "main";
	document.getElementById("content").appendChild(main);
	
	let title = document.createElement("h4");
	document.getElementById("main").appendChild(title);
	title.innerText = `About Reimbursement`;
	
	let table = document.createElement("Table");
	table.className = "table table-bordered table-hover";
	document.getElementById("main").appendChild(table);
	
	let firstHead = document.createElement("thead");
	firstHead.className = "thead-light";
	firstHead.innerHTML = `<tr>
	<th>Id</th>
	<th>Status</th>
	<th>Employee</th>
	<th>Department</th>
	<th>Submit Date</th>
	<th>Description</th>
	</tr>`;
	table.appendChild(firstHead);
	
	let firstRow = document.createElement("tr");	
	firstRow.innerHTML= `<td>${r.reimId}</td>
	<td>${r.status.toUpperCase()}</td>
	<td>${r.submitBy.firstName} ${r.submitBy.lastName}</td>
	<td>${r.submitBy.department.deptName}</td>
	<td>${r.submitDate.slice(0, 16)}</td>
	<td>${r.description}</td>`;
	table.appendChild(firstRow);

	let secondHead = document.createElement("thead");
	secondHead.className = "thead-light";
	secondHead.innerHTML = `<tr>
	<th>Amount</th>
	<th>Result</th>
	<th>Manager</th>
	<th>Position</th>
	<th>Resolved Date</th>
	<th>Reason</th>
	</tr>`;
	table.appendChild(secondHead);
	
	let secondRow = document.createElement("tr");	
	secondRow.innerHTML= `<td>${r.amount}</td>
	<td>${r.result.toUpperCase()}</td>
	<td>${r.resolvedBy.firstName} ${r.resolvedBy.lastName}</td>
	<td>${r.resolvedBy.position}</td>
	<td>${r.resolvedDate.slice(0, 16)}</td>
	<td>${r.reason}</td>`;
	table.appendChild(secondRow);
}