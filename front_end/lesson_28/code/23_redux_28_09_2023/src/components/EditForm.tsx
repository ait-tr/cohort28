import React, { FC, FormEvent, useState } from "react";
import { useDispatch } from "react-redux";
import { editTitle } from "../redux/slices/booksSlice";

interface IProps {
    isbn: string
}

const EditForm: FC<IProps> = (props): JSX.Element => {
    const { isbn } = props;
    const [title, setTitle] = useState<string>('');
    const dispatch = useDispatch();

    const handleSubmit = (e: FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        dispatch(editTitle({isbn, title}));
    }

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="title"
                    value={title}
                    onChange={(e) => setTitle(e.target.value)}
                />
                <button type="submit">Edit</button>
            </form>
        </div>
    );
};

export default EditForm;
