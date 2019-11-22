/*
[Longest String]
Define function: maxLength(array) Write a JavaScript to find the longest string 
from a given array of strings and returns the string’s array index.
*/

function maxLength(str) {

    var longestString = " "; // declares empty string to hold longest string
    var longestStringIndex = 0; // declares a variable to hold the index of the longest string
    var longestStringLength = 0; // declares a variable to hold the length of the longest string

    for(var i = 0; i < str.length; i++){ // loops thru the array 
      if(str[i].length > longestStringLength){ // if the length of the string current string is greater than
      longestStringLength = str[i].length; // longestStringLength set longestStringLength to that length
      longestStringIndex = i; // set longestStringIndex to that index
      longestString = str[i]; // set longestString to the string at that array index
       }
    
    }
    return `The longest string in this array of strings \n is "${longestString}" and its array index is ${longestStringIndex}.`;

  }

// TEST DATA

// str = ["The","quick","brown", "fox", "jumped", "over", "the", "lazy", "dog"];

// "jumped" is the longest string and it is located 
// at the 4th index of the array
// so the function should return 4




/*
[Reverse Array]
Define function: reverseArray(array). Write a JavaScript function to reverse the elements of a given array.
*/

function reverseArray(array){

   var reversedArray = array.reverse(); // reverses the array using built in array method reverse()

   return reversedArray; // returns reversed array
}

function reverseArray2(array){

    var reversedArray = []; // declares an empty array to hold the reversed array

    for(var i=array.length - 1; i>=0; i--){ // a for loop to iterates thru the array in reverse 
    
        reversedArray.push(array[i]); // the push() method adds new items to the end of an array, and returns the new length.
        
    }
    return reversedArray; // returns the reversed array
}


/*
[Count Vowels]
Define function: vowelCount(string)
Write a JavaScript function to count the number 
of vowels in a given string.
*/

function vowelCount(str){
    
    var counter = 0; // declare a counter to count the number of vowels

    for(var i=0; i<str.length; i++){ // a for loop to iterate thru the arrap

         switch(str[i]) { // a switch statement to check each character in the string
                          // if the character is a vowel counter is incremented by 1
            case 'a': 
                counter += 1; 
                break;
            case 'i':
                counter += 1;
                break;
            case 'e':
                counter += 1;
                break;
            case 'o':
                counter += 1;
                break;
            case 'u':
                counter += 1;
                break;
            default:
                break;
         }
    }

    return `This string contains ${counter} vowels.`; // returns counter which is the number of vowels found in the string

}



/*
[Email Validation]
Define function: isValidEmail(string)
Create a function that checks for a valid email format.
*/


function isValidEmail(email){
    
        // Returns a Boolean value that indicates whether or not a pattern exists in a searched string.
         var answer = /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email); 

        if (answer == false){
            return `This email address is invalid.`;
        } else{
            return `This email address is valid.`;
        }
}

/*
[Remove Character]
Define function: removeChar(string, index)
Write a JavaScript function to remove a character at the specified position of a given
string and return the new string.
*/

function removeChar(str, index){

    console.log(`This is your original string '${str}'. \n`);

    // The substring() method extracts the characters from a string, 
    // between two specified indices, and returns the new sub string.
    part1 = str.substring(0, index);
    part2 = str.substring(index + 1, str.length);
    return `This is your string with the character \nremoved from the position you specified: '${(part1 + part2)}'`;
   }


/*
[Bubble Sort]
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort an array of numbers. 
You may need to look up the
algorithm if you’re not familiar with it
Return the sorted array.
*/

function bubbleSort(numArray){

    for(var i=0; i<numArray.length; i++){ // for loop to iterate thru the array
        for(var j=0; j<numArray.length; j++){ // for loop to iterate thru the array & make comparison & swap
            if(numArray[j] > numArray[j+1]){ // if the number at the current position is greater than the next number in the array
                let temp = numArray[j]; // store the greater number in temp
                numArray[j] = numArray[j+1]; // store the smaller number in the array position of the current number
                numArray[j+1] = temp; // store the greater number we saved in temp in the position after the smaller number (SWAP)
            }
        }

    }

    return numArray; // returns the array in the new order with the numbers swapped/sorted into ascending order

}




/*
[Even Number]
Define function: isEven(someNum)
Return true if even, false if odd.
Challenge: Do not use % operator.
*/

function isEven(someNum){

    // the Math.floor() function rounds the result of dividing 
    // the number by 2 to an integer. An even number divided by 2 
    // and then multiplied by 2 will always give the same number.
    // if it does not then the number is odd.
     result = (Math.floor(someNum/2) * 2 == someNum); //stores the result of the equality boolean in result

     if (result == true){
        return `The number ${someNum} is even.`;
    }
    else{
        return `The number ${someNum} is odd.`;
    }

}


/*
Palindrome
Define function: isPalindrome(someStr)
Return true if someStr is a palindrome, 
otherwise return false.
*/

function isPalindrome (str) {

    // if statement splits up string by spaces, reverses the string and 
    // joins it back by spaces (if any), then compares this reversed string to the original string. 
    // if they are equal then the string input by the user is a Palindrome.
    if (str == str.split('').reverse().join('')){ 
        return `This string is a palindrome.`;
    }else{
        return `This string is not a palindrome.`;
    }
  }