/* 
    We can create objects in a few ways:
    1. object literal
    2. maker function (kind of like our factory pattern)
    3. constructors 
*/

/*
function Dog(name, breed, age){
    this.name = name;
    this.breed = breed;
    this.age = age;
}
*/


function Dog(nameInput, breedInput, ageInput){
    let name = nameInput;
    let breed = breedInput;
    let age = ageInput;

    this.getName = function(){
        return name;
    }

    this.setName = function(newName){
        if(newName != "bananas"){
            name = newName;
        }
    }

    this.getBreed = function(){
        return breed;
    }

    this.getAge = function(){
        return age;
    }

    this.setAge = function(newAge){
        if(typeof newAge == "number"){
            if(newAge>0){
                age = newAge;
            }
        }
    }

    this.bark = function(){
        console.log("woof");
    }
}