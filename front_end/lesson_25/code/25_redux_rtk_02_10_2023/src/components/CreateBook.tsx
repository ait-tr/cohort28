import React, { useState, FormEvent } from "react";
import { useDispatch } from "react-redux";

const CreateBook: React.FC = (): JSX.Element => {
    const [title, setTitle] = useState<string>("");
    const [author, setAuthor] = useState<string>("");
    const [year, setYear] = useState<string>("");

    const dispatch = useDispatch();

    const handleSubmit = (e: FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        dispatch({ type: 'books/add', payload: { title, author, year: +year } });
        setTitle('');
        setAuthor('');
        setYear('');
    };

    return (
        <div>
            <h1>Create Book</h1>

            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="title"
                    value={title}
                    onChange={(e) => setTitle(e.target.value)}
                />
                <input
                    type="text"
                    placeholder="author"
                    value={author}
                    onChange={(e) => setAuthor(e.target.value)}
                />
                <input
                    type="number"
                    placeholder="year"
                    value={year}
                    onChange={(e) => setYear(e.target.value)}
                />
                <button type="submit"> Create </button>
            </form>
        </div>
    );
};

export default CreateBook;
