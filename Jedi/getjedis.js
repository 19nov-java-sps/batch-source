document.getElementById("findjedi").addEventListener("click",sendAjaxGet);
var name= document.getElementById("firstname")





function sendAjaxGet(){
    let xhr = new XMLHttpRequest();
    let url= "https://swapi.co/api/people/1/";
    xhr.open("GET",url);

    xhr.onreadystatechange=function(){
if(xhr.readyState==4 && xhr.status==200){
let parsedJSON= JSON.parse(xhr.response);
document.getElementById("name").innerHTML = parsedJSON.name;
document.getElementById("height").innerHTML=parsedJSON.height;
document.getElementById("mass").innerHTML = parsedJSON.mass;
document.getElementById("hair_color").innerHTML=parsedJSON.hair_color;
document.getElementById("skin_color").innerHTML = parsedJSON.skin_color;
document.getElementById("eye_color").innerHTML=parsedJSON.eye_color;
document.getElementById("birth_year").innerHTML = parsedJSON.birth_year;
document.getElementById("gender").innerHTML=parsedJSON.gender;



}


    }
    
xhr.send();

}



