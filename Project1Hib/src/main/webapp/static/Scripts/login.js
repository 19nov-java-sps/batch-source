document.getElementById("employee-btn").addEventListener("click", reqLoginEmployee);
// hides the wrong username text when the username input is focused.
document.getElementById("username").addEventListener("focus", function() {
    document.getElementById("wrong-cred").hidden = true;
})

// Post request that sends the username and password to confirm credentials and then sets sessionStorage with token
// that was created in the server side.
function reqLoginEmployee() {
    const url = "http://localhost:8080/Project1Hib/login";

    let xhr = new XMLHttpRequest();
    xhr.open("POST", url);
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            let auth = xhr.getResponseHeader("Authorization");
            sessionStorage.setItem("token", auth);
            window.location.href = "http://localhost:8080/Project1Hib/employeeHome";
        } else if (xhr.status === 400) {
            // if the status is 400 then show the username is wrong text and
            // clear the input values.
            document.getElementById("wrong-cred").hidden = false;
            document.getElementById("username").value = "";
            document.getElementById("password").value = "";
        }
    }

    // gets the username and password from the input boxes.
    let user = document.getElementById("username").value;
    let pass = document.getElementById("password").value;

    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");

    let reqBody = `username=${user}&password=${pass}`;

    xhr.send(reqBody);
}