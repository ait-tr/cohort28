package com.demoqa.tests;

import com.demoqa.pages.AlertsPage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getAlertsFrameWindows();
        new SidePanel(driver).selectAlerts().hideIframes();
    }

    @Test
    public void waitAlertTest() {
        new AlertsPage(driver).clickOnAlertWithTimer();
    }

    @Test
    public void alertWithSelectTest() {
        new AlertsPage(driver).selectResult("Cancel").verifyResult("Cancel");
    }

    @Test
    public void sendMessageToAlertTest() {
        new AlertsPage(driver).sendMessageToAlert("Hello World!").verifyMessage("Hello World!");
    }

}
