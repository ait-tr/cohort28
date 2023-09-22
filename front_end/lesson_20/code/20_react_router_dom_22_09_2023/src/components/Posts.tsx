import React, { useEffect, useState } from "react";

interface IPost {
    userId: number;
    id: number;
    body: string;
}

const Posts = () => {
    const [posts, setPosts] = useState<IPost[]>([]);
    
    useEffect(() => {
        fetch("https://jsonplaceholder.typicode.com/posts")
            .then(response => response.json())
            .then(data => setPosts((data)));
    }, []);
    
    return (
        <div>
            <h1>Posts List</h1>
            <ul>
                {posts.map(({body, id, userId}) => (
                    <li key={id} style={{ border: '1px solid black', width: '30%' }}>
                        <p>Сообщение от: {userId}</p>
                        <p>Текст сообщения: {body}</p>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default Posts;