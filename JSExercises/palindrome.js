//--------------------------------------------------------------
// Check if a string is a palindrome
//--------------------------------------------------------------

function isPalindrome(someStr) {
  let start = 0;
  let end = someStr.length-1;

  while (start <= end) {
    if (someStr.charAt(start) != someStr.charAt(end)) {
      return false;
    }
    else {
      ++start;
      --end;
    }
  }
  return true;
}

let str = "civic civic";
console.log(isPalindrome(str));
