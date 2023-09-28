import React, { createContext, useState } from "react";
import "./App.css";
import Header from "./components/Header";
import Main from "./components/Main";
import Footer from "./components/Footer";
import { navItems } from "./utils";

export const PageContext = createContext((currentPage: string) => {});
export const CurrentPageContext = createContext("");

function App() {
    const [currentPage, setCurrentPage] = useState<string>(navItems[0]);

    // console.log(currentPage);

    const changePage = (currentPage: string) => {
        setCurrentPage(currentPage);
    };

    return (
        <>
            <PageContext.Provider value={changePage}>
                <CurrentPageContext.Provider value={currentPage}>
                    <Header changePage={changePage} />
                    <Main currentPage={currentPage} />
                    <Footer />
                </CurrentPageContext.Provider>
            </PageContext.Provider>
        </>
    );
}

export default App;
