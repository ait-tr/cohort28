package com.remindly.tests;

import com.remindly.fw.ApplicationManager;
import com.remindly.models.Reminder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();

    protected static final Reminder reminder = Reminder.builder()
            .title("Holiday")
            .period("future").month("MAR").number(2)
            .index(7)
            .period2("future").year("2026")
            .timeOfDay("pm").XHour(812).YHour(930).XMin(538).YMin(653)
            .repeat("2")
            .start(0.8).stop(0.4)
            .typeRep("Week")
            .build();

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }

}

