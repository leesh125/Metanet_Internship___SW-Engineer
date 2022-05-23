const clock = document.querySelector("h1#clock");
const now = document.querySelector("h1#now");
const colors = {
    0: "red",
    1: "white",
    2: "blue",
    3: "magenta",
    4: "yellow",
    5: "green",
    6: "orange",
    7: "purple"
}		
function getClock() {
    const date = new Date();
    const color = colors[getRandom()];  
    const hours = String(date.getHours()).padStart(2,"0");
    const minutes = String(date.getMinutes()).padStart(2,"0");
    const second = String(date.getSeconds()).padStart(2,"0");
    clock.innerText = hours + ":" + minutes + ":" + second;
    clock.style.color = color;
    if(color == "white"){
		now.style.color = "blue";
	}else{
		now.style.color = "white";
	}
}

function getRandom() {
	return Math.floor(Math.random() * (8));
}

getClock();
setInterval(getClock, 1000);