package com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SelectMenuPage;
import com.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;

public class SelectMenuTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getWidgets();
        new SidePanel(driver).getSelectMenu();
    }

    @Test
    public void oldStyleSelectMenuTest() {
        new SelectMenuPage(driver).oldStyleSelectMenu("White");
    }
}
