let arr = [1, 2, 3, 'four', 'five'];

// typeof - ключевое слово, с помощью которого можно получить информацию о типе данных
console.log(typeof arr); // object

// Метод push меняет исходный массив,
// добавляя к нему элементы, переданные ему в качестве параметров, возвращает новую длину
console.log('===== push =====');
let res = arr.push(6, 7, 18);

// Возвращается новый массив (равен [1, 2, 3, 'four', 'five', 6, 7, 18]);
console.log(arr);
// Возвращается новая длина массива (равна 8);
console.log(res);

// Метод pop меняет исходный массив, удаляя последний элемент, возвращает удалённый элемент
console.log('===== pop =====');
res = arr.pop();

// Возвращается новый массив (равен [1, 2, 3, 'four', 'five', 6, 7]);
console.log(arr);
// Возвращает удалённый элемент массива (равна 18);
console.log(res);

// Метод shift меняет исходный массив, удаляя первый элемент, возвращает удалённый элемент
console.log('===== shift =====');
res = arr.shift();

// Возвращается новый массив (равен [2, 3, 'four', 'five', 6, 7]);
console.log(arr);
// Возвращает удалённый элемент массива (равен 1);
console.log(res);

// Метод unshift меняет исходный массив, добавляя элементы в начало массива,
// переданные ему в качестве параметров, возвращает новую длину
console.log('===== unshift =====');
res = arr.unshift(0, 1);

// Возвращается новый массив (равен [0, 1, 2, 3, 'four', 'five', 6, 7]);
console.log(arr);
// Возвращает новую длину массива (равен 8);
console.log(res);

// Метод concat не меняет оригинал! Возвращает новый, объединённый массив
console.log('===== concat =====');
let arr1 = [1, 2, 3];
let arr2 = [4, 5, 6];
res = arr1.concat(arr2);

console.log(res);
console.log(arr1);
console.log(arr2);

// Метод slice не меняет оригинал
// возвращает новый массив
console.log('===== slice =====');
res = arr.slice(0, arr.length - 1)

console.log(res);
console.log(arr);

// Метод splice меняет оригинал, вырезая элементы от индекса старта (первый параметр),
// в количестве (второй параметр) возвращает новый массив
console.log('===== splice =====');
res = arr.splice(1, 4)

console.log(res);
console.log(arr);

console.log('===== spread =====');
// Глубокая копия массива arr1
let uniteArr = [...arr1];

console.log(uniteArr);
console.log(arr1);

uniteArr[0] = 1000000;

console.log(uniteArr);
console.log(arr1);

// Поверхностная копия массива arr1
let arrCopy = arr1;

let x = [5];
let y = x;

console.log(`x = ${x}, y = ${y}`);
x.push(100);
console.log(`x = ${x}, y = ${y}`);

let a = 5;
let b = a;


let obj = {
    userName: 'John',
    age: 14
}

let objCopy = {...obj};

console.log(obj);
console.log(objCopy);

obj.age = 18;

console.log(obj);
console.log(objCopy);

obj = {
    userName: 'John',
    age: 14,
    nationality: 'Poland',
    sex: 'male',
    dateOfBirth: '31.08.2023'
}

objCopy = {...obj, age: 20}

console.log(obj);
console.log(objCopy);

arr = [obj, objCopy];
console.log(arr);