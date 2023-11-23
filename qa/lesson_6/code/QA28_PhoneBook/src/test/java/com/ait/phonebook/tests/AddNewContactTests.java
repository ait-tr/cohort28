package com.ait.phonebook.tests;

import com.ait.phonebook.models.Contact;
import com.ait.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail("manuel@gm.com")
                .setPassword("Manuel1234$"));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addNewContactPositiveTest() {
        app.getContact().clickOnAddLink();

        app.getContact().fillContactForm(new Contact()
                .setName("Karl")
                .setLastname("Adam")
                .setPhone("123456789012")
                .setEmail("adam@gm.co")
                .setAddress("Koblenz")
                .setDescription("goalkeeper"));

        app.getContact().clickOnSaveButton();

        Assert.assertTrue(app.getContact().isContactCreatedByText("Karl"));
    }

    @AfterMethod
    public void postCondition() {
        app.getContact().removeContact();
    }

}
