import React, {createContext, useState} from 'react';
import './App.css';
import Header from './components/Header';
import Main from './components/Main';
import Footer from './components/Footer';
import { navItems } from './utils';

export const PageContext = createContext((currentPage: string) => {});

function App() {
  const [currentPage, setCurrentPage] = useState<string>(navItems[0]);

  console.log(currentPage);
  

  const changePage = (currentPage: string) => {
    setCurrentPage(currentPage);
  }

  return (
    <>
        <PageContext.Provider value={changePage}>
          <Header changePage={changePage} />
          <Main />
          <Footer />
        </PageContext.Provider>
    </>
  );
}

export default App;
