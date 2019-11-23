// 1.      Longest String
// Define function: maxLength(array)
// Write a JavaScript to find the longest string from a given array of strings and returns the string’s array index.

let maxLength = function(arr){
  let longlength = 0;
  let index = 0;
  for(let i = 0; i<arr.length; i++){
    if (arr[i].length > longlength);
      longlength = arr[i].length;
      index = i;
    }
    return "The longest word is in the array of " + index;
  }

// Test
myArray = ["Mark","Jungle","hello","Top","Zhonyas"];
maxLength(myArray);

// 2.      Reverse Array
// Define function: reverseArray(array)
// Write a JavaScript function to reverse the elements of a given array.

let reverseArray = function(arr){
  return arr.reverse();
}

// 3.     Count Vowels
// 	Define function: vowelCount(string)
// 	 Write a JavaScript function to count the number of vowels in a given string.

let countVowels = function(string){
  let counter = 0;

  for(let i = 0; i < string.length; i++){
    if(string.toLowerCase().charAt(i) == 'a' || string.toLowerCase().charAt(i) == 'e' || string.toLowerCase().charAt(i) == 'i' || string.toLowerCase().charAt(i) == 'o' || string.toLowerCase().charAt(i) == 'u'){
      counter++;
    }
  }
  return counter;
}

// 4.      Email Validation
// Define function: isValidEmail(string)
// Create a function that checks for a valid email format.

let isValidEmail = function(string){
  let email = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
      if(string.match(email)){
        return true;
      }
    return false;
}

// 5.     Remove Character
// 	Define function: removeChar(string, index)
// Write a JavaScript function to remove a character at the specified position of a given string and return the new string.

let removeChar = function(string, index){
  newString = string.replace(string.charAt(index), "");
  return newString;
}

// 6.       Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort an array of numbers. You may need to look up the algorithm if you’re not familiar with it
// Return the sorted array.

let bubbleSort = function(numArray){
  let n = numArray.length;
        for (let i = 0; i < n-1; i++)
            for (let j = 0; j < n-i-1; j++)
                if (numArray[j] > numArray[j+1])
                {
                    // swap arr[j+1] and arr[i]
                    let temp = numArray[j];
                    numArray[j] = numArray[j+1];
                    numArray[j+1] = temp;
                }
                return numArray;
}

// 7.    Even Number
// Define function: isEven(someNum)
// Return true if even, false if odd.
// Challenge: Do not use % operator.

let isEven = function(someNum){
  if(someNum%2 == 0){
    return true;
  }
  else{
    return false;
  }
}

// 8.   Palindrome
// Define function: isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false.

let isPalindrome = function(someStr){
  let reverseStr = "";
  for(let i = someStr.length-1 ; i>-1; i--){
    reverseStr += someStr.charAt(i);
  }
  if(someStr == reverseStr){
    return true;
  }
  return false;
}

// 9. Find Leap Year
// Define function: isLeapYear(date)
// Create a JavaScript function that takes a date parameter and returns true if the year is a leap year in the Gregorian calendar.

let isLeapYear = function(date){
  if (date%4 == 0){
    return true;
  }
  return false;
}
