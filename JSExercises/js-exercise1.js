
// Find longest string from given array of strings and return its index
function getMaxString(inputArr) {
  let position_longest = 0;
  for (let i = 1; i < inputArr.length; ++i) {
    if (inputArr[i].length > inputArr[position_longest].length) {
      position_longest = i;
    }
  }

  return position_longest;
}

let inputArr = ["one", "two", "three", "b", "cd"];
console.log(getMaxString(inputArr));

// Reverse the elements of a given array
function reverseElementPositions(inputArr) {
  let counter = 0;
  let temp;
  while (counter < inputArr.length-1) {
    temp = inputArr[0];
    inputArr.push(temp);
    inputArr.shift();
    ++counter;
  }

  return inputArr;
}
console.log(reverseElementPositions(inputArr));

//
