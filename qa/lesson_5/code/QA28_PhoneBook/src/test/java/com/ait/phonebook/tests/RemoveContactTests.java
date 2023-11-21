package com.ait.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        //precondition: User should be logged out
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }
        //click on Login link
        clickOnLoginLink();
        //login
        fillLoginRegisterForm("manuel@gm.com", "Manuel1234$");
        //click on Login button
        clickOnLoginButton();
        //click on Add link
        click(By.cssSelector("[href='/add']"));
        type(By.cssSelector("input:nth-child(1)"), "Karl");
        type(By.cssSelector("input:nth-child(2)"), "Adam");
        type(By.cssSelector("input:nth-child(3)"), "123456789012");
        type(By.cssSelector("input:nth-child(4)"), "adam@gm.co");
        type(By.cssSelector("input:nth-child(5)"), "Koblenz");
        type(By.cssSelector("input:nth-child(6)"), "goalkeeper");
        //click on Save button
        click(By.cssSelector(".add_form__2rsm2 button"));
    }

    @Test
    public void removeContactPositiveTest() {
        //get size of contacts before remove
        int sizeBefore = sizeOfContacts();
        //click on Contact card
        click(By.cssSelector(".contact-item_card__2SOIM"));
        //click on Remove button
        click(By.xpath("//button[.='Remove']"));
        pause(1000);
        //get size of contacts after remove
        int sizeAfter = sizeOfContacts();
        //assert: Contact is removed by size
        Assert.assertEquals(sizeAfter, sizeBefore - 1);
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int sizeOfContacts() {
        if (isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))) {
            return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        }
        return 0;
    }

}
