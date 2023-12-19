package com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.LinksPage;
import com.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinksTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getElements();
    }

    @Test
    public void getAllLinksTest() {
        new SidePanel(driver).selectLinks().hideIframes();
        new LinksPage(driver).getAllLinks();
    }

    @Test
    public void checkBrokenLinksTest() {
        new SidePanel(driver).selectBrokenLinks();
        new LinksPage(driver).checkBrokenLinks();
    }

    @Test
    public void checkBrokenImagesTest() {
        new SidePanel(driver).selectBrokenLinks();
        new LinksPage(driver).checkBrokenImages();
    }
}
