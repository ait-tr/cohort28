console.log('Hello world!');

// undefined
let x;
console.log(x);

x = 7;
x = 'bye';
console.log(x);

const pi = 3.1415926;
// pi = 3.14 пример ошибки!

let y = x;

console.log(y);

console.log('pi = ' + pi);

const exp = pi;

// ''   ""    ``

// "x = x"

// `x = ${x}`

console.log(`exp = ${exp} or ${pi}`);
// console.log('exp = ' + exp + ' or ' + pi);

x = true;
console.log(x);

x = null;
console.log(x);

let res = 7 % 2; // остаток от деления
console.log(`res = ${res}`);

res = 'true' + 5;
console.log(`res = ${res}`);

res = true + 5; // false - 0, true - 1
console.log(`res = ${res}`);

// строгое неравенство
x = '2' === 2;
console.log(`x = ${x}`);

// нестрогое неравенство
x = '2' == 2;
console.log(`x = ${x}`);

res = 5 + ''; // String(5)
console.log(typeof res);

res = +'5'; // Number(5)
console.log(res);

// console.log(10 + 5 + +res);

switch (res) {
    case 5:
        console.log(`number: ${res}`);
        break;
    case '5':
        console.log(`string: ${res}`);
        break;
    default:
        console.log("It's not a 5");
}

let age = 16;
let vol = age > 16 ? 42 : 1.5
console.log(`vol = ${vol}`);

// if (age > 16) {
//     return 42;
// } else {
//     return 1.5;
// }

console.log(+pi.toFixed(2));

++age;
age++;

x = 10;
res = x++ + ++x; // 10 + 12 = 22
console.log(`res = ${res}`);

x = 10;
y = 5;

res = add(x, y);
console.log(`res = ${res}`);

function add(a, b) {
    return a + b;
}

x = !!x; // неявное приведение переменной к boolean значению
console.log(x);

let example = 'hello';
console.log(!!example);

// false = 0, -0, '', false, null, NaN, undefined

let userName = null;
let nickName = userName || 'Anonymous';

greeting();
greeting('Rabindranat');

function greeting(nickName1 = 'Anonymous') {
    console.log(`Hello ${nickName1}`);
}


// Home work

res = sumDigits(1234);
console.log(`res = ${res}`); // Ожидаем увидеть 10

res = luckyNumber(123871); // 1 + 2 + 3 === 8 + 7 + 1
console.log(res ? 'Lucky' : 'Unlucky');

banana();

function sumDigits(x) {
    // создаём результирующую переменную
    let sum = 0;
    // цикл while будет отрабатывать до того момента, пока x не будет равен 0
    while (x) {
        // Аккумулируем в sum остаток от деления на 10 (т.е. последнюю цифру числа)
        sum += x % 10;
        // Отбрасываем последнюю цифру от числа
        x = (x - x % 10) / 10;
    }
    return sum;
}

function luckyNumber(x) {
    // TODO
    let secondHalf = x % 1000;
    let firstHalf = (x - secondHalf) / 1000;

    return sumDigits(firstHalf) === sumDigits(secondHalf);
}

function banana() {
    let a = 'a';
    let b = 'b';
    // TODO
    console.log((b + a + +a + a).toLowerCase());
}

// 'b', 'a' => banana

let d = 5;
console.log(Math.floor(19 / 10));

// x = 4 || x = 7
function returnNumber(x) {
    return 11 - x;
}

// function returnNumber(x) {
//     return 28 / x;
// }