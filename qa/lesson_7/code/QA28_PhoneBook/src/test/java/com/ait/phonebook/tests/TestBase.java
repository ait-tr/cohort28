package com.ait.phonebook.tests;

import com.ait.phonebook.fw.ApplicationManager;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.*;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser",
            Browser.CHROME.browserName()));

    // @BeforeMethod
    @BeforeSuite
    public void setUp() {
        app.init();
        System.out.println("Before Suite!");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("*****Before Test!");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("*****After Test!");
    }



    // @AfterMethod(enabled = true)
    @AfterSuite
    public void tearDown() {
        app.stop();
        System.out.println("After Suite!");
    }

}
