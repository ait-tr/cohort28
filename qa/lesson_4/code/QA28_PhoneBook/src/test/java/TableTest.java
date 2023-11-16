package com.ait.qa28;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TableTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/css/css_table.asp");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void tableCssTest() {
        //get row 8, last element
        WebElement canada = driver.findElement(By.cssSelector("#customers tr:nth-child(8) td:last-child"));
        System.out.println(canada.getText());
        System.out.println("======================================================");

        //print numbers of rows
        List<WebElement> rows = driver.findElements(By.cssSelector("tr"));
        System.out.println(rows.size());
        for (WebElement el: rows) {
            System.out.println(el.getText());
        }

    }
}


