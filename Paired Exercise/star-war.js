let url = `https://swapi.co/api/people/?search=`;

document.getElementById("my-btn").addEventListener("click", searchCharacter);

function searchCharacter() {
    let input = document.getElementById("name-input").value;
    console.log(input);
    xmlGetRequest(url+input, displayResults);
}

function xmlGetRequest(url, callback) {
    console.log("clicked");
    let xhr = new XMLHttpRequest();
    xhr.open("GET", url);
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            callback(xhr.response);
        }
    }
    xhr.send();
}

function displayResults(starWarsJSON) {
    document.getElementById("results").hidden = false;

    let starWarsData = JSON.parse(starWarsJSON);
    console.log(starWarsData);

    document.getElementById("name").innerText = `Name: ${starWarsData.results[0].name}`;
    document.getElementById("birth-year").innerText = `Birth Year: ${starWarsData.results[0].birth_year}`;
    document.getElementById("height").innerText = `Height: ${starWarsData.results[0].height}`;
    document.getElementById("eye-color").innerText = `Eye Color: ${starWarsData.results[0].eye_color}`;
    document.getElementById("mass").innerText = `Mass: ${starWarsData.results[0].mass}`;



}