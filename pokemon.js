document.getElementById("submit-btn").addEventListener("click", searchWeight);

let baseUrl = "https://pokeapi.co/";

function searchWeight(){
    let idInput = document.getElementById("id-input").value;
    SendAjaxGet(baseUrl, displayWeight, displayErrorMessage);
}


function sendAjaxGet(url, callback, errorCallback){
    let xhr = new XMLHttpRequest();
    xhr.open("GET", url);
    xhr.onreadystatechange = function(){ 
        if(xhr.readyState==4 && xhr.status ==200){
            let parsedJSON = JSON.parse(xhr.response);
            if(parsedJSON.success == false){
                errorCallback();
            } else {
                callback(parsedJSON);
            }
        } 
    }
    xhr.send()
        


}

function displayWeight(idInput){
    document.getElementById("error").hidden = true;

    console.log(weatherInfo);

    document.getElementById("result").hidden = false;
    document.getElementById("weight").innerText = `Weight for ${idInput.location.name}`;
}

let JSONPokemone =`[ ]`
window.onload = function(){
let Pokemon = JSON.parse(JSONPokemon);
for(let pokemon of Pokemon){
    this.addTableRow(pokemon.Weight, pokemon.ID);
}
}
let Weight = 40;
function addTableRow(Weight, ID){
let row = document.createElement("tr");

row.innerHTML = `<td>${Weight}</td> <td>${ID}</td>`;


document.getElementById("pokemon-table").appendChild(row);


}
document.getElementById("add-pokemon-btn").addEventListener("click", addNew);




function addNew() {
//let Weight = document.getElementById("Weight-input").value;
let ID = document.getElementById("ID-input").value;
addTableRow(Weight,ID)
}
