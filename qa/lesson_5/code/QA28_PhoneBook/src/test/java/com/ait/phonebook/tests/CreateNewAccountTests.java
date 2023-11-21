package com.ait.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateNewAccountTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }
    }

    @Test
    public void registerExistedUserNegativeTest(){

        clickOnLoginLink();

        fillLoginRegisterForm("manuel@gm.com", "Manuel1234$");

        clickOnRegistrationButton();

        Assert.assertTrue(isAlertPresent());
    }

}
