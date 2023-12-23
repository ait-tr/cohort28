package com.demoqa.tests;

import com.demoqa.pages.DroppablePage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getInteractions();
        new SidePanel(driver).slelectDroppable().hideIframes();
    }

    @Test
    public void dragMeTest() {
        new DroppablePage(driver).actionDragMe()
                .assertDropped("Dropped!");
    }

    @Test
    public void dragMeByTest() {
        new DroppablePage(driver).actionDragMeBy(30,50)
                .assertDropped("Dropped!")
        ;
    }
}
