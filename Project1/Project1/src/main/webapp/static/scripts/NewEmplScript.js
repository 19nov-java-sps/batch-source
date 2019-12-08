let token = sessionStorage.getItem("token");

document.getElementById("empl-return-btn").addEventListener("click", returnHome);
document.getElementById("submit-empl-btn").addEventListener("click", createNewEmpl);

if(!token){
	window.location.href="http://localhost:8080/Project1/login";
} else {
	let tokenArr = token.split(":");
	document.getElementById("manager-id").value = tokenArr[0];
	
	let url = "http://localhost:8080/Project1/api/departments";
	sendAjaxGetDepts(url, addDeptOption);
}

function sendAjaxGetDepts(url, callback){
	let xhr = new XMLHttpRequest();
	xhr.open("GET", url);
	
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200) {
			callback(this);
		} else if (this.readyState === 4 && this.status !== 200){
			alert('Loading Failed! Please try again');
		}
	}

	xhr.setRequestHeader("Authorization", token);
	xhr.send();
}

function addDeptOption(xhr) {
	let depts = JSON.parse(xhr.response);
	let deptSelector = document.getElementById("dept-option");
	
	depts.forEach(dept => {
		let option = document.createElement("option");
		option.value = dept.deptId;
		option.text = dept.deptName;
		deptSelector.appendChild(option);
	})
}

function returnHome() {
	window.location.href="http://localhost:8080/Project1/home";
}

function createNewEmpl() {
	const firstname = document.getElementById("first-name").value;
	const lastname = document.getElementById("last-name").value;
	const email = document.getElementById("email").value;
	let phone = document.getElementById("phone").value;
	phone = phone.replace(/[^0-9]/g, '');
	const position = document.getElementById("position").value;
	const deptId = document.getElementById("dept-option").value;
	const managerId = document.getElementById("manager-id").value;

	if (firstname === '' || lastname === '' || email === '' || phone === '' || position === '') {
		document.getElementById("invalid-input-msg").hidden = false;
		setTimeout(function(){ document.getElementById('invalid-input-msg').hidden = true; }, 3000);
	} else if (!/.+@.+\..+/.test(email)) {
		document.getElementById("invalid-email-msg").hidden = false;
		setTimeout(function(){ document.getElementById('invalid-email-msg').hidden = true; }, 3000);
	} else if (phone.length !== 10) {
		document.getElementById("invalid-phone-msg").hidden = false;
		setTimeout(function(){ document.getElementById('invalid-phone-msg').hidden = true; }, 3000);
	} else {
		phone = phone.replace(/(\d{3})(\d{3})(\d{3})/, "($1) $2-$3");
		
		let url = "http://localhost:8080/Project1/employee/new";
		let xhr = new XMLHttpRequest();
		xhr.open("POST", url);
		
		xhr.onreadystatechange = function() {
			if (this.readyState === 4 && this.status === 201) {
				
				document.getElementById('empl-success-alert').hidden = false;
				document.getElementById("submit-empl-btn").disabled = 'disabled';
				setTimeout(function(){ window.location.reload(); }, 3000);
			}
			
			else if (this.readyState === 4 && this.status !== 201){
				document.getElementById('empl-fail-alert').hidden = false;
				setTimeout(function(){ document.getElementById('empl-fail-alert').hidden = true; }, 3000);
			}
		}
		
		xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")

		let requestBody = `firstname=${firstname}&lastname=${lastname}&email=${email}&phone=${phone}&position=${position}&deptId=${deptId}&managerId=${managerId}`;
		xhr.send(requestBody);
	}
	
}