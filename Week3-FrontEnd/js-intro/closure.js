/* 
    Closures take advantage of JavaScript's lexical scoping 
    to make variables accessible/inaccessible to other 
    segments of code

    functions have access to global scope
    functions have access to the scope in which they've been defined

    *how we can accomplish encapsulation in JavaScript
 */


/*
    We want a counter which we can increment but which we 
    cannot access directly.
*/

/*
let counter = 0;
function add(){
    counter += 1;
}
*/

/*
function add(){
    let counter = 0;
    counter += 1;
    return counter;
}
*/


function add(){
    let counter = 0;
    return function(){ counter+=1; return counter};
}
// let myCounter = add();
// now "myCounter" has access to the lexical scope within add
// invoking myCounter will return "counter + 1" each time

let addAgain = (function(){
    let counter = 0;
    return function(){ counter+=1; return counter}; 
})();
// because we pre-invoke our function (self invoking function)
// the lexical scope is immediately available
// and invoking "addAgain" will return "counter +1"