let token = sessionStorage.getItem("token");
let tokenArr = token.split(":");
let id= tokenArr[0];
let baseurl = "http://localhost:8080/ERS/api/allresolved";
console.log("Can you see me???");

sendAjaxGet(baseurl, showAllManagerResolved);

function sendAjaxGet(url, callback){
	console.log("ajax call made");
	let xhr = new XMLHttpRequest();
	xhr.open("GET", baseurl);
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			console.log("hello");
			callback(xhr);
		}
	}
	
	xhr.setRequestHeader("Authorization", token);
	xhr.send();
}

function showAllManagerResolved(xhr){
	let manres = JSON.parse(xhr.response);
	console.log(manres);
	let table = document.getElementById("man-resolved-table");

	for(let res of manres){
		
		let newRow = document.createElement("tr");
		
		newRow.innerHTML= `<td>${res.employeeID}</td><td>${res.reimbursementID}</td><td>${res.amount}</td><td>${res.reason}</td>
		<td>${res.approved}</td><td>${res.denied}</td><td>${res.resolved}</td>`;
		table.appendChild(newRow);
	
	}
}