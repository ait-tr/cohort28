package com.ait.phonebook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddNewContactTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        //precondition: User should be logged out
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }
        //click on Login link
        clickOnLoginLink();
        //enter email
        fillLoginRegisterForm("manuel@gm.com", "Manuel1234$");
        //click on Login button
        clickOnLoginButton();
    }

    @Test
    public void addNewContactPositiveTest() {
        //click on Add link
        click(By.cssSelector("[href='/add']"));
        //enter name
        type(By.cssSelector("input:nth-child(1)"),"Karl");
        //enter lastname
        type(By.cssSelector("input:nth-child(2)"),"Adam");
        //enter phone
        type(By.cssSelector("input:nth-child(3)"),"123456789012");
        //enter email
        type(By.cssSelector("input:nth-child(4)"),"adam@gm.co");
        //enter address
        type(By.cssSelector("input:nth-child(5)"),"Koblenz");
        //enter description
        type(By.cssSelector("input:nth-child(6)"),"goalkeeper");
        //click on Save button
        click(By.cssSelector(".add_form__2rsm2 button"));
        //assert contact added by text
        Assert.assertTrue(isContactCreatedByText("Karl"));
    }

    public boolean isContactCreatedByText(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for (WebElement element: contacts) {
            if (element.getText().contains(text))
                return true;
        }
        return false;
    }
}
