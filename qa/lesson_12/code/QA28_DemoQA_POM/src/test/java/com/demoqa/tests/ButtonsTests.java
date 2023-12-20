package com.demoqa.tests;

import com.demoqa.pages.ButtonsPage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getElements();
        new SidePanel(driver).selectButtons();
    }

    @Test
    public void doubleClickTest() {
        new ButtonsPage(driver).doubleClick().assertDoubleClick("You have done a double click");
    }
}
