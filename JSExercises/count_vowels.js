//--------------------------------------------------------------
//Write a JavaScript function to count the number of vowels in a given string
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

let inputStr = "fee fie fo fum";
console.log(vowelCount(inputStr));
