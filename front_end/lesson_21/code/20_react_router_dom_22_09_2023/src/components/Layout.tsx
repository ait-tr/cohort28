import React from "react";
import { Link, Outlet } from 'react-router-dom';

const Layout = () => {
    return (
        <>
            <nav>
                <ul>
                    <li>
                        <Link to='/'>Users</Link>
                    </li>
                    <li>
                        <Link to='/posts'>Posts</Link>
                    </li>
                    <li>
                        <Link to='/comments'>Comments</Link>
                    </li>
                    <li>
                        <Link to='/todo'>Todo</Link>
                    </li>
                </ul>
            </nav>

            <Outlet />
        </>
    );
};

export default Layout;
