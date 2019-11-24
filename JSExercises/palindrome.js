//--------------------------------------------------------------
// Check if a string is a palindrome
//--------------------------------------------------------------

//I'm going to assume that the string has only letters
//I'll allow for spaces
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

let str = "civic civic";
console.log(isPalindrome(str));
