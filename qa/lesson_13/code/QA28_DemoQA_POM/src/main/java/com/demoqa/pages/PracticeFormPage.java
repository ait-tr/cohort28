package com.demoqa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PracticeFormPage extends BasePage{

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userNumber")
    WebElement userNumber;

    public PracticeFormPage enterPersonalData(String name, String lastname, String email, String phone) {
        type(firstName,name);
        type(lastName,lastname);
        type(userEmail,email);
        type(userNumber,phone);
        return this;
    }

    @FindBy(css = "[for='gender-radio-1']")
    WebElement male;
    @FindBy(css = "[for='gender-radio-2']")
    WebElement female;
    @FindBy(css = "[for='gender-radio-3']")
    WebElement other;

    public PracticeFormPage selectGender(String gender) {
        if (gender.equals("Male")) {
            click(male);
        } else if (gender.equals("Female")) {
            click(female);
        } else {
            click(other);
        }
        return this;
    }

    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthInput;

    public PracticeFormPage enterDate(String date) {
        clickWithJSExecutor(dateOfBirthInput,0,200);

        String os = System.getProperty("os.name");
        if (os.startsWith("Mac")) {
            dateOfBirthInput.sendKeys(Keys.COMMAND,"a");
        } else {
            dateOfBirthInput.sendKeys(Keys.CONTROL, "a");
        }
        dateOfBirthInput.sendKeys(date);
        dateOfBirthInput.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "subjectsInput")
    WebElement subjectsInput;

    public PracticeFormPage selectSubjects(String[] subjects) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] != null) {
                type(subjectsInput,subjects[i]);
                subjectsInput.sendKeys(Keys.ENTER);
            }
        }
        return this;
    }

    @FindBy(css = "[for='hobbies-checkbox-1']")
    WebElement sports;
    @FindBy(css = "[for='hobbies-checkbox-2']")
    WebElement reading;
    @FindBy(css = "[for='hobbies-checkbox-3']")
    WebElement music;

    public PracticeFormPage selectHobbies(String[] hobbies) {
        for (int i = 0; i < hobbies.length; i++) {
            if (hobbies[i].equals("Sports")){
                click(sports);
            } if (hobbies[i].equals("Reading")) {
                click(reading);
            } if (hobbies[i].equals("Music")){
                click(music);
            }
        }
        return this;
    }

    @FindBy(id = "uploadPicture")
    WebElement uploadPicture;

    public PracticeFormPage uploadFile(String path) {
        uploadPicture.sendKeys(path);
        return this;
    }

    @FindBy(id = "state")
    WebElement stateContainer;

    @FindBy(id = "react-select-3-input")
    WebElement stateInput;

    public PracticeFormPage selectState(String state) {
        clickWithJSExecutor(stateContainer,0,200);
        stateInput.sendKeys(state);
        stateInput.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "city")
    WebElement cityContainer;

    @FindBy(id = "react-select-4-input")
    WebElement cityInput;

    public PracticeFormPage selectCity(String city) {
        click(cityContainer);
        cityInput.sendKeys(city);
        cityInput.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "submit")
    WebElement submit;

    public PracticeFormPage submit() {
        clickWithRectangle(submit,2,3);
        return this;
    }

    public void clickWithRectangle(WebElement element, int x, int y) {
        Rectangle rectangle = element.getRect();

        int xOffset = rectangle.getWidth() / x;
        int yOffset = rectangle.getHeight() / y;

        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.moveByOffset(-xOffset,-yOffset).click().perform();
    }

    @FindBy(css = ".react-datepicker__month-select")
    WebElement monthContainer;

    @FindBy(css = ".react-datepicker__year-select")
    WebElement yearContainer;

    public PracticeFormPage chooseDate(String month, String year, String day) {

        clickWithJSExecutor(dateOfBirthInput,0,400);
        new Select(monthContainer).selectByVisibleText(month);
        new Select(yearContainer).selectByVisibleText(year);

        driver.findElement(By.xpath("//div[@class='react-datepicker__week']//div[.='"+ day +"']")).click();
        return this;
    }
}
