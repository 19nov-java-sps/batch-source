let token = sessionStorage.getItem("token");
let baseUrl = "http://localhost:8080/ERS/api/employee";
fetchAllEmployee()

		
function fetchAllEmployee(){
	fetch(baseUrl, {
		"method": "GET",
		"headers": { Authorization: `${token}`}
	}).then(res => {
		if (res.status === 200) {
			return res.json()
		} else {
			console.log("error")
		}
	}).then( arrayEmployeeObjects => {
		let table = document.getElementById("empl-table");

		for (let empl of arrayEmployeeObjects) {
			console.log(empl)
			let newRow = document.createElement("tr");

		newRow.innerHTML = `<td>${empl.employeeID}</td><td>${empl.fullName}</td><td>${empl.userName}</td><td>${empl.passWord}</td>
		<td>${empl.isManager}</td>`;
		table.appendChild(newRow);
		}
	})
}		
