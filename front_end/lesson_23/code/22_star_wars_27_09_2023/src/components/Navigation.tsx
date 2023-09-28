import React from "react";
import { navItems } from "../utils";
import NavItem from "./NavItem";

const Navigation: React.FC<{changePage: (currentPage: string) => void}> = ({ changePage }) => {
    return (
        <nav>
            <ul>
                {navItems.map((navItem, index) => (
                    <NavItem itemTitle={navItem} key={index} changePage={changePage}/>
                ))}
            </ul>
        </nav>
    );
};

export default Navigation;
