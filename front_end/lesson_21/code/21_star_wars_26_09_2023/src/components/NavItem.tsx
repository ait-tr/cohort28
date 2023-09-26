import React, {FC} from "react";

const NavItem: FC<{itemTitle: string}> = ({ itemTitle }) => {
  return <li className="commonButton">{itemTitle}</li>;
};

export default NavItem;
