/*
	let auth = sessionStorage.getItem("token");
	let tokenArr = auth.split(":");
	let id= tokenArr[0];
	let reasonfor = document.getElementById("reasonfor").value;
*/
document.getElementById("request-btn").addEventListener("click", createReimbursement);

function createReimbursement(){
	console.log("creating reimb")
	
	let url = "http://localhost:8080/ERS/submitreimbursement";
	let xhr = new XMLHttpRequest();
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(this.readyState == 4){
			console.log(this);
		}
		if(this.readyState === 4 && this.status===200){
			// set authorization in our browser for future request
		
			window.location.href="http://localhost:8080/ERS/employee";


			
		}

	}
	let reasonfor = document.getElementById("reasonfor").value;
	let amount = document.getElementById("amount").value;
	let auth = sessionStorage.getItem("token");
	let tokenArr = auth.split(":");
	let id= tokenArr[0];
	console.log(reasonfor);
	
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
	let requestBody = `reasonfor=${reasonfor}&amount=${amount}&id=${id}`;
	xhr.send(requestBody);	


}




