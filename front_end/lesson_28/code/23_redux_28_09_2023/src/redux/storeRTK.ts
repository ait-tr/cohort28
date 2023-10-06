import { configureStore } from "@reduxjs/toolkit";
import counterReducer from "./slices/counterSlice";
import booksReducer from "./slices/booksSlice";
import sandwichReducer from "./slices/sandwichSlice";

export const storeRTK = configureStore({
    reducer: {
        counter: counterReducer,
        books: booksReducer,
        sandwich: sandwichReducer
    }
})

export type RootState = ReturnType<typeof storeRTK.getState>;
export type AppDispatch = typeof storeRTK.dispatch