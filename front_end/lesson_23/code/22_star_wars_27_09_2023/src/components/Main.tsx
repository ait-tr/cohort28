import React, { useContext } from "react";
import { navItems } from "../utils";
import Home from "./Home";
import AboutMe from "./AboutMe";
import Contact from "./Contact";
import StarWars from "./StarWars";
import { CurrentPageContext } from "../App";

const Main: React.FC<{ currentPage: string }> = ({ currentPage }): JSX.Element => {
  
  const myStr = useContext(CurrentPageContext);
  console.log(myStr);
  
  switch (myStr) {
    case navItems[1]:
      return <AboutMe />;
    case navItems[2]:
      return <StarWars />;
    case navItems[3]:
      return <Contact />;
    default:
      return <Home />;
  }
};

export default Main;
