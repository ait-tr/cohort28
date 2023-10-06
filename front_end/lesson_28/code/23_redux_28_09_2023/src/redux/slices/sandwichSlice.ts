import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { SandwichState } from "../types/State";

const initialState: SandwichState = {
    ingredients: ''
}

export const sandwichSlice = createSlice({
    name: 'sandwich',
    initialState,
    reducers: {
        addIngredient: (state, action: PayloadAction<string>) => {
            state.ingredients += ` ${action.payload}`;
        },

        clear: (state) => {
            state.ingredients = '';
        }
    }
})

export const { addIngredient, clear } = sandwichSlice.actions;

export default sandwichSlice.reducer;