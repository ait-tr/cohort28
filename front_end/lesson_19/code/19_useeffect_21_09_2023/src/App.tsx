import React from "react";
import "./App.css";
import Counter from "./components/Counter";

function App() {
    return (
        <>
            <Counter initialValue={100}/>
            {/* <Counter initialValue={0} />
            <Counter initialValue={10}/>

            <ClassComponent /> */}
        </>
    );
}

export default App;
