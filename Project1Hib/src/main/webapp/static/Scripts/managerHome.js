let token = sessionStorage.getItem("token");

if (!token) {
    window.location.href = "http://localhost:8080/Project1Hib/mlogin";
} else {
    const tokenArr = token.split(":");
    if (tokenArr.length === 2) {
        const employeeUrl = "http://localhost:8080/Project1Hib/api/employees";
        const managerUrl = "http://localhost:8080/Project1Hib/api/managers?username=";
        const reimbursementUrl = "http://localhost:8080/Project1Hib/api/reimbursements";
        sendAjaxGetManager(managerUrl + tokenArr[0], displayManager);   // gets manager by username
        sendAjaxGetEmployees(employeeUrl, displayEmployees);    // gets all employees
        sendAjaxGetReimbursements(`${reimbursementUrl}?status=Resolved`, displayResReimbursements); // gets all resolved reimbursements
        sendAjaxGetReimbursements(`${reimbursementUrl}?status=Pending`, displayPenReimbursements);  // gets all pending reimbursements
        sendAjaxGetReimbursements(`${reimbursementUrl}?status=Denied`, displayDenReimbursements);  // gets all denied reimbursements
    } else {    // redirects to login page if token doesnt exist.
        window.location.href = "http://localhost:8080/Project1Hib/login";
    }
}

function sendAjaxGetManager(url, callback) {
    let xhr = new XMLHttpRequest();
    xhr.open("GET", url);
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            callback(xhr.response);
        } else if (xhr.readyState === 4) {
            window.location.href = "http://localhost:8080/Project1Hib/login";
        }
    }
    xhr.setRequestHeader("Authorization", token);
	xhr.send();
}

// displays manager's information
function displayManager(xhrResponse) {
    let manager = JSON.parse(xhrResponse);
    document.getElementById("name").innerHTML = `${manager.fName} ${manager.lName}`;
}

// sends a get request to retrieve reimbursements
function sendAjaxGetReimbursements(url, callback) {
    let xhr = new XMLHttpRequest();
    xhr.open("GET", url);
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            callback(xhr.response);
        } else if (xhr.status === 400) {
            // Since the status is 400 then we can show this message to the manager stating
            // that the username doesnt exist or the username doesnt have any pending
            // reimbursements.
            document.getElementById("wrong-username").hidden = false;
        }
    }
    xhr.send();
}

// searching for pending reimbursements for a specific employee
document.getElementById("search-btn").addEventListener("click", filterReim);
document.getElementById("show-all-btn").addEventListener("click", function() {
    window.location.href = "http://localhost:8080/Project1Hib/managerHome";
})

// filters the reimbursements by the username that the manager inputs in the input form.
function filterReim() {
    const empName = document.getElementById("emp-search").value;
    const reimbursementUrl = "http://localhost:8080/Project1Hib/api/reimbursements?status=Pending&username=";
    document.getElementById("emp-search").value = ""; // after grabbing the input value we can clear it.
    sendAjaxGetReimbursements(`${reimbursementUrl}${empName}`, displayPenReimbursements);  // send a get request with the username the manager inputted
    document.getElementById("show-all-btn").hidden = false; // show the show all button in order for the manager to regain back all the reimbursements from all usernames.
}

// after the input is focused, hide the wrong username text.
document.getElementById("emp-search").addEventListener("focus", function() {
    document.getElementById("wrong-username").hidden = true;
})

// displays all pending reimbursements
function displayPenReimbursements(xhrResponse) {
    let reimbursements = JSON.parse(xhrResponse);
    const reimTable = document.getElementById("pending-reim");
    reimTable.innerHTML = `<tr><th>Reimbursement Id</th><th>Amount</th><th>Description</th><th>Status</th><th>Employee</th></tr>`;
    reimTable.hidden = false;   // shows the table.

    // iterates through reimbursements and also adds two buttons at the end of each row.
    for (reim of reimbursements) {
        const newTr = document.createElement("tr");
        newTr.innerHTML = `<td>${reim.reim_id}</td><td>$${reim.amount}</td><td>${reim.description}</td><td>${reim.status}</td><td>${reim.username}</td><td><button id="resolve-btn" class="btn btn-success">Resolve</button></td><td><button id="deny-btn" class="btn btn-danger">Deny</button></td>`;
        reimTable.appendChild(newTr);
    }
}

