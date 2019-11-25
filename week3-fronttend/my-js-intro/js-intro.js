// console.log ("hello world");

// truthly / fasly values

// console.log(boolean(0));
// console.log(boolean(null));

let x = 0;
console.log(boolean(x));
// console.log(boolean("7"*7));
// console.log(boolean(""));
// console.log(boolean("seven"*7));
// console.log(boolean(false));
// console.log(boolean(" "));
// console.log(boolean([]));
// console.log(boolean({}));
// console.log(boolean());

// working with objects and variables

// let dog = {
//     breed : "German Sheprad",
//     name: "Rover",
//     age: 4,
//     bark: function(){
//         console.log("woof");
//     }
// }
// dog.name dog["name"] reference a value of dog
// dog.bark() is a method because it is a function 

// function myFunc(){
//     console.log("hello world");
// }

/*
    var 
        - gets hoised
        - can't be reassigned or declare 
        - global scop or function scope
*/

// var x = 10;
// var x = 12;

// let x = 10;
// let y = 9;
// var y = 10;
// var x = 13;
// x =13;
// let pass = false;
// var pass = false;
//var score = 80;
// if (score > 75){
//     var pass = true;
// }

//console.log(pass);

// let pass = false;
// let score = 80;
// if (score > 75){
//     let pass = true;
//     console.log("inside the block : " + pass);
// }

// console.log("outside of block: " + pass);


/*
    const
        - can not be reassigned , can not be redeclared
        - doesn't get hoised
        - allows for block scope
*/

// const z = 10;
// z = 12;

const dog2 = {
        breed : "Austrian  Sheprad",
        name: "Fluffy",
        age: 1,
        bark: function(){
            console.log("woof");
        }
    }

dog2.name = "priscill";

// hoisting - bringing the var declaration to the top of the scope

console.log(myVar);
var myVar = 15;  // this hoists the declaration


// console.log(myVar2);
// let myVar2  = 17; // this give us a referenceError

let myString = "here is my string";

// do not support multiLine string
/*
let myString2 = "here is my string
i want to put x in it";*/

let myString2 = "here is my string" + "I want to put x in it";

// instead we can use single quote
/*
    template literals 
        these allow for multiple line  strings where
*/
        let myString3 = `here is my string 
                I want to put ${x} in it`;










