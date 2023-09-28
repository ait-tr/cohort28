import React from "react";
import Navigation from "./Navigation";

const Header: React.FC<{changePage: (currentPage: string) => void}> = ({ changePage }) => {
    return (
        <header>
            <Navigation changePage={changePage} />
            <h1>Luke Skywalker</h1>
        </header>
    );
};

export default Header;