// displays all resolved reimbursements
function displayResReimbursements(xhrResponse) {
    let reimbursements = JSON.parse(xhrResponse);
    const reimTable = document.getElementById("resolved-reim");
    reimTable.hidden = false;
    
    for (reim of reimbursements) {
        const newTr = document.createElement("tr");
        newTr.innerHTML = `<td>${reim.reim_id}</td><td>$${reim.amount}</td><td>${reim.description}</td><td>${reim.status}</td><td>${reim.username}</td><td>${reim.managerName}`;
        reimTable.appendChild(newTr);
    }
}

// displays all resolved reimbursements
function displayDenReimbursements(xhrResponse) {
    let reimbursements = JSON.parse(xhrResponse);
    const reimTable = document.getElementById("denied-reim");
    reimTable.hidden = false;
    
    for (reim of reimbursements) {
        const newTr = document.createElement("tr");
        newTr.innerHTML = `<td>${reim.reim_id}</td><td>$${reim.amount}</td><td>${reim.description}</td><td>${reim.status}</td><td>${reim.username}</td><td>${reim.managerName}`;
        reimTable.appendChild(newTr);
    }
}

// sends a get request to retrieve all employees.
function sendAjaxGetEmployees(url, callback) {
    let xhr = new XMLHttpRequest();
    xhr.open("GET", url);
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            callback(xhr.response);
        }
    }
	xhr.send();
}

// displays all employees.
function displayEmployees(xhrResponse) {
    let employees = JSON.parse(xhrResponse);
    const empTable = document.getElementById("employee-table");
    empTable.hidden = false;

    for (emp of employees) {
        const newTr = document.createElement("tr");
        newTr.innerHTML = `<td>${emp.emp_id}</td><td>${emp.fName} ${emp.lName}</td><td>${emp.username}</td>`;
        empTable.appendChild(newTr);
    }
}

// Since the buttons are dynamically created we need to perform event delegation in order for an event to fire when clicking those buttons.
document.getElementById("pending-reim").addEventListener("click", function(e) {
    if (e.target && e.target.id == "resolve-btn") { // checks if the event target exists and if the target's id corresponds with the resolved button
        resolveReim(e); // if so then call this function and pass e to it in order to get the reimbursement id.
    } else if (e.target && e.target.id == "deny-btn") { // checks if the deny button was clicked.
        denyReim(e);    // calls the deny reimbursement function and passes the event object.
    }
});

// requests a post where it updates the specified reimbursement's status and manager name.
function resolveReim(e) {
    const url = "http://localhost:8080/Project1Hib/updateReim";
	let xhr = new XMLHttpRequest();
    xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4 && xhr.status === 200){
            window.location.href = "http://localhost:8080/Project1Hib/managerHome";   // refreshes the page to see new changes.
		}
    }
    const tokenArr = token.split(":");
    const reim_id = e.path[2].children[0].outerText;    // this is acquired through the event object.
    const managerName = tokenArr[0];
    const status = "Resolved";  // Since we clicked the resolve button, the status is now resolved
    
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	
    let requestBody = `reim_id=${reim_id}&managerName=${managerName}&status=${status}`;
	
    xhr.send(requestBody);
}

// requests a post where it updates the specified reimbursement's status to Denied and also updates the manager name.
function denyReim(e) {
    const url = "http://localhost:8080/Project1Hib/updateReim";
	let xhr = new XMLHttpRequest();
    xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4 && xhr.status === 200){
            window.location.href = "http://localhost:8080/Project1Hib/managerHome";
		}
    }
    const tokenArr = token.split(":");
    const reim_id = e.path[2].children[0].outerText;    // use the event object to get the value.
    const managerName = tokenArr[0];
    const status = "Denied";
    
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	
    let requestBody = `reim_id=${reim_id}&managerName=${managerName}&status=${status}`;
	
    xhr.send(requestBody);
}

// when event is fired the sessionStorage is cleared and it redirects to login page.
document.getElementById("logout-link").addEventListener("click", function() {
    sessionStorage.clear();
    window.location.href = "http://localhost:8080/Project1Hib/mlogin";
});
