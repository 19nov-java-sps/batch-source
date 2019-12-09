let token = sessionStorage.getItem("token");

console.log("I am in index. file");
console.log("SessionStored token = " + token);
if(!token){
	console.log("I am in index.js if method");
	window.location.href="http://localhost:8080/Project1/login";
} else {
	console.log("I am in index.js else method");
	let tokenArr = token.split(":");
	console.log("tokenArr from index.js= " +tokenArr);
	if(tokenArr.length===2){
		let baseUrl = "http://localhost:8080/Project1/api/empl?id=";
		console.log(baseUrl+tokenArr[0] + " url from indexscript");
		sendAjaxGet(baseUrl+tokenArr[0], displayName);
		
	} else {
		console.log("else else");
		window.location.href="http://localhost:8080/Project1/login";
	}
	
	

	let reimbUrl = "http://localhost:8080/Project1/api/empls";
	sendAjaxGet(reimbUrl, displayReimbursements);


	function displayReimbursements(xhr){
		console.log("Type of" + typeof xhr.response);
		console.log("xhr.response " + xhr.response);
		let reimbursements = JSON.parse(xhr.response);
		console.log("reimbursements is " + reimbursements);
		console.log(typeof reimbursements);
		let table = document.getElementById("reimb-table");
		table.hidden = false;
		
		for(let reimb of reimbursements){
			if(reimb.reportTo==tokenArr[1] && reimb.emplId!=tokenArr[0]){
			let newRow = document.createElement("tr");
			let rDate = new Date(reimb.date);
			newRow.innerHTML= `<td>${reimb.rId}</td><td>${reimb.firstName}</td><td>${reimb.lastName}</td><td>${rDate.toDateString()}</td><td id="reimb-status">${reimb.status}</td>
			<td>${reimb.descr}</td><td>${reimb.sum}</td><td>${null}</td><td><button type="button" class="btn btn-success btn-xs  py-0" id="approve${reimb.rId}" onclick="getApproved(event)" style="font-size: 0.8em;">Approve</button>
<button type="button" class="btn btn-danger btn-xs  py-0 id="deny" style="font-size: 0.8em;">Deny</button></td>`;
			table.appendChild(newRow);
			
			}
			if( reimb.emplId==tokenArr[0]){
				let newRow = document.createElement("tr");
				let rDate = new Date(reimb.date);
				newRow.innerHTML= `<td>${reimb.rId}</td><td>${reimb.firstName}</td><td>${reimb.lastName}</td><td>${rDate.toDateString()}</td><td id="status">${reimb.status}</td>
				<td>${reimb.descr}</td><td>${reimb.sum}</td><td>${null}</td><td><button type="button" class="btn btn-success btn-xs  py-0" id="edit" style="font-size: 0.8em;">Edit</button>
	<button type="button" class="btn btn-danger btn-xs  py-0 id="delete" style="font-size: 0.8em;">Delete</button></td>`;
				table.appendChild(newRow);
				
				}
	}
}
	
//	function getMaxReimbId(){
//		let reimbUrl = "http://localhost:8080/Project1/api/empls";
//		let next = sendAjaxGet(reimbUrl, nextReimbId);
//		
//	}
//	
//	function nextReimbId (xhr){
//	
//		let reimbursements = JSON.parse(xhr.response);for(let reimb of reimbursements){
//			for(let reimb of reimbursements){
//				consel.log(reimb.rId);
//					return reimb.rId[5];
//		}
//	}
//	}
	

	
	function getApproved(event){
		
//	let rowId = event.target.id
//	let rowStatus = rowId.substr(0,7);
//	let  rowNumber = rowId.substr(8);
//	
//	let table = document.getElementById("reimb-table");
//	let newRow = table.rows[rowNumber];
//	table.status = "approved";
//	
//	console.log(newRow);
//		console.log("newRowStatus" + table.status);
//		//console.log("rowNUmber" + rowNumber);
	}
	

	
	
	
document.getElementById("logout-btn").addEventListener("click", logOut);

function logOut(){
	sessionStorage.clear()
	window.location.href="http://localhost:8080/Project1/login"
	}


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
	console.log("I am in displayName  method");
	let empl = JSON.parse(xhr.response);
	console.log("Empl  in display Name " + empl);
	document.getElementById("empl").innerHTML = " " + empl.firstName + " " + empl.lastName;
	document.getElementById("empl-f-name").innerHTML = " " + empl.firstName;
	document.getElementById("empl-l-name").innerHTML = " " + empl.lastName;
	document.getElementById("empl-manager").innerHTML = " " + empl.reportTo;
	document.getElementById("empl-depart").innerHTML = " " + empl.depart;
	document.getElementById("empl-number").innerHTML = " " + empl.strNum;
	document.getElementById("empl-street").innerHTML = " " + empl.street;
	document.getElementById("empl-city").innerHTML = " " + empl.city;
	document.getElementById("empl-state").innerHTML = " " + empl.state;
	document.getElementById("empl-zip").innerHTML = " " + empl.zip;
	document.getElementById("empl-phone").innerHTML = " " + empl.phone;

}




document.querySelectorAll('.dropdown-item').forEach(item => {
	  item.addEventListener('click', event => {
	    document.querySelector('#dropdownMenuButton').innerText =
	      event.target.innerText;
	    let value = event.target.innerText;
	    console.log(value);
	  //  showReimbOnlyAvailable(value);
	    
	  });
	});


//function showReimbOnlyAvailable(value){
//	switch(value){
//	case  "approved":
//		displayReimbursements(xhr, "approved")
//		console.log("Work 1")
//		break;
//	case  "denied":
//		console.log("Work 2")
//		displayReimbursements(xhr, "denied")
//		break;
//	case "pending":
//		console.log("Work 3")
//		displayReimbursements(xhr, "pending")
//		break;
//	}
//	
//
//
//
//}



function addTableRow(rId, fName, lName, date, status, descr, sum){
	let table = document.getElementById("reimb-table");
	let newRow = document.createElement("tr");

	newRow.innerHTML= `<td>${rId}</td><td>${fName}</td><td>${lName}</td><td>${date.toDateString()}</td><td>${status}</td><td>${descr}</td><td>${sum}</td><td>${null}</td><td>${null}</td>`;
	table.appendChild(newRow);
	
}


document.getElementById("new-reimb-btn").addEventListener("click", addNew);

function addNew(){
	
	let rId = document.getElementById("ureimb-id").value;
	let descr = document.getElementById("ureimb-descr").value;
	let sum = document.getElementById("reimb-summ").value;
	let date = new Date();
	let status = "pending";
	let emplId = sessionStorage.getItem("token")[0];
	let fName = empl.firstName;
	let lName = empl.lastName;
	
	console.log(`You have submitted: ${rId} ,  ${descr} with a sum of ${sum} and date : ${date} and status ${status}`);

	//add a new row into a table
	addTableRow(rId, fName, lName, date, status, descr, sum);
	
	
	//sending request to Database
	let url = "http://localhost:8080/Project1/reimb";
	let xhr = new XMLHttpRequest();
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status===200){
			let requestBody = string;
			}

	}
	
xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
	
	let requestBody = `rId=${rId}&fName=${fName}&lName=${lName}&descr=${descr}&sum=${sum}&emplId=${emplId}&status=${status}`;
	
	xhr.send(requestBody);
	
	
}
	
	
}

