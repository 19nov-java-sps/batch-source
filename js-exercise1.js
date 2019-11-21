// 1. Longest String
function maxLength(arr) {
  let longest = '';
  arr.forEach(str => {
    if (str.length > longest.length) {
      longest = str;
    }
  })
  return arr.indexOf(longest);
}

// 2. Reverse Array
function reverseArray(arr) {
  let result = [];
  while(arr.length) {
    result.push(arr.pop());
  }
  return result;
}

// 3. Count Vowels 
function vowelCount(str) {
  const vowels = 'aeiouAEIOU';
  let count = 0;
  for (let i = 0; i < str.length; i++) {
    if (vowels.includes(str[i])) count++
  }
  return count;
}

// 4. Email Validation     
isValidEmail = str => /.+@.+\..+/.test(str);

// 5. Remove Character
removeChar = (str, idx) => str.slice(0, idx).concat(str.slice(idx+1));

// 6. Bubble Sort
function bubbleSort(numArr) {
  while (true) {
    let count = 0;
    for (let i = 0; i < numArr.length; i++) {
      if (numArr[i] > numArr[i+1]) {
        let temp = numArr[i];
        numArr[i] = numArr[i+1];
        numArr[i+1] = temp;
        count++;
      }
    }
    if (count === 0) return numArr;
  }
}

// 7. Even Number
isEven = num => num.toString(2).slice(-1) == 0 ? true : false;

// 8. Palindrome
function isPalindrome(str) {
  while (str.length > 1) {
    if (str[0] !== str[str.length - 1]) {
      return false;
    }
    str = str.slice(1, -1);
  }
  return true;
}

// 9. Find Leap Year
function isLeapYear(date) {
  if (date % 100 === 0) {
    if (date % 400 === 0) {
      return true;
    }
  } else {
    if (date % 4 === 0) {
      return true;
    }
  }
  return false;
}

// 10. Shapes
function printShape(shape, height, character) {
  let string ='';

  if (shape === 'Square') {
    for (let i = 0; i < height; i++) {
      for (let j = 0; j < height; j++) {
        string += character;
      }
      string += '\n';
    }
  } else if (shape === 'Triangle') {
    for (let i = 1; i <= height; i++) {
      
    }
  } else if (shape === 'Diamond') {

  }

  return string;
}
console.log(printShape("Square", 3, "%"));

// 11. Rotate Left
function rotate(arr, n) {
  let t = n % arr.length;
  return arr.slice(t).concat(arr.slice(0, t));
}

// 12. Balanced Brackets
function balanced(str) {

}