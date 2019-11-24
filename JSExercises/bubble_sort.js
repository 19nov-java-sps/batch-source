//--------------------------------------------------------------
// Use bubble sort algorithm to sort an array of numbers.
// Return the sorted array
//--------------------------------------------------------------

function bubbleSort(arr) {
  for (let i = 0; i < arr.length-1; ++i) {
    for (let j = 0; j < arr.length-1-i; ++j) {
      if (arr[j] > arr[j+1]) {
        let temp = arr[j];
        arr[j] = arr[j+1];
        arr[j+1] = temp;
      }
    }
  }

  return arr;
}

let inputArr = [5, 1, 3, 2, 8];
console.log(bubbleSort(inputArr));
