import { createSlice, PayloadAction } from '@reduxjs/toolkit';

interface BoardState {
    squares: Array<string | null>;
    xIsNext: boolean;
}

const initialState: BoardState = {
    squares: Array(9).fill(null),
    xIsNext: true
};

const boardSlice = createSlice({
    name: 'board',
    initialState, // initialState: initialState
    reducers: {
        handleClick: (state, action: PayloadAction<number>) => {
            if (action.payload === -1) {
                state.squares = Array(9).fill(null);
                state.xIsNext = true;
            }

            const squares = [...state.squares];

            if (calculateWinner(squares) || squares[action.payload]) {
                return;
            }

            squares[action.payload] = state.xIsNext ? 'X' : 'O';
            state.squares = squares;
            state.xIsNext = !state.xIsNext;
        }
    }
})

// const obj = {
//     age: 43,
//     nickName: 'Boris',
//     greeting: {
//         hello: () => console.log('Hello')
//     }   
// }

// const helloFunc = obj.greeting.hello;
// const { hello } = obj.greeting;

// console.log(hello);
// console.log(helloFunc);

export const { handleClick } = boardSlice.actions;

export const selectSquares = ((state: { board: BoardState }) => state.board.squares);

export default boardSlice.reducer;

export function calculateWinner(squares: Array<string | null>): string | null {
    const lines = [
        [0, 1, 2],
        [3, 4, 5],
        [6, 7, 8],
        [0, 3, 6],
        [1, 4, 7],
        [2, 5, 8],
        [0, 4, 8],
        [2, 4, 6]
    ];

    // for (let i = 0; i < lines.length; i++) {
    //     if (squares[lines[i][0]] &&
    //         squares[lines[i][0]] === squares[lines[i][1]] &&
    //         squares[lines[i][1]] === squares[lines[i][2]]
    //         ) {
    //             return squares[lines[i][0]]
    //         }
        
    // }

    for (const [a, b, c] of lines) {
        if (
            squares[a] &&
            squares[a] === squares[b] &&
            squares[b] === squares[c]
        ) {
            return squares[a];
        };
    };

    if (squares.every(square => square !== null)) {
        return 'Draw';
    };

    return null;
}