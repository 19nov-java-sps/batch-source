//event listeners
let expenseId = sessionStorage.getItem("expenseId");
document.getElementById('logout-btn').addEventListener("click", requestLogout);
document.getElementById("sub").addEventListener("click", addExp);
document.getElementById("approve").addEventListener("click", appPending);
document.getElementById("updateEmpInfo").addEventListener("click", updateInfo);
document.getElementById("deny").addEventListener("click", denyPending);
let appdenyid;

function timedRefresh(timeout){
	setTimeout("location.reload(true);",timeout);
}


window.addEventListener('load', getResolved);
window.addEventListener('load', getAll);
window.addEventListener('load', getPending);



let token = sessionStorage.getItem("token");
let requestUrl = "http://localhost:8087/Project1/api/employees";
let emplId=null;
let managerId;



/////////////////////////////////////////////////////////////////////////////////////////////////////token auth
if(!token){
	window.location.href="http://localhost:8087/Project1/login";
} else {
	let tokenArr = token.split(":");
	emplId=tokenArr[0];
	managerId = tokenArr[0];
	
	console.log(tokenArr);
	if(tokenArr.length===2){
		let baseUrl = "http://localhost:8087/Project1/api/employees?id=";
		sendAjaxGet(baseUrl+tokenArr[0], displayName);
	} else {
		window.location.href="http://localhost:8087/Project1/login";
	}
	if(tokenArr[1]=="Manager"){
		console.log(tokenArr[1]);
		let table = document.getElementById("manager_only");
		table.hidden = false;
	} 
	if(tokenArr[1]!=="Manager"){
		console.log(tokenArr[1]);
		let form=document.getElementById("emp_only");
		form.hidden=false;
	}
}



/////////////////////////////////////////////display all employees and for the select option///////////	works 
function sendAjaxGet(url, callback){
	let xhr = new XMLHttpRequest();
	xhr.open("GET", url);
	xhr.onreadystatechange = function(){
		if(this.readyState===4 && this.status===200){
			callback(this);
		} 
	}
	xhr.setRequestHeader("Authorization",token);
	xhr.send();
}
sendAjaxGet(requestUrl, displayEmployees);

function requestLogout() {
	sessionStorage.clear();
	window.location.href="http://localhost:8087/Project1/login";
}

function displayName(xhr){
	let user = JSON.parse(xhr.response);
	//lists the heading depending on which user logins/type
	document.getElementById("user").innerHTML = user.name;
	document.getElementById("type").innerHTML = user.employeetype;
	
	
	//also lists a single users info on the employee side///////////////
	let table = document.getElementById("empl-table-empview");
	let newRow = document.createElement("tr");
	newRow.innerHTML= `<td>${user.name}</td><td>${user.email}</td><td>${user.passWord}</td>`;
	table.appendChild(newRow);	
}



function displayEmployees(xhr){
	let employees = JSON.parse(xhr.response);
	let table = document.getElementById("empl-table");
	let names=document.getElementById("empnames");
	for(let employee of employees){
		let newRow = document.createElement("tr");
		newRow.innerHTML= `<td>${employee.name}</td><td>${employee.email}</td><td>${employee.employeetype}</td>`;
		table.appendChild(newRow);
		
		
		
		///lists employee names to view single reqs
		let inputnames=document.createElement("option");
		inputnames.text=`${employee.name}`;
		inputnames.value=`${employee.user_id}`;
		if(`${employee.employeetype}`!="Manager"){
		let ineedthis=`${employee.user_id}`;
		
		names.appendChild(inputnames);
		}
	}
}

/////////////////////////////////////////////////use select and if value changes, show that employees expenses////works
function getSelectedValue(){
	var selected=document.getElementById("empnames").value;
	console.log("this is final value" + selected);
	
	let table = document.getElementById("single-empl-table");
	table.innerHTML=" ";
	
	
	let baseUrl="http://localhost:8087/Project1/api/expenses/resolved2?id=";
	sendAjaxGetSingleEmpResolved(baseUrl+selected,displaySingleResolvedEmp);
}


function sendAjaxGetSingleEmpResolved(url,callback){
	  let xhr = new XMLHttpRequest(); // || new ActiveXObject
	    console.log(xhr.readyState);
	    xhr.open("GET", url);
	    console.log(xhr.readyState);
	    xhr.onreadystatechange = function(){
	        console.log(xhr.readyState);
	        if(xhr.readyState==4 && xhr.status==200){
	            let parsedJSON = JSON.parse(xhr.response);
	        	console.log("this is the size!!!!!"+ parsedJSON.size);
	            if(parsedJSON.success == false){
	                errorCallback();
	            } else {
	                callback(parsedJSON);
	            }
	        } 
	    }
	    xhr.send();
}

