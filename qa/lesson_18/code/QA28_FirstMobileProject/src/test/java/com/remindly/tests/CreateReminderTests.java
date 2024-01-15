package com.remindly.tests;

import org.testng.annotations.Test;

public class CreateReminderTests extends TestBase{

    @Test
    public void addReminderPositiveTest() {
        //tap on add reminder button
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
        //swipe to year
        app.getReminder().swipeToYear("future","2026");
        //tap on ok
        app.getReminder().tapOnOk();
        //tap on time field
        //select time(h,m,am-pm)
        //tap on ok
        //tap on repetition field
        //enter number of repetition
        //swipe up
        //tap on time of repetitions
        //select type of repetitions
        //save reminder
        //assert by title
    }
}
