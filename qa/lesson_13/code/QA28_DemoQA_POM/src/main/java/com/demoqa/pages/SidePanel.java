package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanel extends BasePage {

    public SidePanel(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[.='Alerts']")
    WebElement alerts;

    public AlertsPage selectAlerts() {
        clickWithJSExecutor(alerts, 0, 300);
        return new AlertsPage(driver);
    }

    @FindBy(xpath = "//span[.='Browser Windows']")
    WebElement browserWindows;

    public BrowserWindowsPage selectBrowserWindows() {
        clickWithJSExecutor(browserWindows, 0, 300);
        return new BrowserWindowsPage(driver);
    }

    @FindBy(xpath = "//span[.='Select Menu']")
    WebElement selectMenu;

    public SelectMenuPage getSelectMenu() {
        clickWithJSExecutor(selectMenu, 0, 600);
        return new SelectMenuPage(driver);
    }

    @FindBy(xpath = "//span[.='Practice Form']")
    WebElement practiceForm;

    public PracticeFormPage selectPracticeForm() {
        clickWithJSExecutor(practiceForm, 0, 100);
        return new PracticeFormPage(driver);
    }

    @FindBy(xpath = "//span[.='Frames']")
    WebElement frames;

    public FramesPage selectFrames() {
        clickWithJSExecutor(frames, 0, 300);
        return new FramesPage(driver);
    }

    @FindBy(xpath = "//span[.='Nested Frames']")
    WebElement nestedFrames;

    public FramesPage selectNestedFrames() {
        clickWithJSExecutor(nestedFrames, 0, 300);
        return new FramesPage(driver);
    }

    @FindBy(xpath = "//span[.='Buttons']")
    WebElement buttons;

    public ButtonsPage selectButtons() {
        clickWithJSExecutor(buttons,0,300);
        return new ButtonsPage(driver);
    }
    @FindBy(xpath = "//span[.='Text Box']")
    WebElement textBox;
    public TextBoxPage selectTextBox() {
        click(textBox);
        return new TextBoxPage(driver);
    }

    @FindBy(xpath = "//span[.='Links']")
    WebElement links;

    public LinksPage selectLinks() {
        clickWithJSExecutor(links,0,400);
        return new LinksPage(driver);
    }

    @FindBy(xpath = "//span[.='Broken Links - Images']")
    WebElement brokenLinks;

    public LinksPage selectBrokenLinks() {
        clickWithJSExecutor(brokenLinks,0,400);
        return new LinksPage(driver);
    }

}
