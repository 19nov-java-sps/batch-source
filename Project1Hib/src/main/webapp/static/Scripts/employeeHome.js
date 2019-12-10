let token = sessionStorage.getItem("token");

// Checks if a token exists in the sessionStorage
if (!token) {
    window.location.href = "http://localhost:8080/Project1Hib/login";
} else {
    const tokenArr = token.split(":");
    if (tokenArr.length === 2) {
        const employeeUrl = "http://localhost:8080/Project1Hib/api/employees?username=";
        const reimbursementUrl = "http://localhost:8080/Project1Hib/api/reimbursements";
        sendAjaxGetEmployees(employeeUrl + tokenArr[0], displayEmployee);   // Gets employee by username
        sendAjaxGetReimbursements(reimbursementUrl + "?status=Resolved" + `&username=${tokenArr[0]}`, displayResReimbursements); // gets reimbursements by status = Resolved and username
        sendAjaxGetReimbursements(reimbursementUrl + "?status=Pending" + `&username=${tokenArr[0]}`, displayPenReimbursements); // gets reimbursements by status = Pending and username
        sendAjaxGetReimbursements(reimbursementUrl + "?status=Denied" + `&username=${tokenArr[0]}`, displayDenReimbursements); // gets reimbursements by status = Denied and username
    } else {    // redirects back to login page if sessionStorage is empty.
        window.location.href="http://localhost:8080/Project1Hib/login";
    }
}

// sends a get request to get employees.
function sendAjaxGetEmployees(url, callback) {
    let xhr = new XMLHttpRequest();
    xhr.open("GET", url);
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            callback(xhr.response);
        } else if (xhr.readyState === 4) {
            window.location.href="http://localhost:8080/Project1Hib/login";
        }
    }
    xhr.setRequestHeader("Authorization", token);
	xhr.send();
}

// Displays the employee's information
function displayEmployee(xhrResponse) {
    let employee = JSON.parse(xhrResponse);
    document.getElementById("name").innerHTML = `${employee.fName} ${employee.lName}`;
}

function sendAjaxGetReimbursements(url, callback) {
    let xhr = new XMLHttpRequest();
    xhr.open("GET", url);
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            callback(xhr.response);
        }
    }
    xhr.send();
}

// Displays pending reimbursements
function displayPenReimbursements(xhrResponse) {
    let reimbursements = JSON.parse(xhrResponse);
    const reimTable = document.getElementById("pending-reim");
    reimTable.hidden = false;
    
    for (reim of reimbursements) {
        const newTr = document.createElement("tr");
        newTr.innerHTML = `<td>${reim.reim_id}</td><td>$${reim.amount}</td><td>${reim.description}</td><td>${reim.status}</td>`;
        reimTable.appendChild(newTr);
    }
}

// Displays resolved reimbursements
function displayResReimbursements(xhrResponse) {
    let reimbursements = JSON.parse(xhrResponse);
    const reimTable = document.getElementById("resolved-reim");
    reimTable.hidden = false;
    
    // iterates through reimbursements and creates a table row with 4 table datas in each.
    for (reim of reimbursements) {
        const newTr = document.createElement("tr");
        newTr.innerHTML = `<td>${reim.reim_id}</td><td>$${reim.amount}</td><td>${reim.description}</td><td>${reim.status}</td><td>${reim.managerName}</td>`;
        reimTable.appendChild(newTr);
    }
}

// Displays pending reimbursements
function displayDenReimbursements(xhrResponse) {
    let reimbursements = JSON.parse(xhrResponse);
    const reimTable = document.getElementById("denied-reim");
    reimTable.hidden = false;
    
    for (reim of reimbursements) {
        const newTr = document.createElement("tr");
        newTr.innerHTML = `<td>${reim.reim_id}</td><td>$${reim.amount}</td><td>${reim.description}</td><td>${reim.status}</td><td>${reim.managerName}</td>`;
        reimTable.appendChild(newTr);
    }
}

// adds an event listener to the logout list item.
document.getElementById("logout-link").addEventListener("click", function() {
    sessionStorage.clear();
    window.location.href = "http://localhost:8080/Project1Hib/login";
});

// after the fields are focused the error message hides.
document.getElementById("amount").addEventListener("focus", function() {
    document.getElementById("fill-inputs-text").hidden = true;
});

document.getElementById("description").addEventListener("focus", function() {
    document.getElementById("fill-inputs-text").hidden = true;
});

document.getElementById("submit-btn").addEventListener("click", reqCreate);
// clears the input fields when you click on close.
document.getElementById("close-btn").addEventListener("click", function() {
    document.getElementById("amount").value = "";
    document.getElementById("description").value = "";
    document.getElementById("fill-inputs-text").hidden = true;
});

// after the submit button is clicked this function runs where we request a post method to create a new reimbursement
function reqCreate() {
    const url = "http://localhost:8080/Project1Hib/create";
	let xhr = new XMLHttpRequest();
    xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4 && xhr.status === 200){
            window.location.href = "http://localhost:8080/Project1Hib/employeeHome";
		}
	}
	const tokenArr = token.split(":");	// to get the username.
	// assign the input field values to send to the server.
	const amount = document.getElementById("amount").value;
	const description = document.getElementById("description").value;
    
    // checks if the amount and description fields are filled.
    if (!amount || !description) {
        document.getElementById("fill-inputs-text").hidden = false; // shows error if not
        return; // also returns.
    }

	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
	
    let requestBody = `amount=${amount}&description=${description}&username=${tokenArr[0]}`;
	
    xhr.send(requestBody);
}
