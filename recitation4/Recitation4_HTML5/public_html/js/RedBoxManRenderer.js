/* 
 * This JavaScript file provides methods for clearing the
 * canvas and for rendering Red Box Man.
 */

var canvas;
var gc;
var canvasWidth;
var canvasHeight;
var imageLoaded;
var mousePositionRendering;
var redBoxManImage;
var mouseX;
var mouseY;
var imagesRedBoxManLocations;
var shapesRedBoxManLocations;

function Location(initX, initY) {
    this.x = initX;
    this.y = initY;
}

function init() {
    // GET THE CANVAS SO WE CAN USE IT WHEN WE LIKE
    canvas = document.getElementById("red_box_man_canvas");
    gc = canvas.getContext("2d");
        
    // MAKE SURE THE CANVAS DIMENSIONS ARE 1:1 FOR RENDERING
    canvas.width = canvas.offsetWidth;
    canvas.height = canvas.offsetHeight;
    canvasWidth = canvas.width;
    canvasHeight = canvas.height;
    
        // FOR RENDERING TEXT
    gc.font="32pt Arial";

    // LOAD THE RED BOX MAN IMAGE SO WE CAN RENDER
    // IT TO THE CANVAS WHENEVER WE LIKE
    redBoxManImage = new Image();
    redBoxManImage.onload = function() {
	imageLoaded = true;
    }
    redBoxManImage.src = "./images/RedBoxMan.png";
    
    // BY DEFAULT WE'LL START WITH MOUSE POSITION RENDERING ON
    mousePositionRendering = true;
    
    // HERE'S WHERE WE'LL PUT OUR RENDERING COORDINATES
    imagesRedBoxManLocations = new Array();
    shapesRedBoxManLocations = new Array();
}

function processMouseClick(event) {
    updateMousePosition(event);
    var location = new Location(mouseX, mouseY);
    if (event.shiftKey) {
	shapesRedBoxManLocations.push(location);
	render();
    }
    else if (event.ctrlKey) {
	if (imageLoaded) {
	    imagesRedBoxManLocations.push(location);
	    render();
	}
    }
    else {
	clear();
    }
}

function clearCanvas() {
    gc.clearRect(0, 0, canvasWidth, canvasHeight);
}

function clear() {
    shapesRedBoxManLocations = [];
    imagesRedBoxManLocations = [];
    clearCanvas();
}

function updateMousePosition(event) {
    var rect = canvas.getBoundingClientRect();
    mouseX = event.clientX - rect.left;
    mouseY = event.clientY - rect.top;
    render();
}

function renderShapesRedBoxMan(location) {
    var headColor = "#DD0000";
    var outlineColor = "#000000";
    var headW = 115;
    var headH = 88;
    
    // DRAW HIS RED HEAD
    gc.fillStyle = headColor;
    gc.fillRect(location.x, location.y, headW, headH);
    gc.beginPath();
    gc.strokeStyle = outlineColor;
    gc.lineWidth = 1;
    gc.rect(location.x, location.y, headW, headH);
    gc.stroke();
    
    // AND THEN DRAW THE REST OF HIM
    var eyeColor = "#FFFF14";
    var eyeW = 30;
    var eyeH = 20;

    // left eye
    gc.fillStyle = eyeColor;
    gc.fillRect(location.x + 10, location.y + 10, eyeW, eyeH);
    gc.beginPath();
    gc.strokeStyle = outlineColor;
    gc.lineWidth = 1;
    gc.rect(location.x+10, location.y+10, eyeW, eyeH);
    gc.stroke();
        
    // right eye
    gc.fillStyle = eyeColor;
    gc.fillRect(location.x + 80, location.y + 10, eyeW, eyeH);
    gc.beginPath();
    gc.strokeStyle = outlineColor;
    gc.lineWidth = 1;
    gc.rect(location.x+80, location.y+10, eyeW, eyeH);
    gc.stroke();
        
    var pupilColor = "#000000";
    var pupilW = 4;
    var pupilH = 4;

    // left pupil
    gc.fillStyle = pupilColor;
    gc.fillRect(location.x + 15, location.y + 10, pupilW, pupilH);
    gc.beginPath();
    gc.strokeStyle = outlineColor;
    gc.lineWidth = 1;
    gc.rect(location.x+15, location.y+10, pupilW, pupilH);
    gc.stroke();
        
    // left pupil
    gc.fillStyle = pupilColor;
    gc.fillRect(location.x + 82, location.y + 20, pupilW, pupilH);
    gc.beginPath();
    gc.strokeStyle = outlineColor;
    gc.lineWidth = 1;
    gc.rect(location.x+82, location.y+20, pupilW, pupilH);
    gc.stroke();
        
    // mouth
    var mouthW = 80;
    var mouthH = 4;

     gc.fillStyle = pupilColor;
    gc.fillRect(location.x + 10, location.y + 50, mouthW, mouthH);
    gc.beginPath();
    gc.strokeStyle = outlineColor;
    gc.lineWidth = 1;
    gc.rect(location.x+10, location.y+50, mouthW, mouthH);
    gc.stroke();
        
    var bodyW = 80;
    var bodyH = 10;
    // body
    gc.fillStyle = pupilColor;
    gc.fillRect(location.x + 10, location.y + 88, bodyW, bodyH);
    gc.beginPath();
    gc.strokeStyle = outlineColor;
    gc.lineWidth = 1;
    gc.rect(location.x+10, location.y+88, bodyW, bodyH);
    gc.stroke();
        
    var waistW = 65;
    var waistH = 10;
    // waist
    gc.fillStyle = pupilColor;
    gc.fillRect(location.x + 20, location.y + 98, waistW, waistH);
    gc.beginPath();
    gc.strokeStyle = outlineColor;
    gc.lineWidth = 1;
    gc.rect(location.x+20, location.y+98, waistW, waistH);
    gc.stroke();
        
    var legW = 10;
    var legH = 10;
    // left leg
    gc.fillStyle = pupilColor;
    gc.fillRect(location.x + 10, location.y + 108, legW, legH);
    gc.beginPath();
    gc.strokeStyle = outlineColor;
    gc.lineWidth = 1;
    gc.rect(location.x+10, location.y+108, legW, legH);
    gc.stroke();
    
    // right leg
    gc.fillStyle = pupilColor;
    gc.fillRect(location.x + 80, location.y + 108, legW, legH);
    gc.beginPath();
    gc.strokeStyle = outlineColor;
    gc.lineWidth = 1;
    gc.rect(location.x+80, location.y+108, legW, legH);
    gc.stroke();
}

function renderImageRedBoxMan(location) {
    gc.drawImage(redBoxManImage, location.x, location.y);
}

function renderMousePositionInCanvas(event) {
    if (mousePositionRendering) {
	gc.strokeText("(" + mouseX + "," + mouseY + ")", 10, 50);    
    }
}

function toggleMousePositionRendering() {
    mousePositionRendering = !mousePositionRendering;
}

function render() {
    clearCanvas();
    for (var i = 0; i < shapesRedBoxManLocations.length; i++) {
	var location = shapesRedBoxManLocations[i];
	renderShapesRedBoxMan(location);
    }
    for (var j = 0; j < imagesRedBoxManLocations.length; j++) {
	var location = imagesRedBoxManLocations[j];
	renderImageRedBoxMan(location);
    }
    renderMousePositionInCanvas();
}