package com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.TextBoxPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TextBoxTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getElements();
        new SidePanel(driver).selectTextBox().hideIframes();
    }

    @Test
    @Parameters({"name","email","address"})
    public void keyBoardEventTest(String name, String email, String address) {
        new TextBoxPage(driver).enterPersonalData(name,email)
                .keyBoardEvent(address)
                .submit()
                .assertCopyPastAddress();
    }
}
