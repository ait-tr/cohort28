import React from 'react';
import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Layout from './components/Layout';
import Posts from './components/Posts';
import Comments from './components/Comments';
import Users from './components/Users';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<Layout />}>
          <Route index element={<Users />} />
          <Route path='/posts' element={<Posts />} />
          <Route path='/comments' element={<Comments />} />
          {/* <Route path='/todo' element={<Comments />} /> */}
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
