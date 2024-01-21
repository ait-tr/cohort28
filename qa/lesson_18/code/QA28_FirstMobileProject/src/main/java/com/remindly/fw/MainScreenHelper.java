package com.remindly.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import java.util.Collection;

public class MainScreenHelper extends BaseHelper{
    public MainScreenHelper(AppiumDriver driver) {
        super(driver);
    }

    public boolean isMainScreenMessagePresent() {
        return isElementPresent(By.id("no_reminder_text"));
    }

    public void tapOnAddReminderButton() {
        tap(By.id("add_reminder"));
    }

    public String isReminderTitlePresent() {
        String text = driver.findElement(By.id("recycle_title")).getText();
        return text;
    }

    public String isReminderDatePresent() {
        return driver.findElement(By.id("recycle_date_time")).getText();    }
}
