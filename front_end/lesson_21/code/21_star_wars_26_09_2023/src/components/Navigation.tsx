import React from "react";
import { navItems } from "../utils";
import NavItem from "./NavItem";

const Navigation = () => {
    return (
        <nav>
            <ul>
                {navItems.map((navItem, index) => (
                    <NavItem itemTitle={navItem} key={index} />
                ))}
            </ul>
        </nav>
    );
};

export default Navigation;
