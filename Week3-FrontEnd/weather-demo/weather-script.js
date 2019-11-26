document.getElementById("submit-btn").addEventListener("click", searchWeather);

let baseUrl = "http://api.weatherstack.com/current?access_key=93d3364c99aef5709d1caaabc64709b7&units=f&query=";

// access my zipcode input and invoke the sendAjaxGet function to perform the http call
function searchWeather(){
    let zipInput = document.getElementById("zip-input").value;
    sendAjaxGet(baseUrl+zipInput, displayWeather, displayErrorMessage);
}

// ajax workflow
function sendAjaxGet(url, callback, errorCallback){
    let xhr = new XMLHttpRequest(); // || new ActiveXObject
    console.log(xhr.readyState);
    xhr.open("GET", url);
    console.log(xhr.readyState);
    xhr.onreadystatechange = function(){
        console.log(xhr.readyState);
        if(xhr.readyState==4 && xhr.status==200){
            let parsedJSON = JSON.parse(xhr.response);
            if(parsedJSON.success == false){
                errorCallback();
            } else {
                callback(parsedJSON);
            }
        } 
    }
    xhr.send();
}

// manipulates the DOM and displays the weather data
function displayWeather(weatherInfo){
    document.getElementById("error").hidden = true;

    console.log(weatherInfo);

    document.getElementById("result").hidden = false;
    document.getElementById("location").innerText = `Weather for ${weatherInfo.location.name}, ${weatherInfo.location.region}`;
    document.getElementById("condition").innerText = weatherInfo.current.weather_descriptions[0];
    document.getElementById("icon").src = weatherInfo.current.weather_icons[0];

    // let tempC = weatherInfo.current.temperature;
    // let tempF = (9/5)*tempC + 32;

    // let feelLikeC = weatherInfo.current.feelslike;
    // let feelLikeF = (9/5)*feelLikeC + 32;

    document.getElementById("temp").innerText = `${weatherInfo.current.temperature}°F (Feels like ${weatherInfo.current.feelslike}°F)`;

}



function displayErrorMessage(){
    let errorNode = document.getElementById("error");
    errorNode.innerText = "There was an issue processing your request";
    errorNode.hidden = false;
    errorNode.style = "color:red";
}