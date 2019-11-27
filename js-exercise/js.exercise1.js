// 1. Longest String

let maxLength = function(arr) {
    let longestString = "";

    for (let string of arr) {
        if (string.length > longestString.length) {
            longestString = string;
        } else {
            continue;
        }
    }

    console.log(`1). the longest string is ${longestString}`);
}

maxLength(["string", "areallyreallylongstring", "adonis", "anotherstring"]);

// 2. Reverse Array

let reverseArray = function(arr) {
    let arrReversed = [];

    for (let i = arr.length - 1; i >= 0; i--) {
        arrReversed.push(arr[i]);
    }
    console.log(`2). ${arr} reversed is ${arrReversed}`);
}

reverseArray([1,2,3,4,5]);

// 3. Count Vowels

let vowelCount = function(str) {
    // lowercases the string for the switch cases and splits it into an array
    let strSplit = str.toLowerCase().split("");
    let count = 0;  // used for the vowel count.
    // iterates through the array
    for (let letter of strSplit) {
        // uses a switch to check all the possible vowels and increments count if it finds one.
        switch (letter) {
            case "a":
                count++;
                break;
            case "e":
                count++;
                break;
            case "i":
                count++;
                break;
            case "o":
                count++;
                break;
            case "u":
                count++;
                break;
        }
    }
    console.log(`3). ${str} has ${count} vowels`);
}

vowelCount("Adonis");

// 4. Email Validation

let isValidEmail = function(email) { // "\w" looks for a word character.
    let regex = /\w+@\w+.com/i;     // "i" looks for characters no matter the case (capital or lowercase).
    let emailValid = regex.test(email); // uses the RegExp test method and returns a boolean.

    if (emailValid) {
        console.log(`4). ${email} is a valid email`);
    } else {
        console.log(`4). ${email} is not a valid email`);
    }
   
}

isValidEmail("adonis@gmail.com");
isValidEmail("@gmail.com");
isValidEmail("com.gmail@adonis");

// 5. Remove Character

let removeChar = function(str, index) {
    let strSplit = str.split("");
    let newString = "";

    for (letter of strSplit) {
        if (letter !== strSplit[index]) {
            newString += letter;
        } else {
            continue;
        }
    }
    console.log(`5). index is ${index} so ${str} is now ${newString}`);
}

removeChar("Adonis", 3);

// 6. Bubble Sort

let bubbleSort = function(arr) {

    let arrSorted = [...arr];   // Using the spread operator in order to not alter the original array.

    for (let i = 0; i < arrSorted.length; i++) {
        // j starts at 1 since i want to check arr[0] against arr[1]
        for (let j = 1 + i; j < arrSorted.length; j++) {
            if (arrSorted[i] < arrSorted[j]) {
                continue;   // if the left is not greater than the right then continue.
            } else {
                let temp = arrSorted[i];  // assigns this to temp since it will be lost if i dont.
                arrSorted[i] = arrSorted[j];    // assign the lower number to the left.
                arrSorted[j] = temp;      // assign the higher number to the right.
            }
        }
    }
    console.log(`6). ${arr} sorted is: ${arrSorted}`);  // Outputting the original array and the sorted array.
}

bubbleSort([2,1,3,9,10,4,8,-2]);

// 7. Even Number

let isEven = function(num) {
    let numDivBy2 = Math.floor(num / 2);    // It uses the floor function which will make any odd division by 2
    if (numDivBy2 * 2 === num) {            // into an integer which will then fail this if statement.
        return `7). ${num} is an even number`;  // ex: 5 / 2 = 2.5 but with floor its 2, 2 * 2 != 5 so its an odd number.
    } else {
        return `7). ${num} is an odd number`;
    }
}

console.log(isEven(5));
console.log(isEven(6));

// 8. Palindrome

let palindrome = function(str) {
    let splitStr = str.toLowerCase().split("");
    let index = splitStr.length - 1;    // index that starts at the end of the string.

    // I divide by 2 here since we only need half of it to check if its a palindrome.
    for (let i = 0; i < splitStr.length / 2; i++) {

        if (splitStr[i] === splitStr[index - i] || splitStr[i] === " " || splitStr[index] === " ") {
            continue;   // if it is equal then continue the loop.
        } else {
            return `${str} is not a palindrome`;  // if not then return this.
        }
    }
    return `${str} is a palindrome`;  // if the loop is successful that means it is a palindrome.
}

console.log("8).",palindrome("my gym"));
console.log("8).",palindrome("racecar"));
console.log("8).",palindrome("adonis"));
