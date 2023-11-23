package com.ait.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{

    @Test
    public void isHomeComponentPresentTest() {
        //System.out.println("Home Component is " + isHomeComponentPresent());
        Assert.assertTrue(app.getHomePage().isHomeComponentPresent());
    }

}
