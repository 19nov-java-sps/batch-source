/*
    closures take advantage of javaScript's lexical scoping to make variable accessible/inaccessible to 
    other segments of code 

    function have access to global scope
    function have access to the scope in which they've been 
    
    * how can we accomplish encapsulation in JavaScript

*/

/*
    we want a counter which we can increment but which we 
    cannot access directly
*/

//let counter = 0 ;
/*
function add(){
    let counter = 0;
    counter += 1;
    return counter;
}
*/

function add(){
    let counter = 0;
    return function(){counter += 1; return counter};
}

let addAgain = (function(){
    let counter = 0;
    return function(){counter += 1; return counter}
})();

// because we pre-invoke our function 
// the lexical scope is immediately available 
// and invoking "addAgain" will return "counter +1"



