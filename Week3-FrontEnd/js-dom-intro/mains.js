console.log("hello from main.js")

let picElements = document.getElementsByTagName("img");
console.log(picElements);

let waterfallPic = picElements[0];

let catUrl = "https://cdn.24.co.za/files/Cms/General/d/3975/2d37607e47904b088f051249d27bed10.jpg";

waterfallPic.src = catUrl;
waterfallPic.alt = "A cozy cat";

let picCaption = document.getElementsByTagName("figcaption")[0];
picCaption.innerText = "A little cat wearing a sweater!!";

let paintingList = document.getElementById("painting-list");

let paintingLinks = paintingList.children;
console.log(paintingLinks);

//accessing the first anchor tag in our list of image links
let firstItemLink = paintingLinks[0].firstElementChild;
console.log(firstItemLink);
// firstItemLink.click();


document.getElementById("subtitle").hidden = true;

// create a new list item to add to our unordered list
let newLiElement = document.createElement("li");
let newAElement = document.createElement("a");
newAElement.innerText = "Sunset Glow";
newAElement.href = "https://dynaimage.cdn.cnn.com/cnn/q_auto,w_727,c_fit/http%3A%2F%2Fcdn.cnn.com%2Fcnnnext%2Fdam%2Fassets%2F190904125001-bob-ross-sunsetaglow-2612.jpg";
newLiElement.appendChild(newAElement);
paintingList.appendChild(newLiElement);

