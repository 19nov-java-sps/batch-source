// console.log("hello world");

//// truthy/falsy values

/*
console.log(Boolean(0));
console.log(Boolean(null));
let x;
console.log(Boolean(x));
console.log(Boolean("7"*7));
console.log(Boolean(""));
console.log(Boolean("seven"*7));
console.log(Boolean(false));
console.log(Boolean(" "));
console.log(Boolean([]));
console.log(Boolean({}));
console.log(Boolean());
*/

/// working with objects and variables

let dog = {
    breed: "German Shepard",
    name: "Rover",
    age: 4,
    bark: function(){
        console.log("woof");
    }
}
//dog.name or dog["name"] references a value of dog
//dog.bark() is a method because it is a function which belongs to an object 

function myFunc(){
    console.log("Hello World");
}

/*
    var
        - gets hoisted
        - can be reassigned or redeclared
        - global scope or function scope
*/
// var x = 10;
// var x = 12;

/*
    let 
        - can be reassigned, cannot be redeclared
        - doesn't get hoisted
        - allows for block scope
*/
let x = 10;
// let x = 12;
x = 13;


/* // using var does not allow for block scope
var pass = false;
var score = 80;
if(score>75){
    var pass = true;
}
console.log(pass);
*/


/* // using let introduces variables scoped just to the block
let pass = false;
let score = 80;
if(score>75){
    let pass = true;
    console.log("inside the block: " + pass);
}
console.log("outside the block: " + pass);
*/


/*
    const 
        - cannot be reassigned, cannot be redeclared
        - doesn't get hoisted
        - allows for block scope
*/
// const z = 10;
// z = 12;
const dog2 = {
    breed: "Australian Shepard",
    name: "Fluffy",
    age: 1,
    bark: function(){
        console.log("woof");
    }
}
dog2.name = "Priscilla";


// hoisting - bringing the variable declaration to the top of the scope
/*
console.log(myVar);
var myVar = 15; // this hoists the declaration  
console.log(myVar2);
let myVar2 = 17; // this gives us a ReferenceError
*/


// template literals
    // these allow for multiline strings where we can inject 
    // variables right into our strings
/*
let myString = "heres my string
I want to put some of it down here tool";
let myString = "heres my string. I want to put "+x+" in it";
*/

let myString = `here is my string
I want to put some of it down here.
Also my value for ${x} is included`;
