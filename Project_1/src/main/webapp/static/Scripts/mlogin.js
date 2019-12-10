document.getElementById("manager-btn").addEventListener("click", reqLoginManager);
document.getElementById("username").addEventListener("focus", function() {
    document.getElementById("wrong-cred").hidden = true;
})

function reqLoginManager() {
    const url = "http://localhost:8080/Project_1/mlogin";

    let xhr = new XMLHttpRequest();
    xhr.open("POST", url);
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            let auth = xhr.getResponseHeader("Authorization");
            sessionStorage.setItem("token", auth);
            window.location.href = "http://localhost:8080/Project_1/managerHome";
        } else if (xhr.status === 400) {
            // if the status is 400 then show the username is wrong text and
            // clear the input values.
            document.getElementById("wrong-cred").hidden = false;
            document.getElementById("username").value = "";
            document.getElementById("password").value = "";
        }
    }

    let user = document.getElementById("username").value;
    let pass = document.getElementById("password").value;

    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");

    let reqBody = `username=${user}&password=${pass}`;

    xhr.send(reqBody);
}