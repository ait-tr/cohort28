package com.ait.phonebook.tests;

import com.ait.phonebook.models.Contact;
import com.ait.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddNewContactTests extends TestBase{

//    @BeforeClass
//    public void beforeClass() {
//        System.out.println("*********************Before Class!");
//    }
//
//    @AfterClass
//    public void afterClass() {
//        System.out.println("********************After Class!");
//    }

    @BeforeMethod
    public void ensurePrecondition() {
        //  System.out.println("***************************************Before Method!");
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

    @DataProvider
    public Iterator<Object[]> addNewContact() {
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{"Oliver","Kan","1234567890","kan@gm.com","Berlin","goalkeeper"});
        list.add(new Object[]{"Oliver1","Kan","1234567891","kan1@gm.com","Berlin","goalkeeper"});
        list.add(new Object[]{"Oliver2","Kan","1234567892","kan2@gm.com","Berlin","goalkeeper"});
        return list.iterator();
    }

    @Test(dataProvider = "addNewContact")
    public void addNewContactFromDataProviderPositiveTest(String name, String lastname, String phone,
                                                          String email, String address, String desc) {
        app.getContact().clickOnAddLink();

        app.getContact().fillContactForm(new Contact()
                .setName(name)
                .setLastname(lastname)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setDescription(desc));

        app.getContact().clickOnSaveButton();
    }

    @DataProvider
    public Iterator<Object[]> addNewContactFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader
                (new File("src/test/resources/contacts.csv")));

        String line = reader.readLine();
        while (line!=null) {
            String[] split = line.split(",");

            list.add(new Object[]{new Contact().setName(split[0]).setLastname(split[1]).setPhone(split[2])
                    .setEmail(split[3]).setAddress(split[4]).setDescription(split[5])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test(dataProvider = "addNewContactFromCSV")
    public void addNewContactFromDataProviderCSWPositiveTest(Contact contact) {
        app.getContact().clickOnAddLink();

        app.getContact().fillContactForm(contact);

        app.getContact().clickOnSaveButton();
    }

}
