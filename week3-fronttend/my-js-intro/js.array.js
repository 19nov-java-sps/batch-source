// Object , arrays, functions, and parameters

let myObject = {
    0: null,
    1: "hello",
    2: true,
    3: 5
}

let myArray = [ null, "hello", true, 5];

for (let i = 0; i < myArray.length; i++)
 {
    console.log (i + " : " +myArray[i]); 
}

// for/ forin loops
// for let press for 
for (let index in myArray) {
    console.log (i + " : " +myArray[i]);     
}

// for let
for (let key in myObject) {
    console.log (key + " : " +myObject[key]);     
}

for (let index = 0; index < array.length; index++) {
    const element = array[index];
    
}

// for/ forof loops

        // introduce in ES6, allows us to iterate over 
        // without needing to work with the index

        for (let value in myArray) {
            console.log (value);     
        } 
        
/* 
for (let value in myArray) {
            console.log (value);     
        } 
*/

let dog4 = {
    name: "fulffy"
}

let dog5 = {
    name: "priscilla"
}

let dog6 = {
    name: "emma"
}

let dogArray = [ dog4, dog5, dog6];

for(let dog of dogArray){
    console.log(dog.name);
}

function myFunc1(){
    console.log("it's my func1");
}

let myFunc2 = function(){
    console.log(" it's my func2");
}

// arrow notation - another ES6 addition

let findSum = (num1, num2) => { return num1+num2};
findSum(4,5);
findSum(3,4);
// without the curly bracket
let findSum2 = (num1, num2) =>  num1+num2;

let addTwo = x => x+2

let printSum = (num1, num2) => {console.log(num1+num2)}

// function arguments 

let printAll = function(a,b,c){
    console.log(a);
    console.log(b);
    console.log(c);
}

// printAll(5,2);
// printAll(2,3,4,5,6);

let printAll = function(){
    for(let arguments of arguments){
        console.log(argument)
    }
}
printAll(2,3,4,5,6);





