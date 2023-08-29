const titleLink = document.getElementById('title');
let flag = true;

console.log(titleLink);

function changeTitle() {
    const clicked = 'You clicked button';
    const unClicked = 'Welcome to my page!';

    if (flag) {
        titleLink.textContent = clicked;
    } else {
        titleLink.textContent = unClicked;
    }

    flag = !flag;
}

const images = [
    "./Images/Rouen_Cathedral_1.jpg",
    "./Images/Rouen_Cathedral_2.jpg",
    "./Images/Rouen_Cathedral_3.jpg",
    "./Images/Rouen_Cathedral_4.jpg",
    "./Images/Rouen_Cathedral_5.jpg",
    "./Images/Rouen_Cathedral_6.jpg"
];

const btnPrev = document.getElementById('prev');
const elemPicture = document.getElementById('picture')
const btnNext = document.getElementById('next');

btnPrev.onclick = prevHandler;
btnNext.onclick = nextHandler;
let index = 0;

function prevHandler() {
    index--;
    if (index == -1) {
        index = images.length - 1;
    }
    elemPicture.src = images[index];   
}

function nextHandler() {
    index++;
    if (index == images.length) {
        index = 0;
    }
    elemPicture.src = images[index]; 
}