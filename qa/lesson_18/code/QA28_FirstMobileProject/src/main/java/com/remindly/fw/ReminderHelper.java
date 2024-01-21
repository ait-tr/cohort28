package com.remindly.fw;

import com.remindly.models.Reminder;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ReminderHelper extends BaseHelper{
    public ReminderHelper(AppiumDriver driver) {
        super(driver);
    }

    public void enterTitle(String text) {
        type(By.id("reminder_title"),text);
    }

    public void tapOnDateField() {
        tap(By.id("date"));
    }

    public void swipeToMonth(String period, String month, int number) {

        if (!getSelectedMonth().equals(month)) {
            for (int i = 0; i < number; i++) {
                if (period.equals("future")) {
                    swipe(0.8,0.4);
                } else if (period.equals("past")) {
                    swipe(0.5,0.8);
                }
            }
        }
    }

    public String getSelectedMonth() {
        return driver.findElement(By.id("date_picker_month")).getText();
    }

    public void selectDate(int index) {
        List<WebElement> days = driver.findElements(By.className("android.view.View"));
        days.get(index).click();
    }

    public void tapOnYear() {
        tap(By.id("date_picker_year"));
    }

    public void swipeToYear(String period2, String year) {
        if (!getSelectedYear().equals(year)) {
            if (period2.equals("future")) {
                swipeUntilNeededYear(year,0.6,0.5);
            } else if (period2.equals("past")) {
                swipeUntilNeededYear(year,0.5,0.6);
            }
        }
        tap(By.id("month_text_view"));
    }

    private void swipeUntilNeededYear(String year, double startPoint, double stopPoint) {
        while (!getYear().equals(year)) {
            moveInElement(By.className("android.widget.ListView"),startPoint,stopPoint);
            getYear();
        }
    }

    public String getYear() {
        return driver.findElement(By.id("month_text_view")).getText();
    }

    public String getSelectedYear() {
        return driver.findElement(By.id("date_picker_year")).getText();
    }

    public void tapOnOk() {
        tap(By.id("ok"));
    }

    public void tapOnTimeField() {
        tap(By.id("time"));
    }

    public void selectTime(String timeOfDay, int xHour, int yHour, int xMin, int yMin) {

        pause(500);
        if (timeOfDay.equals("am")) {
            tapWithCoordinates(279,1318);
        } else if (timeOfDay.equals("pm")) {
            tapWithCoordinates(789,1318);
        }
        tapWithCoordinates(xHour,yHour);
        tapWithCoordinates(xMin,yMin);
    }

    public void repeatOff() {
        tap(By.id("repeat_switch"));
    }
    public void tapOnRepetitionIntervalField() {
        tap(By.id("RepeatNo"));
    }

    public void enterNumber(String repeat) {
        pause(500);
        type(By.className("android.widget.EditText"),repeat);
        tap(By.xpath("//*[@text='OK']"));
    }

    public void selectTypeOfRepetition(String typeRep) {
        tap(By.xpath("//*[@text='" + typeRep + "']"));
    }

    public void tapOnRepetitionField() {
        tap(By.id("RepeatType"));
    }

    public void saveReminder() {
        tap(By.id("save_reminder"));
    }

    public String isRepeatOffTextPresent() {
        return driver.findElement(By.id("repeat_switch")).getText();
    }

    public String isRepeatIntervalTextPresent() {
        return driver.findElement(By.id("set_repeat_no")).getText();
    }

    public String isRepetitionTypeTextPresent() {
        return driver.findElement(By.id("set_repeat_type")).getText();
    }

    public void addReminderEnteringAllFields(Reminder reminder) {
        enterTitle(reminder.getTitle());
        tapOnDateField();
        swipeToMonth(reminder.getPeriod(), reminder.getMonth(), reminder.getNumber());
        selectDate(reminder.getIndex());
        tapOnYear();
        swipeToYear(reminder.getPeriod2(), reminder.getYear());
        tapOnOk();
        tapOnTimeField();
        selectTime(reminder.getTimeOfDay(), reminder.getXHour(), reminder.getYHour(), reminder.getXMin(), reminder.getYMin());
        tapOnOk();
        tapOnRepetitionIntervalField();
        enterNumber(reminder.getRepeat());
        swipe(reminder.getStart(), reminder.getStop());
        tapOnRepetitionField();
        selectTypeOfRepetition(reminder.getTypeRep());
        saveReminder();
    }

}
