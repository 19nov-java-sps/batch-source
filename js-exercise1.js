function maxLength(array){
    var i = 0;
    var max = 0;
    for (i; i < array.length+1; i++){
        if(array[max] < array[i]){
            max = i;
        }
    }
    return max;
}

function reverseArray(array){
    var reverse = [];
    for(var i = array.length; i > 0; i--){
        reverse.push(array[i-1]);
    }
    return reverse;
}

function countVowel(stringInput){
    var countV = 0;
    for (var i = 0; i< stringInput.length-1;i++){
        if(stringInput.charAt(i) === "a" | "A" | "e" | "E" | "i" | "I" | "o" | "O" | "u" | "U"){
            countV++;
        } 
    }
    return countV;
}

function emailValid(stringInput){
    var firstCheck = 0;
    var firstPosition = 0;
    var secondCheck = 0;
    var secondPosition = 0;
    var badEmail = "Bad Format";
    for (var i = 0; i< stringInput.length;i++){
        if(stringInput.charAt(i) === "@"){
            firstCheck = 1;
            firstPosition = i;
        }
        if(stringInput.charAt(i) === "."){
            secondCheck = 1;
            secondPosition = i;
        }
    }
    if (firstPosition < secondPosition & firstCheck === 1 & secondCheck === 1){
        return stringInput;
    }
    return badEmail;

}

function removeAtChar(stringInput,x){
    if (stringInput.length < x){
        return "Can't reach x";
    }
    var input = "";
for (var i = 0; i< stringInput.length;i++){
    if (i === x){
        i ++;
    }
    input += stringInput.charAt(i);
}
return input;
}

function bubbleSort(numArray){
    for(var i = 0; i < numArray.length-1; i++){
        for(var e = 0; e < numArray.length-i-1; e++){
            if(numArray[e] > numArray[e+1]){
                [numArray[e], numArray[e+1]] = [numArray[e+1], numArray[e]];
            }
        }
    }
    return numArray;
}

function isEven(someNum){
    var even = "true";
    var odd = "false";
    var half = someNum/2;
    var roundedhalf = Math.round(half);
    if (roundedhalf*2 != someNum){
        return odd;
    }
    return even;
}

function isPalindrome(someStr){
    var reverse = "";
    var holder = "";
    for (var i = someStr.length-1; i > -1;i--){
        holder = someStr.charAt(i);
        reverse += holder.toLowerCase();
    }
    if (reverse == someStr.toLowerCase()){
        return "true";
    }
    return "false";
}

function isLeapYear(x){
    var leap = "true";
    var notLeap = "false";
    var quarter = x/4;
    var roundedquarter = Math.round(quarter);
    var century = x/100;
    var roundedcentury = Math.round(century);
    var quadCent = x/400;
    var roundedquadCent = Math.round(quadCent);
    if(roundedquarter*4 == x){
              if(roundedcentury*100 == x){
                    if(roundedquadCent*400 == x){
                        return leap;
                    }
                return notLeap;
              }
        return leap;
    }
    return notLeap;
}

function printShape(shape, height, input){
    var string = "";
    if (shape === "Square"){
        for(var i = 0; i< height; i++){
            for(var j = 0; j< height; j++){
                string += input;
                if (j == height-1){
                    string+= '\n';
                }
            }
        }
    }
    if (shape === "Triangle"){
        for(var i = 0; i< height+1; i++){
            for(var j = 0; j< i; j++){
                string += input;
                if (j == i-1){
                    string+= '\n';
                }
            }
        }
    }
    if (shape === "Diamond"){
        var halfheight = height/2;
        var roundedhalf = Math.round(halfheight);
        var rest = height - roundedhalf;
        for(var i = 0; i< roundedhalf+1; i++){
            for(var j = 0; j< i; j++){
                string += input;
                if (j == i-1){
                    string+= '\n';
                }
            }
        }
        for(var i = 0; i< rest+1; i++){
            for(var j = rest - i; j > 0; j--){
                string += input;
                if (j == 1){
                    string+= '\n';
                }
            }
        }  
           
    }
    return string;
}

function rotateLeft(array, n){
    var holder = [1];
    var length = array.length-1;
    for (var j = 0; j < n; j++){
        holder[0] = array[0];
        for (var i = 0; i < length; i++){
            array[i] = array[i+1];
        }
        array[length] = holder[0];

    }
    return array;
}

