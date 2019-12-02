let token = sessionStorage.getItem("token");

document.getElementById("update-info-btn").addEventListener("click", updateInfo);
document.getElementById("update-info-return-btn").addEventListener("click", returnHome);

function returnHome() {
	window.location.href="http://localhost:8080/Project1/home";
}

function updateInfo() {
	console.log('update');
}

