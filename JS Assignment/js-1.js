function isValidEmail(string){
    let x= false;
    let mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if(string.match(mailformat)){
        x=true;
    }
    
    return x;
    
    }