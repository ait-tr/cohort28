package com.remindly.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MainScreenTests extends TestBase{

    @Test
    public void appLaunchTest() {
        Assert.assertTrue(app.getMainScreen().isMainScreenMessagePresent());
    }
}
