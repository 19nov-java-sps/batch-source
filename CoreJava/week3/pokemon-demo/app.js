document.getElementById("btn").addEventListener("click", searchForPokemon)
let baseUrl = "https://pokeapi.co/api/v2/pokemon/"

function searchForPokemon(){
    let pokemon = document.getElementById("poke").value
    document.getElementById("poke-info").hidden=true
    searchQuery(baseUrl+pokemon, updateHTML)
   


}

function searchQuery(url, callback){

    let xhr = new XMLHttpRequest()
    xhr.open("GET", url)
    xhr.onreadystatechange = function(){
        if (xhr.readyState==4 && xhr.status==200) {
            let parsedJSON = JSON.parse(xhr.response)
            callback(parsedJSON)
        }
    }
    xhr.send()
}

function updateHTML(parsedJSON){
    document.getElementById("poke-info").hidden=false
    console.log(parsedJSON)

    document.getElementById("poke_pic").src = parsedJSON.sprites.front_default
    document.getElementById("pokemon_ability_name").innerHTML = parsedJSON.abilities[1].ability.name
    document.getElementById("pokemon_weight").innerHTML = parsedJSON.weight
    document.getElementById("pokemon_height").innerHTML = parsedJSON.height
    document.getElementById("pokemon_species").innerHTML = parsedJSON.species.name
    document.getElementById("pokemon_name").innerHTML = parsedJSON.species.name

}