import React from "react";
import "./App.css";
import Board from "./components/Board";
import { Provider } from "react-redux";
import store from "./store"; // внутри папки по дефолту импортируется файл с именем index

function App() {
    return (
        <Provider store={store}>
            <div className="App">
                <Board />
            </div>
        </Provider>
    );
}

export default App;
