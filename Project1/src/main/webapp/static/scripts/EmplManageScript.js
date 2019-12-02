document.getElementById('view-empls').addEventListener("click", viewEmpls);

function viewEmpls() {
	let url = "http://localhost:8080/Project1/api/employees";
	sendAjaxGetEmpls(url, displayEmplsInfo);
}

function sendAjaxGetEmpls(url, callback) {
	let xhr = new XMLHttpRequest();
	xhr.open("GET", url);
	
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200) {
			callback(this);
		} else if (this.readyState === 4){
			window.location.href="http://localhost:8080/Project1/login";
		}
	}

	xhr.setRequestHeader("Authorization", token);
	xhr.send();
}

function displayEmplsInfo(xhr) {
	
	let empls = JSON.parse(xhr.response);
	
	if (document.getElementById("main")) {		
		document.getElementById("main").remove();
	}
	
	let main = document.createElement("Div");
	main.id = "main";
	document.getElementById("content").appendChild(main);
	
	let title = document.createElement("h4");
	document.getElementById("main").appendChild(title);
	title.innerText = "All Employees";
	
	let table = document.createElement("Table");
	table.className = "table table-bordered table-striped";
	document.getElementById("main").appendChild(table);
	
	let head = document.createElement("thead");
	head.className = "thead-light";
	head.innerHTML = `<tr>
	<th>Id</th>
	<th>Name</th>
	<th>Email</th>
	<th>Phone</th>
	<th>Position</th>
	<th>Department</th>
	<th>Manager Id</th>
	</tr>`
	table.appendChild(head);
	
	let body = document.createElement("tbody");
	
	empls.forEach(empl => {
		let newRow = document.createElement("tr");
		let manager = empl.managerId === 0 ? null : empl.managerId;
		
		newRow.innerHTML= `<td>${empl.emplId}</td>
		<td>${empl.firstName} ${empl.lastName}</td>
		<td>${empl.email}</td>
		<td>${empl.phone}</td>
		<td>${empl.position}</td>
		<td>${empl.department.deptName}</td>
		<td>${manager}</td>`;
		body.appendChild(newRow);
	})
	
	table.appendChild(body);
}


