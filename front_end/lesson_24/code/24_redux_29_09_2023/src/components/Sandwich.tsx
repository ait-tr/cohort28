import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { RootState } from "../redux/store";

const Sandwich: React.FC = (): JSX.Element => {

    const ingredients = useSelector((state: RootState) => state.sandwich.ingredients);
    const dispatch = useDispatch();

    // console.log(useSelector((state: RootState) => state.counter.value));
    

    const handleAddBread = (): void => {
        dispatch({ type: 'sandwich/addIngredient', payload: 'bread' });
    }

    const handleAddCheese = (): void => {
        dispatch({ type: 'sandwich/addIngredient', payload: 'cheese' });
    }

    const handleAddSalami = (): void => {
        dispatch({ type: 'sandwich/addIngredient', payload: 'salami' });
    }

    const handleDelete = (): void => {
        dispatch({ type: 'sandwich/clear' });
    }

    return (
        <>
            <h1>Choose your sandwich:</h1>
            <p>Sandwich: { ingredients } </p>
            <button onClick={handleAddBread}>Add Bread</button>
            <button onClick={handleAddCheese}>Add Cheese</button>
            <button onClick={handleAddSalami}>Add Salami</button>
            <button onClick={handleDelete}>Delete All</button>
        </>
    );
};

export default Sandwich;