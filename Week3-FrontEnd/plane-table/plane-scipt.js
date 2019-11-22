let JSONPlanes = `[
    {
        "id": 25,
        "model": "Boeing 747",
        "topSpeed": 614,
        "isCargo": false
    }, {
        "id":38,
        "model": "F16",
        "topSpeed": 1500,
        "isCargo": false
    }, {
        "id": 48,
        "model": "Airbus A300",
        "topSpeed": 557,
        "isCargo": true
    }
]`

window.onload = function(){
    // console.log(JSONPlanes);
    let planes = JSON.parse(JSONPlanes);
    // console.log(planes);
    for(let plane of planes){
        this.addTableRow(plane.model, plane.topSpeed, plane.isCargo, plane.id);
    }
}

let counter = 100;

function addTableRow(model, topSpeed, isCargo, id){
    let row = document.createElement("tr");

    let type = "Cargo";
    if(!isCargo){
        type = "NonCargo";
    }

    if(!id){
        id = ++counter;
    }

    row.innerHTML = `<td>${id}</td><td>${model}</td><td>${topSpeed}</td><td>${type}</td>`;

    /*
    let cell1 = document.createElement("td");
    let cell2 = document.createElement("td");
    let cell3 = document.createElement("td");
    let cell4 = document.createElement("td");
    cell1.innerText = id;
    cell2.innerText = model;
    cell3.innerText = topSpeed;
    if(isCargo){
        cell4.innerText = "Cargo";
    } else {
        cell4.innerText = "Non Cargo";
    }
    row.appendChild(cell1);
    row.appendChild(cell2);
    row.appendChild(cell3);
    row.appendChild(cell4);  
    */
    
    document.getElementById("plane-table").appendChild(row);

}


document.getElementById("add-plane-btn").addEventListener("click", addNew);



function addNew(){
    let model = document.getElementById("model-input").value;
    let topSpeed = document.getElementById("speed-input").value;
    let isCargo = document.getElementById("cargo-input").checked;
    console.log(`You have submitted: ${model} with a top speed of ${topSpeed}. Is it cargo? ${isCargo}`);

    addTableRow(model,topSpeed, isCargo)

}