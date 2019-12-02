let token = sessionStorage.getItem("token");
let emplId, password, email, phone;

document.getElementById("update-info-btn").addEventListener("click", updateInfo);
document.getElementById("update-info-return-btn").addEventListener("click", returnHome);

document.getElementById("my-email").addEventListener("click", editEmail);
function editEmail() {
	document.getElementById("my-email").removeAttribute('readonly');
}

document.getElementById("my-phone").addEventListener("click", editPhone);
function editPhone() {
	document.getElementById("my-phone").removeAttribute('readonly');
}

if (!token) {
	window.location.href="http://localhost:8080/Project1/login";
} else {
	let tokenArr = token.split(":");

	if (tokenArr.length === 3) {
		emplId = tokenArr[0];
		let baseUrl = "http://localhost:8080/Project1/api/employees?id=";
		sendAjaxGetMyInfo(baseUrl + tokenArr[0], setValue);
	} else {
		window.location.href="http://localhost:8080/Project1/login";
	}
}

function sendAjaxGetMyInfo(url, callback){
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

function setValue(xhr) {
	let empl = JSON.parse(xhr.response);
	
	password = empl.password;
	email = empl.email;
	phone = empl.phone;

	document.getElementById("my-email").value = email;
	document.getElementById("my-phone").value = phone;
}

function returnHome() {
	window.location.href="http://localhost:8080/Project1/home";
}

function updateInfo() {
	let callAjax = true;
	
	let newPass = document.getElementById("new-password").value;
	if (newPass !== '' && newPass.length < 8 || newPass.length > 16) {
		callAjax = false;
		document.getElementById('pass-length-msg').hidden = false;
		setTimeout(function(){ document.getElementById('pass-length-msg').hidden = true; }, 3000);
	} else if (newPass !== document.getElementById("confirm-password").value) {
		callAjax = false;
		document.getElementById('pass-match-msg').hidden = false;
		setTimeout(function(){ document.getElementById('pass-match-msg').hidden = true; }, 3000);
	} else if (newPass !== '') {
		password = newPass;
	}
	
	let newEmail = document.getElementById("my-email").value;
	if (!/.+@.+\..+/.test(newEmail)) {
		callAjax = false;
		console.log('email')
		document.getElementById("invalid-email-msg").hidden = true;
		setTimeout(function(){ document.getElementById('invalid-email-msg').hidden = true; }, 3000);
	} else {
		email = newEmail;
	}
	
	let newPhone = document.getElementById("my-phone").value;
	newPhone = newPhone.replace(/[^0-9]/g, '');
	if (newPhone.length !== 10) {
		callAjax = false;
		document.getElementById("invalid-phone-msg").hidden = true;
		setTimeout(function(){ document.getElementById('invalid-phone-msg').hidden = true; }, 3000);
	} else {
		phone = newPhone.replace(/(\d{3})(\d{3})(\d{3})/, "($1) $2-$3");
	}
	if (callAjax) sendAjaxUpdateEmpl();
}

function sendAjaxUpdateEmpl() {
	let url = "http://localhost:8080/Project1/employee/update";
	let xhr = new XMLHttpRequest();
	xhr.open("PUT", url);
	
	xhr.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 204) {
			window.location.reload();
		}
		
		else if (this.readyState === 4 && this.status !== 204){
			alert('Failed! Please Try Again.');
		}
	}
	
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");

	let requestBody = `emplId=${emplId}&password=${password}&email=${email}&phone=${phone}`;
	xhr.send(requestBody);
}

