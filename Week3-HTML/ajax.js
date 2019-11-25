let aReq = document.getElementById("show-char-but").addEventListener("click", getId);

function getId (){
    let charId = document.getElementById("characterId").value;
    sendAjax(url+charId, displayCharData);
}


let url = "https://swapi.co/api/people/";

function sendAjax (url, callback){
    let xhr = new XMLHttpRequest();
    xhr.open("get", url);
    xhr.onreadystatechange = function(){
        if(xhr.readyState==4 && xhr.status == 200){
            
            callback(xhr.response);
        }
    }
    xhr.send();
}

function displayCharData(JSONcode){
    let jsObject = JSON.parse(JSONcode);

//    console.log(jsObject.name);
    let brk = document.createElement("br");
    let head = document.createElement("h5");
    head.innerText = jsObject.name;
    document.getElementById("target-div").appendChild(brk);
    document.getElementById("target-div").appendChild(head);

}