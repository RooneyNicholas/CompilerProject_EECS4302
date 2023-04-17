/**
 * 
 */
 
console.log('mc.js loaded!')
 function onStart() {
	console.log('onStart called');
	//readTextFile
	
}

var acc = document.getElementsByClassName("dropView");
var i;

for (i = 0; i < acc.length; i++) {
  acc[i].addEventListener("click", function() {
    /* Toggle between adding and removing the "active" class,
    to highlight the button that controls the panel */
    this.classList.toggle("active");

    /* Toggle between hiding and showing the active panel */
    var panel = this.nextElementSibling;
    if (panel.style.display === "block") {
      panel.style.display = "none";
    } else {
      panel.style.display = "block";
    }
  });
}

function readTextFile(file, callback) {
	console.log('in read')
    var rawFile = new XMLHttpRequest();
    rawFile.overrideMimeType("application/json");
    rawFile.open("GET", file, true);
    rawFile.onreadystatechange = function() {
        if (rawFile.readyState === 4 && rawFile.status == "200") {
			console.log(responseText);
            callback(rawFile.responseText);
        }
    }
    rawFile.send(null);
    console.log('end')
}

/* cant read files through html due to security reasons :(
readTextFile("../output1.txt", function(text){
	console.log('calledreading')
	console.log(text);
    var data = JSON.parse(text);
    console.log(data);
});
*/