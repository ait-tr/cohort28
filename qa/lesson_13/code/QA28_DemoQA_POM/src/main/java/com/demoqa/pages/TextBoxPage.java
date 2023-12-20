package com.demoqa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class TextBoxPage extends BasePage{
    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName")
    WebElement userName;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    public TextBoxPage enterPersonalData(String name, String email) {
        type(userName,name);
        type(userEmail,email);
        return this;
    }

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    public TextBoxPage keyBoardEvent(String address) {
        //create object of the Actions class
        Actions actions = new Actions(driver);
        //enter Current Address
        type(currentAddress,address);
        //select Current Address
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        //copy Current Address
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        //press TAB Key to switch focus to Permanent Address
        actions.sendKeys(Keys.TAB).perform();
        //past Current Address in Permanent Address field
        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
        return this;
    }

    @FindBy(id = "submit")
    WebElement submit;

    public TextBoxPage submit() {
        clickWithJSExecutor(submit,0,200);
        return this;
    }

    @FindBy(css = "p#currentAddress")
    WebElement currentAddressResult;

    @FindBy(css = "p#permanentAddress")
    WebElement permanentAddressResult;

    public TextBoxPage assertCopyPastAddress() {
        String[] current = currentAddressResult.getText().split(":");
        String[] permanent = permanentAddressResult.getText().split(":");

        Assert.assertEquals(permanent[1],current[1]);
        return this;
    }
}
