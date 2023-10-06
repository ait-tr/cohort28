import { uid } from "uid";
import { ActionBook } from "../types/Action";
import { BooksState } from "../types/State";

const initialState: BooksState = {
    books: [
        {isbn: '1', title: 'Harry Potter', author: 'J.Rouling', year: 2002}
    ]
}

export default function booksReducer(
    state: BooksState = initialState,
    action: ActionBook
): BooksState {
    switch (action.type) {
        case 'books/add':
            return {...state, books: [...state.books, { isbn: uid(), ...action.payload }]};
        case 'books/delete':
            // console.log(arr4.filter(e => e !== 5))  =>  [1, 2, 3, 4, 6]
            return {...state, books: state.books.filter(book => book.isbn !== action.payload)}
        case "books/editTitle":
            // arr.map(e => e === 9 ? e + 1 : e)   =>    [10, 2, 4, 1, 5, 2, 10, 1, 2, 0]
            return {...state, books: state.books.map(book => {
                if (book.isbn === action.payload.isbn) {
                    return {...book, title: action.payload.title}
                }
                return book;
            })}
        default:
            return state;
    }
}