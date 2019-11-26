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


function Animal(speciesInput, canFlyInput){
    let species = speciesInput;
    let canFly = canFlyInput;

    this.getCanFly = function(){
        return canFly;
    }

    this.getSpecies = function(){
        return species;
    }
}

// these are constructor functions > let dog = new Dog();
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

    this.__proto__ = new Animal("Canis lupus familiaris",false);
}
