let token = sessionStorage.getItem("token");

document.getElementById('logout-btn').addEventListener("click", logout);
document.getElementById('profile').addEventListener("click", getMyInfo);

if(!token){
	window.location.href="http://localhost:8080/Project1/login";
} else {
	let tokenArr = token.split(":");

	if(tokenArr.length === 3){
		
		if (tokenArr[1] > 0) {
			document.getElementById('manager-sidebar').hidden = false;
		}
		
		let baseUrl = "http://localhost:8080/Project1/api/employees?id=";
		sendAjaxGet(baseUrl + tokenArr[0], displayEmplInfo);
	} else {
		window.location.href="http://localhost:8080/Project1/login";
	}
}

function sendAjaxGet(url, callback){
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

function displayEmplInfo(xhr){
	let empl = JSON.parse(xhr.response);
	
	let main = document.createElement("Div");
	main.id = "main";
	document.getElementById("content").appendChild(main);
	
	let title = document.createElement("h4");
	document.getElementById("main").appendChild(title);
	title.innerText = "My Profile";
	
	let table = document.createElement("Table");
	table.className = "table table-bordered";
	document.getElementById("main").appendChild(table);
	table.innerHTML = `<tr><th>Name </th><td>${empl.firstName} ${empl.lastName}</td></tr>
	<tr><th>Email </th><td>${empl.email}</td></tr>
	<tr><th>Phone </th><td>${empl.phone}</td></tr>
	<tr><th>Position </th><td>${empl.position}</td></tr>
	<tr><th>Department </th><td>${empl.department.deptName}</td></tr>
	`;
	
}

function logout() {
	sessionStorage.clear();
	window.location.href="http://localhost:8080/Project1/login";
}

function getMyInfo() {
	if (document.getElementById("main")) {		
		document.getElementById("main").remove();
	}
	
	let tokenArr = token.split(":");
	let baseUrl = "http://localhost:8080/Project1/api/employees?id=";
	sendAjaxGet(baseUrl + tokenArr[0], displayEmplInfo);

}


