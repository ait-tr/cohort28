package com.remindly.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateReminderTests extends TestBase {

    @Test
    public void addReminderPositiveTest() {
        //tap on add reminder
        app.getMainScreen().tapOnAddReminderButton();
        //enter title
        app.getReminder().enterTitle("Holiday");
        //tap on date field
        app.getReminder().tapOnDateField();
        //swipe to month
        app.getReminder().swipeToMonth("future","MAR",2);
        //select date
        app.getReminder().selectDate(7);
        //tap on year
        app.getReminder().tapOnYear();
        //swipe to year and tap
        app.getReminder().swipeToYear("future","2025");
        //tap on ok
        app.getReminder().tapOnOk();
        //tap on time field
        app.getReminder().tapOnTimeField();
        //select time
        app.getReminder().selectTime("am",812,930,538,653);
        //tap on ok
        app.getReminder().tapOnOk();
        //tap on repetition interval field
        app.getReminder().tapOnRepetitionIntervalField();
        //enter number
        app.getReminder().enterNumber("2");
        //swipe up
        app.getReminder().swipe(0.8,0.4);
        //tap on type of repetition field
        app.getReminder().tapOnRepetitionField();
        //select type of repetition
        app.getReminder().selectTypeOfRepetition("Week");
        // save repetition
        app.getReminder().saveReminder();
        //assert by title
        app.getReminder().pause(500);
        Assert.assertTrue(app.getMainScreen().isReminderTitlePresent().contains("Holiday"));
    }

    @Test
    public void verifyAddTitlePositiveTest() {
        app.getMainScreen().tapOnAddReminderButton();
        app.getReminder().enterTitle(reminder.getTitle());
        app.getReminder().saveReminder();
        app.getReminder().pause(500);
        Assert.assertTrue(app.getMainScreen().isReminderTitlePresent().contains("Holiday"));
    }

    @Test
    public void verifySelectDatePositiveTest() {
        app.getMainScreen().tapOnAddReminderButton();
        app.getReminder().enterTitle(reminder.getTitle());
        app.getReminder().tapOnDateField();
        app.getReminder().swipeToMonth(reminder.getPeriod(), reminder.getMonth(), reminder.getNumber());
        app.getReminder().selectDate(reminder.getIndex());
        app.getReminder().tapOnOk();
        app.getReminder().saveReminder();
        app.getReminder().pause(500);
        Assert.assertTrue(app.getMainScreen().isReminderDatePresent().contains("8/3"));
    }

    @Test
    public void verifySelectYearPositiveTest() {
        app.getMainScreen().tapOnAddReminderButton();
        app.getReminder().enterTitle(reminder.getTitle());
        app.getReminder().tapOnDateField();
        app.getReminder().tapOnYear();
        app.getReminder().swipeToYear(reminder.getPeriod2(), reminder.getYear());
        app.getReminder().tapOnOk();
        app.getReminder().saveReminder();
        app.getReminder().pause(500);
        Assert.assertTrue(app.getMainScreen().isReminderDatePresent().contains("2026"));
    }

    @Test
    public void verifySelectTimePositiveTest() {
        app.getMainScreen().tapOnAddReminderButton();
        app.getReminder().enterTitle(reminder.getTitle());
        app.getReminder().tapOnTimeField();
        app.getReminder().selectTime(reminder.getTimeOfDay(), reminder.getXHour(),
                reminder.getYHour(), reminder.getXMin(), reminder.getYMin());
        app.getReminder().tapOnOk();
        app.getReminder().saveReminder();
        app.getReminder().pause(500);
        Assert.assertTrue(app.getMainScreen().isReminderDatePresent().contains("15:00"));
    }

    @Test
    public void verifyOffRepeatPositiveTest() {
        app.getMainScreen().tapOnAddReminderButton();
        app.getReminder().enterTitle(reminder.getTitle());
        app.getReminder().repeatOff();
        Assert.assertTrue(app.getReminder().isRepeatOffTextPresent().contains("Off"));
    }

    @Test
    public void verifyRepetitionIntervalPositiveTest() {
        app.getMainScreen().tapOnAddReminderButton();
        app.getReminder().enterTitle(reminder.getTitle());
        app.getReminder().tapOnRepetitionIntervalField();
        app.getReminder().enterNumber(reminder.getRepeat());
        Assert.assertTrue(app.getReminder().isRepeatIntervalTextPresent().contains("2"));
    }

    @Test
    public void verifyTypeOfRepetitionsPositiveTest() {
        app.getMainScreen().tapOnAddReminderButton();
        app.getReminder().enterTitle(reminder.getTitle());
        app.getReminder().swipe(reminder.getStart(), reminder.getStop());
        app.getReminder().tapOnRepetitionField();
        app.getReminder().selectTypeOfRepetition(reminder.getTypeRep());
        Assert.assertTrue(app.getReminder().isRepetitionTypeTextPresent().contains("Week"));
    }

    @Test
    public void addReminderEnteringAllFieldsPositiveTest() {
        app.getMainScreen().tapOnAddReminderButton();
        app.getReminder().addReminderEnteringAllFields(reminder);
        Assert.assertTrue(app.getMainScreen().isReminderTitlePresent().contains("Holiday"));
    }
}
