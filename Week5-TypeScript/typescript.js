function doSomething() {
    for (var i = 0; i < 5; i++) {
        console.log(i);
    }
}
// doSomething();
var x = 10;
x = 5;
// x = true;
var bool;
var str;
var obj;
function myVoidFunction() {
    console.log("this function doesn't return anything");
    // return 5;
}
var anotherFunction = function (value) {
    if (typeof value === "string" && typeof value === "number") {
        return value;
    }
};
var foreverFunction = function () {
    while (true) {
        console.log("hello");
    }
};
// console.log(typeof foreverFunction());
var y;
// console.log(y);
// console.log(typeof y);
var myArr = [true, 5];
myArr[3] = "hello";
// let myArr2: string[] = [true, 5];
var drawPoint = function (x, y) {
    console.log(x + ", " + y);
};
// drawPoint("cat", "dog");
drawPoint(4, 5);
var drawPoint2 = function (point) {
    console.log(point.x + ", " + point.y);
};
var myPoint = { x: 4, y: 5 };
drawPoint2(myPoint);
var myFakePoint = { name: "Lisa", email: "lisarocks@gmail.com" };
drawPoint2(myFakePoint);
var drawPoint3 = function (point) {
    console.log(point.x + ", " + point.y);
};
drawPoint3(myPoint);
var drawPoint4 = function (point) {
    console.log(point.x + ", " + point.y);
};
drawPoint4(myPoint);
var MyPoint = /** @class */ (function () {
    function MyPoint() {
    }
    return MyPoint;
}());
var drawPoint5 = function (point) {
    console.log(point.x + ", " + point.y);
};
var MyPoint2 = /** @class */ (function () {
    function MyPoint2(_x, _y) {
        var _this = this;
        this.drawPoint = function () {
            console.log(_this.x + ", " + _this.y);
        };
        this.x = _x;
        this.y = _y;
    }
    return MyPoint2;
}());
var p = new MyPoint2(5, 12);
p.drawPoint();
