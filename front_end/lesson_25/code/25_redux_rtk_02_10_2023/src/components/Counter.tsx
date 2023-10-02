import React from "react";
import { useSelector, useDispatch } from "react-redux";
import { RootState } from "../redux/storeRTK";
import { decrement, increment } from "../redux/slices/counterSlice";

const Counter: React.FC = (): JSX.Element => {

    const counter = useSelector((state: RootState) => state.counter.value);
    const dispatch = useDispatch();

    // console.log(useSelector((state: RootState) => state.sandwich.ingredients));
    

    const handleMinus = ():void => {
        dispatch(decrement());
    }

    const handlePlus = ():void => {
        dispatch(increment(1));
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
