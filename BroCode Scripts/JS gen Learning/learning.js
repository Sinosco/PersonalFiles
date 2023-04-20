//functions
function toCelsius(f){
    return (f-32) * 5/9
};

function toFarenheit(c){
    return (c*9/5) + 32;
};
/*
console.log("my temp in C is",toCelsius(100),"degrees.");
console.log("Muy temp in Farenheit is",toFarenheit(37.7777777),"degrees");
*/

//objects
var human1 = {
    name: "Rick",
    age: 65,

    eat: function(){
        console.log("Rick is eating")
    },
    
    drink: function(){
        console.log("Rick is drinking, bad man")
    },

    sleep: function(){
        console.log("mans is dead bruh")
    }
};

human1.name //dot notation
human1['name'] //bracket notation

console.log(human1.name);
console.log(human1.age);
human1.eat();
human1.drink();

var human2 = {
    stateOfBeing: "dead",
    name: "Unneeded",
    age: "mortal"

}
console.log(human2.stateOfBeing);


//arrays: a variable that holds more than one value
// each space is known as a n element, you access 
//elements in an array by referring to the index number

var cars = ["toyota", "ford", "mustang"];
console.log(cars);
//
console.log(cars[0]);
console.log(cars[1]);
console.log(cars[2]);

cars.push("tesla"); // adds an element
console.log(cars[3]);

cars.pop(); // removes last element
console.log(cars[3]);

cars.length; //returns numeric value, tells items in array
var numberOfCars = cars.length;
console.log(numberOfCars,"cars");

cars = cars.sort(); //sorts an array alphabettically/numerically
console.log(cars);

cars=cars.reverse(); //reverse an array

// to access the last element of an array
var lastCar = cars[cars.length-1];
console.log(lastCar);
console.log(cars.indexOf("ford"));


/* switch = statemtn that evalueates a value/experessoin,
            matches the value to many case caluses
            more efficient than many "else f statements" */    

var grade = "";

switch (grade){
    case "A":
        console.log("you did awesome");
        break;
    case "B":
        console.log("You did brave");
        break;
    case "C":
        console.log("You did coursely");
        break;
    case "D":
        console.log("you did dumb");
        break;
    case "F":
        console.log("you failed lulw");
        break;
    
    default:
        console.log(grade,"is not a letter grade");

}


// while loop repeats csome code, while the loop's condition remains true
// do while loop executes body first THEN checks the condition.


//var creditNum = window.prompt("YOUR COMPUTER HAS VIRUS!! ENTER CREDIT CARD NUMBER NOW TO REMOVE IT!!!");
/*
while(creditNum == ""){
    var creditNum = window.prompt("YOUR COMPUTER HAS VIRUS!! ENTER CREDIT CARD NUMBER NOW TO REMOVE IT!!!");
}*/


/*
{
    var creditNum = window.prompt("YOUR COMPUTER HAS VIRUS!! ENTER CREDIT CARD NUMBER NOW TO REMOVE IT!!!");
}while(creditNum == "")
*/

// console.log("THANK YOU FOR THE PAYMENT, YOU ARE NOW SAFE");

//for loopsss
for(let i=0; i<=10; i++){
    console.log(i);
}
/* or

var i = 0;
for(; i<+10;){
    console.log(i);
    i--;
}
these both work, just remember to keep the semi colons in!! */


console.log("");


//for in loop = loops through tht elements in an array
//              or the properties of an Object
//              less syntax to write, but less flexible

let letters = ["H","E","L","P"];

let Car = {
    make: "chevy",
    model: "corvette",
    year: 2022,
    color: "blue"
}

/*
for(let i = 0; i<letters.length; i++){
    console.log(letters[i]);
}
*/

for(let property in Car){
    console.log(Car[property]);
}

//nested loops are loops inside other loops, incest // 12/23/22 shaikh here, ???
/*
var symbol = window.prompt("enter a symbol to use");
var rows = window.prompt("enter number of rows");
var columns = window.prompt("enter number of columns");

for(let i=0; i<rows; i++){

    for(let j=0; j<columns; j++){
       document.getElementById("myRectangle").symbol;
    }
}
*/


// Math related uses

// var myNum;
// myNum = Math.round(3.5); rounds to the nearest integar
// muNum = Math.floor(3.5); will round it down to 3
// myNum = Math.ceil(3.1); will round it up to 4
// myNum = Math.pow(3,2); will do 3 to the 2nd power
// myNum = Math.sqrt(64); will do the square root of 64
// myNum = Math.abs(-1); will give the absolute value of -1
// myNum = Math.min(1, 5, 2, 6, 3); will give the minimum value in the list of values
// myNum = Math.max(1, 5, 2, 6, 3); will give the maximum value in the list of values



