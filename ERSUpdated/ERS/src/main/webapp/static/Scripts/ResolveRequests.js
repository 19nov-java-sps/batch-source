
document.getElementById("approve-btn").addEventListener("click", updateInfo);

let auth = sessionStorage.getItem("token");
let tokenArr = auth.split(":");
let managerid= tokenArr[0];

function updateInfo(){
	
	
	let url = "http://localhost:8080/ERS/approveordeny";
	let xhr = new XMLHttpRequest();
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(this.readyState == 4){
			console.log(this);
		}
		if(this.readyState === 4 && this.status===200){
			// set authorization in our browser for future request
		
			window.location.href="http://localhost:8080/ERS/manager";


			
		}

	}
	let id = document.getElementById("id").value;
	let status = document.getElementById("status").value;
	

	
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
	let requestBody = `id=${id}&status=${status}&managerid=${managerid}`;
	xhr.send(requestBody);	


}



