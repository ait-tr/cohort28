import React from "react";
import { useSelector, useDispatch } from "react-redux";
import { RootState } from "../redux/store";

const Counter: React.FC = (): JSX.Element => {

    const counter = useSelector((state: RootState) => state.counter.value);
    const dispatch = useDispatch();

    const handleMinus = ():void => {
        dispatch({ type: 'counter/minus', payload: 1 });
    }

    const handlePlus = ():void => {
        dispatch({ type: 'counter/plus', payload: 1 });
    }

    return (
        <>
            <div>Counter: {counter}</div>
            <button onClick={handleMinus}>-1</button>
            <button onClick={handlePlus}>+1</button>
        </>
    );
};

export default Counter;
