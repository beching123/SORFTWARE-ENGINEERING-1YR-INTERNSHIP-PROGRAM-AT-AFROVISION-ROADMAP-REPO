const myImage = document.querySelector("img");

myImage.addEventListener("click", () => {
  const mySrc = myImage.getAttribute("src");
  if (mySrc === "images/learning-main.jpg") {
    myImage.setAttribute("src", "images/firefox-icon.png");
  } else {
    myImage.setAttribute("src", "images/learning-main.jpg");
  }
});

let myButton = document.querySelector("button");
let myHeading = document.querySelector("h1");

function setUserName() {
  const myName = prompt("Please enter your name.");

  if (!myName) {
    setUserName();
  }
  else {

  localStorage.setItem("name", myName);
  myHeading.textContent = `The Science of Efficient Learning, How to Master Any Skill, ${myName}`;
  }
}

if(!localStorage.getItem("name")) {
    setUserName();
} else {
    const storedName = localStorage.getItem("name");
    myHeading.textContent = `The Science of Efficient Learning, How to Master Any Skill, ${storedName}`;
}

myButton.addEventListener("click", () => {  
    setUserName();
});