import { PayloadAction, createSlice } from "@reduxjs/toolkit";
import { BooksState } from "../types/State";
import { Book, EditBook } from "../types/Action";
import { uid } from "uid";

const initialState: BooksState = {
    books: [
        {isbn: '1', title: 'Harry Potter', author: 'J.Rouling', year: 2002}
    ]
};

interface str {
    isbn: string
}

export const booksSlice = createSlice({
    name: 'books',
    initialState,
    reducers: {
        add: (state, action: PayloadAction<Book>) => {
            const newBook = {isbn: uid(), ...action.payload};
            state.books.push(newBook);
        },

        deleteBook: (state, action: PayloadAction<str>) => {
            const newBooks = state.books.filter(book => book.isbn !== action.payload.isbn);
            state.books = newBooks;
        },

        editTitle: (state, action: PayloadAction<EditBook>) => {
            const newBooks = state.books.map(book => {
                if (book.isbn === action.payload.isbn) {
                    return {...book, title: action.payload.title}
                }
                return book;
            });
            state.books = newBooks;
        }
    }
});

export default booksSlice.reducer;

export const { add, editTitle, deleteBook } = booksSlice.actions;