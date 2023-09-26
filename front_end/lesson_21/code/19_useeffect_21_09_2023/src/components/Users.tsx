import React, { useEffect, useState } from "react";

interface IUser {
    id: number;
    name: string;
    username: string;
}

interface IAddress {
    city: string;
}

interface IUserDetails {
    id: number;
    name: string;
    username: string;
    email: string;
    address: IAddress;
    phone: string;
    company: {
        name: string;
    };
}

const Users = () => {
    const [users, setUsers] = useState<IUser[]>([]);
    const [userDetails, setUserDetails] = useState<IUserDetails | null>(null);
    
    useEffect(() => {
        fetch("https://jsonplaceholder.typicode.com/users")
            .then(response => response.json())
            .then(data => setUsers((data)));
    }, []);

    const handleUserClick = async (userId: number): Promise<void> => {
        const res = await fetch(`https://jsonplaceholder.typicode.com/users/${userId}`);
        const data = await res.json();
        setUserDetails(data);
    }

    const test = (): number => {   
        return 5;
    }

    console.log(test); // () => {return: 5}
    console.log(test()); // 5
    console.log(() => test()); // () => {return: 5}
    
    
    return (
        <div>
            <h1>Users List</h1>
            <ul>
                {users.map(({id, name, username}) => (
                    <li
                        key={id}
                        style={{ border: '1px solid black', width: '30%' }}
                        onClick={
                            () => handleUserClick(55) // функция, к-ая возвращает результат вызова функции handleUserClick с параметром id
                            // handleUserClick(id) // результат вызова функции
                            // handleUserClick // функция, подходит для подобной ситуации, когда функция не принимает параметров
                        }
                    >
                        <p>a. {name}</p>
                        <p>b. {username}</p>
                    </li>
                ))}
            </ul>

            <h1>User Details</h1>
            {userDetails && (
                <div>
                    <p>Email: {userDetails.email}</p>
                    <p>Address: {userDetails.address.city}</p>
                    <p>Phone: {userDetails.phone.split(' ')[0]}</p>
                    <p>Company: {userDetails.company.name}</p>
                </div>
            )}
        </div>
    );
};

export default Users;