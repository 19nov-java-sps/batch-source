let token = sessionStorage.getItem("token");

document.getElementById("generate").addEventListener("click", sendAjaxPost);

if(!token){
	window.location.href="http://localhost:8080/Project11/login";
} else {
	let tokenArr = token.split(":");
	console.log(tokenArr);
	if(tokenArr.length===2){
		let baseUrl = "http://localhost:8080/Project11/api/users?id=";
		sendAjaxGet(baseUrl+tokenArr[0], displayName);
	} else {
		window.location.href="http://localhost:8080/Project11/login";
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
			window.location.href="http://localhost:8080/Project11/login";
		}
	}
	xhr.setRequestHeader("Authorization",token);
	xhr.send();
}

function sendAjaxPost(){
	let xhr = new XMLHttpRequest();
	let url = "http://localhost:8080/Project11/invoices";
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(this.readyState===4 && this.status===200){

		}

	}
	let getAmount = document.getElementById("amount").value;
	let userID = token[0];

	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")

	let requestBody = `userid=${userID}&amount=${getAmount}`;

	xhr.send(requestBody);
}



function displayName(xhr){
	let user = JSON.parse(xhr.response);
//	console.log(user);
	document.getElementById("DisplayUserNameHere").innerHTML = user.user_name;
	document.getElementById("DisplayUser").innerHTML = user.user_name;

}
