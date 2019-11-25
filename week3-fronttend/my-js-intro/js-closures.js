
/*
    WE CAN CREATE OBJECT IN FEW WAYS :
        1. OBJECT LITERAL 
        2. MAKE FUNCTION (KIND OF OUR FOCTORY PATTERN )
        3. CONSTRUCTORS

*/
/*
function Dog(name, breed, age){
    this.name = name;
    this.breed = breed;
    this.age = age;
}
*/

// let say we want intantiate a new dog
// and to have access to the parameters we need getter&setter
// let qaz = new Dog("wer", "edrf", 4);
// and acceess the parameters by get&set


function Dog(nameInput, breedInput, ageInput){
    let name = nameInput;
    let breed = breedInput;
    let age = ageInput;

    // to access the diff argument outside 
    // of the func we should use THIS

    this.getName = function(){
        return name;
    }

    this.setName = function(newName){
        if (newName != "Bananas"){
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
        if(newAge){
            if(newAge>0){
                age = newAge;
            }
        }
    }

    this.setAge = function(newAge){
        if(typeof newAge == "number"){
            if(newAge>0){
                age = newAge;
            }
        }
    }

    this.bark = function(){
        console.log("woof")
    }

    this.__porto__ = new AnimationPlaybackEvent("Canis lupus familiarls", false)
    
}
