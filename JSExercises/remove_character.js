//--------------------------------------------------------------
// Write a function to remove a character at the specified position of a given
// string and return the new string
//--------------------------------------------------------------

function removeChar(str, index) {
  return str.substring(0, index) + str.substring(index+1);

}

let str = "civitas";
console.log(removeChar(str, 2));
