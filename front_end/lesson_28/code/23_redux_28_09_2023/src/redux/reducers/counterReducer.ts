import Action from "../types/Action";
import { CounterState } from "../types/State";

const initialState: CounterState = {
    value: 0
}

// Передаём дефолтное значение для State
export default function counterReducer(
    state: CounterState = initialState,
    action: Action
): CounterState
    {
        switch (action.type) {
            case 'counter/minus':
                return {...state, value: state.value - 1};
            case 'counter/plus':
                return {...state, value: state.value + action.payload};
            default:
                return state;
        }
}


// Comments:
// console.log({a: 10, b: 20, a: 30})   // output {a: 30, b: 20}

const sum = (a: number, b: number | 'Error' = 5) => {
    if (typeof b === 'number') {
        return a + b;   
    }
};

console.log(sum(10));