console.log('Hello world!');
console.log(5 + 4);

// однострочный комментарий
/* 
   многострочный комментарий
*/

console.log(document.body);

// document.body.innerHTML = '<h1>Hello world!</h1>';

/*
    var - переменные (глобальные, deprecated)

    let - переменные (блочные)
    const - константа (не может быть переопределена)
*/

let a = 10;
a = '5';

const div1 = document.getElementById('div1');
console.log(div1);

console.log(`${div1.style.border} значение свойства border`);

div1.style.border = '1px solid black';

console.log(div1.style.border);


// Маркер, по которому можно найти элемент на странице
const div1Query = document.querySelector('#div1');
console.log(div1Query);

const pDiv1 = document.querySelectorAll('#div1 > p');
console.log(pDiv1.length);

// ""   ''    ``

for (let i = 0; i < pDiv1.length; i++) {
    pDiv1[i].innerHTML = `<span>new text ${i + 1}</span>`
}

const children = div1.children;
console.log(children.length);

for (let i = 0; i < children.length; i++) {
    children[i].style.color = 'red';
}

const newP = document.createElement('p');
const newPCopy = document.createElement('p');
console.log(newP);

const newPText = document.createTextNode('This text was created by special method');
const newPCopyText = document.createTextNode('This text was created by special method222222222');

newP.appendChild(newPText);
newPCopy.appendChild(newPCopyText);

div1.appendChild(newP);
div1.insertBefore(newPCopy, div1.firstElementChild)

// div1.insertBefore(newP, div1.firstElementChild)

const t = setInterval(move, 20);
let pos = 0;
const box = document.getElementById('box');

function move() {
    pos++;
    if (pos == 150) {
        clearInterval(t);
    }
    box.style.top = pos + 'px';
    box.style.left = pos + 'px';
}