let person = {
    isAlive: true,
    walk: function(){
        console.log("Person is walking...");
    }

}

let scientist = {
    isPhD: true,
    doResearch: function(){
        console.log("conducting research...");
    }

}


scientist.__proto__ = person;