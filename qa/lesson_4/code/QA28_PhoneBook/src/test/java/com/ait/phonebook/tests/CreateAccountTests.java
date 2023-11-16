package com.ait.phonebook.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateNewAccountTests extends TestBase{

    //precondition: user should be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.cssSelector("[href='/login']"))) {
            driver.findElement(By.xpath("//button[.='Sign Out']")).click();
        }
    }

    @Test
    public void registerExistedUserNegativeTest(){
        //click on Login link
        driver.findElement(By.cssSelector("[href='/login']")).click();
        //enter email
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("neuer@gm.com");
        //enter password
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("Neuer1234$");
        //click on Registration button
        driver.findElement(By.name("registration")).click();
        //assert Alert is present
        Assert.assertTrue(isAlertPresent());
    }

    public boolean isAlertPresent() {

        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            return true;
        }
    }
}
