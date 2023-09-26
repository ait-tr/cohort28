import React, { useEffect, useState } from "react";

interface ITodo {
    userId: number;
    id: number;
    title: string;
    completed: boolean;
}

const Todo = () => {
    const [todo, setTodo] = useState<ITodo[]>([]);

    useEffect(() => {
        fetch("https://jsonplaceholder.typicode.com/todos")
            .then((response) => response.json())
            .then((data) => setTodo(data));
    }, []);

    return (
        <div>
            <h1>Todo List</h1>
            <ul>
                {todo.map(({ userId, id, title, completed }) => (
                    <li
                        key={id}
                        style={{ border: "1px solid black", width: "30%" }}
                    >
                        <p>Пользователь: {userId}</p>
                        <p
                          style={ completed ? { textDecoration: 'line-through' } : {}}
                        >Задача: {title}</p>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default Todo;
