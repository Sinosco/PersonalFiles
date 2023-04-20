const btnOne = document.querySelector("#btnOne");
const btnTwo = document.querySelector("#btnTwo");
const btnThree = document.querySelector("#btnThree");
const menuBtnOne = document.querySelector("#menuBtnOne");
let curRoute = "r0";
let story = "Introductory piece of text.";
document.getElementById('story').innerHTML = story;

btnOne.addEventListener("click", choiceOneSelected);
btnTwo.addEventListener("click", choiceTwoSelected);
btnThree.addEventListener("click", choiceThreeSelected);

function choiceOneSelected(){
    switch(curRoute) {
        case curRoute = "r0":
            story = "Choice 1 consequence text.";
            curRoute = "r1";
            break;
        case curRoute = "r1": 
            story = "Choice 1 consequence after Choice 1 prior.";
            curRoute = "r11"
            break;
        case curRoute = "r2":
            story = "Choice 1 consequence text after choice 2";
            curRoute = "r21";
            break;

    }
    document.getElementById('story').innerHTML = story;
}

function choiceTwoSelected(){
    switch(curRoute) {
        case curRoute = "r0":
            story = "Choice 2 consequence text.";
            curRoute = "r2";
            break;
        case curRoute = "r2":
            story = "Choice 2 consequence after choice 2";
            curRoute = "r22"
            break;
    }
    document.getElementById('story').innerHTML = story;
}

function choiceThreeSelected(){
    switch(curRoute) {
        case curRoute = "r0":
            story = "Choice 3 consequence text.";
            curRoute = "r3";
            break;    
        case curRoute = "r3":
            story = "Choice 3 consequence text after choice 3.";
            curRoute = "r33";
            break;
    }
    document.getElementById('story').innerHTML = story;
}

menuBtnOne.addEventListener("click", )