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

    return (
        <div className="board">
            <div className="board-row">
                <Square
                    value={squares[0]}
                    onClick={() => dispatch(handleClick(0))}
                />
                <Square
                    value={squares[1]}
                    onClick={() => dispatch(handleClick(1))}
                />
                <Square
                    value={squares[2]}
                    onClick={() => dispatch(handleClick(2))}
                />
            </div>
            <div className="board-row">
                <Square
                    value={squares[3]}
                    onClick={() => dispatch(handleClick(3))}
                />
                <Square
                    value={squares[4]}
                    onClick={() => dispatch(handleClick(4))}
                />
                <Square
                    value={squares[5]}
                    onClick={() => dispatch(handleClick(5))}
                />
            </div>
            <div className="board-row">
                <Square
                    value={squares[6]}
                    onClick={() => dispatch(handleClick(6))}
                />
                <Square
                    value={squares[7]}
                    onClick={() => dispatch(handleClick(7))}
                />
                <Square
                    value={squares[8]}
                    onClick={() => dispatch(handleClick(8))}
                />
            </div>
        </div>
    );
};

export default Board;


const check = (p: number) => {
    return 28 / p;
}