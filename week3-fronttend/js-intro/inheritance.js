
let person = {
    isAlive: true,
    walk: function(){
        console.log("Person is walking");
    }
}

let scientist = {
    hasPhD: true,
    doResearch: function(){
        console.log("conducting research")
    }, 
    walk: function(){
        console.log("Scientist is walking")
    }
}

scientist.__proto__ = person;