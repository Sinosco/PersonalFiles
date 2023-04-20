document.getElementById("myButton").onclick = function(){
    var myName = document.getElementById("myText").value;
    var ip = document.getElementById("ip").value;
    console.log("Hello",myName,"whose ip is at",ip);
}

document.getElementById("fearButton").onclick = function(){
    var scaredColor = document.getElementById("scaredColor").value;
    console.log("You fear",scaredColor);
}

//
document.getElementById("arraySymbol").onclick = function(){
    var symbol = document.getElementById("mySymbol").value;
    var rows = document.getElementById("myRows").value;
    var columns = document.getElementById("myColumns").value;
    for(let i=0; i<rows; i++){

        for(let j=0; j<columns; j++){
            document.getElementById("myRectangle").innerHTML += symbol;
        }
        document.getElementById("myRectangle").innerHTML += "<br>";
    }
}


/*
var symbol = window.prompt("Enter your symbol");
var rows = window.prompt("enter your rows");
var columns = window.prompt("enter your columns");

for(let i=0; i<rows; i++){

    for(let j=0; j<columns; j++){
        document.getElementById("myRectangle").innerHTML += symbol;
    }
    document.getElementById("myRectangle").innerHTML += "<br>";
}
*/


document.getElementById("trigButton").onclick = function() {
        var a = Math.pow(document.getElementById("sideA").value, 2);
        var b = Math.pow(document.getElementById("sideB").value, 2);
        var c = Math.pow(document.getElementById("sideC").value, 2);

        if(a && b > 0){
            document.getElementById("trigonometry").innerHTML =+ Math.sqrt(a + b);
        }
        if(c && a > 0){
            document.getElementById("trigonometry").innerHTML =+ Math.sqrt(c - a);
        }
        if(c && b > 0){
            document.getElementById("trigonometry").innerHTML =+ Math.sqrt(c - b);
        }

        /*
        //how the hell do I make this into a swatch case
        switch (a, b, c){
            case a && b > 0:
                document.getElementById("trigonometry").innerHTML =+ Math.sqrt(a + b);
                break;
            case c && a > 0:
                document.getElementById("trigonometry").innerHTML =+ Math.sqrt(c - a);
                break;
            case c && b > 0:
                document.getElementById("trigonometry").innerHTML =+ Math.sqrt(c - b);
                break;
            default:
                document.getElementById("trigonometry").innerHTML =+ "Not enough information";
        }
        */
    }

