import React, { FC, useState, useEffect } from "react";

interface ICounterProps {
    initialValue: number;
}

interface IJson {
    userId: number;
    id: number;
    title: string;
    completed: boolean;
}

const Counter: FC<ICounterProps> = ({ initialValue }): JSX.Element => {
    const [count, setCount] = useState<number>(initialValue);
    // {userId: 1, id: 1, title: 'delectus aut autem', completed: false}
    const [json, setJson] = useState<IJson | null>(null);

    useEffect(() => {
        console.log("Компонент смонтирован");
        fetch("https://jsonplaceholder.typicode.com/todos/1")
            .then((response) => response.json())
            .then((data) => setJson(data));
        
    }, []);

    useEffect(() => {
        return () => {
            console.log("Компонент размонтирован");
        };
    }, []);

    useEffect(() => {
        console.log("Компонент обновлён");
    }, [count]);

    const increment = (): void => {
        setCount(count + 1);
    };

    // const decrement = (): void => {
    //     setCount(count - 1);
    // }

    // if (json !== null) {
    //     return (
    //         <>
    //             {json.id} {json.completed} {json.title} {json.userId}
    //             <h1>Counter: {count}</h1>
    //             <button onClick={increment}>Increment</button>
    //             <button onClick={(): void => setCount(count - 1)}>
    //                 Decrement
    //             </button>
    //         </>
    //     );
    // }

    return (
        <>
            {
                json && 
                <>
                    {json.id} {json.completed} {json.title} {json.userId}
                </>
            }
            <h1>Counter: {count}</h1>
            <button onClick={increment}>Increment</button>
            <button onClick={(): void => setCount(count - 1)}>Decrement</button>
        </>
    );
};

export default Counter;