function displaySingleResolvedEmp(resolvedInfo){
	let employees = (resolvedInfo);
	let table = document.getElementById("single-empl-table");
	table.hidden=false;
	let header=document.createElement("tr");
	header.innerHTML=`
	<th>Expense ID</th>
	<th>Expense Type</th>
	<th>Expense Amount</th>
	<th>Status</th>
	<th>Manager</th>
`;
	table.appendChild(header);
//		let newRow = document.createElement("tr");
		Object.keys(employees).forEach(function(key){
			let newRow = document.createElement("tr");
			newRow.innerHTML= `<td>${employees[key].expenseId}</td><td>${employees[key].expenseType}</td><td>${employees[key].expenseAmount}</td><td>${employees[key].approvalStatus}</td><td>${employees[key].managerId}</td>`;
			table.appendChild(newRow);	
		});
//		Object.keys(employees).forEach(function(key){
//			console.log("these are keys"+employees[key].expenseType);
//		});
}



///////////////////////////Get all resolved expenses///////////////////////////////////////////works on window reload
function getResolved(){
	let baseUrl="http://localhost:8087/Project1/expenses/resolved";
	sendAjaxGet2(baseUrl,displayResolved)
	
}

function sendAjaxGet2(url,callback){
	  let xhr = new XMLHttpRequest(); // || new ActiveXObject
	    console.log(xhr.readyState);
	    xhr.open("POST", url);
	    console.log(xhr.readyState);
	    xhr.onreadystatechange = function(){
	        console.log(xhr.readyState);
	        if(xhr.readyState==4 && xhr.status==200){
	            let parsedJSON = JSON.parse(xhr.response);
	            if(parsedJSON.success == false){
	                errorCallback();
	            } else {
	                callback(parsedJSON);
	            }
	        } 
	    }
	    xhr.send();
}


function displayResolved(resolvedInfo){
	let employees = resolvedInfo
	let table = document.getElementById("resolved-table");
	for(let employee of employees){
		let newRow = document.createElement("tr");
		newRow.innerHTML= `<td>${employee.userId}</td><td>${employee.expenseType}</td><td>${employee.expenseAmount}</td><td>${employee.approvalStatus}</td><td>${employee.managerId}</td>`;
		table.appendChild(newRow);	
	}
	
}




////////////////////////////////////get all reqs//////////////////////////////////////////////////////works on onload 
function getAll(){
	let baseUrl="http://localhost:8087/Project1/expenses/all";
	sendAjaxGet3(baseUrl,displayAll)
}

function sendAjaxGet3(url,callback){
	  let xhr = new XMLHttpRequest(); // || new ActiveXObject
	    xhr.open("POST", url);
	    xhr.onreadystatechange = function(){
	        if(xhr.readyState==4 && xhr.status==200){
	            let parsedJSON = JSON.parse(xhr.response);
	                callback(parsedJSON);
	        } 
	    }
	    xhr.send();
}


function displayAll(resolvedInfo){
	let employees = resolvedInfo;
	let table = document.getElementById("all-table");
	for(let employee of employees){
		let newRow = document.createElement("tr");
		newRow.innerHTML= `<td>${employee.userId}</td><td>${employee.expenseType}</td><td>${employee.expenseAmount}</td><td>${employee.approvalStatus}</td><td>${employee.managerId}</td>`;
		table.appendChild(newRow);	
	}
}



////////////////////////////////////////////////////////////view pending reqs///////////////////////////////////////
function getPending(){
	let baseUrl="http://localhost:8087/Project1/expenses/pending";
	sendAjaxGet4(baseUrl,displayPending);	
}

function sendAjaxGet4(url,callback){
	  let xhr = new XMLHttpRequest(); // || new ActiveXObject
	    console.log(xhr.readyState);
	    xhr.open("POST", url);
//	    console.log(xhr.readyState);
	    xhr.onreadystatechange = function(){
//	        console.log(xhr.readyState);
//	        console.log("ajax4");
	        if(xhr.readyState==4 && xhr.status==200){
	            let parsedJSON = JSON.parse(xhr.response);
	            callback(parsedJSON);	            
	        } 
	    }
	    xhr.send();
}