document.getElementById("trigButton").onclick = function() {
    if (sideA != " "){
        var a = document.getElementById("sideA").value;
    }
    if (sideB != " "){
        var b = document.getElementById("sideA").value;
    }
    if (sideC != " "){
        var c = document.getElementById("sideA").value;
    }
    if(Number.isFinite(a && b)){
        console.log(document.getElementById("trigonometry").innerHTML =+ Math.sqrt(Math.pow(a, 2) + (Math.pow(b, 2))));
    }
}


// Math.random() = generates a psudo-random between 0 and 1, dont use this for security

var randNum;
// randNum = Math.random (); // 0 - 1
// randNum = Math.floor(Math.random()*6)+1;


document.getElementById("freeButton").onclick = function() {
    randNum = Math.floor(Math.random()*6)+1;
    document.getElementById("freeUse").innerHTML =+ getRandomNum(-1, 9);
}

function getRandomNum(min, max){
    return Math.floor(Math.random() * (max - min +1) + min);
}

/* date object = represents a moment in time
                since epoch (reference point)
                */
date = new Date(0);
date = new Date();
date = new Date(2021, 9, 29, 19, 54, 30); // year, month, day, hour, minutes, seconds, milliseconds
date = new Date("April 20, 2022 16:20:01:02");
console.log(date);

let year = date.getFullYear();
/*
let month = date.getMonth();
let dayOfWeek = date.getDay();
let dayOfMonth = date.getDate();
let hours = date.getHours();
let minutes = date.getMinutes();
let seconds = date.getSeconds();
let milliseconds = date.getMilliseconds();
*/
console.log(year);

//setting a date
date.setFullYear(2023);
date.setMonth(11);
date.setDate(25);
date.setHours(0);
date.setMinutes(23);
date.setSeconds(25);
date.setMilliseconds(22);
console.log(date);

// Useful string properties & methods

var myName = "shaikh ahmed";
console.log(myName.length);
console.log(myName.charAt(0)); // tells the char at given pos
console.log(myName.indexOf("a")); // tells the pos of first instance of whatever char
console.log(myName.lastIndexOf("h")); // tells the pos of the last instance of whatever char
console.log(myName.trim()); //gets rid of whitespace before and after string
//console.log(myName.toUpperCase()); // sets entire string to upper case
//console.log(myName.toLowerCase());

//var firstName = myName.slice(0, 7);
var firstName = myName.slice(0, myName.indexOf(" ")); //stores the data of characters until it reaches a space
console.log(firstName);

var lastName = myName.slice(myName.lastIndexOf(" ") + 1)
console.log(lastName);

// string concatanization
var myStreet = "1910 Garrett Road";
var myCity = "Lansdowne 19050";
var myPhone = "267-230-9023"

var myAddress = myStreet.concat(" ", myCity);
console.log(myAddress);

myPhone = myPhone.replaceAll("-", " ");
console.log(myPhone);


// method chaining = calling one method after another
//                   in one continuous line of code

let user = "shaikh";

// without method chaining:
//let firstLetter = user.charAt(0);
//firstLetter = firstLetter.toUpperCase();
//user = firstLetter + user.slice(1);

user = user.charAt(0).toUpperCase() + user.slice(1);

console.log(user);


// break = used to exit out of a loop
// continue = skips over an iteration of a loop

for(let i=1; i<=5; i++){
    if(i == 4){
        break;
    }
    console.log(i);
}
console.log(" ");
for(let i=1; i<=9; i++){
    if(i == 7){
        continue;
    }
    console.log(i);
}
console.log("7 was skipped over");


/* *****Differences between let and var

scope = where a variable is accessible

let = decalre variables with a block scoped ()
var - declare variables with a function scoped ()
*/


/*
for(var i=1; i<=3; i++){
    console.log(i);
}

// console.log(i); comes up with a reference error
// because we used let for variable i
console.log(i+200); 
// i is logged because var can be used outside forloop
*/


/*
function doSomething(){
    for(var i=1; i <= 3; i++){
      console.log(i);  
    }
}

doSomething();
console.log(i);
// Becuase var 'i' is inside the *function* doSomething,
it won't be accessible outside the function.
*/

// if you use var, you may override the preset properties in the
// console behind-the-scenes

