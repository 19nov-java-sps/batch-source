let token = sessionStorage.getItem("token");

var myid;

document.getElementById("change").addEventListener("click", sendAjaxPost);

if(!token){
	window.location.href="http://localhost:8080/Project11/login";
} else {
	let tokenArr = token.split(":");
	console.log(tokenArr);
	if (tokenArr[1] == "manager"){
		window.location.href="http://localhost:8080/Project11/manhome";
	}
	if(tokenArr.length===2){
		let requestUrl = "http://localhost:8080/Project11/api/userprofiles?USERID=";
		sendAjaxGet(requestUrl+tokenArr[0], displayProfile);
		myid = tokenArr[0];
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
		}
	}
	xhr.setRequestHeader("Authorization",token);
	xhr.send();
}

function displayName(xhr){
	let user = JSON.parse(xhr.response);
//	console.log(user);
	document.getElementById("DisplayUserNameHere").innerHTML = user.user_name;
	document.getElementById("DisplayUser").innerHTML = user.user_name;

}

function displayProfile(profileJSON){
	let profile = JSON.parse(profileJSON.response);

	let userID = myid;
	
	let table = document.getElementById("dataTable");
	table.hidden = false;

	for(let pro of profile){

		let newRow = document.createElement("tr");

		newRow.innerHTML= `<td>${userID}</td><td>${pro.address}</td><td>${pro.phoneNumber}</td>`;
		table.appendChild(newRow);

	}
}


function sendAjaxPost(){
	let xhr = new XMLHttpRequest();
	let url = "http://localhost:8080/Project11/updateprofile";
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(this.readyState===4 && this.status===200){

		}

	}
	let getaddress = document.getElementById("addressinput").value;
	let getphonenumber = document.getElementById("phonenumberinput").value;
	let userID = myid;

	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")

	let requestBody = `USERID=${userID}&ADDRESS=${getaddress}&PHONENUMBER=${getphonenumber}`;

	xhr.send(requestBody);
}