function displayPending(resolvedInfo){
	let employees = resolvedInfo;
//	console.log(employees);
	let table = document.getElementById("pending-table");
	for(let employee of employees){
		let newRow = document.createElement("tr");
		newRow.innerHTML= `<td><input type="radio" name="expenseId" id="expenseId" onclick="handleClick(this);" value=${employee.expenseId} </td><td>${employee.userId}</td><td id="expenseId">${employee.expenseId}</td><td>${employee.expenseType}</td><td>${employee.expenseAmount}</td>`;
		let radios=document.getElementsByName("expenseId");
//		console.log("preloop");
//		for(let i=0;i<radios.length;i++){
//			
//				value=radios[i].checked.value;
//				console.log("loop value"+value+"this is index "+i);
//				sessionStorage.setItem("expenseId",value);
//			
//			
//		}
//		console.log("not loop"+ value);
//		sessionStorage.setItem("expenseId",value);
		table.appendChild(newRow);		
	}
}

function handleClick(input){
	console.log("input value is"+input.value);
//	document.getElementById("approve").addEventListener("click", appPending);
	appdenyid=input.value;
}


//approve pending/////////////////////////////////////////////
//function appPending(){
//	let baseUrl="http://localhost:8087/Project1/expenses/pending/approve";
//	sendAjaxGet5(baseUrl,appPending2);
//	
//	 
//}
//
//function sendAjaxGet5(url,callback){
//	  let xhr = new XMLHttpRequest(); // || new ActiveXObject
//	    console.log(xhr.readyState);
//	    xhr.open("GET", url);
//	    console.log(xhr.readyState);
//	    xhr.onreadystatechange = function(){
//	        console.log(xhr.readyState);
//	        console.log("ajax4");
//	        if(xhr.readyState==4 && xhr.status==200){
//	            let parsedJSON = JSON.parse(xhr.response);
//	            
//	                callback(parsedJSON);
//	            
//	        } 
//	    }
//	    xhr.send();
//}

function appPending(){
	let approvalStatus="Approved";
	let url="http://localhost:8087/Project1/expenses/pending/approve?id=";
	let xhr = new XMLHttpRequest();
	xhr.open("PUT", url+appdenyid);
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	let requestBody = `expenseId=${appdenyid}&managerId=${managerId}&approvalStatus=${approvalStatus}`;
	xhr.send(requestBody);
	location.reload(3000);
}

function denyPending(){
	let approvalStatus="Denied";
	let url="http://localhost:8087/Project1/expenses/pending/deny?id=";
	let xhr = new XMLHttpRequest();
	xhr.open("PUT", url+appdenyid);
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	let requestBody = `expenseId=${appdenyid}&managerId=${managerId}&approvalStatus=${approvalStatus}`;
	xhr.send(requestBody);
	location.reload(3000);
}





///////////////////////////employee side/////////////////////////////////////////////////////////////////////////////


///////////////////////////view their pending/////////////////////////////////////////works/////////////////////////
window.addEventListener('load', getPendingEmp);
function getPendingEmp(){
	
//	let baseUrl = "http://localhost:8087/Project1/api/employees?id=";
//	sendAjaxGet(baseUrl+tokenArr[0], displayName);
	
	let tokenArr = token.split(":");
	let id=tokenArr[0];
	document.getElementById('id').value=id;
	let baseUrl="http://localhost:8087/Project1/api/expenses/pending?id=";
	sendAjaxGetEmpPending(baseUrl+id,displayPendingEmp);
	console.log("the value of id is:"+id);
	
	
	
	
}

function sendAjaxGetEmpPending(url,callback){
	  let xhr = new XMLHttpRequest(); // || new ActiveXObject
	    xhr.open("GET", url);
	    xhr.onreadystatechange = function(){
	        if(xhr.readyState==4 && xhr.status==200){
	            let parsedJSON = JSON.parse(xhr.response);
	            if(parsedJSON.success == false){
	                errorCallback();
	            } else {
	                callback(parsedJSON);
	            }
	        } 
	    }
	    xhr.send();
}


function displayPendingEmp(resolvedInfo){
	let employees = (resolvedInfo);
	let table = document.getElementById("pending-table-empside");
//		let newRow = document.createElement("tr");
		Object.keys(employees).forEach(function(key){
			let newRow = document.createElement("tr");
			newRow.innerHTML= `<td>${employees[key].expenseId}</td><td>${employees[key].expenseType}</td><td>${employees[key].expenseAmount}</td><td>${employees[key].approvalStatus}</td>`;
			table.appendChild(newRow);	
		});
//		Object.keys(employees).forEach(function(key){
//			console.log("these are keys"+employees[key].expenseType);
//		});
}




















///////////////////////////////////////////////////////////Employee view page shows their resolved////////works///////
window.addEventListener('load', getResolvedEmp);
function getResolvedEmp(){
	
//	let baseUrl = "http://localhost:8087/Project1/api/employees?id=";
//	sendAjaxGet(baseUrl+tokenArr[0], displayName);
	
	let tokenArr = token.split(":");
	let id=tokenArr[0];
	document.getElementById('id').value=id;
	let baseUrl="http://localhost:8087/Project1/api/expenses/resolved?id=";
	sendAjaxGetEmpResolved(baseUrl+id,displayResolvedEmp);
}

