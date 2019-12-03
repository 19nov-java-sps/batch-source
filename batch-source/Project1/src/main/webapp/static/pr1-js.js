let token = sessionStorage.getItem("token");
//console.log(token);

if(!token){
	window.location.href="http://localhost:8080/Project1/login";
} else {
	let tokenArr = token.split(":");
	console.log(tokenArr);
	if(tokenArr.length===2){
		let baseUrl = "http://localhost:8080/Project1/api/empl?id=";
		sendAjaxGet(baseUrl+tokenArr[0], displayName);
	} else {
		window.location.href="http://localhost:8080/Project1/login";
	}
}

/*
 * if we are not redirected when checking for the token, a request will be made to 
 * the url for that particular user 
 */

function sendAjaxGet(url, callback){
	let xhr = new XMLHttpRequest();
	xhr.open("GET", url);
	xhr.onreadystatechange = function(){
		if(this.readyState===4 && this.status===200){
			callback(this);
		} else if (this.readyState===4){
			window.location.href="http://localhost:8080/Project1/login";
		}
	}
	xhr.setRequestHeader("Authorization",token);
	xhr.send();
}

function displayName(xhr){
	let empl = JSON.parse(xhr.response);
	console.log(empl);
	document.getElementById("empl").innerHTML = empl.username;
	
}

window.onload = function(){
	let reimbursements = JSON.parse(JSONreimb);
	for(let reimb of reimbursements){
		this.addTableRow(reimb.reimId, reimb.descr, reimb.date, reimb.status, reimb.sum, reimb.id);

	}
}

function addTableRow(reimbId, descr, date, status, sum, id){
	let row = document.createElement("tr");

	row.innerHTML = `<td>${reimbId}</td><td>${null}</td><td>${null}</td><td>${date}</td><td>${status}</td><td>${descr}</td><td>${sum}</td><td>${null}</td><td>${null}</td>`;

	document.getElementById("reim-indv-table").appendChild(row);

}


document.getElementById("new-reimb-btn").addEventListener("click", addNew);


function addNew(){
	let descr = document.getElementById("ureimb-descr").nodeValue;
	let sum = document.getElementById("reimb-summ").nodeValue;
	console.log(`You have submitted: ${description} with a sum of ${sum}`);

	addTableRow(descr, sum);
}