let JSONPlanes =`[ ]`

window.onload = function(){
    // console.log(JSONPlanes);
    let Pokemon = JSON.parse(JSONPlanes);
    // console.log(planes);
    for(let pokemon of Pokemon){
        this.addTableRow(pokemon.Weight, pokemon.ID);
    }
}

let counter = 100;

function addTableRow(Weight, ID)
{
    let row = document.createElement("tr");

    if(!ID){
        ID = ++counter;
    // }
    row.innerHTML = `<td>${Weight}</td> <td>${ID}</td>`;

    
    // let cell1 = document.createElement("td");

    document.getElementById("pokemon-table").appendChild(row);

}


document.getElementById("add-pokemon-btn").addEventListener("click", addNew);



function addNew()
{
    // let Weight = document.getElementById("Weight-input").value;
    let ID = document.getElementById("ID-input").value;
    console.log(`You have submitted: ${ID}`);

    addTableRow(Weight,ID)

}
}