const inp = document.getElementById('in');
const btn = document.getElementById('btn');
document.onscroll = changeHandler;

function changeHandler(e) {
    console.log(e);
}

btn.onclick = clickHandler;

function clickHandler(e) {
    console.log(e);
}

btn.addEventListener('keypress', (e) => {
    console.log(e);
    if (e.code === "Space") {
        console.log("Вы нажали пробел");
    } else {
        console.log("Вы нажали другую кнопку");
    }
});

inp.addEventListener('focus', (e) => {
    console.log(e);
    e.target.style.fontSize = '18px';
})

inp.addEventListener('blur', (e) => {
    console.log(e);
    e.target.style.fontSize = '14px';
})

inp.addEventListener('input', (e) => {
    if (e.target.value === '123456') {
        return document.body.style.backgroundColor = 'aqua';
    }
});