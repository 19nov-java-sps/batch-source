let person =
 {
    isAlive: true, 
    walk: function()
        {
            console.log("person is walking");
        }
}

let scientist  = { 
    hasPHD: true,
    doReseach: function(){
        console.log("conducting research")
    },
    walk: function(){
        console.log("Scientist is walking")
    }
}

scientist.__proto__ = person; 