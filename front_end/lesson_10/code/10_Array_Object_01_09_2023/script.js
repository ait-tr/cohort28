console.log("======== Regular function ========");
console.log(multiply(3, 4));

function multiply(a, b) {
    return a * b;
}

console.log(multiply(2, 5));

console.log("======== Arrow function ========");
// console.log(multiplyArrow(6, 5));

const multiplyArrow = (a, b) => a * b;
console.log(multiplyArrow(6, 5));

console.log("======== Object ========");

const obj = {
    userName: "John",
    sayHello: function () {
        console.log(this);
        console.log(`Hello ${this.userName}`);
    },
};

obj.sayHello();

const objArrow = {
    userName: "John",
    sayHello: () => {
        console.log(this);
        console.log(`Hello ${this.userName}`);
    },
};

objArrow.sayHello();

console.log("======== Object 2 ========");

const person = {
    firstName: "Bill",
    lastName: "Brown",
    age: 34,
    fullName: function () {
        return `${this.firstName} ${this.lastName}`;
    },
};

// arr ( массив ключей объекта ) - это всегда массив строк,
// т.к. ключи ВСЕГДА преобразовываюися в формат строки
let arr = Object.keys(person);
console.log(arr);

// arr ( массив значений объекта )
arr = Object.values(person);
console.log(arr);

// arr ( массив с массивами: каждый массив внутри arr состоит
// из двух элементов: ключа и значения )
arr = Object.entries(person);
console.log(arr[2][1]);

console.log("======== Array Methods 2 ========");

arr = ["one", "two", "three", "eight", "three", "three", "six"];

console.log("===== indexOf =====");
let res = arr.indexOf("three");

console.log(arr); // Исходный массив не меняется
console.log(res); // Возвращает индекс искомого элемента

console.log("===== includes =====");
res = arr.includes("nine");

console.log(arr); // Исходный массив не меняется
console.log(res); // Возвращает true, если искомый элемент есть в массиве
// и false, если такого элемента в массиве нет

console.log("===== findIndex =====");
res = arr.findIndex((elem, index) => index > 2 && elem.toLowerCase() === 'three');

console.log(arr); // Исходный массив не меняется
console.log(res); // Возвращает индекс искомого элемента или -1, если такого элемента нет

res = arr.findIndex(predicateLength3);

function predicateLength3(_, i) {
    return i >= 2;
}

console.log(arr); // 
console.log(res); // 

res = arr.find((elem, index) => index > 3 && elem === 'six');

console.log(arr); // 
console.log(res); // 