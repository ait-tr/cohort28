import React, { useEffect, useState } from "react";

interface IUser {
    id: number;
    name: string;
    username: string;
}

const Users = () => {
    const [users, setUsers] = useState<IUser[]>([]);
    
    useEffect(() => {
        fetch("https://jsonplaceholder.typicode.com/users")
            .then(response => response.json())
            .then(data => setUsers((data)));
    }, []);
    
    return (
        <div>
            <h1>Users List</h1>
            <ul>
                {users.map(({id, name, username}) => (
                    <li key={id} style={{ border: '1px solid black', width: '30%' }}>
                        <p>a. {name}</p>
                        <p>b. {username}</p>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default Users;