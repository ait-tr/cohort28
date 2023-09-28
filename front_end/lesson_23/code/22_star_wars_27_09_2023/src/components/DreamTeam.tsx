import React from "react";
import { friends } from "../utils";
import Friend from "./Friend";

const DreamTeam = () => {
    return (
        <section className="right">
            <h2>Dream Team</h2>
            {friends.map((item, index) => (
                <Friend photo={item} number={index+1} key={index} />
            ))}

            {/* <img src={friends[0]} alt="friend1" />
            <img src={friends[1]} alt="friend2" />
            <img src={friends[2]} alt="friend3" />
            <img src={friends[3]} alt="friend4" />
            <img src={friends[4]} alt="friend5" />
            <img src={friends[5]} alt="friend6" />
            <img className="bottomLeft" src={friends[6]} alt="friend7" />
            <img src={friends[7]} alt="friend8" />
            <img className="bottomRight" src={friends[8]} alt="friend9" /> */}
        </section>
    );
};

export default DreamTeam;
