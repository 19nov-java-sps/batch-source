//--------------------------------------------------------------
// Use bubble sort algorithm to sort an array of numbers.
// Return the sorted array
//--------------------------------------------------------------

function bubbleSort(inputArr) {
  for (let i = 0; i < inputArr.length-1; ++i) {
    for (let j = 0; j < inputArr.length-1-i; ++j) {
      if (inputArr[j] > inputArr[j+1]) {
        let temp = inputArr[j];
        inputArr[j] = inputArr[j+1];
        inputArr[j+1] = temp;
      }
    }
  }

  return inputArr;
}

let inputArr = [5, 1, 3, 2, 8];
console.log(bubbleSort(inputArr));
