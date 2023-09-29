import { createStore, combineReducers } from 'redux';
import counterReducer from './reducers/counterReducer';
import sandwichReducer from './reducers/sandwichReducer';
import booksReducer from './reducers/booksReducer';

const store = createStore(combineReducers({
    counter: counterReducer,
    sandwich: sandwichReducer,
    books: booksReducer
}));

export default store;

export type RootState = ReturnType<typeof store.getState>;