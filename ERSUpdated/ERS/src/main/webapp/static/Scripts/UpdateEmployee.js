
document.getElementById("update-btn").addEventListener("click", updateInfo);

let auth = sessionStorage.getItem("token");
let tokenArr = auth.split(":");
let id= tokenArr[0];
function updateInfo(){
	
	
	let url = "http://localhost:8080/ERS/updateinfo";
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
	let firstname = document.getElementById("firstname").value;
	let lastname = document.getElementById("lastname").value;
	let email= document.getElementById("email").value;
	let password= document.getElementById("password").value;

	
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
	let requestBody = `firstname=${firstname}&lastname=${lastname}&email=${email}&password=${password}&id=${id}`;
	xhr.send(requestBody);	


}



