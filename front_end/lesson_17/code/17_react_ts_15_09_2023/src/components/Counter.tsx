import React, { FC, useState } from "react";

const Counter: FC = (): JSX.Element => {
    const [count, setCount] = useState<number>(0);

    const increment = (): void => {
        setCount(count + 1);
    }

    // const decrement = (): void => {
    //     setCount(count - 1);
    // }

    return (
        <>
            <h1>Counter: {count}</h1>
            <button onClick={increment}>Increment</button>
            <button onClick={(): void => setCount(count - 1)}>Decrement</button>
        </>
    );
};

export default Counter;