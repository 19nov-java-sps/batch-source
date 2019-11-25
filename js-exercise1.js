console.log("Hello World!");

// 1.      Longest String
// Define function: maxLength(array)
// Write a JavaScript to find the longest string from a given array of strings and returns the string’s array index.

let array = ["hi","hello","salutations","this is defintely the longest string"];
function maxLength(array){
    let longest = "";
    for (let index = 0; index < array.length; index++) {
        if(array[index].length> longest.length){
            longest = array[index];
        }
        
    }
    return longest;
}

// 2.      Reverse Array
// Define function: reverseArray(array)
// Write a JavaScript function to reverse the elements of a given array.

let array2 = [5,10,15,20,25];
function reverseArray(array2){
    let newArr = array2.reverse();
    return newArr;
}

// 3.     Count Vowels 
// 	Define function: vowelCount(string)
// 	 Write a JavaScript function to count the number of vowels in a given string.

function vowelCount(string) {
    return string.match(/[aeiou]/gi).length;
}


// 4.      Email Validation 	
// Define function: isValidEmail(string)
// Create a function that checks for a valid email format.

function isValidEmail(string){
    let result= false;
    let validEmail = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if(string.match(vaildEmail)){
        result= true;
    }
    
    return result;
    
    }

// 5.     Remove Character
// 	Define function: removeChar(string, index)
// Write a JavaScript function to remove a character at the specified position of a given string and return the new string.

function removeChar(string, index) {
    let replace = new RegExp(string)
    return index.replace(replace, '')
  }
  

// 6.       Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort an array of numbers. You may need to look up the algorithm if you’re not familiar with it
// Return the sorted array.



// 7.    Even Number
// Define function: isEven(someNum)
// Return true if even, false if odd.
// Challenge: Do not use % operator.

function isEven(someNum){
    return someNum % 2 == 0;
} 

// 8.   Palindrome
// Define function: isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false.

    let number = 323;
    function isPalindrome(number) {
           let originalNumber = number;
           let reverse = 0;
   
           while (number != 0) {
              let lastDigit = number % 10;
               reverse = reverse * 10 + lastDigit;
               number = number / 10;
           }
           if (number == reverse) {
              
               return true;
           }
           
           return false;
       }
   

