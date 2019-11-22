let url = `https://pokeapi.co/api/v2/pokemon/`;

document.getElementById("find-weight-btn").addEventListener("click", searchCharacter);

function searchCharacter() {
    let input = document.getElementById("id-input").value;
    xmlGetRequest(url+input, displayWeight);
}

function xmlGetRequest(url, callback) {
    let xhr = new XMLHttpRequest();
    xhr.open("GET", url);
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            callback(xhr.response);
        }
    }
    xhr.send();
}

function displayWeight (pokemonJSON) {
    document.getElementById("idToWeight").hidden = false;

    let pokemonWeight = JSON.parse(pokemonJSON);
    document.getElementById("weight").innerText = `weight: ${pokemonWeight.weight/10}`;




}