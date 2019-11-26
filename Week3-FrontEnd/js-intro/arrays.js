// Objects, Arrays, Functions, and Parameters

let myObject = {
    0: null,
    1: "hello",
    2: true,
    3: 5
}

let myArray = [null, "hello", true, 5];
/*
for(let i=0; i<myArray.length; i++){
    console.log(i+" : "+myArray[i]);
}
*/

// for/in loops
    // iterates over the index of an array or keys of an object
/*
for(let index in myArray){
    console.log(index + " : "+ myArray[index]);
}

for(let key in myObject){
    console.log(key +" : "+ myObject[key]);
}
*/

// for/of loops
    // introduced in ES6, allows us to iterate over an arrays values 
    // without needing to work with the index

/*
for(let value of myArray){
    console.log(value);
}

// we cannot us for/of with an object
for(let value of myObject){
    console.log(value);
}
*/

/*
// we can put objects in arrays
let dog1 = {
    name: "fluffy"
}

let dog2 = {
    name: "priscilla"
}

let dog3 = {
    name: "emma"
}

let dogArray = [dog1, dog2, dog3];

for(let dog of dogArray){
    console.log(dog.name);
}
*/

function myFunc1(){
    console.log("in my func1");
}

let myFunc2 = function(){
    console.log("in my func2");
}

// arrow notation - another ES6 addition
let findSum = (num1, num2) => {return num1+num2};
// findSum(10,12);
// findSum(4,6);

// without the curly brackets, the implementation following the arrow is returned
let findSum2 = (num1, num2) => num1+num2;

let addTwo = x => x+2;

let printSum = (num1, num2) => {console.log(num1+num2)}


// function arguments
/*
let printAll = function(a, b, c){
    console.log(a);
    console.log(b);
    console.log(c);
}
*/

let printAll = function(){
    for(let argument of arguments){
        console.log(argument)
    }
    return "this function is now done";
}

printAll(5,2,3,5,4);