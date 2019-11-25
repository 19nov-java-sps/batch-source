//let arrayString = ["cat", "dog", "abstruction", "code like a boss", "5"];
let numberArray=[12,2,334,4,5]

//FUNCTION-1 LongestString

//Implementation with "index IN array"
function maxLength (array){
    let pointer=0;
    for(let index in array){
        if (array[index].length > array[pointer].length){
            pointer = index
        }
    }
    return pointer;
}

//Implementation with "index OF array"
function maxLength2 (array){
    let pointer=0;
    for(let index of array){
        if (index.length > array[pointer].length){
            pointer = array.indexOf(index)
        }
    }
    return pointer;
}

//FUNCTION-2 Reverse Array

let reverseArray = function (array){
    let newArray = new Array();
    for (let index = array.length-1; index >= 0; index--){
        newArray.push(array[index]);
       }
    return newArray;
}

//FUNCTION-3 Count Vowels 
//	Define function: vowelCount(string)
//   Write a JavaScript function to count the number of vowels in a given string.

let stringExamle = "Code like a boss";
let stringExamle2 = "fghRTLL;";
let stringExamle3 = "A0OjeEkuu5"


function CountVowels (string){
    let vowelsArray = ['a','A','e','E','i','I','o','O','u','U'];
    let counter = 0;
    for (let i=0; i<=string.length; i++){
        for (let index of vowelsArray){
            if (string.charAt(i)==index){
                counter = counter+1;
            }
        }
    }
    return counter;
}

//FUNCTION-4 Email Validation 	
//Define function: isValidEmail(string)
//Create a function that checks for a valid email format.

let email = "someone@somewhere.com" //valid
let email2 = "sdfsdf@srgs.t"
let email3 = "sdfsdf@srgs.taef"
let email4 = "sdfsdfsrgs.fg"
let email5 = "sdfsdf@srgs.tm" //valid

function validateEmail(email){
    let mailFormat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if (email.match(mailFormat)){
        console.log("Email is valid");
    }else{
        console.log("Email is not valid");
    }
}

//FUNCTION-5 Remove Character
//	Define function: removeChar(string, index)
// Write a JavaScript function to remove a character at the specified position of a given string and return the new string.

function removeChar (string, position){
    return string.replace (string.charAt(position),"");
  }

removeChar(stringExamle,2);

//FUNCTION-6   Bubble Sort
//Define function: bubbleSort(numArray)
//Use the bubble sort algorithm to sort an array of numbers. You may need to look up the algorithm if you’re not familiar with it
//Return the sorted array. let numberArray=[12,2,334,4,5]


let numberArray2=[112,562,334,6544,588]

function printArray(arr){
    console.log(arr);
}

function bubbleSort(numArray){
    for(let index in numArray){
        for (let i=0; i<numArray.length-1; i++){
            if (numArray[i] > numArray[i+1]){                   //12>2
                    numArray.splice((i+1)+1,0,numArray[i])
                    numArray.splice(i,1,)
                }
            }
        }
     return numArray;
}

//FUNCTION-7   Even Number
//Define function: isEven(someNum)
//Return true if even, false if odd.
//Challenge: Do not use % operator.

function isEven(num){
    if (num/2-Math.floor(num/2)==0){
        return true;
    }else{
        return false;
    }
}

//FUNCTION-8  Palindrome
//Define function: isPalindrome(someStr)
//Return true if someStr is a palindrome, otherwise return false.

let stringPolindrome = "Too hot to hoot";

function isPalinfrome(someStr){

    let newString =  someStr.replace(/\s/g,'').toLowerCase();

    let reverseString = '';

         for (let i = newString.length; i>=0; i--){
            reverseString = reverseString.concat(newString.charAt(i));
        }
        
    if(reverseString==newString){
        console.log("The string \"" + someStr + "\" is a Palindrome!!  ");
    }else{
        console.log("The string \"" + someStr + "\" is NOT a Palindrome!");
    }
    return reverseString
}

//FUNCTION-9 Find Leap Year
//Define function: isLeapYear(date)
//Create a JavaScript function that takes a date parameter and returns true if the year is a leap year in the Gregorian calendar.

let leapYearDate = new Date ('December 17, 2004 03:24:00');
let notLeapYearDate = new Date ('January 17, 1803 03:24:00');
console.log(leapYearDate);


function isLeapYear (date){

    let year = date.getFullYear();
    console.log(year%4);
    console.log(year%100);
    console.log(year%400);

    if (year%4 != 0){
        console.log("The year " + year + " is a regular year!");
        }else{
                if(year%100 !=0){
                    console.log("The year " + year + " is a leap year!");
                    }else{
                        if(year%400 != 0){
                            console.log("The year " + year + " is a regular year!");
                        }else{
                            console.log("The year " + year + " is a leap year!");
            }
        }
    }
}


function printShape (shape, hight, char){
    if (shape == "Square"){
        let sqareSting = "";
        let spaceString=" "
        let space = " "; // to be visible
        for (let i=0; i<=hight-1; i++){
            sqareSting = sqareSting.concat(char+"  "); //"  " - to take a shape of a square
           
          
        }
        for (let i=0; i<=hight-1; i++){
            spaceString = spaceString.concat(space)
            console.log(sqareSting+spaceString)
        }
    }
    if (shape == "Triangle"){
        let trieSting = "";
        for (let i=0; i<=hight-1; i++){
            trieSting = trieSting.concat(char);
            console.log(trieSting)
        }
    }
    if (shape == "Diamond"){
        let space = " ";
        let concatSpace="";
        let concatChar = "";
        let j=Math.floor(hight/2)
        let x = 1;

            //Printing the top part
        for (let i=1; i<=hight; i=i+2){
            concatChar=char.repeat(i);
            concatSpace=space.repeat(j);
            console.log(concatSpace + concatChar)
            j--;
            }

            //Printing the bottom part
        for (let l=Math.floor(hight-2); l>=1; l=l-2){
            concatChar=char.repeat(l);
            concatSpace=space.repeat(x);
            console.log(concatSpace + concatChar)
            x++;
            }
        }
    }
 


