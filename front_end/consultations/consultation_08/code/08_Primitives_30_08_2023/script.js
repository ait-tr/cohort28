// int[] arr - new int[5];
// int[] arr - {1, 2, 3, 4, 5};

const arr = [1, 2, 3, 'four', 'five', true];
console.log(typeof arr);
console.log(arr[3]);

console.log(typeof arr[3]);

arr[10] = 100500;
console.log(arr[9]);
console.log(arr);

arr.length = 1000;
console.log(arr);

/*
    Primitives types:

    1. Number: 10, -5, 3.14, NaN;
    2. String: 'hello', 'world', '123';
    3. Boolean: true, false;
    4. Undefined: let a; a is undefined;
    5. Null;

    // + - / * % **
*/

console.log(2 ** 4); // возведение в степень
console.log(Math.pow(2, 4));

console.log(1 + '2'); // "12" - конкатенация
console.log('3' * '4'); // 12 - конкатенация
console.log('c' * 'd'); // NaN - конкатенация

// Примитив (сохраняет по значению)

const a = 6;
let b = a;

b = 10;

console.log(a);
console.log(b);

// Объект (сохраняет по ссылке на место в памяти)

const arrNew = [1, 2, 3];
let arrCopy = arrNew;

arrCopy[0] = 100;

console.log(arrNew);
console.log(arrCopy);