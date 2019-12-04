document.getElementById("home-page").addEventListener("click", editView);

let homeURL = "http://localhost:8080/ERS/home"
let token = sessionStorage.getItem("token");
// console.log(token);

if (!token) {
	window.location.href = "http://localhost:8080/ERS/login";
} else {
	let tokenArr = token.split(":");
	console.log(tokenArr);
	if (tokenArr.length === 2) {
		let baseUrl = "http://localhost:8080/ERS/api/employee?id=";
		sendAjaxGet(baseUrl + tokenArr[0], editView);
	} else {
		window.location.href = "http://localhost:8080/ERS/login";
	}
}

function sendAjaxGet(url, callback) {
	let xhr = new XMLHttpRequest();
	xhr.open("GET", homeURL);
	xhr.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {
            callback(this);
        }
    }
            
            let user = document.getElementById("username").value;
            let pass = document.getElementById("password").value;

	
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    
	let requestBody = `username=${user}&password=${pass}`;
	xhr.send(requestBody);
}

function editView(xhr) {
    let empl = JSON.parse(xhr);
    console(empl);
    if(empl.manager == true) {
        document.getElementById("view-employees").hidden = false;
        document.getElementById("search-bar").hidden = false;
    }

    document.getElementById("view-employees").innerHTML
}



function displayEmployeePage(xhr) {
	let employee = JSON.parse(xhr.response);
	// console.log(employee);
    document.getElementById("employee-page").innerHTML = user.username;
    


}