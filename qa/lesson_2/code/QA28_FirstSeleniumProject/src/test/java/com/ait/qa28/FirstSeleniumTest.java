package com.ait.qa28;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    WebDriver driver;

    //before - setUp
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

    //test
    @Test
    public void openGoogleTest() {
        System.out.println("Site opened!!!");
    }

    //after - tearDown
}
