//--------------------------------------------------------------
//Write a JavaScript function to reverse the elements of a given array
//--------------------------------------------------------------

function reverseArray(arr) {
  let start = 0;
  let end = arr.length-1;

  while (start < end) {
    //swap inputArr[start], inputArr[end]
    let temp = arr[start];
    arr[start] = arr[end];
    arr[end] = temp;

    ++start;
    --end;
  }

  return arr;
}

arr = [1, 2, 3, 4];
console.log(reverseArray(arr));
