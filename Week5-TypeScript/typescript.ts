function doSomething(){
    for(let i=0; i<5; i++){
        console.log(i);
    }
}

// doSomething();
let x = 10;
x = 5;
// x = true;

let bool: boolean;
let str: string;
let obj: object;

function myVoidFunction(): void{
    console.log("this function doesn't return anything");
    // return 5;
}

let anotherFunction = function(value: any){
    if(typeof value === "string" && typeof value === "number"){
        return value;
    }
}

let foreverFunction = function(){
    while(true){
        console.log("hello");
    }
}

// console.log(typeof foreverFunction());
let y: any;
// console.log(y);
// console.log(typeof y);

let myArr: any[] = [true, 5];
myArr[3] = "hello";

// let myArr2: string[] = [true, 5];


let drawPoint = (x:number, y:number) =>{
    console.log(x+", "+y);
}

// drawPoint("cat", "dog");
drawPoint(4,5);

let drawPoint2 = (point) => {
    console.log(point.x +", "+point.y);
}

let myPoint = {x:4, y:5};
drawPoint2(myPoint);
let myFakePoint = {name:"Lisa", email:"lisarocks@gmail.com"};
drawPoint2(myFakePoint);

let drawPoint3 = (point: {x:number, y:number}) =>{
    console.log(point.x +", "+point.y);
}
drawPoint3(myPoint);
// drawPoint3(myFakePoint);

interface Point{
    x:number;
    y:number;
}

let drawPoint4 = (point: Point)=>{
    console.log(point.x+", "+point.y);
}

drawPoint4(myPoint);

class MyPoint{
    x: number;
    y: number;
}

let drawPoint5 = (point: MyPoint)=>{
    console.log(point.x+", "+point.y);
}

class MyPoint2{
    x: number;
    y: number;

    constructor(_x:number, _y:number){
        this.x = _x;
        this.y = _y;
    }

    drawPoint = () => {
        console.log(this.x+", "+this.y);
    }
}

let p: MyPoint2 = new MyPoint2(5,12);
p.drawPoint();