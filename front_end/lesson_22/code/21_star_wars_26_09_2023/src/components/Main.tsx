import React from "react";
import Hero from "./Hero";
import DreamTeam from "./DreamTeam";
import FarGalaxy from "./FarGalaxy";

const Main: React.FC = (): JSX.Element => {
  return (
        <main>
            <Hero />
            <DreamTeam />
            <FarGalaxy />
        </main>
  );
};

export default Main;
