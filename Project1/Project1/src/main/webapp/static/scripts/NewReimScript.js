let token = sessionStorage.getItem("token");
let emplId = null;

document.getElementById("reim-return-btn").addEventListener("click", returnHome);
document.getElementById("submit-reim-btn").addEventListener("click", createNewReim);

if(!token){
	window.location.href="http://localhost:8080/Project1/login";
} else {
	let tokenArr = token.split(":");
	emplId = tokenArr[0];
}

function returnHome() {
	window.location.href="http://localhost:8080/Project1/home";
}

function createNewReim() {
	let url = "http://localhost:8080/Project1/reimbursement/new";
	let xhr = new XMLHttpRequest();
	xhr.open("POST", url);
	
	xhr.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 201) {
			document.getElementById('amount').value = '';
			document.getElementById('description').value = '';
			
			document.getElementById('reim-success-alert').hidden = false;
			setTimeout(function(){ document.getElementById('reim-success-alert').hidden = true; }, 10000);
		}
		
		else if (this.readyState === 4 && this.status !== 201){
			document.getElementById('reim-fail-alert').hidden = false;
			//console.log(this.status); 
			//setTimeout(function(){ document.getElementById('reim-fail-alert').hidden = true; }, 10000);
		}
	}
	
	const amount = document.getElementById('amount').value;
	const description = document.getElementById('description').value;
	
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")

	let requestBody = `amount=${amount}&emplId=${emplId}&description=${description}`;
	xhr.send(requestBody);
}