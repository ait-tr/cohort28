import React, { useEffect, useState } from "react";

interface IComment {
    postId: number;
    id: number;
    email: string;
    body: string;
}

const Comments = () => {
    const [comments, setComments] = useState<IComment[]>([]);
    
    useEffect(() => {
        fetch("https://jsonplaceholder.typicode.com/comments")
            .then(response => response.json())
            .then(data => setComments((data)));
    }, []);
    
    return (
        <div>
            <h1>Comments List</h1>
            <ul>
                {comments.map(({body, email, id, postId}) => (
                    <li key={id} style={{ border: '1px solid black', width: '30%' }}>
                        <p>Комментарий от пользователя с емэйлом: {email}, под постом: {postId}</p>
                        <p>Текст комментария: {body}</p>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default Comments;