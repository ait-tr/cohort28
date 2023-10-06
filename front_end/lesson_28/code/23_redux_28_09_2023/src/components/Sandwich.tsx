import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { RootState } from "../redux/storeRTK";
import { addIngredient, clear } from "../redux/slices/sandwichSlice";

const Sandwich: React.FC = (): JSX.Element => {

    const ingredients = useSelector((state: RootState) => state.sandwich.ingredients);
    const dispatch = useDispatch();

    // console.log(useSelector((state: RootState) => state.counter.value));
    

    const handleAddBread = (): void => {
        dispatch(addIngredient('bread'));
    }

    const handleAddCheese = (): void => {
        dispatch(addIngredient('cheese'));
    }

    const handleAddSalami = (): void => {
        dispatch(addIngredient('salami'));
    }

    return (
        <>
            <h1>Choose your sandwich:</h1>
            <p>Sandwich: { ingredients } </p>
            <button onClick={handleAddBread}>Add Bread</button>
            <button onClick={handleAddCheese}>Add Cheese</button>
            <button onClick={handleAddSalami}>Add Salami</button>
            <button onClick={() => dispatch(clear())}>Delete All</button>
        </>
    );
};

export default Sandwich;