//--------------------------------------------------------------
// JavaScript functions
//
// cwc 24Nov2019
//--------------------------------------------------------------

//--------------------------------------------------------------
// 1. Find longest string from given array of strings and return its index
//--------------------------------------------------------------
function getMaxString(inputArr) {
  let position_longest = 0;
  for (let i = 1; i < inputArr.length; ++i) {
    if (inputArr[i].length > inputArr[position_longest].length) {
      position_longest = i;
    }
  }

  return position_longest;
}

let inputOne = ["one", "two", "three", "b", "cd"];
console.log(getMaxString(inputOne));

//--------------------------------------------------------------
// 2. Write a JavaScript function to reverse the elements of a given array
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

let inputTwo = [1, 2, 3, 4, 5];
console.log(reverseArray(inputTwo));

//--------------------------------------------------------------
// 3. Write a JavaScript function to count the number of vowels in a given string
//--------------------------------------------------------------

function vowelCount(inputStr) {
  //define set of vowels
  const vowels = new Set(['a', 'e', 'i', 'o', 'u']);
  let lowered = inputStr.toLowerCase();

  let numberOfVowels = 0;
  for (let i = 0; i < lowered.length; ++i) {
    if (vowels.has(lowered.charAt(i))) {
      numberOfVowels += 1;
    }
  }

  return numberOfVowels;
}

//--
// 4. Create a function that checks for a valid email format
//--

//For simplicity I'll assume any character is valid for email username
/*
function isValidEmail(str) {
  let parsed = str.split('@');
  if (parsed.length !== 2) {
    return false;
  } else {

  }
}

function isValidDomain(str) {
  let parsed = str.split('.');
*/

let isValidEmail = function(str){
  let email = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if(str.match(email)){
      return true;
    }
  return false;
}

//--------------------------------------------------------------
// 5. Write a function to remove a character at the specified position of a given
// string and return the new string
//--------------------------------------------------------------

function removeChar(str, index) {
  return str.substring(0, index) + str.substring(index+1);
}

//--------------------------------------------------------------
// 6. Use bubble sort algorithm to sort an array of numbers.
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

//--------------------------------------------------------------
// 7. Check if a number is even
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

//--------------------------------------------------------------
// 8. Check if a string is a palindrome
//--------------------------------------------------------------

//I'm going to assume that the string has only letters
//I'll allow for spaces by removing them when processing string
function isPalindrome(someStr) {
  let formatted = formatString(someStr).toLowerCase();

  let start = 0;
  let end = formatted.length-1;

  while (start < end) {
    if (formatted.charAt(start) != formatted.charAt(end)) {
      return false;
    }
    else {
      ++start;
      --end;
    }
  }
  return true;
}

function formatString(str) {
  return str.replace(' ', '');
}
