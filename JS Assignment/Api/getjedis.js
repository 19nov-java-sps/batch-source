document.getElementById("findjedi").addEventListener("click",sendAjaxGet);
var name= document.getElementById("firstname")





function sendAjaxGet(){
    let xhr = new XMLHttpRequest();
    let url= "https://swapi.co/api/people/1/";
    xhr.open("GET",url);

    xhr.onreadystatechange=function(){
if(xhr.readyState==4 && xhr.status==200){
let parsedJSON= JSON.parse(xhr.response);
document.getElementById("jedi").innerHTML = parsedJSON.name;


}


    }
    
xhr.send();

}



