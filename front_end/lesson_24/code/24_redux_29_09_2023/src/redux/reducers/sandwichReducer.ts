import { ActionSandwich } from "../types/Action";
import { SandwichState } from "../types/State";

const initialState: SandwichState = {
    ingredients: ''
}

export default function sandwichReducer(
    state = initialState,
    action: ActionSandwich
    ): SandwichState {
        switch (action.type) {
            case 'sandwich/addIngredient':
                return {...state, ingredients: `${state.ingredients} ${action.payload}`}
            case 'sandwich/clear':
                return {...state, ingredients: ''}
            default:
                return state;
        }
}