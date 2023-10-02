import React from "react";
import { useSelector } from "react-redux";
import { RootState } from "../redux/store";
import EditForm from "./EditForm";

const BooksPage: React.FC = (): JSX.Element => {
    const books = useSelector((state: RootState) => state.books.books);

    return (
        <div>
            <h1>Books in our library:</h1>
            <ul>
                {books.map(book => (
                    <li key={book.isbn}>
                        <p>{book.title}</p>
                        <p>{book.author}</p>
                        <p>{book.year}</p>
                        <EditForm isbn={book.isbn} />
                    </li>
                ))}
                
            </ul>
        </div>
    );
};

export default BooksPage;
