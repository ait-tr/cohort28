import React from "react";
import { useSelector, useDispatch } from "react-redux";
import Square from "./Square";
import {
    calculateWinner,
    handleClick,
    selectSquares,
} from "../store/boardSlice";

const Board: React.FC = (): JSX.Element => {
    const squares = useSelector(selectSquares);
    const dispatch = useDispatch();
    const winner = calculateWinner(squares);

    const renderSquare = (i: number) => (
        <Square
            value={squares[i]}
            onClick={() => dispatch(handleClick(i))}
        />
    );

    // const sum = (a: number, b: number) => a + b
    
    // const sum = (a: number, b: number) => {
    //     console.log('Hello from func sum');
    //     return a + b;
    // }

    const renderResult = (): JSX.Element | null => {
        if (winner === 'Draw') {
            return <div className="result">It's a draw!</div>;
        } else if (winner) {
            return <div className="result">Winner: {winner}</div>;
        } else {
            return null;
        }

        // switch (winner) {
        //     case 'Draw':
        //         return <div className="result">It's a draw!</div>;
        //     case 'X':
        //     case 'O':
        //         return <div className="result">Win {winner}!</div>;
        //     default:
        //         return null;
        // }
    }

    const restartGame = () => dispatch(handleClick(-1));

    return (
        <div className="board">
            <div className="board-row">
                {renderSquare(0)}
                {renderSquare(1)}
                {renderSquare(2)}
            </div>
            <div className="board-row">
                {renderSquare(3)}
                {renderSquare(4)}
                {renderSquare(5)}
            </div>
            <div className="board-row">
                {renderSquare(6)}
                {renderSquare(7)}
                {renderSquare(8)}
            </div>
            {/* {renderResult()} */}
            {winner && (
                winner === 'Draw' ?
                    <div className="result">It's a draw!</div> :
                    <div className="result">It's a {winner}!</div>
            )
                }
            <button className="restart-button" onClick={restartGame}>
                Restart Game
            </button>
        </div>
    );
};

export default Board;

// const check = (p: number) => {
//     return 28 / p;
// }
