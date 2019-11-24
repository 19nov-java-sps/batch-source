//--------------------------------------------------------------
// Check if a number is even
//--------------------------------------------------------------
/*
function isEven(someNumber) {
  return (someNumber%2 == 0);
}
*/

function isEven(someNumber) {
  //convert to string, get last character
  let evenNumbers = new Set([0, 2, 4, 6, 8]);
  let lastDigit_char = someNumber.toString().slice(-1);

  return evenNumbers.has(parseInt(lastDigit_char));
}



let num = 4473 ;
console.log(isEven(num));
