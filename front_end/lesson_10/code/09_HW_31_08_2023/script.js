const library = [];
let inputDate = prompt('Enter book data separate by ";"');

// '123456789;Gold Fish;A.S. Pushkin;1820'
// console.log(inputDate);

while (inputDate) {
    const bookData = inputDate.split(';'); // ['', '', '', '']

    const [isbn, title, author, year] = bookData;

    if (
        bookData.length === 4 &&
        isbn &&
        title &&
        author &&
        year &&
        !findBook(library, isbn)
    ) {
        library.push(new Book(isbn, title, author, year));
    }
    inputDate = prompt('Enter book data separate by ";"');
}

function printLibrary(library) {
    for (let i = 0; i < library.length; i++) {
        console.log(library[i].toString());
    }
}

printLibrary(library);

function findBook(library, isbn) {
    for (let i = 0; i < library.length; i++) {
        if (library[i].isbn === isbn) {
            return library[i];
        }
    }
    return null;
}

function Book(isbn, title, author, year) {
    this.isbn = isbn;
    this.title = title;
    this.author = author;
    this.year = year;
    this.toString = function() {
        return `ISBN: ${this.isbn}, Title: ${this.title}, Author: ${this.author}, Year: ${this.year}`
    }
}

// const book1 = new Book(1, 'Kolobok', 'nation', '~1800'); 
// const book2 = new Book(2, 'War and Piece', 'L.N. Tolstoy', '1830');

// console.log(book1);
// console.log(book2);