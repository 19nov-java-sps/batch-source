/*Longest String
Define function: maxLength(array)
Write a JavaScript to find the longest string from a given array of strings and returns the string’s array index.
*/




   

function maxLength(array){
let initialLength=array[0].length;
let longestWord=array[0];
 for(let x=0;x<array.length;x++){
if(array[x].length>initialLength){

longestWord=array[x];
initialLength=longestWord[x].length;

}



 }
return longestWord;


}

/*
Reverse Array
Define function: reverseArray(array)
Write a JavaScript function to reverse the elements of a given array.
 */

function reverseArray(array){
let arr =[array.length];
let count=0;
for(let i=array.length-1;i>-1;i--){

    arr[count]=array[i];
    count++;
}

return arr;

}


/*
3.     Count Vowels 
	Define function: vowelCount(string)
	 Write a JavaScript function to count the number of vowels in a given string.

*/




function vowelCount(string){
let count=0;
let string2= string.toLowerCase(string);

for(let i=0; i<string2.length;i++){
    if(string2.charAt(i)=='a' || string2.charAt(i)=='e' || string2.charAt(i)=='i' || string2.charAt(i)=='o' || string2.charAt(i)=='u'){
        count++;
    }

    return count;
}

}
/*
4.      Email Validation 	
Define function: isValidEmail(string)
Create a function that checks for a valid email format.
*/

function isValidEmail(string){
    let x= false;
    let mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if(string.match(mailformat)){
        x=true;
    }
    
    return x;
    
    }
/*
    5.     Remove Character
	Define function: removeChar(string, index)
Write a JavaScript function to remove a character at the specified position of a given string and return the new string.

*/
/*

6.       Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort an array of numbers. You may need to look up the algorithm if you’re not familiar with it
Return the sorted array.

*/

function bubbleSort(numArray){
    
    var trigger;
    
    
  

do{
  let x=0;
 trigger=false;
let maxRun=numArray.length-1;
  while(maxRun!=0){

if(numArray[x]>numArray[x+1]){
temp=numArray[x];
numArray[x]=numArray[x+1];
numArray[x+1]=temp;
trigger=true;


}
else{
    numArray[x]=numArray[x];
    numArray[x+1]=numArray[x+1];
}
maxRun--;
x++;

  }
  }while(trigger);


return numArray;
}






function removeChar(string,index){
let s;

for(let i=0;i<string.length;i++){
    if(i!=index){
    s+=string.charAt(i);
    }
    
}
return s;
}

/*
7.    Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Challenge: Do not use % operator.
*/


function isEven(someNum){
return someNum%2==0;


}









/*
8.   Palindrome
Define function: isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false.

*/

var x;
function isPalindrome(somestr){
    let x;
    let s=false;
    for(let i=somestr.length-1;i>-1;i--){
        x+=somestr.charAt(i);
    }
    if(somestr.toLowerCase=x.toLowerCase){
        s=true;
    }
    return s;
}
