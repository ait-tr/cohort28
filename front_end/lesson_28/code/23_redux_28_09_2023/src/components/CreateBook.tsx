import React, { useState, FormEvent } from "react";
import { useDispatch } from "react-redux";
import { add } from "../redux/slices/booksSlice";

const CreateBook: React.FC = (): JSX.Element => {
    const [title, setTitle] = useState<string>("");
    const [author, setAuthor] = useState<string>("");
    const [year, setYear] = useState<string>("");

    const dispatch = useDispatch();

    const handleSubmit = (e: FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        dispatch(add({author, year: +year, title}));
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
