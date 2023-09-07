function getFiveAfterSevenSec() {
    setTimeout(() => {
        return 5;
    }, 7000);
}

let res = getFiveAfterSevenSec();
console.log(res);

console.log('===== Promise =====');

let promise = new Promise(function(resolved, reject) {
    setTimeout(() => {
        resolved(5);
    }, 7000);
})

console.log(promise);

promise.then((value) => value + 5).then(value => console.log(value / 5));


let promise2 = new Promise(function(resolved, reject) {
    setTimeout(() => {
        reject(new Error('Ошибка, вызванная нами'));
    }, 7000);
})

promise2
    .then(data => console.log(data))
    .catch(err => console.log(err))
    .finally(console.log('Печатаем в любом случае'))