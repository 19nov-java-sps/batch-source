/**
 * 
 */

const requestUrl = "http://localhost:8080/FrontControllerDemo/api/departments";


function sendAjaxGet(url, callback){
	let xhr = new XMLHttpRequest();
	xhr.open("GET", url);
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			callback(xhr.response);
		}
	}
	xhr.send();
}

sendAjaxGet(requestUrl, displayDepartmentOptions);

function displayDepartmentOptions(deptJSON){
	const departmentSelect = document.getElementById("dept-select");
	const departments = JSON.parse(deptJSON);
	for(let dept of departments){
		let newOption = document.createElement("option");
		newOption.value = dept.id;
		newOption.innerText = dept.name;
		departmentSelect.appendChild(newOption);
	}
	
}