function sendAjaxGetEmpResolved(url,callback){
	  let xhr = new XMLHttpRequest(); // || new ActiveXObject
	    console.log(xhr.readyState);
	    xhr.open("GET", url);
	    console.log(xhr.readyState);
	    xhr.onreadystatechange = function(){
	        console.log(xhr.readyState);
	        if(xhr.readyState==4 && xhr.status==200){
	            let parsedJSON = JSON.parse(xhr.response);
	            if(parsedJSON.success == false){
	                errorCallback();
	            } else {
	                callback(parsedJSON);
	            }
	        } 
	    }
	    xhr.send();
}

function displayResolvedEmp(resolvedInfo){
	let employees = (resolvedInfo);
	let table = document.getElementById("resolved-table-empside");
//		let newRow = document.createElement("tr");
		Object.keys(employees).forEach(function(key){
			let newRow = document.createElement("tr");
			newRow.innerHTML= `<td>${employees[key].expenseId}</td><td>${employees[key].expenseType}</td><td>${employees[key].expenseAmount}</td><td>${employees[key].approvalStatus}</td><td>${employees[key].managerId}</td>`;
			table.appendChild(newRow);	
		});
//		Object.keys(employees).forEach(function(key){
//			console.log("these are keys"+employees[key].expenseType);
//		});
}






////////////////////////////update info works////////////////////////////////////////////////////////////////////////////////
function updateInfo(){
	let url = "http://localhost:8087/Project1/update";
	let xhr = new XMLHttpRequest();
	xhr.open("POST", url);
	let updateEmail = document.getElementById('updateEmail').value;
	let updateName = document.getElementById('updateName').value;
	let updatePass = document.getElementById('updatePass').value;
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
	let requestBody = `updateName=${updateName}&updateEmail=${updateEmail}&updatePass=${updatePass}&emplId=${emplId}`;
	xhr.send(requestBody);
	document.getElementById('updateEmail').value="";
	document.getElementById('updateName').value="";
	document.getElementById('updatePass').value="";
	let success2 = document.getElementById("success2");
	success2.hidden = false;
	timedRefresh(2000);
}



////////////////////////////////////////////////////////////////////////////////////////////add an expense works////////
function addExp() {
	let url = "http://localhost:8087/Project1/expenses";
	let xhr = new XMLHttpRequest();
	xhr.open("POST", url);
	let amount = document.getElementById('amount').value;
	let type = document.getElementsByName('type')[0].value;
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
console.log(amount);
	console.log(type);
	let requestBody = `amount=${amount}&emplId=${emplId}&type=${type}`;
	xhr.send(requestBody);
	let success = document.getElementById("success");
	success.hidden = false;
	document.getElementById('amount').value="";
	document.getElementsByName('type')[0].value="";
	timedRefresh(2000);
}











//////////////////////////////////Obsolete code/////////////////////////////////////////////////////////////////////////
////////////////////////////view their info//////////////////////////////////////
//function viewInfo(){/////////////////////////////////obsolete
//	let tokenArr = token.split(":");
//	id=tokenArr[0];
//	let baseUrl="http://localhost:8087/Project1/employees";
//	sendAjaxGetviewInfo(baseUrl,viewInformation)
//	
//}
//
//function sendAjaxGetviewInfo(url,callback){
//	  let xhr = new XMLHttpRequest(); // || new ActiveXObject
//	    console.log(xhr.readyState);
//	    xhr.open("GET", url);
//	    console.log(xhr.readyState);
//	    xhr.onreadystatechange = function(){
//	        console.log(xhr.readyState);
//	        if(xhr.readyState==4 && xhr.status==200){
//	            let parsedJSON = JSON.parse(xhr.response);
//	            if(parsedJSON.success == false){
//	                errorCallback();
//	            } else {
//	                callback(parsedJSON);
//	            }
//	        }
//	    }
//	        xhr.setRequestHeader("Authorization",token);
//	    
//	    xhr.send();
//}
//
//
//function viewInformation(resolvedInfo){
//	console.log("this is resolved info"+resolvedInfo);
//	let e = (resolvedInfo);
//	let table = document.getElementById("empl-table-empview");
//	document.getElementById("testingthis").innerHTML = e.name;
////	for(let employee of employees){
////		let newRow = document.createElement("tr");
////		newRow.innerHTML= `<td>${employee.name}</td><td>${employee.email}</td><td>${employee.passwordo}</td>`;
////		table.appendChild(newRow);	
////	}
//	
//}










