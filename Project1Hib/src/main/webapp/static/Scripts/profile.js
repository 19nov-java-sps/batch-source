let token = sessionStorage.getItem("token");

if (!token) {
    window.location.href = "http://localhost:8080/Project1Hib/login";
} else {
    const tokenArr = token.split(":");
    if (tokenArr.length === 2) {
        const employeeUrl = "http://localhost:8080/Project1Hib/api/employees?username=";
        sendAjaxGetProfile(employeeUrl + tokenArr[0], displayProfile);
    } else {
        window.location.href="http://localhost:8080/Project1Hib/login";
    }
}

function sendAjaxGetProfile(url, callback) {
    let xhr = new XMLHttpRequest();
    xhr.open("GET", url);
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            callback(xhr.response);
        } else if (xhr.readyState === 4) {
            window.location.href="http://localhost:8080/Project1Hib/login";
        }
    }
	xhr.send();
}

// displays the employee id, username and name of the employee.
function displayProfile(xhrResponse) {
    let profile = JSON.parse(xhrResponse);
    profTable = document.getElementById("profile");
    profTable.hidden = false;

    const newTr = document.createElement("tr");
    newTr.innerHTML = `<td>${profile.fName} ${profile.lName}</td><td>${profile.username}</td><td>${profile.emp_id}</td>`;
    profTable.appendChild(newTr);
}

// if the first name or last name input is focused then hide error message
document.getElementById("first-name").addEventListener("focus", function() {
    document.getElementById("fill-inputs-text").hidden = true;
});

document.getElementById("last-name").addEventListener("focus", function() {
    document.getElementById("fill-inputs-text").hidden = true;
});


document.getElementById("change-btn").addEventListener("click", saveName);

// if the close button is clicked clear both input fields and hide the error message if there is one.
document.getElementById("close-btn").addEventListener("click", function() {
    document.getElementById("first-name").value = "";
    document.getElementById("last-name").value = "";
    document.getElementById("fill-inputs-text").hidden = true;
});

// sends a post request to update the first and last name of the employee.
function saveName(e) {
    const url = "http://localhost:8080/Project1Hib/updateEmp";
	let xhr = new XMLHttpRequest();
    xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4 && xhr.status === 200){
            window.location.href = "http://localhost:8080/Project1Hib/profile";
		}
    }
    const emp_id = e.path[5].children[4].children[1].children[2].outerText;
    const fName = document.getElementById("first-name").value;
    const lName = document.getElementById("last-name").value;

    // checks if the input fields are empty
    if (!fName || !lName) {
        document.getElementById("fill-inputs-text").hidden = false; // shows error message
        return; // and returns.
    }
    
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");

    let requestBody = `fName=${fName}&lName=${lName}&emp_id=${emp_id}`;
	
    xhr.send(requestBody);
}

// when the logout item is clicked, clear the sessionStorage and redirect to the login page.
document.getElementById("logout-link").addEventListener("click", function() {
    sessionStorage.clear();
    window.location.href = "http://localhost:8080/Project1Hib/login";
});