package com.ilcarro.pages;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "password")
    WebElement passwordField;

    public LoginPage enterData(String email, String password) {
        type(emailField,email);
        type(passwordField,password);
        return this;
    }

    @FindBy(css = "[type='submit']")
    WebElement yallaButton;

    public HomePage clickOnYallaButton() {
        click(yallaButton);
        return new HomePage(driver);
    }

    public LoginPage enterWrongPassword(DataTable table) {
        List<Map<String,String>> dataTable = table.asMaps();

        String email = dataTable.get(0).get("email");
        String password = dataTable.get(0).get("password");

        enterData(email,password);
        return this;
    }

    @FindBy(css = ".dialog-container h2")
    WebElement errorMessage;

    public LoginPage getError(String text) {
        assert shouldHaveText(errorMessage,text,20);
        return this;
    }
}
