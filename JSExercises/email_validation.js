//Create a function that checks for a valid email format

function isValidEmail(email) {
  if !(email.includes('@')) {
    return false;
  } else {
    let formatted = email.split('@');
    if (formatted.length > 2) {
      return false;
    } else {
      
    }
  }
}
