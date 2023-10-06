import { createSlice, PayloadAction } from '@reduxjs/toolkit';

const initialState = {
    value: 0
}

export const counterSlice = createSlice({
    name: 'counter',
    initialState,
    reducers: {
        increment: (state, action: PayloadAction<number>) => {
            state.value += action.payload;
        },
        decrement: (state) => {
            state.value -= 1;
        }
    }
});

export const { decrement, increment } = counterSlice.actions;

export default counterSlice.reducer